package com.example.customerMS.dto;

import javax.validation.constraints.Pattern;

public class SimDetailsDto {

    private int simId;
    //@Digits(integer = 10,fraction = 0,message = "Invalid details!! Service Number should be of 10 digits.")
    @Pattern(regexp = "[0-9]{10}", message = "Invalid details!! Service Number should be of 10 digits.")
    private String serviceNumber;
//    @Digits(integer = 13,fraction = 0, message = "Invalid details!! SIM Number should be of 13 digits.")
    @Pattern(regexp = "[0-9]{13}", message = "Invalid details!! Sim Number should be of 13 digits.")
    private String simNumber;
    private String simStatus;

    public int getSimId() {
        return simId;
    }

    public void setSimId(int simId) {
        this.simId = simId;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    public String getSimStatus() {
        return simStatus;
    }

    public void setSimStatus(String simStatus) {
        this.simStatus = simStatus;
    }
}
