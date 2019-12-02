package com.kodilla.travelfront.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Trip {

    private String airport;
    private String destination;
    private String airline;
    private Timestamp departure;
    private Timestamp arrival;
    private BigDecimal price;
    private int temperature;
    private int cloudiness;
    private int rainfall;

    public Trip(FlightDto flightDto, WeatherDto weatherDto) {
        this.airport = flightDto.getAirport();
        this.destination = flightDto.getDestination();
        this.airline = flightDto.getAirline();
        this.departure = flightDto.getDeparture();
        this.arrival = flightDto.getArrival();
        this.price = flightDto.getPrice();
        this.temperature = weatherDto.getTemperature();
        this.cloudiness = weatherDto.getCloudiness();
        this.rainfall = weatherDto.getRainfall();
    }

    public String getAirport() {
        return airport;
    }

    public String getDestination() {
        return destination;
    }

    public String getAirline() {
        return airline;
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

    public int getTemperature() {
        return temperature;
    }

    public int getCloudiness() {
        return cloudiness;
    }

    public int getRainfall() {
        return rainfall;
    }
}
