package com.kodilla.travelfront.views;

import com.kodilla.travelfront.components.SearchForm;
import com.kodilla.travelfront.components.TopBar;
import com.kodilla.travelfront.domain.FlightDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("search")
public class SearchView extends VerticalLayout {

    public SearchView() {

        setWidthFull();

        TopBar topBar = new TopBar();

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setWidthFull();

        SearchForm searchForm = new SearchForm();

        Button searchButton = new Button("Search");

        Grid<FlightDto> flightGrid = new Grid<>(FlightDto.class);
        flightGrid.setColumns("airport", "destination", "airline", "departure", "arrival", "price");

        Grid<FlightDto> returnGrid = new Grid<>(FlightDto.class);
        returnGrid.setColumns("airport", "destination", "airline", "departure", "arrival", "price");

        searchButton.addClickListener(event -> {
            flightGrid.setItems(searchForm.getFlightDtoList());
            returnGrid.setItems(searchForm.getReturnList());
        });

        add(topBar, searchForm, searchButton, flightGrid, returnGrid);
    }
}
