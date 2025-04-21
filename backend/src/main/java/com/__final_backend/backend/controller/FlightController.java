package com.__final_backend.backend.controller;

import com.__final_backend.backend.dto.FlightDTO;
import com.__final_backend.backend.dto.FlightSearchRequestDTO;
import com.__final_backend.backend.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller that handles flight-related API endpoints.
 * Provides functionality for searching available flights based on various criteria.
 */
@RestController
@RequestMapping("/api/flights")
public class FlightController {
    /**
     * Service that handles flight search operations.
     */
    @Autowired
    private FlightService flightService;

    /**
     * Searches for flights based on provided search criteria.
     *
     * @param request The flight search request containing search parameters such as
     *                origin, destination, dates, number of travelers, and trip type
     * @return A response containing a list of flights matching the search criteria
     */
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