package com.example.btsApplication.service;

import com.example.btsApplication.entity.TripExtension;
import com.example.btsApplication.model.BtsModel;

import com.example.btsApplication.model.PriceModel;
import com.example.btsApplication.model.TripExtensionModel;

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
    private static TripExtensionModel convertToModel(TripExtension tripEntity) {
        TripExtensionModel tripModel = new TripExtensionModel();
        tripModel.setId(tripEntity.getId());

        BtsModel startStation = BtsService.convertToModel(tripEntity.getStartStation());
        BtsModel endStation = BtsService.convertToModel(tripEntity.getEndStation());
        tripModel.setStartStation(startStation);
        tripModel.setEndStation(endStation);

        PriceModel price = PriceExtensionService.convertToModel(tripEntity.getPriceExtension());
        tripModel.setPriceModel(price);

        tripModel.setTime(tripEntity.getTime());
        return tripModel;
    }

    @Transactional(readOnly = true)
    public Optional<TripExtensionModel> getTripsByStartAndEndStationId(Long startStationId, Long endStationId) {
        Optional<TripExtension> tripEntities = tripExtensionRepository.findByStartStation_IdAndEndStation_Id(startStationId, endStationId);
        return tripEntities.map(TripExtensionService::convertToModel);
    }
}
