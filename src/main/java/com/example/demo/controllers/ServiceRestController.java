package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Services;
import com.example.demo.services.JPA.ServicesJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class ServiceRestController {

    @Autowired
    ServicesJPAService servicesJPAService;

    //find all services
    @GetMapping("/services/all")
    public ResponseEntity<List<Services>> findAllServices() {
        List<Services> servicesList = servicesJPAService.findAll();
        if (servicesList.size() >= 1) {
            return new ResponseEntity<>(servicesList, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Der er ingen kunder");
        }
    }

    //find service by id
    @GetMapping("/services/{id}")
    public ResponseEntity<Services> findServiceById(@PathVariable Integer id) {
        Services services = servicesJPAService.findById(id);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    //post customer
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/services/create", consumes = "application/json")
    public Services createService(@RequestBody Services services) {
        return servicesJPAService.save(services);
    }

    //delete services
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/services/delete/{id}")
    public ResponseEntity<Integer> deleteService(@PathVariable Integer id) {
        try{
            servicesJPAService.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Service med id="+id+" findes ikke.");
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
