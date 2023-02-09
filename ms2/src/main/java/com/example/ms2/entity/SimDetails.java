package com.example.ms2.entity;

import javax.persistence.*;

@Entity
@Table(name = "sim_details")
public class SimDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sim_id")
    private int simId;
    @Column(name = "service_number")
   // @Digits(integer = 10,fraction = 0,message = "Invalid details!! Service Number should be of 10 digits.")
    private String serviceNumber;
   // @Digits(integer = 13,fraction = 0, message = "Invalid details!! SIM Number should be of 13 digits.")
    @Column(name = "sim_number")
    private String simNumber;
    @Column(name = "sim_status")
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
