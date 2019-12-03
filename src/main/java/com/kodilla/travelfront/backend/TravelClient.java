package com.kodilla.travelfront.backend;

import com.kodilla.travelfront.domain.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TravelClient {

    private RestTemplate restTemplate = new RestTemplate();

    private final static String BASE_URL = "http://localhost:8082/v1/travel/";

    public List<FlightDto> getFlights(String airport, String destination, LocalDate date) {
        URI flightURL = UriComponentsBuilder.fromHttpUrl(BASE_URL +
                "flights/" + airport + "/" + destination + "/" + date.toString())
                .build()
                .encode()
                .toUri();

        return Optional.ofNullable(restTemplate.getForObject(flightURL, FlightDto[].class))
                .map(Arrays::asList)
                .orElse(new ArrayList<>());
    }

    public List<AirportDto> getAirports() {
        URI airportURL = UriComponentsBuilder.fromHttpUrl(BASE_URL + "airport")
                .build()
                .encode()
                .toUri();

        return Optional.ofNullable(restTemplate.getForObject(airportURL, AirportDto[].class))
                .map(Arrays::asList)
                .orElse(new ArrayList<>());
    }

    public List<AirportDto> getCountryAirports(String country) {
        URI airportURL = UriComponentsBuilder.fromHttpUrl(BASE_URL + "airport/country/" + country)
                .build()
                .encode()
                .toUri();

        return Optional.ofNullable(restTemplate.getForObject(airportURL, AirportDto[].class))
                .map(Arrays::asList)
                .orElse(new ArrayList<>());
    }

    public List<WeatherDto> getGoodWeather() {
        URI weatherURL = UriComponentsBuilder.fromHttpUrl(BASE_URL + "weather/cond/10/20/20")
                .build()
                .encode()
                .toUri();

        return Optional.ofNullable(restTemplate.getForObject(weatherURL, WeatherDto[].class))
                .map(Arrays::asList)
                .orElse(new ArrayList<>());
    }

    public List<AirportDto> getCityAirports(String city) {
        URI airportURL = UriComponentsBuilder.fromHttpUrl(BASE_URL + "airport/city/" + city)
                .build()
                .encode()
                .toUri();

        return Optional.ofNullable(restTemplate.getForObject(airportURL, AirportDto[].class))
                .map(Arrays::asList)
                .orElse(new ArrayList<>());
    }

    public void addAirport(AirportDto airportDto) {
        URI airportURL = UriComponentsBuilder.fromHttpUrl(BASE_URL + "airport")
                .build()
                .encode()
                .toUri();

        restTemplate.postForLocation(airportURL, airportDto);
    }

    public void addAirline(AirlineDto airlineDto) {
        URI airportURL = UriComponentsBuilder.fromHttpUrl(BASE_URL + "airline")
                .build()
                .encode()
                .toUri();

        restTemplate.postForLocation(airportURL, airlineDto);
    }
}
