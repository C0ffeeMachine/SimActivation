package com.example.customerIdentityMS.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table(name = "customer_identity")
public class CustomerIdentity {
    @Id
    @Column(name = "unique_id_number")
    private String uniqueIdNumber;
    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDate dateOfBirth;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_address")
    @Email
    private String emailAddress;
    @Column(name = "state")
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
