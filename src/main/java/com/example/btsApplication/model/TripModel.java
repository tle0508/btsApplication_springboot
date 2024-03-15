package com.example.btsApplication.model;

public class TripModel {
    private Long id;
    private BtsModel startStationId;
    private BtsModel endStationId;
    private PriceModel priceModel;

    public TripModel() {
    }

    public TripModel(Long id, BtsModel startStationId, BtsModel endStationId, PriceModel priceModel) {
        this.id = id;
        this.startStationId = startStationId;
        this.endStationId = endStationId;
        this.priceModel = priceModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BtsModel getStartStationId() {
        return startStationId;
    }

    public void setStartStationId(BtsModel startStationId) {
        this.startStationId = startStationId;
    }

    public BtsModel getEndStationId() {
        return endStationId;
    }

    public void setEndStationId(BtsModel endStationId) {
        this.endStationId = endStationId;
    }

    public PriceModel getPriceModel() {
        return priceModel;
    }

    public void setPriceModel(PriceModel priceModel) {
        this.priceModel = priceModel;
    }
}
