package com.kodilla.travelfront.domain;


public class AirportDto {

    private Long id;
    private String city;
    private String country;
    private String countryCode;
    private String iata;
    private String name;

    public AirportDto() {
    }

    public AirportDto(Long id, String city, String country, String countryCode, String iata, String name) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.countryCode = countryCode;
        this.iata = iata;
        this.name = name;
    }

    public AirportDto(String city, String country, String countryCode, String iata, String name) {
        this.city = city;
        this.country = country;
        this.countryCode = countryCode;
        this.iata = iata;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getIata() {
        return iata;
    }

    public String getName() {
        return name;
    }
}
