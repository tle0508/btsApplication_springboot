package com.example.btsApplication.repository;

import com.example.btsApplication.entity.TripExtension;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TripExtensionRepository extends JpaRepository<TripExtension, Long> {
    List<TripExtension> findByStartStation_IdAndEndStation_Id(Long startStationId, Long endStationId);
}