package com.team1.ce216project;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.skin.TextAreaSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.team1.ce216project.scanningFile.IMAGES_PATH;


public class questionMarkClass {
    Button helpButton;

    public HBox questionMark() {
        Stage stage = new Stage();
        //to help when the users cannot understand what they do.
        Image questionMark = null;
        try {
            questionMark = new Image(new FileInputStream(IMAGES_PATH + "questionMark.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ImageView questionMarkView = new ImageView(questionMark);

        helpButton = new Button();
        helpButton.setGraphic(questionMarkView); //to add button property to the question mark (help)
        helpButton.setBorder(new Border(new BorderStroke(Color.GAINSBORO, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))
        );
        helpButton.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(0)))
        );


        helpButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // Create a new stage
                Stage newStage = new Stage();


                // Create a new layout for the stage
                VBox vbox1 = new VBox(20);
                HBox box2 = new HBox();


                Label label1 = new Label("help needed for translation");
                Button btn1 = new Button("click");
                btn1.setPrefSize(100, 50);
                Label label2 = new Label("help needed for synonyms");
                Button btn2 = new Button("click");
                btn2.setPrefSize(100, 50);
                Label label3 = new Label("help needed for adding translation");
                Button btn3 = new Button("click");
                btn3.setPrefSize(100, 50);

                vbox1.getChildren().addAll(label1, btn1, label2, btn2, label3, btn3, box2);
                vbox1.setAlignment(Pos.CENTER);
                vbox1.setStyle("-fx-background-color:gainsboro");

                Image returnImage = null;
                try {
                    returnImage = new Image(new FileInputStream(IMAGES_PATH + "return.png"));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                ImageView returnView = new ImageView(returnImage);

                Button returnButton = new Button();
                returnButton.setGraphic(returnView);//to add button property to the sign of return (to go back prev page)
                returnButton.setBorder(new Border(new BorderStroke(Color.GAINSBORO, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                returnButton.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(0))));
                returnButton.setAlignment(Pos.BOTTOM_LEFT);
                returnButton.setOnAction(e -> {
                    newStage.close();
                });


                returnView.setFitHeight(50);
                returnView.setFitWidth(47);

                box2.getChildren().addAll(returnButton, returnView);
                box2.setMargin(returnButton,new Insets(0,0,-90,0));
                box2.setAlignment(Pos.BOTTOM_LEFT);

                btn1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
                btn1.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
                btn2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
                btn2.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
                btn3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
                btn3.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");


                label1.setFont(Font.font("Times New Roman", 15));
                label1.setStyle("-fx-background-color: yellow;");
                label2.setFont(Font.font("Times New Roman", 15));
                label2.setStyle("-fx-background-color: yellow;");
                label3.setFont(Font.font("Times New Roman", 15));
                label3.setStyle("-fx-background-color: yellow;");

                vbox1.setAlignment(Pos.CENTER);

                btn1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // Create a new stage or screen for this button's action
                        Stage newStage1 = new Stage();
                        newStage1.initModality(Modality.APPLICATION_MODAL);
                        newStage1.setTitle("Help Center");
                        Label label = new Label("Information for Translation");
                        StackPane pane = new StackPane(label);
                        StackPane.setMargin(label, new Insets(25, 0, 0, 0));
                        pane.setStyle("-fx-background-color:gainsboro");
                        label.setFont(Font.font("Times New Roman", 20));
                        label.setStyle("-fx-background-color: yellow;");
                        pane.setAlignment(Pos.CENTER);
                        TextArea text = new TextArea("""
                                Steps for to find more than one translation of a word in all languages:
                                1) Click on the 'Start' button
                                2) Click on the 'Extended Translation' button\s
                                3) Enter the word into the text bar you want to search for translation and select the source language
                                4) Click on the 'Find Translations' button.
                                5) The app will translate your word through all languages \u200B\u200Bit has.
                                6) Click on the buttons to see translations: ita for Italian, gre for Greek, eng for English,\s
                                tur for Turkish, deu for German, fra for France, and swe for Swedish.
                                7) Whenever a button is clicked, all the translations will be appeared on the screen.\s
                                -----------------------------------------------------------------------------------------------------------------------------
                                Steps for to find one translation of a word in all languages at the same time:\s
                                1) Click on the 'Start' button
                                2) Click on the 'Translation' button\s
                                3) Enter the word into the text bar you want to search for translation and select the source language
                                4) Click on the 'Search' button.
                                5) The app will translate your word through all languages \u200B\u200Bit has and they will be listed on the screen.
                                """
                                  );
                        text.setWrapText(true); //to make the text area "swappable"
                        text.setEditable(false); //to prevent any addition/deletion from the helping document

                        text.setFont(Font.font("Times New Roman", 15));
                        VBox.setMargin(text, new Insets(170, 0, 0, 35));
                        VBox vBox = new VBox(pane, text);
                        vBox.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(0))));
                        text.setStyle("-fx-background-color: yellow;");

                        StackPane stack = new StackPane(vBox);

                        Scene scene = new Scene(stack, 700, 550);
                        newStage1.setScene(scene);
                        newStage1.show();
                    }
                });

                btn2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // Create a new stage or screen for this button's action
                        Stage newStage2 = new Stage();
                        newStage2.initModality(Modality.APPLICATION_MODAL);
                        newStage2.setTitle("Help Center");
                        Label label = new Label("Information for Synonyms");
                        StackPane pane = new StackPane(label);
                        StackPane.setMargin(label, new Insets(25, 0, 0, 0));
                        pane.setStyle("-fx-background-color:gainsboro");
                        label.setFont(Font.font("Times New Roman", 20));
                        label.setStyle("-fx-background-color: yellow;");
                        pane.setAlignment(Pos.TOP_CENTER);
                        TextArea text = new TextArea("""
                                Steps to find synonyms:
                                1) Click on the 'Start' button.
                                2) Click on the 'Find Synonyms' button.
                                3) Enter the word you want to find its synonyms.
                                4) Choose the source language from the choice box.
                                5) Click on the 'Find Synonyms' button.
                                6) DictOff will give you the synonyms you need.""");

                        text.setFont(Font.font("Times New Roman", 15));
                        text.setStyle("-fx-background-color: yellow;");

                        text.setWrapText(true); //to make the text area "swappable"
                        text.setEditable(false); //to prevent any addition/deletion from the helping document

                        StackPane stack = new StackPane(pane, text);


                        Scene scene = new Scene(stack, 700, 500);
                        newStage2.setScene(scene);
                        newStage2.show();
                    }
                });

                btn3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // Create a new stage or screen for this button's action
                        Stage newStage3 = new Stage();
                        newStage3.initModality(Modality.APPLICATION_MODAL);
                        newStage3.setTitle("Help Center");
                        Label label = new Label("Information for Adding Translations");
                        StackPane pane = new StackPane(label);
                        StackPane.setMargin(label, new Insets(25, 0, 0, 0));
                        pane.setStyle("-fx-background-color:gainsboro");
                        label.setFont(Font.font("Times New Roman", 20));
                        label.setStyle("-fx-background-color: yellow;");
                        pane.setAlignment(Pos.TOP_CENTER);
                        TextArea text = new TextArea("""
                                Steps to add translations:
                                1)Click on the 'Start' button.
                                2)Click on the 'Add Translations' button.
                                3)Enter the word into the first bar that you want to add and select the language of it.\s
                                4)Enter the translation into the second bar that you want to add and select the language of it.\s
                                5)Click on 'Add to the List' button\s
                                6)Dictoff will add to the relevant list your words""");
                        text.setFont(Font.font("Times New Roman", 15));
                        text.setStyle("-fx-background-color: yellow;");

                        text.setWrapText(true); //to make the text area "swappable"
                        text.setEditable(false); //to prevent any addition/deletion from the helping document

                        StackPane stack = new StackPane(pane, text);


                        Scene scene = new Scene(stack, 700, 500);
                        newStage3.setScene(scene);
                        newStage3.show();
                    }
                });


                newStage.setTitle("Help Center");
                Scene scene = new Scene(vbox1, 700, 500);
                newStage.setScene(scene);
                newStage.show();
            }
        });

        questionMarkView.setFitHeight(50);
        questionMarkView.setFitWidth(45);

        HBox box = new HBox(helpButton, questionMarkView);
        box.setAlignment(Pos.BOTTOM_RIGHT);

        return box;
    }
}