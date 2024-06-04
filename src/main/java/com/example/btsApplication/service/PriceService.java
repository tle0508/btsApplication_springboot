package com.example.btsApplication.service;

import com.example.btsApplication.entity.Price;
import com.example.btsApplication.model.PriceModel;
import com.example.btsApplication.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public PriceModel updatePrice(Long numOfDistance, int price) {
        Optional<Price> priceEntity = priceRepository.findByNumOfDistance(numOfDistance);
        if (priceEntity.isPresent()) {
            Price updatePriceEntity = priceEntity.get();
            updatePriceEntity.setPrice(price);
            updatePriceEntity.setUpdatedDay(LocalDateTime.now());
            return convertToModel(priceRepository.save(updatePriceEntity));
        } else {
            return null;
        }
    }
   
    public List<PriceModel> getAllPrices() {
        List<Price> priceEntities = priceRepository.findAll();
        return priceEntities.stream()
                .map(PriceService::convertToModel)
                .collect(Collectors.toList());
    }
    private static PriceModel convertToModel(Price priceEntity){
        PriceModel priceModel = new PriceModel();
        priceModel.setNumOfDistance(priceEntity.getNumOfDistance());
        priceModel.setCreatedDay(priceEntity.getCreatedDay());
        priceModel.setUpdatedDay(priceEntity.getUpdatedDay());
        priceModel.setPrice(priceEntity.getPrice());
        return priceModel;
    }
}
