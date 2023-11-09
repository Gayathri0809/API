package com.demo.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fullstackbackend.exception.UserNotFoundException;
import com.demo.fullstackbackend.model.Addres;
import com.demo.fullstackbackend.model.Address;

import com.demo.fullstackbackend.repository.AddressRepository;



@RestController
@CrossOrigin("http://localhost:3000")
public class AddressController {

	@Autowired
    private AddressRepository addressRepository;
	@GetMapping("/addres")
    List<Addres> getAllLists() {
        return addressRepository.findAll();
    }
	@PostMapping("/address")
    Addres newMenu(@RequestBody Addres newOrdering) {
        return addressRepository.save(newOrdering);
    }
	@DeleteMapping("/address/{id}")
    String deleteMenu(@PathVariable Long id){
        if(!addressRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        addressRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
	@GetMapping("/address/{id}")
    Addres getMenuById(@PathVariable Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
	@PutMapping("/address/{id}")
    Addres updateMenu(@RequestBody   Addres newMenu, @PathVariable Long id) {
        return addressRepository.findById(id)
                .map(list -> {
                    list.setName(newMenu.getName());
                    list.setPhone(newMenu.getPhone());
                 
                    list.setPincode(newMenu.getPincode());
                    list.setAddress(newMenu.getAddress());
                    return addressRepository.save(list);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }
}
