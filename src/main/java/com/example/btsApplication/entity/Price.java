package com.example.btsApplication.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "prices")
public class Price {
    
    @Column(name = "ID")
    private int id;
    @Id
    @Column(name = "NUM_OF_DISTANCE")
    private Long numOfDistance;
    @Column(name = "PRICE")
    private int price;
    @Column(name = "CREATED_DAY", updatable = false)
    private LocalDateTime createdDay;
    @Column(name = "UPDATED_DAY")
    private LocalDateTime updatedDay;

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
