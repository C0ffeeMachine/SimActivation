package com.example.customerIdentityMS.repository;

import com.example.customerIdentityMS.entity.CustomerIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity,Long> {
    public CustomerIdentity findByDateOfBirthAndEmailAddress(LocalDate dateOfBirth,String emailAddress);

    public CustomerIdentity findByFirstNameAndLastName(String firstName, String lastName);

    public CustomerIdentity findByUniqueIdNumber(String uid);
}
