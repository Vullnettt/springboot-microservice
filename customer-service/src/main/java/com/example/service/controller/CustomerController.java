package com.example.service.controller;

import com.example.service.department.ResponseTemlate;
import com.example.service.model.Customer;
import com.example.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public ResponseTemlate findDepartmentWithCustomer(@PathVariable("id") Long customerId){
        return customerService.findDepartmentWithCustomer(customerId);
    }


}
