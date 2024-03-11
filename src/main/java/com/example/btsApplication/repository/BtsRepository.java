package com.example.btsApplication.repository;

import com.example.btsApplication.entity.BtsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface BtsRepository extends JpaRepository<BtsEntity, Long> {
    List<BtsEntity> findByLineColorAndIsActivate(String lineColor, boolean isActivate);
}
