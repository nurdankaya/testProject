package com.flight.demoflightservice.service;

import com.flight.demoflightservice.dto.FlightRequestDTO;
import com.flight.demoflightservice.dto.FlightResponseDTO;
import com.flight.demoflightservice.entity.Flight;
import com.flight.demoflightservice.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    FlightRepository flightRepository;

    @Autowired
    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public ArrayList<FlightResponseDTO> avaliableFlights(FlightRequestDTO flightRequestDTO) {

        //some business logic

        List<Flight> flights = flightRepository.findAll();
        List<Flight> filteredFlights = flights.stream()
                .filter(flight -> (StringUtils.isEmpty(flightRequestDTO.getDepartureAirport()) || flightRequestDTO.getDepartureAirport().equals(flight.getDepartureAirport())))
                .filter(flight -> (StringUtils.isEmpty(flightRequestDTO.getLandingAirport()) || flightRequestDTO.getLandingAirport().equals(flight.getLandingAirport())))
                .filter(flight -> (StringUtils.isEmpty(flightRequestDTO.getDepartureDate()) || flightRequestDTO.getDepartureAirport().equals(flight.getDepartureDate())))
                .filter(flight -> (StringUtils.isEmpty(flightRequestDTO.getLandingDate()) || flightRequestDTO.getLandingAirport().equals(flight.getLandingDate())))
                .collect(Collectors.toList());
        return flightResponseMapper(filteredFlights);
    }

    private ArrayList<FlightResponseDTO> flightResponseMapper(List<Flight> flightEntity) {

        ArrayList<FlightResponseDTO> flightResponse = new ArrayList<>();
        flightEntity.stream().forEach(flight -> {
            flightResponse.add(FlightResponseDTO.builder().departureAirport(flight.getDepartureAirport())
                    .landingAirport(flight.getLandingAirport())
                    .departureDate(flight.getDepartureDate())
                    .landingDate(flight.getLandingDate()).build());
        });
        return flightResponse;
    }
}
