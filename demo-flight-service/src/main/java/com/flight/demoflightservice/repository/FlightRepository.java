package com.flight.demoflightservice.repository;

import com.flight.demoflightservice.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(path="flights",collectionResourceRel = "flight")
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}