const mongoose = require("mongoose");
const Chat = require("./models/chat.js");

mongoose.connect("mongodb://127.0.0.1:27017/whatsappdemo")
    .then(() => console.log("Connected Successfully"))
    .catch(err => console.error("Connection error:", err));

// Sample chat data //put all chat data in form of array with different chats 
let allChats = [
    {
        from: "Dhoni",
        to: "Virat",
        msg: "Hello Virat",
        created_at: new Date()
    },
    {
        from: "Virat",
        to: "Rohit",
        msg: "Hello Rohit",
        created_at: new Date()
    },
    {
        from: "Rohit",
        to: "Sachin",
        msg: "Hello Sachin",
        created_at: new Date()
    },
    {
        from: "Sachin",
        to: "Dravid",
        msg: "Hello Dravid",
        created_at: new Date()
    },
    {
        from: "Dravid",
        to: "Gill",
        msg: "Hello Gill",
        created_at: new Date()
    },
    {
        from: "Gill",
        to: "Bumrah",
        msg: "Hello Bumrah",
        created_at: new Date()
    },
    {
        from: "Bumrah",
        to: "Shami",
        msg: "Hello Shami",
        created_at: new Date()
    }
];

// Inserting chat data into the database
Chat.insertMany(allChats);

//now you can run it on console with node init.js  or on shell db.chats.find(), yoiu will see all the chats---so iss tarh sa hamne apne database ko intitalise kiya 