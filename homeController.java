package lang.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import lang.Main;


import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static java.awt.Color.white;
import static lang.Main.*;
import static lang.view.LinkedList.updateRatings;
import static lang.view.LinkedList.wordsOfTheDay;
import static lang.view.createNoteFile.openNoteFile;
import static lang.view.topic.topicMap;


public class homeController {
    int ansRight =0;
    int totalQuestion =0;
    boolean buttonClicked = false;
    Timer timer = new Timer();
    Timeline timeline;
    Stage window = new Stage();
    Stage errorWindow = new Stage();
    TextField answerTextField = new TextField();
    Button answerButton = new Button("Check");
    Label resultsQuestionWord = new Label();
    Label resultsCorrectAnswerWord = new Label();
    Label resultsUserAnswerWord = new Label();
    Label correctOrIncorrect = new Label();
    Button resultsContinueButton =new Button("Continue");
    String correctSound ="corrSound.mp3";
    private javafx.scene.media.Media mediaCorrect= new Media(new File(correctSound).toURI().toString());
    MediaPlayer mediaPlayerCorrect= new MediaPlayer(mediaCorrect);
    String wrongSound = "wrongSound.mp3";
    private javafx.scene.media.Media mediaWrong= new Media(new File(wrongSound).toURI().toString());
    MediaPlayer mediaPlayerWrong = new MediaPlayer(mediaWrong);
    int secondPassed=7;
    String timedWord="";//because the word inside timed class has to be final
    VBox results = new VBox();
    String answer="";
    Button backButton = new Button("Back");
    boolean isTimed=false;
    private Main main;
    public Button button;
    public Button toTestButton;
    public Label wordDisplay = new Label();
    public BorderPane learnP;

    public void testBackButtonClick()throws IOException
    {
        main = new Main();
        main.showStartView();
        System.out.println(ansRight);
        System.out.println(totalQuestion);
        if(totalQuestion!=0) {
            if(isTimed==false) {
                showResultsPage(ansRight, totalQuestion);
            }
            else
            {
                showTimedResultsPage(ansRight,totalQuestion);
            }
        }
        updateRatings("Daily Routines");
        updateRatings("Education");
        updateRatings("Food and Drink");
        updateRatings("Appearance and Character");
        updateRatings("Health");
        updateRatings("Relationships");
        updateRatings("Shopping");
        updateRatings("Employment");
        updateRatings("Entertainment");
        updateRatings("Holidays");
        updateRatings("Media");
        updateRatings("Sport");
        updateRatings("Technology");
        updateRatings("Transport");
        updateRatings("Environment");
        updateRatings("Global Issues");
        updateRatings("Neighbourhood");
        updateRatings("Geography");
        updateRatings("Towns and Services");
        updateRatings("Weather");
        updateRatings("Other");
        ansRight=0;
        totalQuestion=0;

    }

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

