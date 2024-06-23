package com.example.btsApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.btsApplication.entity.LineStaion;


public interface LineStationRepository  extends JpaRepository<LineStaion, Long> {
	
}
