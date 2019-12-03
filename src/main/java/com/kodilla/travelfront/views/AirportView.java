package com.kodilla.travelfront.views;

import com.kodilla.travelfront.domain.AirportDto;
import com.kodilla.travelfront.services.TravelService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("airport")
public class AirportView extends VerticalLayout {

    private TravelService travelService = new TravelService();

    public AirportView() {

        TextField city = new TextField();
        city.setLabel("city");
        TextField country = new TextField();
        country.setLabel("country");
        TextField countryCode = new TextField();
        countryCode.setLabel("country code");
        TextField iata = new TextField();
        iata.setLabel("iata");
        TextField name = new TextField();
        name.setLabel("name");

        Button button = new Button("Add");
        button.addClickListener(event -> {
            travelService.addAirport(new AirportDto(city.getValue(),
                    country.getValue(),
                    countryCode.getValue(),
                    iata.getValue(),
                    name.getValue()));
            Notification.show("Airport added");
        });

        add(city, country, countryCode, iata, name, button);
    }
}
