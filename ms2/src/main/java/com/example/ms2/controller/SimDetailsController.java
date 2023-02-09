package com.example.ms2.controller;

import com.example.ms2.dto.SimDetailsDto;
import com.example.ms2.dto.SimOffersDto;
import com.example.ms2.exception.NoSuchServiceNumberOrSimNumberException;
import com.example.ms2.exception.SimAlreadyActiveException;
import com.example.ms2.service.SimDetailsService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@CrossOrigin
public class SimDetailsController {

    @Autowired
    private SimDetailsService simDetailsService;

    @Autowired
    private Environment environment;

//    @CircuitBreaker(name = "simDetailsService",fallbackMethod = "validateSimDetailsFallback")
    @PostMapping("/simdetails/validate")
    public SimOffersDto validateSimDetails(@Valid @RequestBody SimDetailsDto simDetailsDto) throws SimAlreadyActiveException, NoSuchServiceNumberOrSimNumberException {
        System.out.println(environment.getProperty("local.server.port"));
        return simDetailsService.validateSimDetails(simDetailsDto);
    }

    @PostMapping("/simdetails/create")
    public SimDetailsDto create(@Valid @RequestBody SimDetailsDto simDetailsDto){
        return simDetailsService.create(simDetailsDto);
    }

    @PostMapping("/simdetails/get")
    public SimDetailsDto getSimDetailsDto(@Valid @RequestBody SimDetailsDto simDetailsDto) throws NoSuchServiceNumberOrSimNumberException {
        return simDetailsService.getSimDetailsDto(simDetailsDto);
    }

    @PostMapping("/simdetails/activate")
    public SimDetailsDto activateSim(@Valid @RequestBody SimDetailsDto simDetailsDto) {
        return simDetailsService.activateSim(simDetailsDto);
    }

//    public SimOffersDto validateSimDetailsFallback(SimDetailsDto simDetailsDto, Throwable throwable){
//        System.out.println("In fallback");
//        return new SimOffersDto();
//    }
}
