package com.kodilla.travelfront.views;

import com.kodilla.travelfront.components.TopBar;
import com.kodilla.travelfront.domain.Flight;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {

        setWidthFull();

        TopBar topBar = new TopBar();

        Grid<Flight> flightGrid = new Grid<>(Flight.class);
        flightGrid.setColumns("to", "from", "airline", "departure", "arrival", "price");
        flightGrid.setWidthFull();

        add(topBar, flightGrid);
    }
}
