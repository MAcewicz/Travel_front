package com.kodilla.travelfront.domain;

import java.time.LocalDate;

public class WeatherDto {

    private Long id;
    private String city;
    private LocalDate date;
    private int temperature;
    private int cloudiness;
    private int rainfall;

    public WeatherDto() {
    }

    public WeatherDto(String city, LocalDate date, int temperature, int cloudiness, int rainfall) {
        this.city = city;
        this.date = date;
        this.temperature = temperature;
        this.cloudiness = cloudiness;
        this.rainfall = rainfall;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getDate() {
        return date;
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
