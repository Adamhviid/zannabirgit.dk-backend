package com.example.demo.services;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Services;
import com.example.demo.repositories.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesJPAService implements ServicesService {
    ServiceRepository serviceRepository;

    public ServicesJPAService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Services> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Services findById(Integer id) {
        return serviceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Services med id="+id+" finde ikke."));
    }

    @Override
    public Services save(Services object) {
        return serviceRepository.save(object);
    }

    @Override
    public void delete(Services object) {
        serviceRepository.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        serviceRepository.deleteById(id);
    }
}
