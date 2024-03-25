package com.example.btsApplication.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "price")
public class Price {
    @Id
    @Column(name = "NUM_OF_DISTANCE")
    private Long numOfDistance;

    @Column(name = "PRICE")
    private int price;
    @Column(name = "PRICE_INCLUDES_EXTENSION")
    private Integer priceIncludesExtension;

    @Column(name = "CREATED_DAY", updatable = false)
    private LocalDateTime createdDay;

    @Column(name = "UPDATED_DAY")
    private LocalDateTime updatedDay;

    public Price() {
    }

    public Price(Long numOfDistance, int price, int priceIncludesExtension, LocalDateTime createdDay, LocalDateTime updatedDay) {
        this.numOfDistance = numOfDistance;
        this.price = price;
        this.priceIncludesExtension = priceIncludesExtension;
        this.createdDay = createdDay;
        this.updatedDay = updatedDay;
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

    public int getPriceIncludesExtension() {
        return priceIncludesExtension;
    }

    public void setPriceIncludesExtension(int priceIncludesExtension) {
        this.priceIncludesExtension = priceIncludesExtension;
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
