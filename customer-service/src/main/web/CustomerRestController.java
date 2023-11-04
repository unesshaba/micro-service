package com.org.customerservice.web;

import com.org.customerservice.entities.Customer;
import com.org.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CustomerRestController {
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping("/customers")
    public List<Customer> customerList(){
     return    customerRepository.findAll();

    }
    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return customerRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
