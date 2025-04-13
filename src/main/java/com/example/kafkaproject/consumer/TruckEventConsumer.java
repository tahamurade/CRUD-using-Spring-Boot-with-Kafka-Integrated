//package com.example.kafkaproject.consumer;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TruckEventConsumer {
//    @KafkaListener(topics = "truck-events", groupId = "plant-group")
//    public void listen(String message) {
//        System.out.println("Truck Event Received: " + message);
//        // Add logic: e.g., notify inventory, security, etc.
//    }
//}
//
//
////
////package com.example.kafkaproject.consumer;
////
////import com.example.kafkaproject.model.TruckEvent;
////import com.example.kafkaproject.repository.TruckEventRepository;
////import com.fasterxml.jackson.databind.JsonNode;
////import com.fasterxml.jackson.databind.ObjectMapper;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.kafka.annotation.KafkaListener;
////import org.springframework.stereotype.Component;
////
////@Component
////public class TruckEventConsumer {
////
////    @Autowired
////    private TruckEventRepository repository;
////
////    private final ObjectMapper mapper = new ObjectMapper();
////
////    @KafkaListener(topics = "truck-events", groupId = "plant-group")
////    public void listen(String message) {
////        try {
////            System.out.println("Truck Event Received: " + message);
////
////            JsonNode node = mapper.readTree(message);
////            Long id = node.get("id").asLong();
////            String action = node.get("action").asText();
////
////            if ("DELETED".equalsIgnoreCase(action)) {
////                repository.findById(id).ifPresent(repository::delete);
////            }
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
////}
