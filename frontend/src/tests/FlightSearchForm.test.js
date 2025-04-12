import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import FlightSearchForm from '../components/FlightSearchForm';
import axios from 'axios';

jest.mock('axios');

describe('FlightSearchForm', () => {
    test('renders form elements correctly', () => {
        render(<FlightSearchForm />);

        expect(screen.getByText('Search Flights')).toBeInTheDocument();
        expect(screen.getByLabelText(/Starting Location:/i)).toBeInTheDocument();
        expect(screen.getByLabelText(/Ending Location:/i)).toBeInTheDocument();
        expect(screen.getByRole('button', { name: /Search Flights/i })).toBeInTheDocument();
    });

    test('toggles return date field when trip type changes', () => {
        render(<FlightSearchForm />);

        // Return date should not be visible initially (one-way is default)
        expect(screen.queryByLabelText(/Return Date:/i)).not.toBeInTheDocument();

        // Change to round-trip
        const tripTypeSlider = screen.getByRole('slider');
        fireEvent.change(tripTypeSlider, { target: { value: '1' } });

        // Return date should now be visible
        expect(screen.getByLabelText(/Return Date:/i)).toBeInTheDocument();
    });

    test('submits form data to API', async () => {
        axios.post.mockResolvedValueOnce({ data: [] });
        render(<FlightSearchForm />);

        // Fill form
        fireEvent.change(screen.getByLabelText(/Starting Location:/i), { target: { value: 'NYC' } });
        fireEvent.change(screen.getByLabelText(/Ending Location:/i), { target: { value: 'LAX' } });
        fireEvent.change(screen.getByLabelText(/Date of Travel:/i), { target: { value: '2023-06-01' } });

        // Submit form
        fireEvent.click(screen.getByRole('button', { name: /Search Flights/i }));

        expect(axios.post).toHaveBeenCalledWith(
            'http://localhost:8080/api/flights/search',
            expect.objectContaining({
                startingLocation: 'NYC',
                endingLocation: 'LAX'
            })
        );
    });
});