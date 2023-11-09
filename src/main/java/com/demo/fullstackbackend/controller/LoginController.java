package com.demo.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fullstackbackend.model.Admin;
import com.demo.fullstackbackend.model.Login;

import com.demo.fullstackbackend.repository.LoginRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {
	@Autowired
    private LoginRepository loginRepository;
	@PostMapping("/login")
    Login newUser(@RequestBody Login newLogin) {
        return loginRepository.save(newLogin);
    }
	@GetMapping("/logins")
    List<Login> getAllUsers() {
        return loginRepository.findAll();
    }

}
