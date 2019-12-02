package com.kodilla.travelfront.components;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;

public class TopBar extends MenuBar {

    public TopBar() {

        MenuItem home = addItem("Home");
        home.add(new Icon(VaadinIcon.HOME));
        home.addClickListener(event -> home.getUI().ifPresent(ui -> ui.navigate("")));
        MenuItem recommended = addItem("Recommended");
        recommended.add(new Icon(VaadinIcon.AIRPLANE));
        recommended.addClickListener(event -> recommended.getUI().ifPresent(ui -> ui.navigate("recommended")));
        MenuItem search = addItem("Search");
        search.add(new Icon(VaadinIcon.SEARCH));
        search.addClickListener(event -> search.getUI().ifPresent(ui -> ui.navigate("search")));
        MenuItem faq = addItem("F.A.Q");
        faq.add(new Icon(VaadinIcon.QUESTION));
        faq.addClickListener(event -> faq.getUI().ifPresent(ui -> ui.navigate("faq")));
    }
}
