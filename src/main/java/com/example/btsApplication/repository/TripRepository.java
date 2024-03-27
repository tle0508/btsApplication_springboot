package com.example.btsApplication.repository;
import com.example.btsApplication.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<TripEntity, Long> {
    List<TripEntity> findByStartStation_IdAndEndStation_Id(Long startStationId, Long endStationId);
}