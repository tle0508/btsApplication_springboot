package com.example.btsApplication.service;

import com.example.btsApplication.entity.Price;
import com.example.btsApplication.entity.TripEntity;
import com.example.btsApplication.model.BtsModel;
import com.example.btsApplication.model.PriceModel;
import com.example.btsApplication.model.TripModel;
import com.example.btsApplication.repository.PriceRepository;

import com.example.btsApplication.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final BtsService btsService;

    @Autowired
    public TripService(TripRepository tripRepository, BtsService btsService) {
        this.tripRepository = tripRepository;
        this.btsService = btsService;
    }

    private TripModel convertToModel(TripEntity tripEntity) {
        TripModel tripModel = new TripModel();
        tripModel.setId(tripEntity.getId());

        BtsModel startStation = btsService.findById(tripEntity.getStartStationId());
        BtsModel endStation = btsService.findById(tripEntity.getEndStationId());
        tripModel.setStartStationId(startStation);
        tripModel.setEndStationId(endStation);

        PriceModel priceModel = new PriceModel();
        priceModel.setNumOfDistance(tripEntity.getPrice().getNumOfDistance());
        priceModel.setPrice(tripEntity.getPrice().getPrice());
        priceModel.setCreatedDay(tripEntity.getPrice().getCreatedDay());
        priceModel.setUpdatedDay(tripEntity.getPrice().getUpdatedDay());
        priceModel.setPriceIncludesExtension(tripEntity.getPrice().getPriceIncludesExtension());
        tripModel.setPriceModel(priceModel);
        return tripModel;
    }
    public List<TripModel> findTripsByStartAndEndStation(Long startStationId, Long endStationId) {
        List<TripEntity> tripEntities = tripRepository.findByStartStationIdAndEndStationId(startStationId, endStationId);
        return tripEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

}
