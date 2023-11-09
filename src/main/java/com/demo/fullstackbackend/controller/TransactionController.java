package com.demo.fullstackbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fullstackbackend.exception.UserNotFoundException;
import com.demo.fullstackbackend.model.Transaction;
import com.demo.fullstackbackend.model.Admin;
import com.demo.fullstackbackend.repository.TransactionRepository;



@RestController
@CrossOrigin("http://localhost:3000")
public class TransactionController {
	@Autowired
	private TransactionRepository transactionRepository;

    @PostMapping("/transaction")
    Transaction newUser(@RequestBody Transaction newTransaction) {
        return transactionRepository.save(newTransaction);
    }
    @GetMapping("/transaction/{id}")
    Transaction getTransactionById(@PathVariable Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}
