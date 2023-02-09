package com.example.customerIdentityMS.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CustomerIdentityDto {
    private String uniqueIdNumber;
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    @NotNull(message = "DOB value is required")
    private LocalDate dateOfBirth;
    @Pattern(regexp = "[a-zA-Z]{1,15}",message = "Firstname should be maximum of 15 characters")
    private String firstName;
    @Pattern(regexp = "[a-zA-Z]{1,15}",message = "Lastname should be maximum of 15 characters")
    private String lastName;
    @Email(regexp = "[a-zA-Z0-9_\\-\\.]+[@][a-z]+[\\.][a-z]{2,3}",message = "Invalid Email.")
    @NotNull(message = "Email value is required")
    private String emailAddress;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
