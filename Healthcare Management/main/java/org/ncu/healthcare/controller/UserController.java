package org.ncu.healthcare.controller;



import java.util.List;

import org.ncu.healthcare.entity.User;
import org.ncu.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    

    @PostMapping
    public String createUser(@RequestBody User user ) {
       
        userService.save(user); 
        


        return "Created user endpoint";
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        
        return userService.findAll();
    }
    

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        
        return userService.findById(userId);
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody User user) {
       
        userService.update(user);
        return "Update user by ID endpoint";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
       
        User user = userService.findById(userId);
        if (user != null) {
            userService.delete(user);
            return "User with ID " + userId + " deleted successfully";
        } else {
            return "User with ID " + userId + " not found";
        }
    }
}
