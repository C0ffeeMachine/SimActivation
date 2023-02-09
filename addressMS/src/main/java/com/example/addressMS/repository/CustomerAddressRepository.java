package com.example.addressMS.repository;

import com.example.addressMS.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Integer> {

//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "update CustomerAddress ca set ca.address = ?1")
//    public CustomerAddress updateCustomerAddress(CustomerAddress customerAddress);

    public CustomerAddress findByAddressAndCityAndPinCodeAndState(String address, String city, String pinCode, String state);
}
