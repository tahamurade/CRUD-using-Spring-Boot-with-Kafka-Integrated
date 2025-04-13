package com.example.kafkaproject.repository;

import com.example.kafkaproject.model.TruckEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckEventRepository extends JpaRepository<TruckEvent, Long> {
}