     ComboBox topicChoose = new ComboBox(options);

@FXML
    public void learnButtonClick()throws IOException {
        main = new Main();
        main.showLearnScene();
    }
    @FXML
    public void toTestPageClick()throws IOException {

        main = new Main();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/topicWiseTestPage.fxml"));
         learnP = loader.load();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Select the type of test");
        Button topicWise = new Button("Topic Wise");
        Font font = new Font("Actor",16);
        topicWise.setFont(font);
        topicChoose.setStyle("-fx-font: 14px \"Actor\";");
       /* topicWise.setStyle("{-fx-background-color: \n" +
                "        #090a0c,\n" +
                "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                "        linear-gradient(#20262b, #191d22),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 5,4,3,5;\n" +
                "    -fx-background-insets: 0,1,2,0;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "    -fx-font-family: \"Actor\";\n" +
                "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                "    -fx-font-size: 12px;\n" +
                "    -fx-padding: 10 20 10 20;}");*/
        Button randomized = new Button("All Topics");
        randomized.setFont(font);
        randomized.setOnAction(e-> {
            try {
                randomizedTest();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        Button timed = new Button("Timed Test");
        timed.setFont(font);
        timed.setOnAction(e-> {
            try {
                timedTest();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        window.setMinWidth(200);
        window.setMinHeight(200);
        window.setOnCloseRequest(e-> {
            try {
                main.showStartView();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        topicChoose.setPromptText("Please choose topic for Topic Wise Test");
topicChoose.getSelectionModel().selectFirst();

            topicWise.setOnAction(e -> {
                try {
                    getTopicWiseWords(topicChoose.getValue().toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });


        Label label = new Label();
        label.setText("Choose the Type of Test");
        Font labelFont = new Font("Actor",16);
        label.setFont(labelFont);
        label.setStyle("-fx-font-weight: bold");
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,topicWise,topicChoose,randomized,timed);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
        VBox layoutTest = new VBox();
        layoutTest.getChildren().addAll(wordDisplay, answerTextField,answerButton);
        learnP.setCenter(layoutTest);
        mainLayout.setCenter(learnP);
       // main.showTestScene();
    }
    public void getTopicWiseWords(String topic)throws IOException
    {
        main = new Main();
        LinkedList list = topicMap.get(topic);
        wordDisplay.setText("");
        Font wordDisplayFont = new Font("Actor",60);
        wordDisplay.setFont(wordDisplayFont);
        System.out.println("size is"+list.getSize());
        System.out.println(Math.ceil(Math.random()*(list.getSize())));
        double espOrEng = Math.random();
                String word="";
        System.out.println(espOrEng);

        if(espOrEng>=0&&espOrEng<=0.5) {
            word=list.find((int) Math.ceil(Math.random() * (list.getSize()))).getEsp();
            wordDisplay.setText(word);
            String finalWord = word;
            answerButton.setOnAction(e-> {
                try {
                    checkTopicWiseEspAnswer(topic, finalWord);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        }
        else if(espOrEng>0.5&&espOrEng<=1.0)
        {
            answer = answerTextField.getText();
            word=list.find((int) Math.ceil(Math.random() * (list.getSize()))).getEng();
            wordDisplay.setText(word);
            String finalWord1 = word;

            answerButton.setOnAction(e-> {
                try {
                    checkTopicWiseEngAnswer(topic, finalWord1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/topicWiseTestPage.fxml"));
        VBox layoutTest = new VBox();
        HBox accentBox = new HBox();
        Button smallA = new Button("á");
        smallA.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("á")));
        Button smallE = new Button("é");
        smallE.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("é")));
        Button smallI = new Button("í");
        smallI.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("í")));
        Button smallO = new Button("ó");
        smallO.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("ó")));
        Button smallU = new Button("ú");
        smallU.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("ú")));
        Button smallN = new Button("ñ");
        smallN.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("ñ")));
        Button smallU1 = new Button("ü");
        smallU1.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("ü")));
        accentBox.getChildren().addAll(smallA,smallE,smallI,smallO,smallU,smallN,smallU1);
        Button bigA = new Button("Á");
        bigA.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Á")));
        Button bigE = new Button("É");
        bigE.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("É")));
        Button bigI = new Button("Í");
        bigI.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Í")));
        Button bigO = new Button("Ó");
        bigO.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Ó")));
        Button bigU = new Button("Ú");
        bigU.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Ú")));
        Button bigN = new Button("Ñ");
        bigN.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Ñ")));
        Button bigU1 = new Button("Ü");
        bigU1.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Ü")));
        Font accentFont = new Font("Actor",16);
        smallA.setFont(accentFont);
        smallE.setFont(accentFont);
        smallI.setFont(accentFont);
        smallO.setFont(accentFont);
        smallU.setFont(accentFont);
        smallN.setFont(accentFont);
        smallU1.setFont(accentFont);
        bigA.setFont(accentFont);
        bigE.setFont(accentFont);
        bigI.setFont(accentFont);
        bigO.setFont(accentFont);
        bigU.setFont(accentFont);
        bigN.setFont(accentFont);
        bigU1.setFont(accentFont);
        accentBox.getChildren().addAll(bigA,bigE,bigI,bigO,bigU,bigN,bigU1);
        accentBox.setSpacing(10);
        backButton.setOnAction(e-> {
            try {
                testBackButtonClick();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        answerTextField.setMinSize(150,50);
        Font answerFont= new Font("Actor",20);
        answerTextField.setFont(answerFont);
        answerButton.setFont(accentFont);
        backButton.setFont(accentFont);
        layoutTest.getChildren().addAll(wordDisplay, answerTextField,accentBox,answerButton,backButton);
        layoutTest.setSpacing(15);
        Insets inset = new Insets(100,300,100,300);
        //Insets wordDisplayInsets = new Insets(0,0,0,200);
        //wordDisplay.setPadding(wordDisplayInsets);
        wordDisplay.setAlignment(Pos.CENTER);
        layoutTest.setPadding(inset);
        learnP = loader.load();
        learnP.setCenter(layoutTest);
        mainLayout.setCenter(learnP);
window.close();
    }

    public void checkTopicWiseEspAnswer(String topic,String word) throws IOException {
        boolean chk = false;
        int index =0;
        LinkedList list = topicMap.get(topic);
        answer = answerTextField.getText();
        answerTextField.setText("");
        for(int i =0;i<list.getSize()+1;i++)
        {
            if(list.find(i).getEsp().equals(word))//finding index of question word
            {
                index=i;
                break;
            }
        }
        if(list.find(index).getEng().equals(answer))
        {
            chk = true;
        }
        else {
            chk = false;
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/resultsPage.fxml"));
        learnP = loader.load();
        resultsQuestionWord.setText("The question was "+word);
        resultsCorrectAnswerWord.setText("The correct answer was "+list.find(index).getEng());
        resultsUserAnswerWord.setText("Your answer was "+answer);
        Font font = new Font("Actor",20);
        resultsQuestionWord.setFont(font);
        resultsCorrectAnswerWord.setFont(font);
        resultsUserAnswerWord.setFont(font);
        Font corrFont = new Font("Actor",48);
        correctOrIncorrect.setFont(corrFont);
        Insets inset = new Insets(100,0,100,500);
        results.setPadding(inset);
        results.setSpacing(10);

if(chk == true)
{
    ++ansRight;
    ++totalQuestion;
    System.out.println("ansRight is increasing"+ansRight);
    correctOrIncorrect.setText("Correct");
    int ratingChange =topicMap.get(topic).find(index).getRating()-1;
    topicMap.get(topic).find(index).setRating(ratingChange);
    mediaPlayerCorrect.seek(Duration.millis(0));
    mediaPlayerCorrect.play();

}
     else   if(chk == false)
        {
            System.out.println("totalQuestion is increasing"+totalQuestion);
            ++totalQuestion;
            correctOrIncorrect.setText("Wrong");
            int ratingChange =topicMap.get(topic).find(index).getRating()+1;
            topicMap.get(topic).find(index).setRating(ratingChange);
            mediaPlayerWrong.seek(Duration.millis(0));
            mediaPlayerWrong.play();
        }
        resultsContinueButton.setOnAction(e-> {
            try {
                getTopicWiseWords(topic);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println(topicMap.get(topic).find(index).getRating());
        results.getChildren().clear();
        results.getChildren().addAll(correctOrIncorrect,resultsQuestionWord,resultsCorrectAnswerWord,resultsUserAnswerWord, resultsContinueButton);
        learnP.setCenter(results);
        mainLayout.setCenter(learnP);


    }
    public void checkTopicWiseEngAnswer(String topic, String word) throws IOException {
        boolean chk = false;
        int index =0;
        LinkedList list = topicMap.get(topic);
        answer = answerTextField.getText();
        answerTextField.setText("");
        System.out.println("word is "+word+"topic is "+topic +"my answer is "+answer);

        for(int i =0;i<list.getSize()+1;i++)
        {
            if(list.find(i).getEng().equals(word))//finding index of question word
            {
                index=i;
                break;
            }
        }
        System.out.println("index is "+index);
        if(list.find(index).getEsp().equals(answer))
        {
            chk = true;
        }
        else {
            chk = false;
        }// now create a result page
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/resultsPage.fxml"));
        learnP = loader.load();
        resultsQuestionWord.setText("The question was "+word);
        resultsCorrectAnswerWord.setText("The correct answer was "+list.find(index).getEsp());
        resultsUserAnswerWord.setText("Your answer was "+answer);
        Font font = new Font("Actor",20);
        resultsQuestionWord.setFont(font);
        resultsCorrectAnswerWord.setFont(font);
        resultsUserAnswerWord.setFont(font);
        Font corrFont = new Font("Actor",48);
        correctOrIncorrect.setFont(corrFont);
        Insets inset = new Insets(100,0,100,500);
        results.setPadding(inset);
        results.setSpacing(10);
        if(chk == true)
        {
            ++ansRight;
            System.out.println("ansRight is increasing"+ansRight);
            ++totalQuestion;
            correctOrIncorrect.setText("Correct");
            int ratingChange =topicMap.get(topic).find(index).getRating()-1;
            topicMap.get(topic).find(index).setRating(ratingChange);
            mediaPlayerCorrect.seek(Duration.millis(0));
            mediaPlayerCorrect.play();
        }
        else   if(chk == false)
        {
            System.out.println("total queston is increasin"+totalQuestion);
            ++totalQuestion;
            correctOrIncorrect.setText("Wrong");
            int ratingChange =topicMap.get(topic).find(index).getRating()+1;
            topicMap.get(topic).find(index).setRating(ratingChange);
            mediaPlayerWrong.seek(Duration.millis(0));
            mediaPlayerWrong.play();

        }
        resultsContinueButton.setOnAction(e-> {
            try {
                getTopicWiseWords(topic);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println(topicMap.get(topic).find(index).getRating());
        results.getChildren().clear();
        results.getChildren().addAll(correctOrIncorrect,resultsQuestionWord,resultsCorrectAnswerWord,resultsUserAnswerWord, resultsContinueButton);
        learnP.setCenter(results);
        mainLayout.setCenter(learnP);

        System.out.println("results is "+chk);

    }

    public void randomizedTest() throws IOException {

        Random generator = new Random();
        Object[] values = topicMap.values().toArray();
        Object randomValue = values[generator.nextInt(values.length)];
        LinkedList list = (LinkedList) randomValue;
        String topic = (String) getKeyByValue(topicMap,list);
        Font wordDisplayFont = new Font("Actor",60);
        wordDisplay.setFont(wordDisplayFont);
        double espOrEng = Math.random();
        String word="";
        System.out.println(espOrEng);
        if(espOrEng>=0&&espOrEng<=0.5) {
            word=list.find((int) Math.ceil(Math.random() * (list.getSize()))).getEsp();
            wordDisplay.setText(word);
            String finalWord = word;
            // String finalAnswer = answer;
            answerButton.setOnAction(e-> {
                try {
                    checkRandomizedTestEspAnswer(topic, finalWord);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        }
        else if(espOrEng>0.5&&espOrEng<=1.0)
        {
            answer = answerTextField.getText();
            word=list.find((int) Math.ceil(Math.random() * (list.getSize()))).getEng();
            wordDisplay.setText(word);
            String finalWord1 = word;

            answerButton.setOnAction(e-> {
                try {
                    checkRandomizedTestEngAnswer(topic, finalWord1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/topicWiseTestPage.fxml"));
        VBox layoutTest = new VBox();
        HBox accentBox = new HBox();
        Button smallA = new Button("á");
        smallA.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("á")));
        Button smallE = new Button("é");
        smallE.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("é")));
        Button smallI = new Button("í");
        smallI.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("í")));
        Button smallO = new Button("ó");
        smallO.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("ó")));
        Button smallU = new Button("ú");
        smallU.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("ú")));
        Button smallN = new Button("ñ");
        smallN.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("ñ")));
        Button smallU1 = new Button("ü");
        smallU1.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("ü")));
        accentBox.getChildren().addAll(smallA,smallE,smallI,smallO,smallU,smallN,smallU1);
        Button bigA = new Button("Á");
        bigA.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Á")));
        Button bigE = new Button("É");
        bigE.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("É")));
        Button bigI = new Button("Í");
        bigI.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Í")));
        Button bigO = new Button("Ó");
        bigO.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Ó")));
        Button bigU = new Button("Ú");
        bigU.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Ú")));
        Button bigN = new Button("Ñ");
        bigN.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Ñ")));
        Button bigU1 = new Button("Ü");
        bigU1.setOnAction(e->answerTextField.setText(answerTextField.getText().concat("Ü")));
        Font accentFont = new Font("Actor",16);
        smallA.setFont(accentFont);
        smallE.setFont(accentFont);
        smallI.setFont(accentFont);
        smallO.setFont(accentFont);
        smallU.setFont(accentFont);
        smallN.setFont(accentFont);
        smallU1.setFont(accentFont);
        bigA.setFont(accentFont);
        bigE.setFont(accentFont);
        bigI.setFont(accentFont);
        bigO.setFont(accentFont);
        bigU.setFont(accentFont);
        bigN.setFont(accentFont);
        bigU1.setFont(accentFont);
        accentBox.getChildren().addAll(bigA,bigE,bigI,bigO,bigU,bigN,bigU1);
        accentBox.setSpacing(10);
        backButton.setOnAction(e-> {
            try {
                testBackButtonClick();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        answerTextField.setMinSize(150,50);
        Font answerFont= new Font("Actor",20);
        answerTextField.setFont(answerFont);
        answerButton.setFont(accentFont);
        backButton.setFont(accentFont);
        layoutTest.getChildren().addAll(wordDisplay, answerTextField,accentBox,answerButton,backButton);
        layoutTest.setSpacing(15);
        Insets inset = new Insets(100,300,100,300);
        //Insets wordDisplayInsets = new Insets(0,0,0,200);
        //wordDisplay.setPadding(wordDisplayInsets);
        wordDisplay.setAlignment(Pos.CENTER);
        layoutTest.setPadding(inset);
        learnP = loader.load();
        learnP.setCenter(layoutTest);
        mainLayout.setCenter(learnP);
        window.close();

    }
    public void checkRandomizedTestEspAnswer(String topic, String word) throws IOException {
        boolean chk = false;
        int index =0;
        LinkedList list = topicMap.get(topic);
        answer = answerTextField.getText();
        answerTextField.setText("");
        System.out.println("word is "+word+"topic is "+topic +"my answer is "+answer);

        for(int i =0;i<list.getSize()+1;i++)
        {
            if(list.find(i).getEsp().equals(word))//finding index of question word
            {
                index=i;
                break;
            }
        }
        System.out.println("index is "+index);
        if(list.find(index).getEng().equals(answer))
        {
            chk = true;
        }
        else {
            chk = false;
        }// now create a result page
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/resultsPage.fxml"));
        learnP = loader.load();
        resultsQuestionWord.setText("The question was "+word);
        resultsCorrectAnswerWord.setText("The correct answer was "+list.find(index).getEng());
        resultsUserAnswerWord.setText("Your answer was "+answer);
        Font font = new Font("Actor",20);
        resultsQuestionWord.setFont(font);
        resultsCorrectAnswerWord.setFont(font);
        resultsUserAnswerWord.setFont(font);
        Font corrFont = new Font("Actor",48);
        correctOrIncorrect.setFont(corrFont);
        Insets inset = new Insets(100,0,100,500);
        results.setPadding(inset);
        results.setSpacing(10);

        if(chk == true)
        {
            ansRight++;
            totalQuestion++;
            correctOrIncorrect.setText("Correct");
            int ratingChange =topicMap.get(topic).find(index).getRating()-1;
            topicMap.get(topic).find(index).setRating(ratingChange);
            mediaPlayerCorrect.seek(Duration.millis(0));
            mediaPlayerCorrect.play();

        }
        else   if(chk == false)
        {
            totalQuestion++;
            correctOrIncorrect.setText("Wrong");
            int ratingChange =topicMap.get(topic).find(index).getRating()+1;
            topicMap.get(topic).find(index).setRating(ratingChange);
            mediaPlayerWrong.seek(Duration.millis(0));
            mediaPlayerWrong.play();

        }

        System.out.println(topicMap.get(topic).find(index).getRating());
        resultsContinueButton.setOnAction(e-> {
            try {
                randomizedTest();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        results.getChildren().clear();
        results.getChildren().addAll(correctOrIncorrect,resultsQuestionWord,resultsCorrectAnswerWord,resultsUserAnswerWord, resultsContinueButton);
        learnP.setCenter(results);
        mainLayout.setCenter(learnP);

        System.out.println("results is "+chk);

    }
    public void checkRandomizedTestEngAnswer(String topic, String word) throws IOException {
        boolean chk = false;
        int index =0;
        LinkedList list = topicMap.get(topic);
        answer = answerTextField.getText();
        answerTextField.setText("");
        System.out.println("word is "+word+"topic is "+topic +"my answer is "+answer);

        for(int i =0;i<list.getSize()+1;i++)
        {
            if(list.find(i).getEng().equals(word))//finding index of question word
            {
                index=i;
                break;
            }
        }
        System.out.println("index is "+index);
        if(list.find(index).getEsp().equals(answer))
        {
            chk = true;
        }
        else {
            chk = false;
        }// now create a result page
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/resultsPage.fxml"));
        learnP = loader.load();
        resultsQuestionWord.setText("The question was "+word);
        resultsCorrectAnswerWord.setText("The correct answer was "+list.find(index).getEsp());
        resultsUserAnswerWord.setText("Your answer was "+answer);
        Font font = new Font("Actor",20);
        resultsQuestionWord.setFont(font);
        resultsCorrectAnswerWord.setFont(font);
        resultsUserAnswerWord.setFont(font);
        Font corrFont = new Font("Actor",48);
        correctOrIncorrect.setFont(corrFont);
        Insets inset = new Insets(100,0,100,500);
        results.setPadding(inset);
        results.setSpacing(10);
        if(chk == true)
        {
            ansRight++;
            totalQuestion++;
            correctOrIncorrect.setText("Correct");
            int ratingChange =topicMap.get(topic).find(index).getRating()-1;
            topicMap.get(topic).find(index).setRating(ratingChange);
            mediaPlayerCorrect.seek(Duration.millis(0));
            mediaPlayerCorrect.play();

        }
        else   if(chk == false)
        {
            totalQuestion++;
            correctOrIncorrect.setText("Wrong");
            int ratingChange =topicMap.get(topic).find(index).getRating()+1;
            topicMap.get(topic).find(index).setRating(ratingChange);
            mediaPlayerWrong.seek(Duration.millis(0));
            mediaPlayerWrong.play();

        }
        resultsContinueButton.setOnAction(e-> {
            try {
                randomizedTest();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println(topicMap.get(topic).find(index).getRating());
        results.getChildren().clear();
        results.getChildren().addAll(correctOrIncorrect,resultsQuestionWord,resultsCorrectAnswerWord,resultsUserAnswerWord, resultsContinueButton);
        learnP.setCenter(results);
        mainLayout.setCenter(learnP);

        System.out.println("results is "+chk);

    }

    public static <T, E> T getKeyByValue(HashMap<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    public void timedTest() throws IOException {
    isTimed=true;
    Random generator = new Random();
    Object[] values = topicMap.values().toArray();
    Object randomValue = values[generator.nextInt(values.length)];
    Font wordDisplayFont = new Font("Actor", 60);
    wordDisplay.setFont(wordDisplayFont);
    System.out.println("Random value is " + randomValue);
    LinkedList list = (LinkedList) randomValue;
    String topic = (String) getKeyByValue(topicMap, list);
    System.out.println("topic is " + topic);
    double espOrEng = Math.random();
    String word = "";
    System.out.println(espOrEng);
    if (espOrEng >= 0 && espOrEng <= 0.5) {
        word = list.find((int) Math.ceil(Math.random() * (list.getSize()))).getEsp();
        wordDisplay.setText(word);
        String finalWord = word;
        answerButton.setOnAction(e -> {
            try {
                System.out.println(finalWord);
                checkTimedEspAnswer(topic, finalWord);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    } else if (espOrEng > 0.5 && espOrEng <= 1.0) {
        answer = answerTextField.getText();
        word = list.find((int) Math.ceil(Math.random() * (list.getSize()))).getEng();
        wordDisplay.setText(word);
        String finalWord1 = word;

        answerButton.setOnAction(e -> {
            try {
                System.out.println(finalWord1);
                checkTimedEngAnswer(topic, finalWord1);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
    secondPassed = 7;
    System.out.println(secondPassed);
    Label timerLabel = new Label();
    timer = new Timer();

    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            if (secondPassed > 0) {
                Platform.runLater(() -> timerLabel.setText("Time remaining = " + secondPassed));
                --secondPassed;
            }
        }
    };
    timer.scheduleAtFixedRate(task, 0, 1000);
    timeline = new Timeline(new KeyFrame(Duration.seconds(7), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            answerButton.fire();
        }
    }));
    timeline.setCycleCount(1);
    timeline.play();
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("test/topicWiseTestPage.fxml"));
    VBox layoutTest = new VBox();
    HBox accentBox = new HBox();
    Button smallA = new Button("á");
    smallA.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("á")));
    Button smallE = new Button("é");
    smallE.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("é")));
    Button smallI = new Button("í");
    smallI.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("í")));
    Button smallO = new Button("ó");
    smallO.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("ó")));
    Button smallU = new Button("ú");
    smallU.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("ú")));
    Button smallN = new Button("ñ");
    smallN.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("ñ")));
    Button smallU1 = new Button("ü");
    smallU1.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("ü")));
    accentBox.getChildren().addAll(smallA, smallE, smallI, smallO, smallU, smallN, smallU1);
    Button bigA = new Button("Á");
    bigA.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("Á")));
    Button bigE = new Button("É");
    bigE.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("É")));
    Button bigI = new Button("Í");
    bigI.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("Í")));
    Button bigO = new Button("Ó");
    bigO.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("Ó")));
    Button bigU = new Button("Ú");
    bigU.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("Ú")));
    Button bigN = new Button("Ñ");
    bigN.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("Ñ")));
    Button bigU1 = new Button("Ü");
    bigU1.setOnAction(e -> answerTextField.setText(answerTextField.getText().concat("Ü")));
    Font accentFont = new Font("Actor", 16);
    smallA.setFont(accentFont);
    smallE.setFont(accentFont);
    smallI.setFont(accentFont);
    smallO.setFont(accentFont);
    smallU.setFont(accentFont);
    smallN.setFont(accentFont);
    smallU1.setFont(accentFont);
    bigA.setFont(accentFont);
    bigE.setFont(accentFont);
    bigI.setFont(accentFont);
    bigO.setFont(accentFont);
    bigU.setFont(accentFont);
    bigN.setFont(accentFont);
    bigU1.setFont(accentFont);
    accentBox.getChildren().addAll(bigA, bigE, bigI, bigO, bigU, bigN, bigU1);
    accentBox.setSpacing(10);
    backButton.setOnAction(e -> {
        try {
            testBackButtonClick();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    });
    answerTextField.setMinSize(150, 50);
    Font answerFont = new Font("Actor", 20);
    answerTextField.setFont(answerFont);
    answerButton.setFont(accentFont);
    backButton.setFont(accentFont);
    layoutTest.getChildren().addAll(timerLabel, wordDisplay, answerTextField, accentBox, answerButton, backButton);
    layoutTest.setSpacing(15);
    Insets inset = new Insets(100, 300, 100, 300);
    //Insets wordDisplayInsets = new Insets(0,0,0,200);
    //wordDisplay.setPadding(wordDisplayInsets);
    wordDisplay.setAlignment(Pos.CENTER);
    layoutTest.setPadding(inset);
    learnP = loader.load();
    learnP.setCenter(layoutTest);
    mainLayout.setCenter(learnP);
    window.close();
    }
    public void checkTimedEspAnswer(String topic, String word) throws IOException {
        timer.cancel();
        timer.purge();
    timeline.stop();
    System.out.println(word);
        boolean chk = false;
        int index =0;
        LinkedList list = topicMap.get(topic);
        answer = answerTextField.getText();
        answerTextField.setText("");
        System.out.println("word is "+word+"topic is "+topic +"my answer is "+answer);

        for(int i =0;i<list.getSize()+1;i++)
        {
            if(list.find(i).getEsp().equals(word))//finding index of question word
            {
                index=i;
                break;
            }
        }
        System.out.println("index is "+index);
        if(list.find(index).getEng().equals(answer))
        {
            chk = true;
        }
        else {
            chk = false;
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/resultsPage.fxml"));
        System.out.println("timed word is "+word);
        learnP = loader.load();
        resultsQuestionWord.setText("The question was "+word);
        resultsCorrectAnswerWord.setText("The correct answer was "+list.find(index).getEng());
        resultsUserAnswerWord.setText("Your answer was "+answer);
        Font font = new Font("Actor",20);
        resultsQuestionWord.setFont(font);
        resultsCorrectAnswerWord.setFont(font);
        resultsUserAnswerWord.setFont(font);
        Font corrFont = new Font("Actor",48);
        correctOrIncorrect.setFont(corrFont);
        Insets inset = new Insets(100,0,100,500);
        results.setPadding(inset);
        results.setSpacing(10);
        if(chk == true)
        {
            ansRight++;
            totalQuestion++;
            correctOrIncorrect.setText("Correct");
            int ratingChange =topicMap.get(topic).find(index).getRating()-1;
            topicMap.get(topic).find(index).setRating(ratingChange);
            mediaPlayerCorrect.seek(Duration.millis(0));
            mediaPlayerCorrect.play();

        }
        else   if(chk == false)
        {
            totalQuestion++;
            correctOrIncorrect.setText("Wrong");
            int ratingChange =topicMap.get(topic).find(index).getRating()+1;
            topicMap.get(topic).find(index).setRating(ratingChange);
            mediaPlayerWrong.seek(Duration.millis(0));
            mediaPlayerWrong.play();
        }
        System.out.println(topicMap.get(topic).find(index).getRating());
        resultsContinueButton.setOnAction(e-> {
            try {
                timedTest();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        results.getChildren().clear();
        results.getChildren().addAll(correctOrIncorrect,resultsQuestionWord,resultsCorrectAnswerWord,resultsUserAnswerWord, resultsContinueButton);
        learnP.setCenter(results);
        mainLayout.setCenter(learnP);

        System.out.println("results is "+chk);

    }
    public void checkTimedEngAnswer(String topic, String word) throws IOException {
        timer.cancel();
        timer.purge();
    timeline.stop();
    System.out.println(word);
        boolean chk = false;
        int index =0;
        LinkedList list = topicMap.get(topic);
        answer = answerTextField.getText();
        answerTextField.setText("");
        System.out.println("word is "+word+"topic is "+topic +"my answer is "+answer);

        for(int i =0;i<list.getSize()+1;i++)
        {
            if(list.find(i).getEng().equals(word))//finding index of question word
            {
                index=i;
                break;
            }
        }
        System.out.println("index is "+index);
        if(list.find(index).getEsp().equals(answer))
        {
            chk = true;
        }
        else {
            chk = false;
        }// now create a result page
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/resultsPage.fxml"));
        learnP = loader.load();
        resultsQuestionWord.setText("The question was "+word);
        resultsCorrectAnswerWord.setText("The correct answer was "+list.find(index).getEsp());
        resultsUserAnswerWord.setText("Your answer was "+answer);
        Font font = new Font("Actor",20);
        resultsQuestionWord.setFont(font);
        resultsCorrectAnswerWord.setFont(font);
        resultsUserAnswerWord.setFont(font);
        Font corrFont = new Font("Actor",48);
        correctOrIncorrect.setFont(corrFont);
        Insets inset = new Insets(100,0,100,500);
        results.setPadding(inset);
        results.setSpacing(10);
        if(chk == true)
        {
            ansRight++;
            totalQuestion++;
            correctOrIncorrect.setText("Correct");
            int ratingChange =topicMap.get(topic).find(index).getRating()-1;
            topicMap.get(topic).find(index).setRating(ratingChange);
            mediaPlayerCorrect.seek(Duration.millis(0));
            mediaPlayerCorrect.play();

        }
        else   if(chk == false)
        {
            totalQuestion++;
            correctOrIncorrect.setText("Wrong");
            int ratingChange =topicMap.get(topic).find(index).getRating()+1;
            topicMap.get(topic).find(index).setRating(ratingChange);
            mediaPlayerWrong.seek(Duration.millis(0));
            mediaPlayerWrong.play();
        }
        resultsContinueButton.setOnAction(e-> {
            try {
                timedTest();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println(topicMap.get(topic).find(index).getRating());
        results.getChildren().clear();
        results.getChildren().addAll(correctOrIncorrect,resultsQuestionWord,resultsCorrectAnswerWord,resultsUserAnswerWord, resultsContinueButton);
        learnP.setCenter(results);
        mainLayout.setCenter(learnP);

        System.out.println("results is "+chk);

    }

    public void showResultsPage(int right, int total) throws IOException {/** it not incrementing ansRight and totalQuestion**/

    main = new Main();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/resultsPage.fxml"));
        learnP = loader.load();
        VBox layout = new VBox();
        Label question = new Label("Total number of questions "+total);
        Label answer = new Label("Number of Correct Answers "+right);
      //  double acc =(right/total);
        //System.out.println(acc);
       // Label accuracy = new Label("Accuracy is "+acc+"%");
        //label accuracy= new Label(acc+"");
        Button button = new Button("Done");
        button.setOnAction(e-> {
            try {
                main.showStartView();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        Font font = new Font("Actor",24);
        question.setFont(font);
        answer.setFont(font);
        button.setFont(font);
        layout.getChildren().addAll(question,answer,button);
        layout.setSpacing(10);
        Insets inset = new Insets(100,0,100,500);
        layout.setPadding(inset);
        learnP.setCenter(layout);
        //learnP.setPadding(insets);
        mainLayout.setCenter(learnP);
    }
    public void showTimedResultsPage(int right, int total) throws IOException {/** it not incrementing ansRight and totalQuestion**/
        timer.cancel();
        timer.purge();
        timeline.stop();
        main = new Main();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("test/resultsPage.fxml"));
        learnP = loader.load();
        VBox layout = new VBox();
        Label question = new Label("Total number of questions "+total);
        Label answer = new Label("Number of Correct Answers "+right);
        //  double acc =(right/total);
        //System.out.println(acc);
        // Label accuracy = new Label("Accuracy is "+acc+"%");
        //label accuracy= new Label(acc+"");
        Button button = new Button("Done");
        button.setOnAction(e-> {
            try {
                main.showStartView();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        Font font = new Font("Actor",24);
        question.setFont(font);
        answer.setFont(font);
        button.setFont(font);
        layout.getChildren().addAll(question,answer,button);
        layout.setSpacing(10);
        Insets inset = new Insets(100,0,100,500);
        layout.setPadding(inset);
        learnP.setCenter(layout);
        //learnP.setPadding(insets);
        mainLayout.setCenter(learnP);
    }

    public  void toNotesPageClick()throws IOException {
        main = new Main();
        main.showNotesScene();
      //  notesTextField.flushNotes();
        notesTextField.setText(openNoteFile());
    }
    public String[] initializeWordsOfTheDay() throws IOException {
        String max []=wordsOfTheDay();
        ObservableList<String> maxEsp = FXCollections.observableArrayList();
        ObservableList<String> maxEng = FXCollections.observableArrayList();
        for(int i =0;i<max.length;i++)
        {
            maxEsp.add(max[i]);
            ++i;
            maxEng.add(max[i]);
        }
        ListView maxListEsp = new ListView();
        maxListEsp.getItems().addAll(maxEsp);
        ListView maxListEng = new ListView();
        maxListEng.getItems().addAll(maxEng);
        maxListEsp.setCellFactory(cell -> {
            return new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item);

                        // decide to add a new styleClass
                        // getStyleClass().add("costume style");
                        // decide the new font size
                        setFont(javafx.scene.text.Font.font(14));
                    }
                }
            };
        });
        maxListEng.setCellFactory(cell -> {
            return new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item);

                        // decide to add a new styleClass
                        // getStyleClass().add("costume style");
                        // decide the new font size
                        setFont(Font.font(14));
                    }
                }
            };
        });
        Platform.runLater(new Runnable() {

            public void run() {
                Node n = maxListEsp.lookup(".scroll-bar");
                if (n instanceof ScrollBar) {
                    final ScrollBar bar = (ScrollBar) n;
                    if (bar.getOrientation().equals(Orientation.VERTICAL)) {
                        Node n2 = maxListEng.lookup(".scroll-bar");
                        final ScrollBar bar1=(ScrollBar)n2;
                        ((ScrollBar) n).valueProperty().bindBidirectional(bar1.valueProperty());

                    }
                }
            }
        });
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainView.fxml"));// JUST LINK THEM TOGETHER AND YOURE DONE
        BorderPane learnP = loader.load();
         HBox layout = new HBox();
         layout.getChildren().addAll(maxListEsp,maxListEng);
         learnP.setLeft(layout);
        mainLayout.setCenter(learnP);
        System.out.println("LOOK HERE "+dailyRoutineString);
        return max;
    }
}