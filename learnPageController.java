package lang.view;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lang.Main;

import javax.swing.*;
import javax.swing.text.html.CSS;
import java.io.IOException;
import java.util.List;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static lang.Main.*;
import static lang.view.LinkedList.deleteFromFile;
//import static lang.view.LinkedList.wordsOfTheDay;
import static lang.view.topic.dailyRoutineObj;
import static lang.view.topic.topicMap;

public class learnPageController
{
    ObservableList<String> topics =
            FXCollections.observableArrayList(
                    "Daily Routines",
                    "Education",
                    "Food and Drink",
                    "Personal Details",
                    "Appearance and Character",
                    "Health",
                    "Relationships",
                    "Shopping",
                    "Employment",
                    "Entertainment",
                    "Holidays",
                    "Media",
                    "Sport",
                    "Technology",
                    "Transport",
                    "Environment",
                    "Global Issues",
                    "Neighbourhood",
                    "Geography",
                    "Towns and Services",
                    "Weather",
                    "Other"
            );
    Button deleteButton = new Button("Delete");
     ComboBox deleteTopicChoose = new ComboBox(topics);
    ListView listViewEsp = new ListView();
    ListView listViewEng = new ListView();
    VBox layout = new VBox(10);
    private Main main;
    public Button learnBackButton;
    public Button editWordsButton;
    public Button deleteWordsButton;
    static TextField engInputText = new TextField();
    static TextField espInputText = new TextField();
   // public static final TableView<word>table = new TableView<word>();
    //public static final ObservableList<word> data=FXCollections.observableArrayList();

    static ObservableList<String> options =
            FXCollections.observableArrayList(
                    "Daily Routines",
                    "Education",
                    "Food and Drink",
                    "Personal Details",
                    "Appearance and Character",
                    "Health",
                    "Relationships",
                    "Shopping",
                    "Employment",
                    "Entertainment",
                    "Holidays",
                    "Media",
                    "Sport",
                    "Technology",
                    "Transport",
                    "Environment",
                    "Global Issues",
                    "Neighbourhood",
                    "Geography",
                    "Towns and Services",
                    "Weather",
                    "Other"
            );


    final static ComboBox topicChoose = new ComboBox(options);


    @FXML
    public void learnBackButtonClick()throws IOException {
        main = new Main();
        main.showStartView();
    }
    @FXML
    public void inputDisplay() throws IOException {
main = new Main();
        Stage window = new Stage();

        //Block events to other windows

        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle("Input words");

        window.setMinWidth(300);
        window.setMinHeight(300);

        Label label = new Label();

        label.setText("Add new words here");

        HBox accentBox = new HBox();
Button smallA = new Button("á");
smallA.setOnAction(e->espInputText.setText(getTextInput().concat("á")));
        Button smallE = new Button("é");
        smallE.setOnAction(e->espInputText.setText(getTextInput().concat("é")));
        Button smallI = new Button("í");
        smallI.setOnAction(e->espInputText.setText(getTextInput().concat("í")));
        Button smallO = new Button("ó");
        smallO.setOnAction(e->espInputText.setText(getTextInput().concat("ó")));
        Button smallU = new Button("ú");
        smallU.setOnAction(e->espInputText.setText(getTextInput().concat("ú")));
        Button smallN = new Button("ñ");
        smallN.setOnAction(e->espInputText.setText(getTextInput().concat("ñ")));
        Button smallU1 = new Button("ü");
        smallU1.setOnAction(e->espInputText.setText(getTextInput().concat("ü")));
accentBox.getChildren().addAll(smallA,smallE,smallI,smallO,smallU,smallN,smallU1);
        Button bigA = new Button("Á");
        bigA.setOnAction(e->espInputText.setText(getTextInput().concat("Á")));
        Button bigE = new Button("É");
        bigE.setOnAction(e->espInputText.setText(getTextInput().concat("É")));
        Button bigI = new Button("Í");
        bigI.setOnAction(e->espInputText.setText(getTextInput().concat("Í")));
        Button bigO = new Button("Ó");
        bigO.setOnAction(e->espInputText.setText(getTextInput().concat("Ó")));
        Button bigU = new Button("Ú");
        bigU.setOnAction(e->espInputText.setText(getTextInput().concat("Ú")));
        Button bigN = new Button("Ñ");
        bigN.setOnAction(e->espInputText.setText(getTextInput().concat("Ñ")));
        Button bigU1 = new Button("Ü");
        bigU1.setOnAction(e->espInputText.setText(getTextInput().concat("Ü")));
        accentBox.getChildren().addAll(bigA,bigE,bigI,bigO,bigU,bigN,bigU1);
        Button closeButton = new Button("Close this window");

        Button submitButton = new Button("Submit");
        closeButton.setOnAction(e -> window.close());


        engInputText.setPromptText("English");
        espInputText.setPromptText("Spanish");
        topicChoose.setPromptText("Topics");
        submitButton.setOnAction(e-> getInput());
        VBox layout = new VBox(10);
topicChoose.getSelectionModel().selectFirst();
        layout.getChildren().addAll(label, topicChoose, espInputText,accentBox, engInputText, submitButton);

        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning

        Scene scene = new Scene(layout);
window.setOnCloseRequest(e-> {
    try {
        Main.showStartView();
    } catch (IOException e1) {
        e1.printStackTrace();
    }
});
        window.setScene(scene);

        window.showAndWait();

    }
    public static void getInput() {
        String x ="";
        /*if(topicChoose.getValue().toString().equals(null))
        {
        }
        else{*/
            x=topicChoose.getValue().toString();
        String text[] ={x,espInputText.getText(),engInputText.getText()};
        //System.out.println(text[0]);
        //System.out.println(text[1]);
        //System.out.println(text[2]);
        topic.traverseHashMap(text[0],text[1],text[2]);
//check hashmap for topics first
        //then add to the linked list
    }
    protected static String getTextInput()
    {
        String x = espInputText.getText();
        return x;
    }
    public static String getComboInput()
    {
         String a=topicChoose.getValue().toString();
        return a;
    }

