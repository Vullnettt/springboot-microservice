package com.example.service.service;

import com.example.service.department.Department;
import com.example.service.department.ResponseTemlate;
import com.example.service.model.Customer;
import com.example.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    RestTemplate restTemplate;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public ResponseTemlate findDepartmentWithCustomer(Long customerId) {
        ResponseTemlate responseTemlate = new ResponseTemlate();
        Customer customer = customerRepository.findByCustomerId(customerId);

        Department department = restTemplate.getForObject("http://localhost:8081/department/"
                + customer.getDepartmentId()
                , Department.class);

        responseTemlate.setCustomer(customer);
        responseTemlate.setDepartment(department);

        return responseTemlate;
    }


}
