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
        MenuItem search = addItem("Search");
        search.add(new Icon(VaadinIcon.SEARCH));
        search.addClickListener(event -> search.getUI().ifPresent(ui -> ui.navigate("search")));
        MenuItem signIn = addItem("Sign In");
        signIn.add(new Icon(VaadinIcon.SIGN_IN));
    }
}
