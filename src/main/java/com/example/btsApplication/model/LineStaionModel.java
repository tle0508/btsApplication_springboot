package com.example.btsApplication.model;

import java.time.LocalDateTime;

import com.example.btsApplication.entity.LineStaion;


public class LineStaionModel {
	private Long id;   
    private String lineStationNameTH;   
    private String lineStationNameENG;	
    private String color;
    private LocalDateTime createdDay; 
    private LocalDateTime updatedDay;
	
	 public static  LineStaionModel convertToModel(LineStaion lineStaion){
        LineStaionModel lineStaionModel = new LineStaionModel();
        lineStaionModel.setColor(lineStaion.getColor());
        lineStaionModel.setId(lineStaion.getId());
        lineStaionModel.setLineStationNameENG(lineStaion.getLineStationNameENG());
        lineStaionModel.setLineStationNameTH(lineStaion.getLineStationNameTH());
        lineStaionModel.setCreatedDay(lineStaion.getCreatedDay());
        lineStaionModel.setUpdatedDay(lineStaion.getUpdatedDay());
       return lineStaionModel;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLineStationNameTH() {
		return lineStationNameTH;
	}

	public void setLineStationNameTH(String lineStationNameTH) {
		this.lineStationNameTH = lineStationNameTH;
	}

	public String getLineStationNameENG() {
		return lineStationNameENG;
	}

	public void setLineStationNameENG(String lineStationNameENG) {
		this.lineStationNameENG = lineStationNameENG;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
