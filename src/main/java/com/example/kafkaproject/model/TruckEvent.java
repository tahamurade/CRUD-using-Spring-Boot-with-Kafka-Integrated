package com.example.kafkaproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

import java.time.LocalDateTime;

@Entity
public class TruckEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String truckId;
    private String eventType; // "ENTRY" or "EXIT"
    private LocalDateTime eventTime;

    @Version
    private int version;
    // Constructors
    public TruckEvent() {}
    public TruckEvent(String truckId, String eventType, LocalDateTime eventTime) {
        this.truckId = truckId;
        this.eventType = eventType;
        this.eventTime = eventTime;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTruckId() { return truckId; }
    public void setTruckId(String truckId) { this.truckId = truckId; }
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public LocalDateTime getEventTime() { return eventTime; }
    public void setEventTime(LocalDateTime eventTime) { this.eventTime = eventTime; }

    // For Kafka (convert to JSON-like string)
    public String toJson() {
        return "{\"truckId\": \"" + truckId + "\", \"eventType\": \"" + eventType + "\", \"eventTime\": \"" + eventTime + "\"}";
    }
}
