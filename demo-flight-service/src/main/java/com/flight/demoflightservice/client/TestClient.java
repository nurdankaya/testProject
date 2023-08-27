package com.flight.demoflightservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@FeignClient(value = "testFlightApi", url = "https://testApi")
public interface TestClient {

    @GetMapping(value = "/flight")
    public List<Objects> getFlights();
}
