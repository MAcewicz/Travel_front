package com.kodilla.travelfront.views;

import com.kodilla.travelfront.components.TopBar;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("faq")
public class FAQView extends VerticalLayout {

    public FAQView() {

        TopBar topBar = new TopBar();

        Label breakLine1 = new Label("__________________________________________________________________________________________________");
        Label breakLine2 = new Label("__________________________________________________________________________________________________");
        Label breakLine3 = new Label("__________________________________________________________________________________________________");

        Label question1 = new Label("Q: The results from app are different from the ones on airlines page. Why?");
        Label answer1 = new Label("A: It's because I'm using free version of API which is used just for tests" +
                " and does not return real results.");

        Label question2 = new Label("Q: What APIs are used?");
        Label answer2 = new Label("A: I'm using Amadeus for flight search in free, test version " +
                "and Weatherbit.io for weather forecast.");

        Label question3 = new Label("Q: Why not use full version of API?");
        Label answer3 = new Label("A: Firstly, this app only serves to show my skills in back-end development and not for real usage" +
                " as there are many better ones. Secondly, I'm rather poor.");

        Label question4 = new Label("Q: What front-end is made in?");
        Label answer4 = new Label("A: Vaadin 14. This is enough for me to present the application and " +
                "at the moment I want to full focus just on back-end.");

        add(topBar, question1, answer1, breakLine1,
                question2, answer2, breakLine2,
                question3, answer3, breakLine3,
                question4, answer4);
    }
}
