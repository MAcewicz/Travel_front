package com.kodilla.travelfront.views;

import com.kodilla.travelfront.components.SearchForm;
import com.kodilla.travelfront.components.TopBar;
import com.kodilla.travelfront.domain.Flight;
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
        searchForm.setWidth("30%");

        Grid<Flight> flightGrid = new Grid<>(Flight.class);
        flightGrid.setColumns("to", "from", "airline", "departure", "arrival", "price");
        flightGrid.setWidth("70%");

        horizontalLayout.add(searchForm, flightGrid);

        add(topBar, horizontalLayout);
    }
}
