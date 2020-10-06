package lang;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import lang.view.createNoteFile;
import lang.view.topic;
import javafx.scene.text.Font;
import java.io.IOException;
import java.util.Timer;
import static lang.view.LinkedList.readFromFile;
import static lang.view.learnPageController.displayWordList;
import static lang.view.topic.initializeHashMap;
import static lang.view.topic.topicMap;

public class Main extends Application {
    public static String notesFileText ="";
    public static BorderPane learnP;
     public static TextField notesTextField = new TextField();
    public static String dailyRoutineString="";
    public static String educationString="";
    public static String foodString="";
    public static String personalDetailsString="";
    public static String appearanceString="";
    public static String healthString="";
    public static String relationshipsString="";
    public static String shoppingString="";
    public static String employmentString="";
    public static String entertainmentString="";
    public static String holidaysString="";
    public static String mediaString="";
    public static String sportString="";
    public static String technologyString="";
    public static String transportString="";
    public static String environmentString="";
    public static String globalIssuesString="";
    public static String neighbourhoodString="";
    public static String geographyString="";
    public static String townsAndServicesString="";
    public static String weatherString="";
    public static String otherString="";
   public static Button dailyRoutineButton = new Button("Daily Routines");
    public static Button educationButton = new Button("Education");
    public static Button foodButton = new Button("Food");
    public static Button personalDetailsButton = new Button("Personal Details");
    public static  Button appearanceButton = new Button("Appearance and Character");
    public static Button healthButton = new Button("Health");
    public static Button relationshipsButton = new Button("Relationships");
    public static Button shoppingButton = new Button("Shopping");
    public static Button employmentButton = new Button("Employment");
    public static  Button entertainmentButton = new Button("Entertainment");
    public static  Button holidaysButton = new Button("Holidays");
    public static  Button mediaButton = new Button("Media");
    public static  Button sportButton = new Button("Sport");
    public static  Button technologyButton = new Button("Technology");
    public static  Button transportButton = new Button("Transport");
    public static Button environmentButton = new Button("Environment");
    public static Button globalIssuesButton = new Button("Global Issues");
    public static Button neighbourhoodButton = new Button("Neighbourhood");
    public static Button geographyButton = new Button("Geography");
    public static Button townsAndServicesButton = new Button("Towns and Services");
    public static Button weatherButton = new Button("Weather");
    public static Button otherButton = new Button("Other");

