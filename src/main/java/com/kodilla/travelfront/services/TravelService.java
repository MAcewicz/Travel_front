package com.kodilla.travelfront.services;

import com.kodilla.travelfront.backend.TravelClient;
import com.kodilla.travelfront.domain.AirportDto;
import com.kodilla.travelfront.domain.FlightDto;
import com.kodilla.travelfront.domain.WeatherDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TravelService {

    private TravelClient travelClient = new TravelClient();

    public List<String> getCountries() {
        return travelClient.getAirports().stream()
                .map(AirportDto::getCountry)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<AirportDto> getCountryAirports(String country) {
        return travelClient.getCountryAirports(country);
    }

    public List<FlightDto> getFlights(String airport, String destination, LocalDate date) {
        return travelClient.getFlights(airport, destination, date);
    }

    public List<WeatherDto> getGoodWeather() {
        return travelClient.getGoodWeather();
    }

    public List<AirportDto> getCityAirports(String city) {
        return travelClient.getCityAirports(city);
    }

    public void addAirport(AirportDto airportDto) {
        travelClient.addAirport(airportDto);
    }
}
