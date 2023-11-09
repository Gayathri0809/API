package com.demo.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.fullstackbackend.model.Register;


public interface RegisterRepository extends JpaRepository<Register,Integer>{

}
