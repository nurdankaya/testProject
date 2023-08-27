package com.flight.demoflightservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequestDTO {

    @JsonProperty("departureAirport")
    private String departureAirport;

    @JsonProperty("landingAirport")
    private String landingAirport;

    @JsonProperty("departureDate")
    private String departureDate;

    @JsonProperty("landingDate")
    private String landingDate;

}
