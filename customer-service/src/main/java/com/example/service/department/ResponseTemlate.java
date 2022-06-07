package com.example.service.department;

import com.example.service.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemlate {

    private Customer customer;
    private Department department;
}
