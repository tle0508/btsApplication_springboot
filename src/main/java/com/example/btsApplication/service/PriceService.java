package com.example.btsApplication.service;


import com.example.btsApplication.entity.PriceEntity;
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

    public PriceModel updatePrice(Long id, Integer price) {
        Optional<PriceEntity> priceEntity = priceRepository.findById(id);
        if (priceEntity.isPresent()) {
            PriceEntity existingPriceEntity = priceEntity.get();
            existingPriceEntity.setPrice(price);
            existingPriceEntity.setUpdatedDay(LocalDateTime.now());
            return convertToModel(priceRepository.save(existingPriceEntity));
        } else {
            return null;
        }
    }


    public List<PriceModel> getAllPrices() {
        List<PriceEntity> priceEntities = priceRepository.findAll();
        return priceEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }
    private PriceModel convertToModel(PriceEntity priceEntity){
        PriceModel priceModel = new PriceModel();
        priceModel.setId(priceEntity.getId());
        priceModel.setCreatedDay(priceEntity.getCreatedDay());
        priceModel.setUpdatedDay(priceEntity.getUpdatedDay());
        priceModel.setPrice(priceEntity.getPrice());
        // เพิ่มการตั้งค่า distanceModel

        return priceModel;
    }
}
