package com.example.btsApplication.service;

import com.example.btsApplication.entity.TripExtension;
import com.example.btsApplication.model.BtsModel;
import com.example.btsApplication.model.PriceExtensionModel;

import com.example.btsApplication.model.TripExtensionModel;

import com.example.btsApplication.repository.TripExtensionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripExtensionService {
    private final TripExtensionRepository tripExtensionRepository;
    @Autowired
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

        PriceExtensionModel priceModel = new PriceExtensionModel();
        priceModel.setNumOfDistance(tripEntity.getPriceExtension().getNumOfDistance());
        priceModel.setPrice(tripEntity.getPriceExtension().getPrice());
        priceModel.setCreatedDay(tripEntity.getPriceExtension().getCreatedDay());
        priceModel.setUpdatedDay(tripEntity.getPriceExtension().getUpdatedDay());
        tripModel.setPriceExtensionModel(priceModel);

        return tripModel;
    }
    public List<TripExtensionModel> getTripsByStartAndEndStationId(Long startStationId, Long endStationId) {
        List<TripExtension> tripEntities = tripExtensionRepository.findByStartStation_IdAndEndStation_Id(startStationId, endStationId);
        return tripEntities.stream()
                .map(TripExtensionService::convertToModel)
                .collect(Collectors.toList());
    }
}
