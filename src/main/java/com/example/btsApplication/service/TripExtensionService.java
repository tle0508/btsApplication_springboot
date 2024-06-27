package com.example.btsApplication.service;

import com.example.btsApplication.entity.TripExtension;
import com.example.btsApplication.model.TripModel;
import com.example.btsApplication.repository.TripExtensionRepository;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class TripExtensionService {
    private final TripExtensionRepository tripExtensionRepository;
    
    public TripExtensionService(TripExtensionRepository tripExtensionRepository) {
        this.tripExtensionRepository = tripExtensionRepository;
    }
 

    @Transactional(readOnly = true)
    public Optional<TripModel> getTripsByStartAndEndStationId(Long startStationId, Long endStationId) {
        Optional<TripExtension> tripEntities = tripExtensionRepository.findByStartStation_IdAndEndStation_Id(startStationId, endStationId);
        return tripEntities.map(TripModel::convertToModelExtention);
    }
}