    static final ObservableList<topic> topics = FXCollections.observableArrayList(
            new topic("Daily Routines",topicMap.get("Daily Routines"))
            );
    private Main main;
    public Button startButton;
    public static void initializeAllString()
    {
        dailyRoutineString=readFromFile("Daily Routines");
        dailyRoutineButton.setOnAction(e->displayWordList("Daily Routines"));
        educationString=readFromFile("Education");
        educationButton.setOnAction(e->displayWordList("Education"));
        foodString=readFromFile("Food and Drink");
        foodButton.setOnAction(e->displayWordList("Food and Drink"));
        personalDetailsString=readFromFile("Personal Details");
        personalDetailsButton.setOnAction(e->displayWordList("Personal Details"));
        appearanceString=readFromFile("Appearance and Character");
        appearanceButton.setOnAction(e->displayWordList("Appearance and Character"));
        healthString=readFromFile("Health");
        healthButton.setOnAction(e->displayWordList("Health"));
        relationshipsString=readFromFile("Relationships");
        relationshipsButton.setOnAction(e->displayWordList("Relationships"));
        shoppingString=readFromFile("Shopping");
        shoppingButton.setOnAction(e->displayWordList("Shopping"));
        employmentString=readFromFile("Employment");
        employmentButton.setOnAction(e->displayWordList("Employment"));
        entertainmentString=readFromFile("Entertainment");
        entertainmentButton.setOnAction(e->displayWordList("Entertainment"));
        holidaysString=readFromFile("Holidays");
        holidaysButton.setOnAction(e->displayWordList("Holidays"));
        mediaString=readFromFile("Media");
        mediaButton.setOnAction(e->displayWordList("Media"));
        sportString=readFromFile("Sport");
        sportButton.setOnAction(e->displayWordList("Sport"));
        technologyString=readFromFile("Technology");
        technologyButton.setOnAction(e->displayWordList("Technology"));
        transportString=readFromFile("Transport");
        transportButton.setOnAction(e->displayWordList("Transport"));
        environmentString=readFromFile("Environment");
        environmentButton.setOnAction(e->displayWordList("Environment"));
        globalIssuesString=readFromFile("Global Issues");
        globalIssuesButton.setOnAction(e->displayWordList("Global Issues"));
        neighbourhoodString=readFromFile("Neighbourhood");
        neighbourhoodButton.setOnAction(e->displayWordList("Neighbourhood"));
        geographyString=readFromFile("Geography");
        geographyButton.setOnAction(e->displayWordList("Geography"));
        townsAndServicesString=readFromFile("Towns and Services");
        townsAndServicesButton.setOnAction(e->displayWordList("Towns and Services"));
        weatherString=readFromFile("Weather");
        weatherButton.setOnAction(e->displayWordList("Weather"));
        otherString=readFromFile("Other");
        otherButton.setOnAction(e->displayWordList("Other"));
    }
    private Stage primaryStage;
    private Button button;
    public static BorderPane mainLayout;
    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/baseBorderPane.fxml"));
        //Button startButton = new Button();
       // startButton.setOnAction(startButtonClick());
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
        Timeline timeline ;
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    startButtonClick();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }

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

    public static void showStartView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainView.fxml"));
        BorderPane learnP = loader.load();
       // HBox layout = new HBox(wordsOfTheDay());
       // learnP.setLeft(layout);
        mainLayout.setCenter(learnP);
    }
    public static void showLearnScene() throws IOException {
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("learn/learnPage.fxml"));
        learnP = loader.load();
        TextField learnTextField = new TextField();
        TableView topicView= new TableView();
        TableView wordView = new TableView();
        topicView.setPrefHeight(430);
        topicView.setPrefWidth(300);
        topicView.setEditable(true);
        topicView.setMaxSize(300,430);
        VBox buttonLayout = new VBox(5);
        buttonLayout.setPrefWidth(300);
        ScrollPane scroll = new ScrollPane();
        Label topicLabel = new Label("Topics");
        Font font = new Font("Actor",24);
        dailyRoutineButton.setPrefWidth(285);
        dailyRoutineButton.setPrefHeight(50);
        dailyRoutineButton.setFont(font);

        appearanceButton.setPrefWidth(285);
        appearanceButton.setPrefHeight(50);
        appearanceButton.setFont(font);

        educationButton.setPrefWidth(285);
        educationButton.setPrefHeight(50);
        educationButton.setFont(font);

        employmentButton.setPrefWidth(285);
        employmentButton.setPrefHeight(50);
        employmentButton.setFont(font);

        entertainmentButton.setPrefWidth(285);
        entertainmentButton.setPrefHeight(50);
        entertainmentButton.setFont(font);

        environmentButton.setPrefWidth(285);
        environmentButton.setPrefHeight(50);
        environmentButton.setFont(font);

        foodButton.setPrefWidth(285);
        foodButton.setPrefHeight(50);
        foodButton.setFont(font);

        geographyButton.setPrefWidth(285);
        geographyButton.setPrefHeight(50);
        geographyButton.setFont(font);

        globalIssuesButton.setPrefWidth(285);
        globalIssuesButton.setPrefHeight(50);
        globalIssuesButton.setFont(font);

        healthButton.setPrefWidth(285);
        healthButton.setPrefHeight(50);
        healthButton.setFont(font);

        holidaysButton.setPrefWidth(285);
        holidaysButton.setPrefHeight(50);
        holidaysButton.setFont(font);

        mediaButton.setPrefWidth(285);
        mediaButton.setPrefHeight(50);
        mediaButton.setFont(font);

        neighbourhoodButton.setPrefWidth(285);
        neighbourhoodButton.setPrefHeight(50);
        neighbourhoodButton.setFont(font);

        otherButton.setPrefWidth(285);
        otherButton.setPrefHeight(50);
        otherButton.setFont(font);

        relationshipsButton.setPrefWidth(285);
        relationshipsButton.setPrefHeight(50);
        relationshipsButton.setFont(font);

        shoppingButton.setPrefWidth(285);
        shoppingButton.setPrefHeight(50);
        shoppingButton.setFont(font);

        sportButton.setPrefWidth(285);
        sportButton.setPrefHeight(50);
        sportButton.setFont(font);

        technologyButton.setPrefWidth(285);
        technologyButton.setPrefHeight(50);
        technologyButton.setFont(font);

        townsAndServicesButton.setPrefWidth(285);
        townsAndServicesButton.setPrefHeight(50);
        townsAndServicesButton.setFont(font);

        transportButton.setPrefWidth(285);
        transportButton.setPrefHeight(50);
        transportButton.setFont(font);

        weatherButton.setPrefWidth(285);
        weatherButton.setPrefHeight(50);
        weatherButton.setFont(font);

        personalDetailsButton.setPrefWidth(285);
        personalDetailsButton.setPrefHeight(50);
        personalDetailsButton.setFont(font);
        Insets inset = new Insets(0,0,5,0);
