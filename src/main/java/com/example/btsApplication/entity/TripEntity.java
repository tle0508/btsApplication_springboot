package com.example.btsApplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trip")
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //ทำเป็น Long เพราะว่าค่าที่รับเข้ามาเป็น id
    @Column(name = "START_STATION_ID")
    private Long startStationId;

    @Column(name = "END_STATION_ID")
    private Long endStationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISTANCE", referencedColumnName = "NUM_OF_DISTANCE")
    private Price price;

    public TripEntity() {
    }

    public TripEntity(Long id, Long startStationId, Long endStationId, Price price) {
        this.id = id;
        this.startStationId = startStationId;
        this.endStationId = endStationId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStartStationId() {
        return startStationId;
    }

    public void setStartStationId(Long startStationId) {
        this.startStationId = startStationId;
    }

    public Long getEndStationId() {
        return endStationId;
    }

    public void setEndStationId(Long endStationId) {
        this.endStationId = endStationId;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
