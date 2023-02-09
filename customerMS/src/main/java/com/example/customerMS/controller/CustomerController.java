package com.example.customerMS.controller;

import com.example.customerMS.dto.CustomerDto;
import com.example.customerMS.exception.InvalidCredentialsException;
import com.example.customerMS.exception.SimAlreadyActiveException;
import com.example.customerMS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer/create")
    public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerDto customerDto) throws InvalidCredentialsException, SimAlreadyActiveException {
        return new ResponseEntity<String>(customerService.validateAndCreateCustomer(customerDto), HttpStatus.OK);
    }
}
