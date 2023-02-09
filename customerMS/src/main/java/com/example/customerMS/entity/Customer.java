package com.example.customerMS.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "unique_id_number")
    private String uniqueIdNumber;
    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDate dateOfBirth;
    @Column(name = "email_address")
    @Email
    private String emailAddress;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "id_type")
    private String idType;
    @Column(name = "customer_address_address_id")
    private int customerAddress1;
    @Column(name = "sim_id")
    private int simId1;
    @Column(name = "state")
    private String state;

//    public Customer(String uniqueIdNumber, LocalDate dateOfBirth, String emailAddress, String firstName, String lastName, String idType, int customerAddress, int simId, String state) {
//        this.uniqueIdNumber = uniqueIdNumber;
//        this.dateOfBirth = dateOfBirth;
//        this.emailAddress = emailAddress;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.idType = idType;
//        this.customerAddress = customerAddress;
//        this.simId = simId;
//        this.state = state;
//    }
//
//    public Customer() {
//    }

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

    public int getCustomerAddress1() {
        return customerAddress1;
    }

    public void setCustomerAddress1(int customerAddress1) {
        this.customerAddress1 = customerAddress1;
    }

    public int getSimId1() {
        return simId1;
    }

    public void setSimId1(int simId1) {
        this.simId1 = simId1;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
