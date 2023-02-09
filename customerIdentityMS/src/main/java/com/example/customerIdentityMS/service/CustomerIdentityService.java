package com.example.customerIdentityMS.service;

import com.example.customerIdentityMS.dto.CustomerIdentityDto;
import com.example.customerIdentityMS.entity.CustomerIdentity;
import com.example.customerIdentityMS.exception.InvalidCredentialsException;
import com.example.customerIdentityMS.exception.NoSuchCustomerException;
import com.example.customerIdentityMS.repository.CustomerIdentityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerIdentityService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CustomerIdentityRepository customerIdentityRepository;


    public CustomerIdentityDto create(CustomerIdentityDto customerIdentityDto) {
        CustomerIdentity customerIdentity = mapper.map(customerIdentityDto,CustomerIdentity.class);
        CustomerIdentity newCustomerIdentity = customerIdentityRepository.saveAndFlush(customerIdentity);
        return mapper.map(newCustomerIdentity,CustomerIdentityDto.class);
    }

    public String validateCustomerIdentity(CustomerIdentityDto customerIdentityDto) throws NoSuchCustomerException {
        CustomerIdentity customerIdentity = customerIdentityRepository.findByDateOfBirthAndEmailAddress(customerIdentityDto.getDateOfBirth(),customerIdentityDto.getEmailAddress());
        if(Objects.isNull(customerIdentity)){
            throw new NoSuchCustomerException("No request placed for you.");
        }
        return "Successfully Validated!!";
    }

    public String validateCustomerPersonalDetails(CustomerIdentityDto customerIdentityDto) throws NoSuchCustomerException, InvalidCredentialsException {
        CustomerIdentity customerIdentity = customerIdentityRepository.findByFirstNameAndLastName(customerIdentityDto.getFirstName(),customerIdentityDto.getLastName());
        if(Objects.isNull(customerIdentity)){
            throw new NoSuchCustomerException("No customer found for the provided details");
        }else if(!customerIdentityDto.getEmailAddress().equals(customerIdentity.getEmailAddress())){
            throw new InvalidCredentialsException("“Invalid email details!!");
        }
        return "Customer details verified Successfully!!";
    }

    public CustomerIdentityDto getCustomerIdentityDto(CustomerIdentityDto customerIdentityDto) throws NoSuchCustomerException {
        CustomerIdentity customerIdentity = customerIdentityRepository.findByUniqueIdNumber(customerIdentityDto.getUniqueIdNumber());
        if(Objects.isNull(customerIdentity)){
            throw new NoSuchCustomerException("No customer found for the provided details");
        }
        return mapper.map(customerIdentity,CustomerIdentityDto.class);
    }
}
