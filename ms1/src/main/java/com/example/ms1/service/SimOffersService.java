package com.example.ms1.service;

import com.example.ms1.controller.OfferDetailsFeign;
import com.example.ms1.dto.SimDetailsDto;
import com.example.ms1.dto.SimOffersDto;
import com.example.ms1.entity.SimOffers;
import com.example.ms1.repository.SimOffersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SimOffersService {

    @Autowired
    private SimOffersRepository simOffersRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OfferDetailsFeign simDetailsFeign;

    public SimOffersDto create(SimOffersDto simOffersDto) {
        SimOffers simOffers = mapper.map(simOffersDto,SimOffers.class);
        SimOffers offers = simOffersRepository.saveAndFlush(simOffers);
        return mapper.map(offers,SimOffersDto.class);
    }

    public SimOffersDto getSimOffersDto(SimDetailsDto simDetailsDto) {
        SimOffers simOffers = simOffersRepository.findBySimId(simDetailsDto.getSimId());
        return mapper.map(simOffers,SimOffersDto.class);
    }
}
