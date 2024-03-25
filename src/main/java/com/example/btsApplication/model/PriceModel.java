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
    private int priceIncludesExtension;

    public PriceModel() {
    }

    public PriceModel(Long numOfDistance, int price, LocalDateTime createdDay, LocalDateTime updatedDay, int priceIncludesExtension) {
        this.numOfDistance = numOfDistance;
        this.price = price;
        this.createdDay = createdDay;
        this.updatedDay = updatedDay;
        this.priceIncludesExtension = priceIncludesExtension;
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

    public int getPriceIncludesExtension() {
        return priceIncludesExtension;
    }

    public void setPriceIncludesExtension(int priceIncludesExtension) {
        this.priceIncludesExtension = priceIncludesExtension;
    }
}
