package com.example.btsApplication.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "line_station")
public class LineStaion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "LINE_STATION_NAME_TH")
    private String lineStationNameTH;
    @Column(name = "LINE_STATION_NAME_ENG")
    private String lineStationNameENG;
	@Column(name = "COLOR")
    private String color;
    @Column(name = "CREATED_DAY")
    private LocalDateTime createdDay;
    @Column(name = "UPDATED_DAY")
    private LocalDateTime updatedDay;
	
	

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
