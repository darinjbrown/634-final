package com.__final_backend.backend.service;

import com.__final_backend.backend.dto.FlightDTO;
import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    List<FlightDTO> searchFlights(
            String startingLocation,
            String endingLocation,
            LocalDate travelDate,
            LocalDate returnDate,
            Integer numberOfTravelers,
            String tripType
    );
}