package com.kodilla.travelfront.backend;

import com.kodilla.travelfront.domain.AirportDto;
import com.kodilla.travelfront.domain.FlightDto;
import com.kodilla.travelfront.domain.WeatherDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelClientTestSuite {

    private TravelClient travelClient = new TravelClient();

    @Test
    public void testGetAirports() {
        List<AirportDto> resultList = travelClient.getAirports();
        resultList.forEach(System.out::println);
    }

    @Test
    public void testGetFlights() {
        List<FlightDto> resultList = travelClient.getFlights("WAW", "PRG", LocalDate.of(2019, 12, 31));
        resultList.forEach(System.out::println);
    }

    @Test
    public void testGetCountryAirports() {
        List<AirportDto> resultList = travelClient.getCountryAirports("Poland");
        resultList.forEach(System.out::println);
    }

    @Test
    public void testGetGoodConditions() {
        List<WeatherDto> resultList = travelClient.getGoodWeather();
        System.out.println(resultList.size());
        resultList.forEach(System.out::println);
    }
}
