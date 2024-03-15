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
    public List<TripModel> getAllTrips() {
        List<TripEntity> tripEntities = tripRepository.findAll();
        return tripEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    private TripModel convertToModel(TripEntity tripEntity) {
        PriceEntity priceExtension = priceRepository.findById(9L).orElse(null);
        TripModel tripModel = new TripModel();
        tripModel.setId(tripEntity.getId());

        // สร้าง BtsModel startStationId และ endStationId
        BtsModel startStation = btsService.findById(tripEntity.getStartStationId());
        BtsModel endStation = btsService.findById(tripEntity.getEndStationId());
        tripModel.setStartStationId(startStation);
        tripModel.setEndStationId(endStation);

        // สร้าง PriceModel
        PriceModel priceModel = new PriceModel();
        priceModel.setId(tripEntity.getPrice().getId());
        priceModel.setPrice(tripEntity.getPrice().getPrice());
        priceModel.setCreatedDay(tripEntity.getPrice().getCreatedDay());
        priceModel.setUpdatedDay(tripEntity.getPrice().getUpdatedDay());


        // เพิ่มเงื่อนไขเช็คหาก endStationId.extension เป็น false ให้บวกราคาอีก 15 บาท
        if (!endStation.getExtension()) {
            if (!(endStation.getId() == 17L)){
                int adjustedPrice = priceModel.getPrice() + priceExtension.getPrice();
                priceModel.setPrice(adjustedPrice);
            }
        }
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
