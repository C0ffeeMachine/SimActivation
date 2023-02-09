package com.example.customerMS.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CustomerDto {
    @NotNull
    @Pattern(regexp = "[0-9]{16}",message = "Id should be 16 digit")
    private String uniqueIdNumber;
    @NotNull
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDate dateOfBirth;
    @NotNull
    @Email
    private String emailAddress;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String idType;
    @NotNull
    @Valid
    private CustomerAddressDto customerAddressDto;
    @NotNull
    @Valid
    private SimDetailsDto simDetailsDto;
    @NotNull
    private String state;

    public String getUniqueIdNumber() {
        return uniqueIdNumber;
    }

    public void setUniqueIdNumber(String uniqueIdNumber) {
        this.uniqueIdNumber = uniqueIdNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public CustomerAddressDto getCustomerAddressDto() {
        return customerAddressDto;
    }

    public void setCustomerAddressDto(CustomerAddressDto customerAddressDto) {
        this.customerAddressDto = customerAddressDto;
    }

    public SimDetailsDto getSimDetailsDto() {
        return simDetailsDto;
    }

    public void setSimDetailsDto(SimDetailsDto simDetailsDto) {
        this.simDetailsDto = simDetailsDto;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
