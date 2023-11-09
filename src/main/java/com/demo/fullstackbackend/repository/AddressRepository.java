package com.demo.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.fullstackbackend.model.Addres;



public interface AddressRepository extends JpaRepository<Addres,Long> {

}
