package com.example.btsApplication.model;

import com.example.btsApplication.entity.Trip;
import com.example.btsApplication.entity.TripExtension;

public class TripModel {
    private Long id;
    private BtsModel startStation;
    private BtsModel endStation;
    private PriceModel priceModel;
    private String time;

    public static TripModel convertToModel(Trip tripEntity) {
        TripModel tripModel = new TripModel();
        tripModel.setId(tripEntity.getId());

        BtsModel startStation = BtsModel.convertToModel(tripEntity.getStartStation());
        BtsModel endStation = BtsModel.convertToModel(tripEntity.getEndStation());
        tripModel.setStartStation(startStation);
        tripModel.setEndStation(endStation);

        PriceModel price = PriceModel.convertToModel(tripEntity.getPrice());
        tripModel.setPriceModel(price);
        
        tripModel.setTime(tripEntity.getTime());
        
        return tripModel;
    }

    public static TripModel convertToModelExtention (TripExtension tripExtentionEntity) {
        TripModel tripModel = new TripModel();
        tripModel.setId(tripExtentionEntity.getId());

        BtsModel startStation = BtsModel.convertToModel(tripExtentionEntity.getStartStation());
        BtsModel endStation = BtsModel.convertToModel(tripExtentionEntity.getEndStation());
        tripModel.setStartStation(startStation);
        tripModel.setEndStation(endStation);

        PriceModel price = PriceModel.convertToModel(tripExtentionEntity.getPriceExtension());
        tripModel.setPriceModel(price);

        tripModel.setTime(tripExtentionEntity.getTime());
        return tripModel;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
