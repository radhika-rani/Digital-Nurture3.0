package com.bookstore.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookstore.api.entity.Customer;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customerList = new ArrayList<>();

    // POST endpoint to create a new customer via form data
    @PostMapping("/form")
    public ResponseEntity<Customer> createCustomerFromForm(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String address) {

        Customer customer = new Customer();
        customer.setId((long) (customerList.size() + 1)); // Generate a new ID
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);

        customerList.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
