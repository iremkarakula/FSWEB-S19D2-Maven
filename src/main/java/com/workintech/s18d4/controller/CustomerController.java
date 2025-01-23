package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable("id") Long id){
        return customerService.find(id);
    }

   @PostMapping
    public CustomerResponse saveCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary());
    }


}
