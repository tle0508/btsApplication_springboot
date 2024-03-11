package com.example.btsApplication.model;


import java.time.LocalDateTime;

public class BtsModel {
    private Long id;
    private Boolean isActivate;
    private Boolean isExtension;
    private LocalDateTime createdDay;
    private LocalDateTime updatedDay;
    private Boolean isCenter;
    private String btsStationNameTH;
    private String btsStationNameENG;
    private String idStation;
    private String lineColor;
    private Long nextStationId;
    private Long previousStationId;

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

    public Boolean getCenter() {
        return isCenter;
    }

    public void setCenter(Boolean center) {
        isCenter = center;
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

    public Long getNextStationId() {
        return nextStationId;
    }

    public void setNextStationId(Long nextStationId) {
        this.nextStationId = nextStationId;
    }

    public Long getPreviousStationId() {
        return previousStationId;
    }

    public void setPreviousStationId(Long previousStationId) {
        this.previousStationId = previousStationId;
    }
}
