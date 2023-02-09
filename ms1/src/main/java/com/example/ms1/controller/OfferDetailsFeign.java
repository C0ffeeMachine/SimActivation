package com.example.ms1.controller;

import com.example.ms1.dto.SimDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("MS2")
public interface OfferDetailsFeign {

    @PostMapping(value = "/simdetails/create")
    SimDetailsDto getSimDetailsDto(@RequestBody SimDetailsDto simDetailsDto);
}
