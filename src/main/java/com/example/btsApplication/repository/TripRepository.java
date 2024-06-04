package com.example.btsApplication.repository;
import com.example.btsApplication.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByStartStation_IdAndEndStation_Id(Long startStationId, Long endStationId);
}