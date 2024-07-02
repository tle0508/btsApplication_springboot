package com.example.btsApplication.service;

import com.example.btsApplication.entity.PriceExtension;

import com.example.btsApplication.model.PriceModel;
import com.example.btsApplication.repository.PriceExtensionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
    
    @Transactional
    public PriceModel updatePrice(Long id, int price) {
        Optional<PriceExtension> priceEntity = priceExtensionRepository.findById(id);
        if (price < 0 || price >= 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect price");
        }
        if (priceEntity.isPresent()) {
            PriceExtension updatePriceEntity = priceEntity.get();
            updatePriceEntity.setPrice(price);
            updatePriceEntity.setUpdatedDay(LocalDateTime.now());
            return PriceModel.convertToModel(priceExtensionRepository.save(updatePriceEntity));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"entity not exist");
        }
    }

    @Transactional(readOnly = true)
    public List<PriceModel> getAllPrices() {
        List<PriceExtension> priceEntities = priceExtensionRepository.findAll();
        return priceEntities.stream()
                .map(PriceModel::convertToModel)
                .collect(Collectors.toList());
    }

  
}
