package com.example.btsApplication.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "price")
    public class PriceEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "price")
        private int price;

        @Column(name = "created_day", updatable = false)
        private LocalDateTime createdDay;

        @Column(name = "updated_day")
        private LocalDateTime updatedDay;



        public PriceEntity() {
        }

        public PriceEntity(Long id, int price, LocalDateTime createdDay, LocalDateTime updatedDay) {
            this.id = id;
            this.price = price;
            this.createdDay = createdDay;
            this.updatedDay = updatedDay;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public LocalDateTime getCreatedDay() {
            return createdDay;
        }

        public void setCreatedDay(LocalDateTime createdDay) {
            this.createdDay = createdDay;
        }

        public LocalDateTime getUpdatedDay() {
            return updatedDay;
        }

        public void setUpdatedDay(LocalDateTime updatedDay) {
            this.updatedDay = updatedDay;
        }
    }
