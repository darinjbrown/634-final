package com.__final_backend.backend.dto;

import java.time.LocalDate;

public class FlightSearchRequestDTO {
    private String startingLocation;
    private String endingLocation;
    private LocalDate travelDate;
    private LocalDate returnDate;
    private Integer numberOfTravelers;
    private String tripType;

    // Existing getters and setters
    public String getStartingLocation() { return startingLocation; }
    public void setStartingLocation(String startingLocation) { this.startingLocation = startingLocation; }
    public String getEndingLocation() { return endingLocation; }
    public void setEndingLocation(String endingLocation) { this.endingLocation = endingLocation; }
    public LocalDate getTravelDate() { return travelDate; }
    public void setTravelDate(LocalDate travelDate) { this.travelDate = travelDate; }

    // New getters and setters
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public Integer getNumberOfTravelers() { return numberOfTravelers; }
    public void setNumberOfTravelers(Integer numberOfTravelers) { this.numberOfTravelers = numberOfTravelers; }
    public String getTripType() { return tripType; }
    public void setTripType(String tripType) { this.tripType = tripType; }
}