package com.example.btsApplication.service;

import com.example.btsApplication.model.TripResultModel;
import com.example.btsApplication.repository.PriceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    private final PriceRepository priceRepository;


    @Autowired
    public TripService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public TripResultModel calculateTripPrice(Long startStationId, Long endStationId) {
        int FakeDistance;
        int numOfDistance = Math.abs(Math.toIntExact(startStationId - endStationId));
        Integer price;
        if (numOfDistance > 8) {
            FakeDistance=8;
            price = priceRepository.getPriceByDistance(FakeDistance);
        }else {
            price = priceRepository.getPriceByDistance(numOfDistance);
        }
        Integer numOfStations = numOfDistance + 1;
        return new TripResultModel(price, numOfStations);
    }
}
