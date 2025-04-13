package com.example.kafkaproject.controller;


   import com.example.kafkaproject.model.TruckEvent;
   import com.example.kafkaproject.service.TruckEventService;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.web.bind.annotation.*;

   import java.util.List;

   @RestController
   @RequestMapping("/api/trucks")
   public class TruckEventController {
       @Autowired
       private TruckEventService service;

       // Create
       @PostMapping("/events")
       public TruckEvent createEvent(@RequestParam String truckId, @RequestParam String eventType) {
           return service.createEvent(truckId, eventType);
       }

       // Read All
       @GetMapping("/events")
       public List<TruckEvent> getAllEvents() {
           return service.getAllEvents();
       }

       // Read One
       @GetMapping("/events/{id}")
       public TruckEvent getEventById(@PathVariable Long id) {
           return service.getEventById(id);
       }

       // Update
       @PutMapping("/events/{id}")
       public TruckEvent updateEvent(@PathVariable Long id, @RequestParam String truckId, @RequestParam String eventType) {
           return service.updateEvent(id, truckId, eventType);
       }

//       // Delete
//       @DeleteMapping("/events/{id}")
//       public String deleteEvent(@PathVariable Long id) {
//           service.deleteEvent(id);
//           return "Event deleted with ID: " + id;
           
//           // Delete
           @DeleteMapping("/events/{id}")
           public String deleteEvent(@PathVariable Long id) {
               try {
                   service.deleteEvent(id);
                   return "Event deleted with ID: " + id;
               } catch (RuntimeException e) {
                   return "Delete failed: " + e.getMessage();
               }
           }
   }


           
           
           
           
           
    