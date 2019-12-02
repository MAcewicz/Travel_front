package com.kodilla.travelfront.components;

import com.kodilla.travelfront.domain.AirportDto;
import com.kodilla.travelfront.domain.FlightDto;
import com.kodilla.travelfront.services.TravelService;
import com.kodilla.travelfront.views.SearchView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchForm extends FormLayout {

    private TravelService travelService = new TravelService();

    private String airport;
    private String destination;
    ComboBox<String> countryBox1 = new ComboBox<>();
    ComboBox<AirportDto> originBox = new ComboBox<>();
    ComboBox<String> countryBox2 = new ComboBox<>();
    ComboBox<AirportDto> destinationBox = new ComboBox<>();
    DatePicker startDatePicker = new DatePicker();
    DatePicker endDatePicker = new DatePicker();

    public SearchForm() {

        countryBox1.setLabel("Select your country:");

        originBox.setItemLabelGenerator(AirportDto::getName);
        originBox.setLabel("Airport you're going from:");
        originBox.setRequired(true);

        List<String> countries = travelService.getCountries();
        countryBox1.setItems(countries);
        countryBox1.addValueChangeListener(event -> originBox.setItems(travelService.getCountryAirports(countryBox1.getValue())));

        countryBox2.setLabel("Where to:");

        destinationBox.setItemLabelGenerator(AirportDto::getName);
        destinationBox.setLabel("Airport:");
        destinationBox.setRequired(true);

        countryBox2.setItems(countries);
        countryBox2.addValueChangeListener(event -> destinationBox.setItems(travelService.getCountryAirports(countryBox2.getValue())));

        startDatePicker.setLabel("Flying when: ");
        startDatePicker.setMin(LocalDate.now());
        startDatePicker.setClearButtonVisible(true);
        startDatePicker.setRequired(true);

        endDatePicker.setLabel("Return: ");
        endDatePicker.setMin(LocalDate.now());
        endDatePicker.setClearButtonVisible(true);
        startDatePicker.addValueChangeListener(event -> {
            LocalDate flyDate = event.getValue();
            LocalDate returnDate = endDatePicker.getValue();
            if (flyDate != null) {
                endDatePicker.setMin(flyDate);
                if (returnDate == null) {
                    endDatePicker.setOpened(true);
                }
            } else {
                endDatePicker.setMin(null);
                Notification.show("Please select fly date");
            }
        });

        add(countryBox1, originBox, countryBox2, destinationBox, startDatePicker, endDatePicker);
    }

    public List<FlightDto> getFlightDtoList() {
        airport = originBox.getValue().getIata();
        destination = destinationBox.getValue().getIata();
        LocalDate departureDate = startDatePicker.getValue();
        return travelService.getFlights(airport, destination, departureDate);
    }

    public List<FlightDto> getReturnList() {
        if(endDatePicker.getValue() != null) {
            airport = originBox.getValue().getIata();
            destination = destinationBox.getValue().getIata();
            LocalDate returnDate = endDatePicker.getValue();
            return travelService.getFlights(destination, airport, returnDate);
        } else {
            return new ArrayList<>();
        }
    }
}
