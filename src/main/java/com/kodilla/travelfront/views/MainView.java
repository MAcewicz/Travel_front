package com.kodilla.travelfront.views;

import com.kodilla.travelfront.components.TopBar;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {

        setWidthFull();

        TopBar topBar = new TopBar();

        Label breakLine = new Label(" ");

        Label label = new Label("Welcome. This is project for my Java Back-end Developer portfolio. " +
                "It's simple flight search application, which also can recommend destinations with a good weather. " +
                "Front-end is made just to showcase the app working in real-life conditions. " +
                "For more question and answers please visit F.A.Q. page. " +
                "To view the back-end code, please visit page below: ");

        Anchor anchor = new Anchor("https://github.com/MAcewicz/Travel_Back", "GitHub Repository");

        add(topBar, breakLine, label, anchor);
    }
}
