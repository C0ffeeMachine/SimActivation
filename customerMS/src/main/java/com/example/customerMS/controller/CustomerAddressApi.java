package com.example.customerMS.controller;

import com.example.customerMS.dto.CustomerAddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("AddressMS")
public interface CustomerAddressApi {

    @PostMapping("/customeraddress/get")
    CustomerAddressDto getCustomerAddressDto(@RequestBody CustomerAddressDto customerAddressDto);
}
