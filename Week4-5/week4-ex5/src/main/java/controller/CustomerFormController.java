package controller;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers/form")
public class CustomerFormController {

    private List<Customer> customers = new ArrayList<>();

    // POST request to accept form data and create a new customer
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestParam("name") String name,
                                                     @RequestParam("email") String email,
                                                     @RequestParam("address") String address) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);

        customers.add(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    // GET endpoint to return all customers (for testing purposes)
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }
}
