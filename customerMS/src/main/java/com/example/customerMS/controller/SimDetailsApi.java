package com.example.customerMS.controller;

import com.example.customerMS.dto.SimDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MS2")
public interface SimDetailsApi {
    @PostMapping("/simdetails/get")
    SimDetailsDto getSimDetailsDto(@RequestBody SimDetailsDto simDetailsDto);

    @PostMapping("/simdetails/activate")
    SimDetailsDto activateSim(@RequestBody SimDetailsDto simDetailsDto);
}
