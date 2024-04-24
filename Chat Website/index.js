const express = require("express");
const app = express();
const path = require("path");
const mongoose = require("mongoose");
const Chat = require("./models/chat.js");
const methodOverride = require("method-override");

// Database Connected with mongoose 
main()
    .then((res) => {
        console.log("connection successful");
    })
    .catch(err => console.log(err));

async function main() {
    await mongoose.connect("mongodb://127.0.0.1:27017/whatsappdemo"); //for connection to our database. //means moongoose will be using whatsapp databse after connection 
}

app.set("views", path.join(__dirname, "views"));
app.set("view engine", "ejs");

app.use(express.static(path.join(__dirname, "public")));
app.use(express.urlencoded({ extended: true }));
app.use(methodOverride("_method"));
app.get("/home", (req,res)=>{
    res.render("home.ejs");
})
// Index Route
app.get("/chats", async (req, res) => {  //chats ko hame databse sa lana hoga aur satabse sa sara data lamne ke liye we use Chats.find() and it is arynchronous and returns promise  so use async-await and make callbak async
    let chats = await Chat.find();
    res.render("index.ejs", { chats });
});

// New Route
app.get("/chats/new", (req, res) => {
    res.render("new.ejs");
});

// Create Route
app.post("/chats", (req, res) => {
    let { from, to, msg } = req.body; //access data of the form  req.body ke data ko parse krne ke liye urlencoded 
    let newChat = new Chat({  //create new chat object  and add from to msg 
        from: from,
        to: to,
        msg: msg,
        created_at: new Date(),
    });
    newChat.save().then(() => { //insert this new chat //saving this new chat 
        res.redirect("/chats");
    }).catch((err) => {
        console.log(err);
    });
}); //now changes are stored permamnently with the he;p of database 

// Edit Route
app.get("/chats/:id/edit", async (req, res) => {
    let id = req.params.id; //id agyi , ab iss id  ke basis pr ham puri chat ko database mai search krnege , 
    let chat = await Chat.findById(id); //use findbyId to search for chat wiht help of id. findbyId is asyncrhonus funct so use async-await 
    res.render("edit.ejs", { chat });
});

// Update Route
app.put("/chats/:id", async (req, res) => {
    let id = req.params.id;
    let newMsg = req.body.msg;
    let updatedChat = await Chat.findByIdAndUpdate( // USE THIS AS HAM CHAHTE HAIN KI PHELE DATABASE KI ID SA DHUNDO AUR PHIR UPDATE KRO 
        id, //PASS ID 
        { msg: newMsg }, //WE WANT TO SET MSG TO NEW MSG 
        { runValidators: true, new: true } //RV:TRUE AND IF WE WANT UDATE CHAT TO PRUNT , SET IT TO TRUE 
    );
    res.redirect("/chats");
});

// Destroy Route
app.delete("/chats/:id", async (req, res) => {
    let id = req.params.id;
    let deletedChat = await Chat.findByIdAndDelete(id);
    console.log(deletedChat);
    res.redirect("/chats");
}); // can search in shell also, it will show as deleted only, see with db.chats.find()


app.get("/", (req, res) => {
    res.send("Working");
});

app.listen(8000, () => {
    console.log("Server is listening at 8000");
});
