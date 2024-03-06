package com.example.btsApplication.repository;

import com.example.btsApplication.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PriceRepository  extends JpaRepository<PriceEntity, Long> {
    Optional<PriceEntity> findById(Long id);
}
