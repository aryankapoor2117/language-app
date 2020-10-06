package lang.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lang.Main;


import java.io.IOException;

import static lang.Main.*;
import static lang.view.LinkedList.readFromFile;
import static lang.view.topic.initializeHashMap;


public class mainController {
    private Main main;
    public Button startButton;


    @FXML
    public void startButtonClick()throws IOException {

        main = new Main();
        main.showStartView();
        initializeHashMap();
        initializeAllString();
        initializeLinkedList("Daily Routines",dailyRoutineString);
        initializeLinkedList("Education",educationString);
        initializeLinkedList("Food and Drink",foodString);
        initializeLinkedList("Personal Details",personalDetailsString);
        initializeLinkedList("Appearance and Character",appearanceString);
        initializeLinkedList("Health",healthString);
        initializeLinkedList("Relationships",relationshipsString);
        initializeLinkedList("Shopping",shoppingString);
        initializeLinkedList("Employment",employmentString);
        initializeLinkedList("Entertainment",entertainmentString);
        initializeLinkedList("Holidays",holidaysString);
        initializeLinkedList("Media",mediaString);
        initializeLinkedList("Sport",sportString);
        initializeLinkedList("Technology",technologyString);
        initializeLinkedList("Transport",transportString);
        initializeLinkedList("Environment",environmentString);
        initializeLinkedList("Global Issues",globalIssuesString);
        initializeLinkedList("Neighbourhood",neighbourhoodString);
        initializeLinkedList("Geography",geographyString);
        initializeLinkedList("Towns and Services",townsAndServicesString);
        initializeLinkedList("Weather",weatherString);
        initializeLinkedList("Other",otherString);
    }

}

