package com.example.btsApplication.model;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class PriceModel {
    private Long id;
    private Integer price;
    private LocalDateTime createdDay;
    private LocalDateTime updatedDay;



    public PriceModel(Long id, Integer price, LocalDateTime createdDay, LocalDateTime updatedDay) {
        this.id = id;
        this.price = price;
        this.createdDay = createdDay;
        this.updatedDay = updatedDay;
    }



    public PriceModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
