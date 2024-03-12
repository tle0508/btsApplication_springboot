package com.example.btsApplication.service;

import com.example.btsApplication.entity.BtsEntity;
import com.example.btsApplication.model.BtsModel;
import com.example.btsApplication.model.TripResultModel;
import com.example.btsApplication.repository.BtsRepository;
import com.example.btsApplication.repository.PriceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final PriceRepository priceRepository;
    private final BtsService btsService;

    @Autowired
    public TripService(PriceRepository priceRepository,BtsService btsService) {
        this.priceRepository = priceRepository;
        this.btsService=btsService;
    }

    public TripResultModel calculateTripPrice(Long startStationId, Long endStationId) {
        int FakeDistance;
        final int ExtensionDistance = 0;
        final int idNorthExtensionStation = 17;
        final int numOfDistance = Math.abs(Math.toIntExact(startStationId - endStationId));
        Integer price;

        BtsModel startStation = (BtsModel) btsService.findById(startStationId);
        BtsModel endStation = (BtsModel) btsService.findById(endStationId);

        if(startStation.getExtension().equals(true) && endStation.getExtension().equals(true)){
             price = priceRepository.getPriceByDistance(ExtensionDistance);
        }else if (startStation.getExtension().equals(false) && endStation.getExtension().equals(true)){
            FakeDistance=Math.abs(Math.toIntExact(startStation.getId()-idNorthExtensionStation));
            if (FakeDistance == 0){
                price = priceRepository.getPriceByDistance(ExtensionDistance);
            }else {
                price = priceRepository.getPriceByDistance(FakeDistance) + priceRepository.getPriceByDistance(ExtensionDistance);
            }
        }else if (startStation.getExtension().equals(true) && endStation.getExtension().equals(false)){
            FakeDistance=Math.abs(Math.toIntExact(endStation.getId()-idNorthExtensionStation));
            if (FakeDistance == 0){
                price = priceRepository.getPriceByDistance(ExtensionDistance);
            }else {
                price = priceRepository.getPriceByDistance(FakeDistance) + priceRepository.getPriceByDistance(ExtensionDistance);
            }
        }
        else {
            if (numOfDistance > 8) {
                FakeDistance = 8;
                price = priceRepository.getPriceByDistance(FakeDistance);
            } else {
                price = priceRepository.getPriceByDistance(numOfDistance);
            }
        }
        Integer numOfStations = numOfDistance + 1;
        return new TripResultModel(price, numOfStations);
    }
}
