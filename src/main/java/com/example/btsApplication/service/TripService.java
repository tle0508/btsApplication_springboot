package com.example.btsApplication.service;

import com.example.btsApplication.entity.Trip;
import com.example.btsApplication.model.TripModel;
import com.example.btsApplication.repository.TripRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class TripService {
    private final TripRepository tripRepository;
  
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    
    
    @Transactional(readOnly = true)
    public Optional<TripModel> getTripsByStartAndEndStationId(Long startStationId, Long endStationId){
        Optional<Trip> tripEntities = tripRepository.findByStartStation_IdAndEndStation_Id(startStationId, endStationId);
        return tripEntities.map(TripModel::convertToModel);
    }

   
}
