package com.flight.demoflightservice.controller;


import com.flight.demoflightservice.dto.FlightRequestDTO;
import com.flight.demoflightservice.dto.FlightResponseDTO;
import com.flight.demoflightservice.service.FlightService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightContoller {

    private FlightService flightService;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @ApiOperation(value = "flights", notes = "Returns avaliable flights according to given filters.")
    @PostMapping("/flight")
    public ResponseEntity<List<FlightResponseDTO>> avaliableFlights(@Validated @RequestBody FlightRequestDTO flightRequestDTO) {

        return new ResponseEntity<>(flightService.avaliableFlights(flightRequestDTO), HttpStatus.OK);
    }
}
