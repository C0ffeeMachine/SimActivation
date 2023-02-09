package com.example.addressMS.service;

import com.example.addressMS.dto.CustomerAddressDto;
import com.example.addressMS.entity.CustomerAddress;
import com.example.addressMS.exception.InvalidCredentialsException;
import com.example.addressMS.repository.CustomerAddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerAddressService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CustomerAddressRepository customerAddressRepository;


    public CustomerAddressDto create(CustomerAddressDto customerAddressDto) {
        CustomerAddress customerAddress = mapper.map(customerAddressDto,CustomerAddress.class);
        CustomerAddress newCustomerAddress = customerAddressRepository.saveAndFlush(customerAddress);
        return mapper.map(newCustomerAddress,CustomerAddressDto.class);
    }

    public CustomerAddressDto update(CustomerAddressDto customerAddressDto) {
        CustomerAddress customerAddress = mapper.map(customerAddressDto,CustomerAddress.class);
        CustomerAddress newCustomerAddress = customerAddressRepository.saveAndFlush(customerAddress);
        return mapper.map(newCustomerAddress,CustomerAddressDto.class);
    }

    public CustomerAddressDto getCustomerAddressDto(CustomerAddressDto customerAddressDto) throws InvalidCredentialsException {
        String address = customerAddressDto.getAddress();
        String city = customerAddressDto.getCity();
        String pinCode = customerAddressDto.getPinCode();
        String state = customerAddressDto.getState();

        CustomerAddress customerAddress = customerAddressRepository.findByAddressAndCityAndPinCodeAndState(address,city,pinCode,state);
        if(Objects.isNull(customerAddress)){
            throw new InvalidCredentialsException("Please Provide a Valid Address!!");
        }
        return mapper.map(customerAddress,CustomerAddressDto.class);
    }
}
