package com.demo.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.fullstackbackend.model.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