    public static void displayWordList(String topic)
    {
        HBox wordLayout = new HBox();
        learnP.setCenter(null);
        ObservableList<String> espWords =
                FXCollections.observableArrayList();
        ObservableList<String> engWords =
                FXCollections.observableArrayList();
        String esp;
        String eng;
        LinkedList list = topicMap.get(topic);
        ListView listViewEsp = new ListView();
        listViewEsp.setPrefWidth(450);
        listViewEsp.setPrefHeight(1030);
        ListView listViewEng = new ListView();
        listViewEng.setPrefWidth(450);
        listViewEng.setPrefHeight(1030);
        wordLayout.getChildren().removeAll();
        Platform.runLater(new Runnable() {
            public void run() {
                Node n = listViewEng.lookup(".scroll-bar");
                if (n instanceof ScrollBar) {
                    final ScrollBar bar = (ScrollBar) n;
                    if (bar.getOrientation().equals(Orientation.VERTICAL)) {
                        Node n2 = listViewEsp.lookup(".scroll-bar");
                        final ScrollBar bar1=(ScrollBar)n2;
                        ((ScrollBar) n).valueProperty().bindBidirectional(bar1.valueProperty());
                    }
                }
            }
        });
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(null);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
for(int i =0;i<list.getSize()+1;i++)
{
    esp=list.find(i).getEsp();
    espWords.add(esp);
    eng=list.find(i).getEng();
    engWords.add(eng);
}
        listViewEsp.setCellFactory(cell -> {
            return new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item);
                        setFont(Font.font(16));
                    }
                }
            };
        });
        listViewEng.setCellFactory(cell -> {
            return new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item);
                        setFont(Font.font(16));
                    }
                }
            };
        });
        HBox espEng = new HBox();
        espEng.setSpacing(430);
        espEng.setPrefHeight(100);
