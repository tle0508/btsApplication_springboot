package com.example.btsApplication.model;


import java.time.LocalDateTime;

import com.example.btsApplication.entity.BtsStation;

public class BtsModel {
    private Long id;
    private Boolean isActivate;
    private Boolean isExtension;
    private LocalDateTime createdDay;
    private LocalDateTime updatedDay;
    private String btsStationNameTH;
    private String btsStationNameENG;
    private String idStation;
    private Integer extensionGroupNumber;
    private String url;
    private LineStaionModel lineStaionModel;
    
  public static  BtsModel convertToModel(BtsStation btsEntity){
        BtsModel btsModel = new BtsModel();
        btsModel.setId(btsEntity.getId());
        btsModel.setActivate(btsEntity.getActivate());
        btsModel.setBtsStationNameENG(btsEntity.getBtsStationNameENG());
        btsModel.setBtsStationNameTH(btsEntity.getBtsStationNameTH());
        btsModel.setCreatedDay(btsEntity.getCreatedDay());
        btsModel.setExtension(btsEntity.getExtension());
        btsModel.setUpdatedDay(btsEntity.getUpdatedDay());
        btsModel.setIdStation(btsEntity.getIdStation());
        btsModel.setUrl(btsEntity.getUrl());
        btsModel.setExtensionGroupNumber(btsEntity.getExtensionGroupNumber());
        LineStaionModel lineStaionModel = LineStaionModel.convertToModel(btsEntity.getLineStaion());
        btsModel.setLineStaionModel(lineStaionModel);

       return btsModel;
    }
    
    public Integer getExtensionGroupNumber() {
    return extensionGroupNumber;
}

public void setExtensionGroupNumber(Integer extensionGroupNumber) {
    this.extensionGroupNumber = extensionGroupNumber;
}

    public LineStaionModel getLineStaionModel() {
        return lineStaionModel;
    }
    public void setLineStaionModel(LineStaionModel lineStaionModel) {
        this.lineStaionModel = lineStaionModel;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
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
}
