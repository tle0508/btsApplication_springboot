package com.example.btsApplication.repository;

import com.example.btsApplication.entity.BtsEntity;
import com.example.btsApplication.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BtsRepository extends JpaRepository<BtsEntity, Long> {
    List<BtsEntity> findByLineColorAndIsActivate(String lineColor, boolean isActivate);
    Optional<BtsEntity> findById(Long id);
}
