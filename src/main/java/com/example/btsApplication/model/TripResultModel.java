package com.example.btsApplication.model;

public class TripResultModel {
    private Integer price;
    private Integer numOfStation;

    public TripResultModel(Integer price, Integer numOfStation) {
        this.price = price;
        this.numOfStation = numOfStation;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumOfStation() {
        return numOfStation;
    }

    public void setNumOfStation(Integer numOfStation) {
        this.numOfStation = numOfStation;
    }
}
