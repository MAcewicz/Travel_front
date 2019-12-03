package com.kodilla.travelfront.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class FlightDto {

    private Long id;
    private String airport;
    private String destination;
    private String airline;
    private Timestamp departure;
    private Timestamp arrival;
    private BigDecimal price;

    public FlightDto() {
    }

    public FlightDto(Long id, String airport, String destination, String airline, Timestamp departure, Timestamp arrival, BigDecimal price) {
        this.id = id;
        this.airport = airport;
        this.destination = destination;
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getAirline() {
        return airline;
    }

    public String getAirport() {
        return airport;
    }

    public String getDestination() {
        return destination;
    }

    public Timestamp getDeparture() {
        return departure;
    }

    public Timestamp getArrival() {
        return arrival;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
