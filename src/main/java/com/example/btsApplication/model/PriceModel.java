package com.example.btsApplication.model;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class PriceModel {
    private Long numOfDistance;
    private int price;
    private LocalDateTime createdDay;
    private LocalDateTime updatedDay;

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


}
