package com.example.btsApplication.repository;
import com.example.btsApplication.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Optional<Trip> findByStartStation_IdAndEndStation_Id(Long startStationId, Long endStationId);
}