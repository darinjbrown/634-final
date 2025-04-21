package com.__final_backend.backend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {

    @InjectMocks
    private FlightServiceImpl flightService;

    @BeforeEach
    void setUp() {
        // Set up API credentials
        ReflectionTestUtils.setField(flightService, "apiKey", "test-api-key");
        ReflectionTestUtils.setField(flightService, "apiSecret", "test-api-secret");
    }

    @Test
    void searchFlights_WithNullOrigin_ThrowsRuntimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                flightService.searchFlights(null, "LAX", LocalDate.now(), null, 1, "one-way"));

        assertTrue(exception.getMessage().contains("Unexpected error in flight search"));
    }

    @Test
    void searchFlights_WithNullDestination_ThrowsRuntimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                flightService.searchFlights("JFK", null, LocalDate.now(), null, 1, "one-way"));

        assertTrue(exception.getMessage().contains("Unexpected error in flight search"));
    }

    @Test
    void searchFlights_WithNullDepartureDate_ThrowsRuntimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                flightService.searchFlights("JFK", "LAX", null, null, 1, "one-way"));

        assertTrue(exception.getMessage().contains("Unexpected error in flight search"));
    }

    @Test
    void searchFlights_WithNullNumberOfTravelers_ThrowsRuntimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                flightService.searchFlights("JFK", "LAX", LocalDate.now(), null, null, "one-way"));

        assertTrue(exception.getMessage().contains("Unexpected error in flight search"));
    }
}