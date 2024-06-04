package com.example.btsApplication.entity;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "trip")
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "START_STATION_ID")
    private BtsStation startStation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "END_STATION_ID")
    private BtsStation endStation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISTANCE")
    private Price price;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BtsStation getStartStation() {
        return startStation;
    }
    public void setStartStation(BtsStation startStation) {
        this.startStation = startStation;
    }
    public BtsStation getEndStation() {
        return endStation;
    }
    public void setEndStation(BtsStation endStation) {
        this.endStation = endStation;
    }
    public Price getPrice() {
        return price;
    }
    public void setPrice(Price price) {
        this.price = price;
    }
}
