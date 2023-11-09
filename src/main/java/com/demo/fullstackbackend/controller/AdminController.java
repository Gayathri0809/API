package com.demo.fullstackbackend.controller;

import com.demo.fullstackbackend.exception.UserNotFoundException;
import com.demo.fullstackbackend.model.Admin;
import com.demo.fullstackbackend.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")

public class AdminController {

    @Autowired
    private AdminRepository userRepository;

    @PostMapping("/user")
    Admin newUser(@RequestBody Admin newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<Admin> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    Admin getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    Admin updateUser(@RequestBody Admin newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }



}
