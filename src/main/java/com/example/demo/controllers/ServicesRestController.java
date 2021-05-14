package com.example.demo.controllers;

import com.example.demo.models.ServicesEntity;
import com.example.demo.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class ServicesRestController {

    @Autowired
    ServicesRepository servicesRepository;

    //find all services
    @GetMapping("/services/all")
    public List<ServicesEntity> findAllServices() {
        return servicesRepository.findAll();
    }

    //find service by id
    @GetMapping("/services/{id}")
    public ServicesEntity printService(@PathVariable Integer id) {
        return servicesRepository.getServicesById(id);
    }

    //delete services
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/products/delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        try{
            servicesRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            System.out.println("FEJL I DELETE -" + e.getMessage());
        }
    }
}
