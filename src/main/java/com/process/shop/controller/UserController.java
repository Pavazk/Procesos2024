package com.process.shop.controller;

import com.process.shop.model.User;
import com.process.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
//
//    @GetMapping("{id}")
//    public User updateUser(@RequestBody User user, @PathVariable Long id) {
//        return userService.updateUser(user, id);
//    }
//    // Endpoint para obtener todos los usuarios
//    @GetMapping("getAll")
//    public List<User> getAllUsers() {
//        return userService.findAllUsers();
//    }
}
