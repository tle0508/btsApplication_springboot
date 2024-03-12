package com.example.btsApplication.entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "station")
public class BtsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "IS_ACTIVATE")
    private Boolean isActivate;

    @Column(name = "IS_EXTENSION")
    private Boolean isExtension;

    @Column(name = "created_day")
    private LocalDateTime createdDay;

    @Column(name = "updated_day")
    private LocalDateTime updatedDay;

    @Column(name = "bts_station_name_TH")
    private String btsStationNameTH;

    @Column(name = "bts_station_name_ENG")
    private String btsStationNameENG;

    @Column(name = "id_station")
    private String idStation;

    @Column(name = "line_color")
    private String lineColor;

    public BtsEntity(Long id, Boolean isActivate, Boolean isExtension, LocalDateTime createdDay, LocalDateTime updatedDay, String btsStationNameTH, String btsStationNameENG, String idStation, String lineColor) {
        this.id = id;
        this.isActivate = isActivate;
        this.isExtension = isExtension;
        this.createdDay = createdDay;
        this.updatedDay = updatedDay;
        this.btsStationNameTH = btsStationNameTH;
        this.btsStationNameENG = btsStationNameENG;
        this.idStation = idStation;
        this.lineColor = lineColor;
    }

    public BtsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActivate() {
        return isActivate;
    }

    public void setActivate(Boolean activate) {
        isActivate = activate;
    }

    public Boolean getExtension() {
        return isExtension;
    }

    public void setExtension(Boolean extension) {
        isExtension = extension;
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

    public String getBtsStationNameTH() {
        return btsStationNameTH;
    }

    public void setBtsStationNameTH(String btsStationNameTH) {
        this.btsStationNameTH = btsStationNameTH;
    }

    public String getBtsStationNameENG() {
        return btsStationNameENG;
    }

    public void setBtsStationNameENG(String btsStationNameENG) {
        this.btsStationNameENG = btsStationNameENG;
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    public String getLineColor() {
        return lineColor;
    }

    public void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }
}
