package com.__final_backend.backend.controller;

import com.__final_backend.backend.dto.FlightDTO;
import com.__final_backend.backend.dto.FlightSearchRequestDTO;
import com.__final_backend.backend.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping("/search")
    public ResponseEntity<List<FlightDTO>> searchFlights(@RequestBody FlightSearchRequestDTO request) {
        List<FlightDTO> results = flightService.searchFlights(
                request.getStartingLocation(),
                request.getEndingLocation(),
                request.getTravelDate(),
                request.getReturnDate(),
                request.getNumberOfTravelers(),
                request.getTripType()
        );
        return ResponseEntity.ok(results);
    }
}