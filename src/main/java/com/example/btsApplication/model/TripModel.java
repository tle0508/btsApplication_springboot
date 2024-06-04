package com.example.btsApplication.model;

public class TripModel {
    private Long id;
    private BtsModel startStation;
    private BtsModel endStation;
    private PriceModel priceModel;

    public TripModel() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BtsModel getStartStation() {
        return startStation;
    }
    public void setStartStation(BtsModel startStation) {
        this.startStation = startStation;
    }
    public BtsModel getEndStation() {
        return endStation;
    }
    public void setEndStation(BtsModel endStation) {
        this.endStation = endStation;
    }
    public PriceModel getPriceModel() {
        return priceModel;
    }
    public void setPriceModel(PriceModel priceModel) {
        this.priceModel = priceModel;
    }
}
