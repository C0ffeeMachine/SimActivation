package com.example.customerMS.service;

import com.example.customerMS.controller.CustomerAddressApi;
import com.example.customerMS.controller.CustomerIdentityApi;
import com.example.customerMS.controller.SimDetailsApi;
import com.example.customerMS.dto.CustomerAddressDto;
import com.example.customerMS.dto.CustomerDto;
import com.example.customerMS.dto.CustomerIdentityDto;
import com.example.customerMS.dto.SimDetailsDto;
import com.example.customerMS.entity.Customer;
import com.example.customerMS.exception.InvalidCredentialsException;
import com.example.customerMS.exception.SimAlreadyActiveException;
import com.example.customerMS.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class CustomerService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CustomerIdentityApi customerIdentityApi;

    @Autowired
    private CustomerAddressApi customerAddressApi;

    @Autowired
    private SimDetailsApi simDetailsApi;

    @Autowired
    private CustomerRepository customerRepository;

    public String validateAndCreateCustomer(CustomerDto customerDto) throws InvalidCredentialsException, SimAlreadyActiveException {
        LocalDate dob = customerDto.getDateOfBirth();
        String email = customerDto.getEmailAddress();
        String fName = customerDto.getFirstName();
        String lName = customerDto.getLastName();
        String state = customerDto.getState();
        String address = customerDto.getCustomerAddressDto().getAddress();
        String city = customerDto.getCustomerAddressDto().getCity();
        String pinCode = customerDto.getCustomerAddressDto().getPinCode();
        String addressState = customerDto.getCustomerAddressDto().getState();
        String serviceNumber = customerDto.getSimDetailsDto().getServiceNumber();
        String simNumber = customerDto.getSimDetailsDto().getSimNumber();
        String simStatus = customerDto.getSimDetailsDto().getSimStatus();

        CustomerIdentityDto customerIdentityDto = customerIdentityApi.getCustomerIdentityDto(mapper.map(customerDto,CustomerIdentityDto.class));
        CustomerAddressDto customerAddressDto = customerAddressApi.getCustomerAddressDto(customerDto.getCustomerAddressDto());
        SimDetailsDto simDetailsDto = simDetailsApi.getSimDetailsDto(customerDto.getSimDetailsDto());

        System.out.println(customerIdentityDto.getUniqueIdNumber());
        System.out.println(customerAddressDto.getAddressId());
        System.out.println(simDetailsDto.getSimId());

        if(Objects.isNull(customerIdentityDto) || Objects.isNull(customerAddressDto) || Objects.isNull(simDetailsDto)){
            throw new InvalidCredentialsException("Invalid details");
        }else if(!dob.isEqual(customerIdentityDto.getDateOfBirth())){
            throw new InvalidCredentialsException("Incorrect date of birth details");
        }else if(simDetailsDto.getSimStatus().equals("active")){
            throw new SimAlreadyActiveException("Sim Already active!!");
        }else if(email.equals(customerIdentityDto.getEmailAddress()) &&
                 fName.equals(customerIdentityDto.getFirstName()) &&
                 lName.equals(customerIdentityDto.getLastName()) &&
                 state.equals(customerIdentityDto.getState()) &&
                 address.equals(customerAddressDto.getAddress()) &&
                 city.equals(customerAddressDto.getCity()) &&
                 pinCode.equals(customerAddressDto.getPinCode()) &&
                 addressState.equals(customerAddressDto.getState()) &&
                simDetailsDto.getSimStatus().equals("inactive"))
        {
            customerDto.setCustomerAddressDto(customerAddressDto);
            customerDto.setSimDetailsDto(simDetailsDto);

            Customer cust = mapper.map(customerDto,Customer.class);
            cust.setCustomerAddress1(customerAddressDto.getAddressId());
            cust.setSimId1(simDetailsDto.getSimId());

//            Customer customer = new Customer();
//            customer.setUniqueIdNumber(customerDto.getUniqueIdNumber());
//            customer.setDateOfBirth(customerDto.getDateOfBirth());
//            customer.setEmailAddress(customerDto.getEmailAddress());
//            customer.setFirstName(customerDto.getFirstName());
//            customer.setLastName(customerDto.getLastName());
//            customer.setIdType(customerDto.getIdType());
//            customer.setCustomerAddress(customerAddressDto.getAddressId());
//            customer.setSimId(simDetailsDto.getSimId());
//            customer.setState(customerDto.getState());


            customerRepository.saveAndFlush(cust);

            SimDetailsDto newSimDetailsDto = simDetailsApi.activateSim(simDetailsDto);
            newSimDetailsDto = simDetailsApi.getSimDetailsDto(simDetailsDto);
            System.out.println(newSimDetailsDto.getSimStatus());
//            if(newSimDetailsDto.getSimStatus()=="active")
//                return "Sim activated successfully!!";
//            else
//                return "Something went Wrong!!";
            return "Sim activated successfully!!";
        }else{
            throw new InvalidCredentialsException("Invalid details");
        }
    }
}
