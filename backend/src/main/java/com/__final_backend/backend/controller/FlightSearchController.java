package com.final_backend.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class FlightSearchController {

    @PostMapping("/api/flights/search")
    public List<Map<String, String>> searchFlights(@RequestBody Map<String, String> searchCriteria) {
        // Dummy flight data
        return List.of(
                Map.of(
                        "flightNumber", "AA123",
                        "airline", "American Airlines",
                        "departure", "New York (JFK)",
                        "arrival", "Los Angeles (LAX)",
                        "departureTime", "2023-12-01T08:00:00",
                        "arrivalTime", "2023-12-01T11:00:00"
                ),
                Map.of(
                        "flightNumber", "DL456",
                        "airline", "Delta Airlines",
                        "departure", "New York (JFK)",
                        "arrival", "Los Angeles (LAX)",
                        "departureTime", "2023-12-01T09:00:00",
                        "arrivalTime", "2023-12-01T12:00:00"
                )
        );
    }
}