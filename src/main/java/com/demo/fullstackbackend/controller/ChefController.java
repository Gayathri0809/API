package com.demo.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fullstackbackend.model.Chef;
import com.demo.fullstackbackend.model.Admin;
import com.demo.fullstackbackend.repository.ChefRepository;
import com.demo.fullstackbackend.repository.AdminRepository;



@RestController
@CrossOrigin("http://localhost:3000")

public class ChefController {
	@Autowired
    private ChefRepository chefRepository;
	 @GetMapping("/chefs")
	    List<Chef> getAllUsers() {
	        return chefRepository.findAll();
	    }

}
