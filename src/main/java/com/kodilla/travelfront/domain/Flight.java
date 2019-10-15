package com.kodilla.travelfront.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Flight {

    private String to;
    private String from;
    private String airline;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private BigDecimal price;

    public Flight() {
    }

    public Flight(String to, String from, String airline, LocalDateTime departure, LocalDateTime arrival, BigDecimal price) {
        this.to = to;
        this.from = from;
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getAirline() {
        return airline;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