buttonLayout.setPadding(inset);
topicLabel.setFont(font);
        buttonLayout.getChildren().addAll(topicLabel,dailyRoutineButton,educationButton,foodButton,personalDetailsButton,appearanceButton,healthButton,relationshipsButton,shoppingButton,employmentButton,entertainmentButton,holidaysButton,mediaButton,sportButton,technologyButton,transportButton,environmentButton,globalIssuesButton,neighbourhoodButton,geographyButton,townsAndServicesButton,weatherButton,otherButton);
scroll.setContent(buttonLayout);
        TableColumn topicTitleColumn = new TableColumn("Topic");
        topicView.setEditable(true);
      topicTitleColumn.setCellValueFactory(new PropertyValueFactory<topic,String>("Topic"));
      topicTitleColumn.setPrefWidth(300);
        topicView.setItems(topics);
      topicView.getColumns().addAll(topicTitleColumn);
        /*initializeHashMap();
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
        initializeLinkedList("Other",otherString);*//** THIS IS ALSO INITIALIZED IN mainController.java**/
        mainLayout.setCenter(learnP);
        learnP.setLeft(scroll);
        learnP.setCenter(wordView);
    }
    public static void showTestScene() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/topicWiseTestPage.fxml"));
        BorderPane learnP = loader.load();

        mainLayout.setCenter(learnP);

    }
    public static void showNotesScene() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("notes/notesPage.fxml"));
        BorderPane learnP = loader.load();
//TextField notesTextField = new TextField();
notesTextField.setPrefHeight(1200.0);
notesTextField.setPrefWidth(434.0);
learnP.setCenter(notesTextField);
notesTextField.setText(createNoteFile.openNoteFile());
        notesFileText = notesTextField.getText();
        mainLayout.setCenter(learnP);

    }
public static void initializeLinkedList(String topic, String dataString)//Daily Routines dailyRoutineString
{
    String esp="";
    String eng="";
    int rating =0;
    int numWords=topicMap.get(topic).getSize();
    int begin=0;
    int end =0;
    int cnt =0;
    int j=0;
    int a=0;
    for(int i =0;i<dataString.length();i++)
    {
        if(dataString.charAt(i)=='?')
        {
            numWords++;
        }
    }

    System.out.println(dataString);
        for (int i = 0; i < dataString.length(); i++)
        {
            begin = dataString.indexOf('?',i);
            end = dataString.indexOf('.', i);
            esp = dataString.substring(begin+1, end);
           // System.out.println(esp);
            begin = dataString.indexOf('.', i);
            end = dataString.indexOf('!', i);
            eng = dataString.substring(begin+1, end);
           // System.out.println(eng);
            begin = dataString.indexOf('!', i);
            end = dataString.indexOf('-', i);
            rating = Integer.valueOf(dataString.substring(begin+1, end));
           // System.out.println(rating);
            i = end;
           // System.out.println("pre add");
            topicMap.get(topic).addAtTail(esp, eng, rating);
            //System.out.println(topic);
           // topicMap.get(topic).printList();
            cnt++;
           //System.out.println(topic+cnt);
        }
}

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Language App");
        showMainView();
       // showStartView();
    }
}


