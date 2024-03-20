package com.example.btsApplication.service;

import com.example.btsApplication.entity.PriceEntity;
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
    private final PriceRepository priceRepository;
    @Autowired
    public TripService(TripRepository tripRepository, BtsService btsService,PriceRepository priceRepository) {
        this.tripRepository = tripRepository;
        this.btsService = btsService;
        this.priceRepository = priceRepository;
    }

    private TripModel processSpecialType(TripEntity tripEntity) {
        PriceEntity priceExtension = priceRepository.findById(9L).orElse(null);
        int extensionPrice = priceExtension.getPrice()-15;
        return convertToModel(tripEntity, extensionPrice);
    }

    private TripModel processNormalType(TripEntity tripEntity) {
        PriceEntity priceExtension = priceRepository.findById(9L).orElse(null);
        int extensionPrice = priceExtension.getPrice();
        return convertToModel(tripEntity, extensionPrice);
    }

    private TripModel convertToModel(TripEntity tripEntity, int extensionPrice) {
        TripModel tripModel = new TripModel();
        tripModel.setId(tripEntity.getId());

        BtsModel startStation = btsService.findById(tripEntity.getStartStationId());
        BtsModel endStation = btsService.findById(tripEntity.getEndStationId());
        tripModel.setStartStationId(startStation);
        tripModel.setEndStationId(endStation);

        PriceModel priceModel = new PriceModel();
        priceModel.setId(tripEntity.getPrice().getId());
        priceModel.setPrice(tripEntity.getPrice().getPrice());
        priceModel.setCreatedDay(tripEntity.getPrice().getCreatedDay());
        priceModel.setUpdatedDay(tripEntity.getPrice().getUpdatedDay());

        int adjustedPrice = adjustPrice(startStation, endStation, priceModel, extensionPrice);
        priceModel.setPrice(adjustedPrice);

        tripModel.setPriceModel(priceModel);
        return tripModel;
    }

    private int adjustPrice(BtsModel startStation, BtsModel endStation, PriceModel priceModel, int extensionPrice) {
        int adjustedPrice = priceModel.getPrice();

        if (startStation.getExtension() && endStation.getExtension()) {
            if ((startStation.getId() < 17 && endStation.getId() > 17)
                    || (startStation.getId() > 34 && startStation.getId() < 49 && (endStation.getId() < 34 || endStation.getId() > 58))
                    || (startStation.getId() > 58 && endStation.getId() < 58)) {
                adjustedPrice += extensionPrice;
            }else if(extensionPrice == 0){
                adjustedPrice = extensionPrice;
            }
        }
        if (startStation.getExtension() && !endStation.getExtension()) {
            if (!(endStation.getId() == 17) && !(endStation.getId() == 34)) {
                adjustedPrice += extensionPrice;
            }
        } else if (!startStation.getExtension() && endStation.getExtension()) {
            if (!(startStation.getId() == 17) && !(startStation.getId() == 34) && !(startStation.getId() == 58)) {
                if ((endStation.getId() > 0 && endStation.getId() < 17)
                        || (endStation.getId() > 34 && endStation.getId() < 49)
                        || (endStation.getId() > 58 && endStation.getId() < 63)) {
                    adjustedPrice += extensionPrice;
                }
            } else {
                if (startStation.getId() == 17 && endStation.getId() > 17
                        || (startStation.getId() == 34 && (endStation.getId() < 34 || endStation.getId() > 58))
                        || (startStation.getId() == 58 && !(endStation.getId() > 58))) {
                    adjustedPrice += extensionPrice;
                }
            }
        }
        return adjustedPrice;
    }

    public List<TripModel> findTripsByStartAndEndStationNormalType(Long startStationId, Long endStationId) {
        List<TripEntity> tripEntities = tripRepository.findByStartStationIdAndEndStationId(startStationId, endStationId);
        return tripEntities.stream()
                .map(this::processNormalType)
                .collect(Collectors.toList());
    }
    public List<TripModel> findTripsByStartAndEndStationSpecialType(Long startStationId, Long endStationId) {
        List<TripEntity> tripEntities = tripRepository.findByStartStationIdAndEndStationId(startStationId, endStationId);
        return tripEntities.stream()
                .map(this::processSpecialType)
                .collect(Collectors.toList());
    }
}
