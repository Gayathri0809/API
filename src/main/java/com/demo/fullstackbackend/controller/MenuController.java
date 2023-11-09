package com.demo.fullstackbackend.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.fullstackbackend.exception.UserNotFoundException;
import com.demo.fullstackbackend.model.Menu;
import com.demo.fullstackbackend.model.Admin;
import com.demo.fullstackbackend.repository.MenuRepository;




@RestController
@CrossOrigin("http://localhost:3000")

public class MenuController {
	@Autowired
    private MenuRepository menuRepository;

     
    @PostMapping("/list")
    Menu newMenu(@RequestBody Menu newMenu) {
        return menuRepository.save(newMenu);
    }
    @GetMapping("/lists")
    List<Menu> getAllLists() {
        return menuRepository.findAll();
    }
    @GetMapping("/list/{id}")
    Menu getMenuById(@PathVariable Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @PutMapping("/list/{id}")
    Menu updateMenu(@RequestBody Menu newMenu, @PathVariable Long id) {
        return menuRepository.findById(id)
                .map(list -> {
                    list.setName(newMenu.getName());
                    list.setPrice(newMenu.getPrice());
                    list.setImages(newMenu.getImages());
                    list.setDescription(newMenu.getDescription());
                    list.setCategory(newMenu.getCategory());
                    return menuRepository.save(list);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/list/{id}")
    String deleteMenu(@PathVariable Long id){
        if(!menuRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        menuRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
    @PostMapping("/list/{id}")
    public ResponseEntity<Menu> updateMenuItemById(@PathVariable Long id, @RequestBody Menu updatedMenu) {
        // Retrieve the menu item by its ID from the database
        Menu existingMenuItem = menuRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // Update the menu item properties
        existingMenuItem.setName(updatedMenu.getName());
        existingMenuItem.setPrice(updatedMenu.getPrice());
        existingMenuItem.setImages(updatedMenu.getImages());
        existingMenuItem.setDescription(updatedMenu.getDescription());
        existingMenuItem.setCategory(updatedMenu.getCategory());

        // Save the updated menu item
        menuRepository.save(existingMenuItem);

        return new ResponseEntity<>(existingMenuItem, HttpStatus.OK);
    }

}
