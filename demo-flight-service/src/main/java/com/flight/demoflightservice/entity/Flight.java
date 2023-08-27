package com.flight.demoflightservice.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Data
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "kalkisHavaalani")
    private String departureAirport;

    @Column(name = "inisHavaalani")
    private String landingAirport;

    @Column(name = "kalkısTarih")
    private String departureDate;

    @Column(name = "inisTarih")
    private String landingDate;

    @Column(name = "fiyat")
    private BigDecimal price;

}