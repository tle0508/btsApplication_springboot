package com.example.btsApplication.model;

public class TripExtensionModel {
    private Long id;
    private BtsModel startStation;
    private BtsModel endStation;
    private PriceExtensionModel priceExtensionModel;
    private String time;
    
    public TripExtensionModel() {
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

	public PriceExtensionModel getPriceExtensionModel() {
		return priceExtensionModel;
	}

	public void setPriceExtensionModel(PriceExtensionModel priceExtensionModel) {
		this.priceExtensionModel = priceExtensionModel;
	}

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
