package com.example.btsApplication.service;


import com.example.btsApplication.entity.PriceExtension;
import com.example.btsApplication.model.PriceExtensionModel;
import com.example.btsApplication.repository.PriceExtensionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriceExtensionService {
    private final PriceExtensionRepository priceExtensionRepository;

  
    public PriceExtensionService(PriceExtensionRepository priceExtensionRepository) {
        this.priceExtensionRepository = priceExtensionRepository;
    }

    public PriceExtensionModel updatePrice(Long numOfDistance, int price) {
        Optional<PriceExtension> priceEntity = priceExtensionRepository.findByNumOfDistance(numOfDistance);
        if (priceEntity.isPresent()) {
            PriceExtension updatePriceEntity = priceEntity.get();
            updatePriceEntity.setPrice(price);
            updatePriceEntity.setUpdatedDay(LocalDateTime.now());
            return convertToModel(priceExtensionRepository.save(updatePriceEntity));
        } else {
            return null;
        }
    }
    
    public List<PriceExtensionModel> getAllPrices() {
        List<PriceExtension> priceEntities = priceExtensionRepository.findAll();
        return priceEntities.stream()
                .map(PriceExtensionService::convertToModel)
                .collect(Collectors.toList());
    }
    
    private static PriceExtensionModel convertToModel(PriceExtension priceEntity){
        PriceExtensionModel priceModel = new PriceExtensionModel();
        priceModel.setId(priceEntity.getId());
        priceModel.setNumOfDistance(priceEntity.getNumOfDistance());
        priceModel.setCreatedDay(priceEntity.getCreatedDay());
        priceModel.setUpdatedDay(priceEntity.getUpdatedDay());
        priceModel.setPrice(priceEntity.getPrice());
        return priceModel;
    }
}
