package com.example.addressMS.controller;

import com.example.addressMS.dto.CustomerAddressDto;
import com.example.addressMS.exception.InvalidCredentialsException;
import com.example.addressMS.service.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@CrossOrigin
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    @PostMapping("/customeraddress/create")
    public ResponseEntity<CustomerAddressDto> createCustomerAddress(@Valid @RequestBody CustomerAddressDto customerAddressDto){
        return new ResponseEntity<CustomerAddressDto>(customerAddressService.create(customerAddressDto), HttpStatus.CREATED);
    }

    @PutMapping("/customeraddress/update")
    public ResponseEntity<CustomerAddressDto> updateCustomerAddress(@Valid @RequestBody CustomerAddressDto customerAddressDto){
        return new ResponseEntity<CustomerAddressDto>(customerAddressService.update(customerAddressDto),HttpStatus.OK);
    }

    @PostMapping("/customeraddress/get")
    public CustomerAddressDto getCustomerAddressDto(@Valid @RequestBody CustomerAddressDto customerAddressDto) throws InvalidCredentialsException {
        return customerAddressService.getCustomerAddressDto(customerAddressDto);
    }
}
