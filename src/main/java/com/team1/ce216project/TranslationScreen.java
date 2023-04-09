package com.team1.ce216project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.team1.ce216project.VerifyScreen.displayVerifyScreen;
public class TranslationScreen {

    static Stage window;
    static Button translateButton;
    static ChoiceBox<String> choosingLanguage1;
    public static void displayTranslationScreen(Stage stage) throws Exception {
        window = stage;
        window.setTitle("DictOff");

        //Instruction text
        Text text = new Text(" Type a word to find its translations"); //in order to centre the text
        Text text2 = new Text(" And then select the source language:"); //in order to centre the text

        text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        text2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

        //Translate bar
        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter the word here");

        //Translate button
        translateButton = new Button("Find Translations");
        translateButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        translateButton.setTextFill(Color.BLACK);
        translateButton.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, new Insets(0))));
        translateButton.setOnAction(e -> {
            try {
                displayVerifyScreen("You typed" ,wordInput.getText());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        choosingLanguage1 = new ChoiceBox<>();
        // WORK IN PROGRESS DO NOT TOUCH
        choosingLanguage1.getItems().addAll("tur" , "eng" , "deu" , "fra" , "ita" , "swe" , "ell");
        choosingLanguage1.setValue("Select Language");


        HBox imageBox = new HBox();

        //GridPane to be added in BorderPane(main layout)
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15,15, 15,15));
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        GridPane.setConstraints(wordInput,11,5);

        GridPane.setConstraints(translateButton,11,6);
        GridPane.setConstraints(choosingLanguage1, 11, 7);
        GridPane.setMargin(choosingLanguage1, new Insets(0,0,0,75));
        GridPane.setMargin(translateButton,new Insets(0, 0,0,65)); //In order to centre the button
        choosingLanguage1.setPrefSize(130,50);
        GridPane.setConstraints(text, 11, 3);
        GridPane.setConstraints(text2, 11,4);

        translateButton.setPrefSize(150,50);
        wordInput.setMaxSize(300,50);

        wordInput.setFont(Font.font("Times New Roman",20));



        //HBox for Help and Back buttons
        HBox backButton = new HBox(backClass.class.newInstance().quesBack());
        backButton.setAlignment(Pos.BOTTOM_LEFT);


        HBox quesButton = new HBox(questionMarkClass.class.newInstance().questionMark());
        quesButton.setAlignment(Pos.BOTTOM_RIGHT);


        HBox total = new HBox(backButton,quesButton);
        total.setSpacing(572);
        //Adding to GridPane
        gridPane.getChildren().addAll(translateButton,text,text2,wordInput, choosingLanguage1);

        //Main Layout
        BorderPane layout = new BorderPane();
        layout.setCenter(gridPane);

        layout.setTop(flagsClass.class.newInstance().flags(imageBox));

        layout.setBottom(total);

        layout.setStyle("-fx-background-color: gainsboro");

        //Setting scene into the Stage
        Scene scene = new Scene(layout, 700, 500);
        window.setScene(scene);
        window.show();
    }
}
