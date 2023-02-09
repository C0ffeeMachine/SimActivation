package com.example.ms2.service;

import com.example.ms2.controller.DetailsOfferFeign;
import com.example.ms2.dto.SimDetailsDto;
import com.example.ms2.dto.SimOffersDto;
import com.example.ms2.entity.SimDetails;
import com.example.ms2.exception.NoSuchServiceNumberOrSimNumberException;
import com.example.ms2.exception.SimAlreadyActiveException;
import com.example.ms2.repository.SimDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class SimDetailsService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SimDetailsRepository simDetailsRepository;

    @Autowired
    private DetailsOfferFeign simOffersFeign;

    public SimOffersDto validateSimDetails(SimDetailsDto simDetailsDto) throws SimAlreadyActiveException, NoSuchServiceNumberOrSimNumberException {
            SimDetails simDetails = simDetailsRepository.findByServiceNumberAndSimNumber(simDetailsDto.getServiceNumber(),simDetailsDto.getSimNumber());
            if(Objects.isNull(simDetails)){ // ask why null condition to be first
                throw new NoSuchServiceNumberOrSimNumberException("Invalid details, please check again SIM number/Service number!");
            }else if(simDetails.getSimStatus().equals("active")){
                throw new SimAlreadyActiveException("SIM already active");
            }

            SimOffersDto simOffersDto = simOffersFeign.getSimOffersDto(mapper.map(simDetails,SimDetailsDto.class));
            return simOffersDto;
    }

    public SimDetailsDto create(SimDetailsDto simDetailsDto){
       SimDetails simDetails = simDetailsRepository.saveAndFlush(mapper.map(simDetailsDto,SimDetails.class));
       simDetailsDto.getSimOffersDto().setSimId(simDetails.getSimId());
       SimOffersDto simOffersDto = simOffersFeign.createSimOffers(simDetailsDto.getSimOffersDto());
       simDetailsDto.setSimOffersDto(simOffersDto);
       simDetailsDto.setSimId(simDetails.getSimId());
       return simDetailsDto;
    }

    public SimDetailsDto getSimDetailsDto(SimDetailsDto simDetailsDto) throws NoSuchServiceNumberOrSimNumberException {
        SimDetails simDetails = simDetailsRepository.findByServiceNumberAndSimNumber(simDetailsDto.getServiceNumber(),simDetailsDto.getSimNumber());
        if(Objects.isNull(simDetails)){ // ask why null condition to be first
            throw new NoSuchServiceNumberOrSimNumberException("Invalid details, please check again SIM number/Service number!");
        }
        SimDetailsDto simDetailsDto1 = mapper.map(simDetails,SimDetailsDto.class);
        SimOffersDto simOffersDto = simOffersFeign.getSimOffersDto(mapper.map(simDetails,SimDetailsDto.class));
        simDetailsDto1.setSimOffersDto(simOffersDto);
        return simDetailsDto1;
    }

    public SimDetailsDto activateSim(SimDetailsDto simDetailsDto) {
        int rowsAffected = simDetailsRepository.activateSim("active",simDetailsDto.getSimId());
        return mapper.map(simDetailsRepository.findByServiceNumberAndSimNumber(simDetailsDto.getServiceNumber(),simDetailsDto.getSimNumber()),SimDetailsDto.class);
    }
}
