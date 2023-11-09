package com.demo.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.fullstackbackend.model.Chef;
import com.demo.fullstackbackend.model.Admin;

public interface ChefRepository extends JpaRepository<Chef,Long>{

}
