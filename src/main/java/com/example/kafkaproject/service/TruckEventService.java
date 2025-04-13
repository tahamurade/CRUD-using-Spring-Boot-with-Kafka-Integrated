package com.example.kafkaproject.service;

import com.example.kafkaproject.model.TruckEvent;
import com.example.kafkaproject.repository.TruckEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


import java.util.List;

@Service
public class TruckEventService {
    @Autowired
    private TruckEventRepository repository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    // Create
    public TruckEvent createEvent(String truckId, String eventType) {
        TruckEvent event = new TruckEvent(truckId, eventType, LocalDateTime.now());
        TruckEvent savedEvent = repository.save(event);
        kafkaTemplate.send("truck-events", savedEvent.toJson());
        return savedEvent;
    }

    // Read All
    public List<TruckEvent> getAllEvents() {
        return repository.findAll();
    }

    // Read One
    public TruckEvent getEventById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update
    public TruckEvent updateEvent(Long id, String truckId, String eventType) {
        TruckEvent event = repository.findById(id).orElse(null);
        if (event != null) {
            event.setTruckId(truckId);
            event.setEventType(eventType);
            event.setEventTime(LocalDateTime.now());
            TruckEvent updatedEvent = repository.save(event);
            kafkaTemplate.send("truck-events", updatedEvent.toJson());
            return updatedEvent;
        }
        return null;
    }

//    // Delete
//    public void deleteEvent(Long id) {
//        TruckEvent event = repository.findById(id).orElse(null);
//        if (event != null) {
//            repository.deleteById(id);
//            kafkaTemplate.send("truck-events", "{\"id\": " + id + ", \"action\": \"DELETED\"}");
//        }
//    }
    
 // Delete
    public void deleteEvent(Long id) {
        repository.findById(id).ifPresent(event -> {
            repository.deleteById(id);
            kafkaTemplate.send("truck-events", "{\"id\": " + id + ", \"action\": \"DELETED\"}");
        });
    }

    
}