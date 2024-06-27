package com.example.btsApplication.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "prices_extension")
public class PriceExtension {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRICE")
    private int price;
    @Column(name = "CREATED_DAY", updatable = false)
    private LocalDateTime createdDay;
    @Column(name = "UPDATED_DAY")
    private LocalDateTime updatedDay;
    @Column(name = "STATION_DISTANCE")
    private String stationDistance;
    
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
