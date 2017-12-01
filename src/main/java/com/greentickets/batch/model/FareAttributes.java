package com.greentickets.batch.model;

import java.math.BigDecimal;


public class FareAttributes {


    private long Fare_ID;
    private BigDecimal Price;
    private String Currency_Type;
    private int Transfers;
    private long Agency_ID;



    public long getFare_ID() {
        return Fare_ID;
    }

    public void setFare_ID(long fare_ID) {
        Fare_ID = fare_ID;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public String getCurrency_Type() {
        return Currency_Type;
    }

    public void setCurrency_Type(String currency_Type) {
        Currency_Type = currency_Type;
    }

    public int getTransfers() {
        return Transfers;
    }

    public void setTransfers(int transfers) {
        Transfers = transfers;
    }

    public long getAgency_ID() {
        return Agency_ID;
    }

    public void setAgency_ID(long agency_ID) {
        Agency_ID = agency_ID;
    }

}
