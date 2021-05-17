package com.example.demo.controllers;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.ServicesEntity;
import com.example.demo.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class ServicesRestController {

    @Autowired
    ServicesRepository servicesRepository;

    //find all services
    @GetMapping("/services/all")
    public ResponseEntity<List<ServicesEntity>> findAllServices() {
        List<ServicesEntity> servicesEntityList = servicesRepository.findAll();
        if (servicesEntityList.size() >= 1) {
            return new ResponseEntity<>(servicesEntityList, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Der er ingen kunder");
        }
    }

    //find service by id
    @GetMapping("/services/{id}")
    public ResponseEntity<ServicesEntity> findServiceById(@PathVariable Integer id) {
        ServicesEntity servicesEntity = servicesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Service med id="+id+" finde ikke."));
        return new ResponseEntity<>(servicesEntity, HttpStatus.OK);
    }

    //post customer
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/services/create", consumes = "application/json")
    public ServicesEntity createService(@RequestBody ServicesEntity service) {
        return servicesRepository.save(service);
    }

    //delete services
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/services/delete/{id}")
    public void deleteService(@PathVariable Integer id) {
        try{
            servicesRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            System.out.println("Service med id="+id+" findes ikke." + e.getMessage());
        }
    }
}