System.out.println(espWords);
System.out.println(engWords);
scroll.setMaxWidth(900);
scroll.setMaxHeight(1000);
        listViewEsp.getItems().addAll(espWords);
        listViewEng.getItems().addAll(engWords);
        wordLayout.getChildren().addAll(listViewEsp,listViewEng);
        scroll.setContent(wordLayout);
        VBox finalWordLayout = new VBox();
        finalWordLayout.getChildren().addAll(espEng,scroll);
        learnP.setCenter(finalWordLayout);
        mainLayout.setCenter(learnP);
    }

    public void deleteAlertBox(ActionEvent actionEvent) throws IOException, InterruptedException
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Font font = new Font ("Actor",16);
        window.setTitle("Delete Words");
        window.setMinHeight(350);
        window.setMinWidth(350);
        deleteTopicChoose.getSelectionModel().selectFirst();
                deleteTopicChoose.setStyle("-fx-font: 16px \"Actor\";");
        listViewEsp.setPrefHeight(200);
        listViewEng.setPrefHeight(200);
        deleteTopicChoose.setPrefWidth(350);
        listViewEsp.setStyle("-fx-font: 16px \"Actor\";");
        String topic = deleteTopicChoose.getValue().toString();
        listViewEsp.getItems().addAll(espDeleteTopic(topic));
        listViewEng.getItems().addAll(engDeleteTopic(topic));
        deleteTopicChoose.setOnAction(e->clearLists());
        deleteButton.setOnAction(e->deleteWord(deleteTopicChoose.getValue().toString(),
                listViewEsp.getSelectionModel().getSelectedItem().toString()));

        deleteButton.setFont(font);
        layout.getChildren().addAll(deleteTopicChoose,listViewEsp,deleteButton);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
        window.setOnCloseRequest(e-> {
            try {
                handleCloseEvent();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    public void deleteWord(String topic, String s)
    {
      LinkedList listDelete = topicMap.get(topic);
      int index =0;
      for(int i =0;i<listDelete.getSize()+1;i++)
      {
          if(listDelete.find(i).getEsp().equals(s))
          {
              break;
          }
          index++;
      }
      topicMap.get(topic).deleteAtIndex(index);
      clearLists();
      deleteFromFile(s,topic);
    }

    public void clearLists()
    {
        String topic = deleteTopicChoose.getValue().toString();
        //VBox tempLayout = new VBox();
        listViewEsp.getItems().clear();
        listViewEng.getItems().clear();
        listViewEsp.getItems().addAll(espDeleteTopic(topic));
        System.out.println(listViewEsp.getItems());// its passing the first thing as topic here
        listViewEng.getItems().addAll(engDeleteTopic(topic));
        layout.getChildren().clear();
        layout.getChildren().addAll(deleteTopicChoose,listViewEsp,/*listViewEng,*/deleteButton);
    }
    public void handleCloseEvent() throws IOException {
        //layout.getChildren().addAll(deleteTopicChoose,listViewEsp,listViewEng);
       // listViewEsp.getItems().addAll(espDeleteTopic("Daily Routines"));
        //listViewEng.getItems().addAll(engDeleteTopic("Daily Routines"));
        layout.getChildren().clear();
        main = new Main();
        main.showStartView();

    }
    public static ObservableList espDeleteTopic(String topic)
    {
        ListView listViewEsp = new ListView();
        ObservableList<String> espWords =
                FXCollections.observableArrayList();
        LinkedList list = topicMap.get(topic);
        String esp;
        for(int i =1;i<list.getSize()+1;i++)
        {
            esp=list.find(i).getEsp();
            // System.out.println(esp);
            espWords.add(esp);
            // System.out.println(eng);
            // data.add(new word(esp,eng));
            // listViewEsp.getItems().addAll(esp);/** THE PROBLEM IS THAT ITS ADDING THE LISTS TO THE RIGHT AND NOT REPLACING IT**/

            // listViewEng.getItems().addAll(eng);

        }
        listViewEsp.getItems().add(espWords);
        return espWords;
    }
    public static ObservableList engDeleteTopic(String topic)
    {
        ListView listViewEng = new ListView();
        ObservableList<String> engWords =
                FXCollections.observableArrayList();
        LinkedList list = topicMap.get(topic);
        String eng;
        for(int i =1;i<list.getSize()+1;i++)
        {
            eng=list.find(i).getEng();
            // System.out.println(esp);
            engWords.add(eng);
            // System.out.println(eng);
            // data.add(new word(esp,eng));
            // listViewEsp.getItems().addAll(esp);/** THE PROBLEM IS THAT ITS ADDING THE LISTS TO THE RIGHT AND NOT REPLACING IT**/

            // listViewEng.getItems().addAll(eng);

        }
        listViewEng.getItems().add(engWords);
        return engWords;
    }
    public void initializeWordsOfTheDay()
    {
        //wordsOfTheDay();
    }
}




