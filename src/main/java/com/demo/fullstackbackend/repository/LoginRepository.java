package com.demo.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.fullstackbackend.model.Login;

public interface LoginRepository extends JpaRepository<Login,Integer>{

}
