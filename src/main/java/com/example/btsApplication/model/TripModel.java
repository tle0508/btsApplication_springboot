package com.example.btsApplication.model;

public class TripModel {
    private Long id;
    private BtsModel startStation;
    private BtsModel endStation;
    private PriceModel priceModel;
    private long stationDistance;
    public TripModel() {
    }

    public TripModel(Long id, BtsModel startStation, BtsModel endStation, PriceModel priceModel, long stationDistance) {
        this.id = id;
        this.startStation = startStation;
        this.endStation = endStation;
        this.priceModel = priceModel;
        this.stationDistance = stationDistance;
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

    public long getStationDistance() {
        return stationDistance;
    }

    public void setStationDistance(long stationDistance) {
        this.stationDistance = stationDistance;
    }
}
