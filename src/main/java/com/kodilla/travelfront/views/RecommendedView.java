package com.kodilla.travelfront.views;

import com.kodilla.travelfront.components.TopBar;
import com.kodilla.travelfront.domain.AirportDto;
import com.kodilla.travelfront.domain.FlightDto;
import com.kodilla.travelfront.domain.WeatherDto;
import com.kodilla.travelfront.services.TravelService;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Route("recommended")
public class RecommendedView extends VerticalLayout {

    private TravelService travelService = new TravelService();

    public RecommendedView() {
        setWidthFull();

        TopBar topBar = new TopBar();

        ComboBox<String> countryBox = new ComboBox<>();
        countryBox.setLabel("Select your country: ");
        countryBox.setRequired(true);
        countryBox.setItems(travelService.getCountries());
        ComboBox<AirportDto> originBox = new ComboBox<>();
        originBox.setLabel("Select your airport: ");
        originBox.setItemLabelGenerator(AirportDto::getName);
        originBox.setRequired(true);
        countryBox.addValueChangeListener(event -> originBox.setItems(travelService.getCountryAirports(countryBox.getValue())));

        Grid<WeatherDto> weatherGrid = new Grid<>();
        weatherGrid.addColumn(WeatherDto::getCity).setHeader("City");
        weatherGrid.addColumn(WeatherDto::getDate).setHeader("Date");
        weatherGrid.addColumn(WeatherDto::getTemperature).setHeader("Temperature (\u00b0C)");
        weatherGrid.addColumn(WeatherDto::getCloudiness).setHeader("Clouds coverage (%)");
        weatherGrid.addColumn(WeatherDto::getRainfall).setHeader("Chance of rainfall (%)");
        weatherGrid.setItems(travelService.getGoodWeather());

        Grid<FlightDto> flightGrid = new Grid<>(FlightDto.class);
        flightGrid.setColumns("airport", "destination", "airline", "departure", "arrival", "price");

        weatherGrid.addItemClickListener(event -> {
            if (originBox.getValue() != null) {
                flightGrid.setItems(getFlights(originBox.getValue().getIata(), event.getItem().getCity(), event.getItem().getDate()));
            } else {
                Notification.show("Please choose your airport.");
            }
        });
        add(topBar, countryBox, originBox, weatherGrid, flightGrid);
    }

    private List<FlightDto> getFlights(String origin, String city, LocalDate date) {
        List<AirportDto> airports = travelService.getCityAirports(city);
        List<FlightDto> flights = new ArrayList<>();
        for (AirportDto airport : airports) {
            flights.addAll(travelService.getFlights(origin, airport.getIata(), date));
        }
        return flights;
    }
}
