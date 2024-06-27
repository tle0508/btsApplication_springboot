package com.example.btsApplication.repository;


import com.example.btsApplication.entity.PriceExtension;

import org.springframework.data.jpa.repository.JpaRepository;



public interface PriceExtensionRepository  extends JpaRepository<PriceExtension, Long> {
   
}
