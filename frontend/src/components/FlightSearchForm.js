import React, { useState } from 'react';
import axios from 'axios';
import './FlightSearchForm.css';

const FlightSearchForm = () => {
    const [formData, setFormData] = useState({
        startingLocation: '',
        endingLocation: '',
        travelDate: '',
        returnDate: '',
        numberOfTravelers: 1,
        tripType: 'one-way',
    });

    const [flightResults, setFlightResults] = useState([]);
    const [error, setError] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleTripTypeChange = (e) => {
        const tripType = e.target.value === '0' ? 'one-way' : 'round-trip';
        setFormData({ ...formData, tripType, returnDate: '' });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        setFlightResults([]);

        try {
            const response = await axios.post('http://localhost:8080/api/flights/search', formData);
            setFlightResults(response.data);
        } catch (err) {
            setError('Failed to fetch flight data. Please try again.');
        }
    };

    return (
        <div className="form-card">
            <h2>Search for Flights</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Trip Type:</label>
                    <div className="slider-container">
                        <span>One Way</span>
                        <input
                            type="range"
                            min="0"
                            max="1"
                            step="1"
                            value={formData.tripType === 'one-way' ? '0' : '1'}
                            onChange={handleTripTypeChange}
                        />
                        <span>Round Trip</span>
                    </div>
                </div>
                <div>
                    <label htmlFor="startingLocation">Starting Location:</label>
                    <input
                        id="startingLocation"
                        name="startingLocation"
                        value={formData.startingLocation}  // Use formData
                        onChange={handleChange}  // Use existing handler
                    />
                </div>

                <div>
                    <label htmlFor="endingLocation">Ending Location:</label>
                    <input
                        id="endingLocation"
                        name="endingLocation"
                        value={formData.endingLocation}  // Use formData
                        onChange={handleChange}  // Use existing handler
                    />
                </div>
                <div>
                    <label htmlFor="travelDate">Date of Travel:</label>
                    <input
                        id="travelDate"
                        type="date"
                        name="travelDate"
                        value={formData.travelDate}
                        onChange={handleChange}
                        required
                    />
                </div>
                {formData.tripType === 'round-trip' && (
                    <div>
                        <label htmlFor="returnDate">Return Date:</label>
                        <input
                            id="returnDate"
                            type="date"
                            name="returnDate"
                            value={formData.returnDate}
                            onChange={handleChange}
                            required
                        />
                    </div>
                )}
                <div>
                    <label htmlFor="numberOfTravelers">Number of Travelers:</label>
                    <input
                        id="numberOfTravelers"
                        type="number"
                        name="numberOfTravelers"
                        value={formData.numberOfTravelers}
                        onChange={handleChange}
                        min="1"
                        required
                    />
                </div>
                <button type="submit">Search Flights</button>
            </form>

            {error && <p className="error">{error}</p>}

            {flightResults.length > 0 && (
                <div className="results results-container">
                    <h3>Flight Results:</h3>
                    <ul>
                        {flightResults.map((flight, index) => (
                            <li key={index}>
                                <strong>{flight.airline}</strong> - {flight.flightNumber}<br/>
                                {flight.departure} to {flight.arrival}<br/>
                                Departure: {flight.departureTime}<br />
                                Arrival: {flight.arrivalTime}
                            </li>
                        ))}
                    </ul>
                </div>
            )}
        </div>
    );
};

export default FlightSearchForm;