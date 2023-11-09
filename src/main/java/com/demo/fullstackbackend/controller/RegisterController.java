package com.demo.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fullstackbackend.model.Register;
import com.demo.fullstackbackend.model.Admin;
import com.demo.fullstackbackend.model.Login;
import com.demo.fullstackbackend.repository.RegisterRepository;


@RestController
@CrossOrigin("http://localhost:3000")
public class RegisterController {
	@Autowired
    private RegisterRepository registerRepository;
	@PostMapping("/register")
    Register newRegister(@RequestBody Register newRegister) {
        return registerRepository.save(newRegister);
    }
	@GetMapping("/registers")
    List<Register> getAllUsers() {
        return registerRepository.findAll();
    }
	

}