package com.example.customerservice.service;


import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.entites.Customer;
import com.example.customerservice.exception.ResourceNotFoundException;
import com.example.customerservice.mapper.CustomerMapper;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {


    private final CustomerRepository repository;


    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    public CustomerDto create(CustomerDto dto) {
        Customer saved = repository.save(CustomerMapper.toEntity(dto));
        return CustomerMapper.toDto(saved);
    }


    public CustomerDto update(Long id, CustomerDto dto) {
        Customer existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        return CustomerMapper.toDto(repository.save(existing));
    }


    public CustomerDto findById(Long id) {
        return repository.findById(id)
                .map(CustomerMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));
    }


    public List<CustomerDto> findAll() {
        return repository.findAll().stream().map(CustomerMapper::toDto).collect(Collectors.toList());
    }


    public void delete(Long id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Customer not found: " + id);
        repository.deleteById(id);
    }
}
