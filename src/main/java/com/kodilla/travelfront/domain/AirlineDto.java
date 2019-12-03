package com.kodilla.travelfront.domain;

public class AirlineDto {

    private Long id;
    private String name;
    private String iataCode;

    public AirlineDto(Long id, String name, String iataCode) {
        this.id = id;
        this.name = name;
        this.iataCode = iataCode;
    }

    public AirlineDto(String name, String iataCode) {
        this.name = name;
        this.iataCode = iataCode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIataCode() {
        return iataCode;
    }
}
