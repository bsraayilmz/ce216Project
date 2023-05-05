package com.team1.ce216project;




import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ActionScreen {
    public static Stage stage;
    public static Scene displayActionScreen(Stage primaryStage) throws InstantiationException, IllegalAccessException {
        stage = primaryStage;
        Label label = new Label("What action would you like to perform?");
        label.setStyle("-fx-font-weight: bold;");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));

        Button btnETranslation = new Button("EXTENDED TRANSLATION");
        btnETranslation.setPrefWidth(150);
        btnETranslation.setPrefHeight(70);
        btnETranslation.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
        btnETranslation.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
        btnETranslation.setOnAction(e -> {
            try {
                TranslationScreen.displayTranslationScreen(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button btnSynonyms = new Button("FIND SYNONYMS");
        btnSynonyms.setPrefHeight(70);
        btnSynonyms.setPrefWidth(150);
        btnSynonyms.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
        btnSynonyms.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
        btnSynonyms.setOnAction(e -> {
            try {
                SynonymScreen.displaySynonymScreen(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button btnAddTranslation = new Button("ADD A TRANSLATION");
        btnAddTranslation.setPrefWidth(150);
        btnAddTranslation.setPrefHeight(70);
        btnAddTranslation.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
        btnAddTranslation.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
        btnAddTranslation.setOnAction(e -> {
            try {
                AddingScreen.displayAddingScreen(primaryStage);
            } catch (InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });
        Button btnTranslation = new Button("TRANSLATION");
        btnTranslation.setPrefHeight(70);
        btnTranslation.setPrefWidth(150);
        btnTranslation.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
        btnTranslation.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
        btnTranslation.setOnAction(e -> {
            try {
                TranslationFinder.displayTranslationFScreen(primaryStage);
            } catch (InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        HBox box = new HBox(questionMarkClass.class.newInstance().questionMark());
        box.setAlignment(Pos.BOTTOM_RIGHT);

        VBox vbox = new VBox(45, label, btnETranslation, btnSynonyms, btnAddTranslation,btnTranslation, box);

        vbox.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane(vbox);
        stackPane.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, null, null)));
        stackPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(stackPane, 700, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("DictOff");
        primaryStage.show();
        return scene;

    }

}