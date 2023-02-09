package com.example.addressMS.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_address")
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressId;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "pin_code")
    private String pinCode;
    @Column(name = "state")
    private String state;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
