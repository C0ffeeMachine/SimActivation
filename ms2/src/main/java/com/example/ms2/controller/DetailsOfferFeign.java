package com.example.ms2.controller;

import com.example.ms2.dto.SimDetailsDto;
import com.example.ms2.dto.SimOffersDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MS1")
public interface DetailsOfferFeign {

    @PostMapping("/simoffers/get")
    SimOffersDto getSimOffersDto(@RequestBody SimDetailsDto simDetailsDto);

    @PostMapping("/simoffers/create")
    SimOffersDto createSimOffers(@RequestBody SimOffersDto simOffersDto);
}
