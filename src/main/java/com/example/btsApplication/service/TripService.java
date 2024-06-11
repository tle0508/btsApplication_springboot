package com.example.btsApplication.service;

import com.example.btsApplication.entity.Trip;
import com.example.btsApplication.model.BtsModel;
import com.example.btsApplication.model.PriceModel;
import com.example.btsApplication.model.TripModel;
import com.example.btsApplication.repository.TripRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {
    private final TripRepository tripRepository;
  
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }
    private static TripModel convertToModel(Trip tripEntity) {
        TripModel tripModel = new TripModel();
        tripModel.setId(tripEntity.getId());

        BtsModel startStation = BtsService.convertToModel(tripEntity.getStartStation());
        BtsModel endStation = BtsService.convertToModel(tripEntity.getEndStation());
        tripModel.setStartStation(startStation);
        tripModel.setEndStation(endStation);

        PriceModel priceModel = new PriceModel();
        priceModel.setNumOfDistance(tripEntity.getPrice().getNumOfDistance());
        priceModel.setPrice(tripEntity.getPrice().getPrice());
        priceModel.setCreatedDay(tripEntity.getPrice().getCreatedDay());
        priceModel.setUpdatedDay(tripEntity.getPrice().getUpdatedDay());
        tripModel.setPriceModel(priceModel);

        return tripModel;
    }
    public List<TripModel> getTripsByStartAndEndStationId(Long startStationId, Long endStationId) {
        List<Trip> tripEntities = tripRepository.findByStartStation_IdAndEndStation_Id(startStationId, endStationId);
        return tripEntities.stream()
                .map(TripService::convertToModel)
                .collect(Collectors.toList());
    }
}
