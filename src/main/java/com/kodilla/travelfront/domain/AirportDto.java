package com.kodilla.travelfront.domain;


public class AirportDto {

    private Long id;
    private String name;
    private String iata;
    private String city;
    private String country;
    private String countryCode;

    public AirportDto() {
    }

    public AirportDto(Long id, String name, String iata, String city, String country, String countryCode) {
        this.id = id;
        this.name = name;
        this.iata = iata;
        this.city = city;
        this.country = country;
        this.countryCode = countryCode;
    }

    public AirportDto(String name, String iata, String city, String country, String countryCode) {
        this.name = name;
        this.iata = iata;
        this.city = city;
        this.country = country;
        this.countryCode = countryCode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIata() {
        return iata;
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

    @Override
    public String toString() {
        return "AirportDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iata='" + iata + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
