package com.example.customerMS.controller;

import com.example.customerMS.dto.CustomerIdentityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CustomerIdentityMS")
public interface CustomerIdentityApi {

    @PostMapping("/customeridentity/get")
    CustomerIdentityDto getCustomerIdentityDto(@RequestBody CustomerIdentityDto customerIdentityDto);
}
