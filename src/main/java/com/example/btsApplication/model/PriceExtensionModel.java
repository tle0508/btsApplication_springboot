package com.example.btsApplication.model;

import java.time.LocalDateTime;

public class PriceExtensionModel {
    private int id;
    private Long numOfDistance;
    private int price;
    private LocalDateTime createdDay;
    private LocalDateTime updatedDay;

    public PriceExtensionModel() {
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
