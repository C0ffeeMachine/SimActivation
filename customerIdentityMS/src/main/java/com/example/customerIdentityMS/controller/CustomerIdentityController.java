package com.example.customerIdentityMS.controller;

import com.example.customerIdentityMS.dto.CustomerIdentityDto;
import com.example.customerIdentityMS.exception.InvalidCredentialsException;
import com.example.customerIdentityMS.exception.NoSuchCustomerException;
import com.example.customerIdentityMS.service.CustomerIdentityService;
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
public class CustomerIdentityController {

    @Autowired
    private CustomerIdentityService customerIdentityService;

    @PostMapping("/customeridentity/create")
    public ResponseEntity<CustomerIdentityDto> createCustomerIdentity(@Valid @RequestBody CustomerIdentityDto customerIdentityDto){
        return new ResponseEntity<CustomerIdentityDto>(customerIdentityService.create(customerIdentityDto),HttpStatus.CREATED);
    }

    @PostMapping("/customeridentity/validate")
    public ResponseEntity<String> validateCustomerIdentity(@Valid @RequestBody CustomerIdentityDto customerIdentityDto) throws NoSuchCustomerException {
        String response = customerIdentityService.validateCustomerIdentity(customerIdentityDto);
        return new ResponseEntity<String>(response,HttpStatus.OK);
    }
    // apply versioning
    @PostMapping("/customeridentity/validate2")
    public ResponseEntity<String> validateCustomerPersonalDetails(@Valid @RequestBody CustomerIdentityDto customerIdentityDto) throws InvalidCredentialsException, NoSuchCustomerException {
        String response = customerIdentityService.validateCustomerPersonalDetails(customerIdentityDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/customeridentity/get")
    public CustomerIdentityDto getCustomerIdentityDto(@Valid @RequestBody CustomerIdentityDto customerIdentityDto) throws NoSuchCustomerException {
        return customerIdentityService.getCustomerIdentityDto(customerIdentityDto);
    }
}
