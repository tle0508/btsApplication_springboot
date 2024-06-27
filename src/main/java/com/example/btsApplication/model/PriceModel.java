package com.example.btsApplication.model;


import java.time.LocalDateTime;

import com.example.btsApplication.entity.Price;

public class PriceModel {
    private int id;
    private Long numOfDistance;
    private int price;
    private LocalDateTime createdDay;
    private LocalDateTime updatedDay;
    
    public static PriceModel convertToModel(Price priceEntity){
        PriceModel priceModel = new PriceModel();
        priceModel.setId(priceEntity.getId());
        priceModel.setNumOfDistance(priceEntity.getNumOfDistance());
        priceModel.setCreatedDay(priceEntity.getCreatedDay());
        priceModel.setUpdatedDay(priceEntity.getUpdatedDay());
        priceModel.setPrice(priceEntity.getPrice());
        return priceModel;
    }
    public PriceModel() {
    }

    public Long getNumOfDistance() {
        return numOfDistance;
    }
    public void setNumOfDistance(Long numOfDistance) {
        this.numOfDistance = numOfDistance;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
