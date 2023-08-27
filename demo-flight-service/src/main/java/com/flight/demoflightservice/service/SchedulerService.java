package com.flight.demoflightservice.service;

import com.flight.demoflightservice.client.TestClient;
import com.flight.demoflightservice.entity.Flight;
import com.flight.demoflightservice.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class SchedulerService {

    private TestClient testClient;
    private FlightRepository flightRepository;

    @Autowired
    public void setTestClient(TestClient testClient) {
        this.testClient = testClient;
    }

    @Scheduled(cron = "0 0 2 * * ?") // Every day at 02:00
    public void schedulerOnEverySecond() {

        addFlight(testClient.getFlights());
        log.info("Running every day at 02.00");
    }

    private void addFlight(List<Objects> flights) {

        flightRepository.save(Flight.builder().departureAirport("testdata").build());
    }
}
