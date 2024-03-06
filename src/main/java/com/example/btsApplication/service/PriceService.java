package com.example.btsApplication.service;

import com.example.btsApplication.entity.PriceEntity;
import com.example.btsApplication.repository.PriceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Transactional
    public PriceEntity updatePrice(Long id, Integer price) {
        Optional<PriceEntity> priceEntity = priceRepository.findById(id);
        if (priceEntity.isPresent()) {
            PriceEntity existingPriceEntity = priceEntity.get();
            existingPriceEntity.setPrice(price);
            existingPriceEntity.setUpdatedDay(LocalDateTime.now());
            return priceRepository.save(existingPriceEntity);
        } else {
            return null;
        }
    }

    public List<PriceEntity> getAllPrices() {
        return priceRepository.findAll();
    }
}
