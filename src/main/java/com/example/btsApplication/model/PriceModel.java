package com.example.btsApplication.model;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class PriceModel {
    private Long id;
    private Integer numOfDistance;
    private Integer price;
    private LocalDateTime createdDay;
    private LocalDateTime updatedDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumOfDistance() {
        return numOfDistance;
    }

    public void setNumOfDistance(Integer numOfDistance) {
        this.numOfDistance = numOfDistance;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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
