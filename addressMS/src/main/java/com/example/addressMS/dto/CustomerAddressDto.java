package com.example.addressMS.dto;

import javax.validation.constraints.Pattern;

public class CustomerAddressDto {

    private int addressId;
    @Pattern(regexp = "[a-zA-Z0-9]{1,25}",message = "Address should be maximum of 25 characters")
    private String address;
    @Pattern(regexp = "^[A-Za-z0-9 ]+$",message = "City should not contain any special characters except space")
    private String city;
    @Pattern(regexp = "[0-9]{6}",message = "Pin should be 6 digit number")
    private String pinCode;
    @Pattern(regexp = "^[A-Za-z0-9 ]+$",message = "State should not contain any special characters except space")
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
