package com.kodilla.travelfront.views;

import com.kodilla.travelfront.domain.AirlineDto;
import com.kodilla.travelfront.services.TravelService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("airline")
public class AirlineView extends VerticalLayout {

    private TravelService travelService = new TravelService();

    public AirlineView() {

        TextField name = new TextField("name");
        TextField iata = new TextField("iata");

        Button button = new Button("Add");
        button.addClickListener(event -> {
            travelService.addAirLine(new AirlineDto(name.getValue(), iata.getValue()));
            Notification.show("Airline added");
        });

        add(name, iata, button);
    }
}
