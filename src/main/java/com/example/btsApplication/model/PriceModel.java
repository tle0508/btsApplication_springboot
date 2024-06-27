package com.example.btsApplication.model;


import java.time.LocalDateTime;

import com.example.btsApplication.entity.Price;
import com.example.btsApplication.entity.PriceExtension;

public class PriceModel {
    private Long id;
    private int price;
    private LocalDateTime createdDay;
    private LocalDateTime updatedDay;
    private String stationDistance;
    
    public static PriceModel convertToModel(Price priceEntity){
        PriceModel priceModel = new PriceModel();
        priceModel.setId(priceEntity.getId());
        priceModel.setCreatedDay(priceEntity.getCreatedDay());
        priceModel.setUpdatedDay(priceEntity.getUpdatedDay());
        priceModel.setPrice(priceEntity.getPrice());
        priceModel.setStationDistance(priceEntity.getStationDistance());
        return priceModel;
    }
      public static PriceModel convertToModel(PriceExtension priceEntity) {
        PriceModel priceModel = new PriceModel();
        priceModel.setId(priceEntity.getId());
        priceModel.setCreatedDay(priceEntity.getCreatedDay());
        priceModel.setUpdatedDay(priceEntity.getUpdatedDay());
        priceModel.setPrice(priceEntity.getPrice());
        priceModel.setStationDistance(priceEntity.getStationDistance());
        return priceModel;
    }

    public PriceModel() {
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public LocalDateTime getCreatedDay() {
        return createdDay;
    }
    public void setCreatedDay(LocalDateTime createdDay) {
        this.createdDay = createdDay;
    }
    public LocalDateTime getUpdatedDay() {
        return updatedDay;
    }
    public void setUpdatedDay(LocalDateTime updatedDay) {
        this.updatedDay = updatedDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStationDistance() {
        return stationDistance;
    }
    public void setStationDistance(String stationDistance) {
        this.stationDistance = stationDistance;
    }


}
