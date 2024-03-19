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
        int adjustedPrice;

        if(startStation.getExtension() && endStation.getExtension()){
            if((startStation.getId() < 17 && endStation.getId()>17)){
                adjustedPrice = priceModel.getPrice() + priceExtension.getPrice();
                priceModel.setPrice(adjustedPrice);
            }else  if((startStation.getId()>34 && startStation.getId() <49) && ( endStation.getId() < 34 || endStation.getId()>58 )){
                adjustedPrice = priceModel.getPrice() + priceExtension.getPrice();
                priceModel.setPrice(adjustedPrice);
            } else if ((startStation.getId() > 58 && endStation.getId()<58)) {
                adjustedPrice = priceModel.getPrice() + priceExtension.getPrice();
                priceModel.setPrice(adjustedPrice);
            }
        }
        // เพิ่มเงื่อนไขเช็คหาก endStationId ไม่เป็นส่วนต่อขยาย ให้บวกราคาอีก 15 บาท
         if (startStation.getExtension() && !endStation.getExtension()) {
            if (!(endStation.getId() == 17) && !(endStation.getId() == 34)){
                adjustedPrice = priceModel.getPrice() + priceExtension.getPrice();
                priceModel.setPrice(adjustedPrice);
            }
        }
        // เพิ่มเงื่อนไขเช็คหาก StartStationId ไม่เป็นส่วนต่อขยาย ให้บวกราคาอีก 15 บาท
        else if (!startStation.getExtension() && endStation.getExtension()){
            if (!(startStation.getId() == 17) && !(startStation.getId() == 34) && !(startStation.getId() == 58)) {
                if (endStation.getId() > 0 && endStation.getId() < 17 || endStation.getId() > 34 && endStation.getId() < 49 || endStation.getId() > 58 && endStation.getId() < 63) {
                    adjustedPrice = priceModel.getPrice() + priceExtension.getPrice();
                    priceModel.setPrice(adjustedPrice);
                }
            }else {
                if(startStation.getId()==17 && endStation.getId()>17){
                    adjustedPrice = priceModel.getPrice() + priceExtension.getPrice();
                    priceModel.setPrice(adjustedPrice);
                } else if (startStation.getId() == 34 && (endStation.getId()<34 || endStation.getId()>58)) {
                    adjustedPrice = priceModel.getPrice() + priceExtension.getPrice();
                    priceModel.setPrice(adjustedPrice);
                } else if (startStation.getId() == 58 && !(endStation.getId() > 58)) {
                    adjustedPrice = priceModel.getPrice() + priceExtension.getPrice();
                    priceModel.setPrice(adjustedPrice);
                }
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
