package com.example.ms1.entity;

import javax.persistence.*;

@Entity
@Table(name = "sim_offers")
public class SimOffers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "offer_id")
    private int offerId;
    @Column(name = "call_qty")
    private int callQty;
    @Column(name = "cost")
    private int cost;
    @Column(name = "data_qty")
    private int dataQty;
    @Column(name = "duration")
    private int duration;
    @Column(name = "offer_name")
    private String offerName;
    @Column(name = "sim_id")
    private int simId;

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getCallQty() {
        return callQty;
    }

    public void setCallQty(int callQty) {
        this.callQty = callQty;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDataQty() {
        return dataQty;
    }

    public void setDataQty(int dataQty) {
        this.dataQty = dataQty;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public int getSimId() {
        return simId;
    }

    public void setSimId(int simId) {
        this.simId = simId;
    }
}
