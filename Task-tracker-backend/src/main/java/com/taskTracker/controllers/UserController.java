package com.taskTracker.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.taskTracker.dao.UserDao;
import com.taskTracker.entities.User;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired private UserDao userDao;
    
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
    
    @GetMapping("/getById/{id}")
    public User getUserById(@PathVariable Long id) {
    	User user  = userDao.findById(id);
    	if(user == null) throw new RuntimeException("User not found with id : " + id);      
        return user;
    }
    
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userDao.create(user);
    }
    
    @PostMapping("/createList")
    public List<User> createUsers(@RequestBody List<User> User) {
        return userDao.createList(User);
    }
    
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userDao.findById(id);
    	if(user == null) throw new RuntimeException("User not found with id : " + id);      

        // Update user details
        user.setEmail(userDetails.getEmail());
        // Save updated user
        userDao.update(user);
        return user;
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        User user = userDao.findById(id);
    	if(user == null) throw new RuntimeException("User not found with id : " + id);      

        userDao.delete(user);
    }
}
