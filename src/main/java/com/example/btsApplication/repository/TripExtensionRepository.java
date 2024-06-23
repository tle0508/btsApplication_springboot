package com.example.btsApplication.repository;

import com.example.btsApplication.entity.TripExtension;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TripExtensionRepository extends JpaRepository<TripExtension, Long> {
    Optional<TripExtension> findByStartStation_IdAndEndStation_Id(Long startStationId, Long endStationId);
}