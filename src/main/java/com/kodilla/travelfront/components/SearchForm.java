package com.kodilla.travelfront.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;

import java.time.LocalDate;

public class SearchForm extends FormLayout {

    public SearchForm() {

        TextField whereTo = new TextField("Where to: ");
        whereTo.isRequired();
        TextField flyingFrom = new TextField("Flying from: ");
        flyingFrom.isRequired();
        Button searchButton = new Button("Search");

        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setLabel("Flying when: ");
        startDatePicker.setClearButtonVisible(true);
        startDatePicker.isRequired();
        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setLabel("Return: ");
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

        add(whereTo, flyingFrom, startDatePicker, endDatePicker, searchButton);
    }
}
