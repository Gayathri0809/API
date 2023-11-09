package com.demo.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.fullstackbackend.model.OrderHistory;

import com.demo.fullstackbackend.repository.OderHistoryRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class OrderHistoryController {
	 private static final Logger logger = LoggerFactory.getLogger(OrderHistoryController.class);

	@Autowired
    private OderHistoryRepository ohRepository;
	 @GetMapping("/history")
     
	    List<OrderHistory> getAllUsers() {
		 logger.info("Getting all order history records.");
	        return ohRepository.findAll();
	    }
	 @PostMapping("/history")
	    OrderHistory newMenu(@RequestBody OrderHistory newOrderHistory) {
		 
	        return ohRepository.save( newOrderHistory);
	    }
}