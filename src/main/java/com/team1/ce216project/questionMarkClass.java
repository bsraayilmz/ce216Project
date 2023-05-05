package com.team1.ce216project;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.team1.ce216project.scanningFile.IMAGES_PATH;


public class questionMarkClass {
    Button helpButton;
    public HBox questionMark(){
        Stage stage = new Stage();
        //to help when the users cannot understand what they do.
        Image questionMark = null;
        try {
            questionMark = new Image(new FileInputStream(IMAGES_PATH+"questionMark.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ImageView questionMarkView = new ImageView(questionMark);

        helpButton = new Button();
        helpButton.setGraphic(questionMarkView); //to add button property to the question mark (help)
        helpButton.setBorder(new Border(new BorderStroke(Color.GAINSBORO,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT))
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
                btn1.setPrefSize(100,50);
                Label label2 = new Label("help needed for synonyms");
                Button btn2 = new Button("click");
                btn2.setPrefSize(100,50);
                Label label3 = new Label("help needed for adding translation");
                Button btn3 = new Button("click");
                btn3.setPrefSize(100,50);

                vbox1.getChildren().addAll(label1, btn1, label2, btn2, label3, btn3,box2);
                vbox1.setAlignment(Pos.CENTER);
                vbox1.setStyle("-fx-background-color:gainsboro");

                Image returnImage = null;
                try {
                    returnImage = new Image(new FileInputStream(IMAGES_PATH+"return.png"));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                ImageView returnView = new ImageView(returnImage);

                Button returnButton = new Button();
                returnButton.setGraphic(returnView);//to add button property to the sign of return (to go back prev page)
                returnButton.setBorder(new Border(new BorderStroke(Color.GAINSBORO,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
                returnButton.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(0))));
                returnButton.setAlignment(Pos.BOTTOM_LEFT);
                returnButton.setOnAction(e -> {
                    newStage.close();
                });


                returnView.setFitHeight(50);
                returnView.setFitWidth(47);

                box2.getChildren().addAll(returnButton,returnView);
                box2.setAlignment(Pos.BOTTOM_LEFT);

                btn1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
                btn1.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
                btn2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
                btn2.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
                btn3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
                btn3.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");



                label1.setFont(Font.font("Times New Roman",15));
                label1.setStyle("-fx-background-color: yellow;");
                label2.setFont(Font.font("Times New Roman",15));
                label2.setStyle("-fx-background-color: yellow;");
                label3.setFont(Font.font("Times New Roman",15));
                label3.setStyle("-fx-background-color: yellow;");

                vbox1.setAlignment(Pos.CENTER);

                btn1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // Create a new stage or screen for this button's action
                        Stage newStage1 = new Stage();
                        newStage1.setTitle("Help Center");
                        Label label = new Label("Information for Translation");
                        StackPane pane = new StackPane(label);
                        StackPane.setMargin(label, new Insets(25,0,0,0));
                        pane.setStyle("-fx-background-color:gainsboro");
                        label.setFont(Font.font("Times New Roman",20));
                        label.setStyle("-fx-background-color: yellow;");
                        pane.setAlignment(Pos.CENTER);
                        Text text = new Text("To Find a translation\n" +
                                "1) Click the start button\n" +
                                "2) Click Search translation button\n" +
                                "3) Enter the words you need for translation and select the source language\n" +
                                "4) Click the Find Translations button again.\n" +
                                "5) dictoff translates your words into all languages \u200B\u200Bdictoff has. You can choose which you related ");

                        text.setFont(Font.font("Times New Roman",15));
                        VBox.setMargin(text, new Insets(170,0,0,35));
                        VBox vBox = new VBox(pane, text);
                        vBox.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(0))));                        text.setStyle("-fx-background-color: yellow;");

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
                        newStage2.setTitle("Help Center");
                        Label label = new Label("Information for Synonyms");
                        StackPane pane = new StackPane(label);
                        StackPane.setMargin(label, new Insets(25,0,0,0));
                        pane.setStyle("-fx-background-color:gainsboro");
                        label.setFont(Font.font("Times New Roman",20));
                        label.setStyle("-fx-background-color: yellow;");
                        pane.setAlignment(Pos.TOP_CENTER);
                        Text text = new Text("To Find synonyms\n" +
                                "1) Click the start button\n" +
                                "2) Click the \"Find Synonyms\" button\n" +
                                "3) Enter the word you want as a synonym\n" +
                                "4) Click the Find Synonyms button again.\n" +
                                "5) dictoff will give you the synonyms you need");

                        text.setFont(Font.font("Times New Roman",15));
                        text.setStyle("-fx-background-color: yellow;");

                        StackPane stack = new StackPane(pane,text);


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
                        newStage3.setTitle("Help Center");
                        Label label = new Label("Information for Adding Translations");
                        StackPane pane = new StackPane(label);
                        StackPane.setMargin(label, new Insets(25,0,0,0));
                        pane.setStyle("-fx-background-color:gainsboro");
                        label.setFont(Font.font("Times New Roman",20));
                        label.setStyle("-fx-background-color: yellow;");
                        pane.setAlignment(Pos.TOP_CENTER);
                        Text text = new Text("To add translations \n" +
                                "1)click start button\n" +
                                "2)click add translations button\n" +
                                "3)enter the word that you want to add and elect source language \n" +
                                "4)in the language you want to translate\n" +
                                " enter the words meaning and choose which language it is\n" +
                                "5) click add to list button \n" +
                                "6)dictoff will add to list your words");
                        text.setFont(Font.font("Times New Roman",15));
                        text.setStyle("-fx-background-color: yellow;");

                        StackPane stack = new StackPane(pane,text);



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