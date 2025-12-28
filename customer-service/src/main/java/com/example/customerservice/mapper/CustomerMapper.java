package com.example.customerservice.mapper;

import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.entites.Customer;

public class CustomerMapper {
    public static CustomerDto toDto(Customer c) {
        CustomerDto d = new CustomerDto();
        d.setId(c.getId());
        d.setFirstName(c.getFirstName());
        d.setLastName(c.getLastName());
        d.setEmail(c.getEmail());
        d.setPhone(c.getPhone());
        return d;
    }


    public static Customer toEntity(CustomerDto d) {
        Customer c = new Customer(null, "Enset", "contact@enset-media.ma");
        c.setId(d.getId());
        c.setFirstName(d.getFirstName());
        c.setLastName(d.getLastName());
        c.setEmail(d.getEmail());
        c.setPhone(d.getPhone());
        return c;
    }
}
