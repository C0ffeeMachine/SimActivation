package com.example.ms1.controller;

import com.example.ms1.dto.SimDetailsDto;
import com.example.ms1.dto.SimOffersDto;
import com.example.ms1.service.SimOffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin
public class SimOffersController {

    @Autowired
    private SimOffersService simOffersService;

    @Autowired
    private Environment environment;

//    @Autowired
//    private DiscoveryClient discoveryClient;

//    List<ServiceInstance> instances=client.getInstances("FriendFamilyMS");
//    ServiceInstance instance=instances.get(0);
//    URI friendUri = instance.getUri();

    @PostMapping("/simoffers/create")
    public SimOffersDto createSimOffers(@Valid @RequestBody SimOffersDto simOffersDto){
        return simOffersService.create(simOffersDto);
    }

    @PostMapping("/simoffers/get")
    public SimOffersDto getSimOffersDto(@RequestBody SimDetailsDto simDetailsDto) throws Exception {
        System.out.println(environment.getProperty("local.server.port"));
        return simOffersService.getSimOffersDto(simDetailsDto);
    }
}
