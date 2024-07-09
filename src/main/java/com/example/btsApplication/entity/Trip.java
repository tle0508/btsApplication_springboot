package com.example.btsApplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "new_trips")
public class Trip {
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
    @JoinColumn(name = "PRICE_ID")
    private Price price;
    @Column(name ="TIME")
    private String time;
    
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
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
