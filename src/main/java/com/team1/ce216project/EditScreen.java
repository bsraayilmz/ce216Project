package com.team1.ce216project;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class EditScreen {
    public static String EnteringWord;
    public static String lang1;
    public static String lang2;
    public static String EnteringTranslation;
    private static ChoiceBox<String> choosingLanguage1;
    private static ChoiceBox<String> choosingLanguage2;
    static Stage window;
    public static Scene displayEditScreen(Stage stage) throws InstantiationException, IllegalAccessException {
        window = stage;
        // To be able to use grid pane and hBoxForFlags layouts together
        BorderPane borderPane = new BorderPane();

        GridPane layoutAddTrans = new GridPane();
        layoutAddTrans.setPadding(new Insets(10, 5, 10, 5));
        layoutAddTrans.setVgap(15);
        layoutAddTrans.setHgap(25);

        //informative texts and place for writing the word and its meaning
        Text enterTheWord = new Text("Enter the word: ");
        enterTheWord.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

        Text enterTheMeaning = new Text("Enter the meaning: ");
        enterTheMeaning.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

        TextField enterWordSpace = new TextField();


        enterWordSpace.setPrefSize(250, 35);

        TextField enterMeaningSpace = new TextField();


        enterMeaningSpace.setPrefSize(250, 35);

        //to locate enterTheWord,enterTheMeaning, enterWordSpace and enterMeaningSpace in the grid pane
        GridPane.setConstraints(enterTheMeaning, 2, 7);
        GridPane.setConstraints(enterTheWord, 2, 4);
        GridPane.setConstraints(enterWordSpace, 4, 4);
        GridPane.setConstraints(enterMeaningSpace, 4, 7);

        //to select the languages that user wants to edit a new word or translation.
        choosingLanguage1 = new ChoiceBox<>();
        choosingLanguage1.getItems().addAll("tur", "eng", "deu", "fra", "ita", "swe", "ell");
        choosingLanguage1.setValue("Select Language");


        choosingLanguage2 = new ChoiceBox<>();
        choosingLanguage2.getItems().addAll("tur", "eng", "deu", "fra", "ita", "swe", "ell");
        choosingLanguage2.setValue("Select Language");

        //to locate choosingLanguage1 and choosingLanguage2 in the grid pane
        GridPane.setConstraints(choosingLanguage1, 5, 4);
        GridPane.setConstraints(choosingLanguage2, 5, 7);

        //to perform editing
        Button editWord = new Button("EDIT");

        GridPane.setConstraints(editWord, 4, 12);
        editWord.setPrefWidth(150);
        editWord.setPrefHeight(70);
        editWord.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        editWord.setTextFill(Color.BLACK);
        editWord.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, new Insets(0))));
        editWord.setOnAction(e-> {
                    if (enterWordSpace.getText().equals("") || choosingLanguage1.getValue().equals(" ") || choosingLanguage2.getValue().equals(" ") || enterMeaningSpace.getText().equals("")) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setHeaderText("Warning");
                        alert.setContentText("Please enter a word and its meaning.");
                        alert.showAndWait();
                    } else {
                        try {
                            scanningFile.editTranslation(choosingLanguage1(), choosingLanguage2(), enterWordSpace.getText(), enterMeaningSpace.getText());

                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        enterWordSpace.setText("");
                        enterMeaningSpace.setText("");
                        choosingLanguage1.setValue("Select Language");
                        choosingLanguage2.setValue("Select Language");
                    }
                });


        //to use in the flags method from the dictOff.flagsClass- horizontally
        HBox hBoxForFlags = new HBox();
        //to use in the quesBack method from the dictOff.quesBackClass - horizontally
        HBox backButton = new HBox(backClass.class.newInstance().quesBack());
        backButton.setAlignment(Pos.BOTTOM_LEFT);

        HBox quesButton = new HBox(questionMarkClass.class.newInstance().questionMark());
        quesButton.setAlignment(Pos.BOTTOM_RIGHT);

        HBox total = new HBox(backButton, quesButton);
        total.setSpacing(572);
        //to make it visible on the screen
        layoutAddTrans.getChildren().addAll(enterTheMeaning, enterTheWord, enterWordSpace,
                enterMeaningSpace, choosingLanguage1, editWord, choosingLanguage2);

        //text fields, texts, checkboxes and addToTheList must be at the center of the screen
        borderPane.setCenter(layoutAddTrans);
        /*hBoxForFlags must be at the top of the screen - from the class flags with dictOff.flagsClass method, because we use flags
        images more than one time.*/
        borderPane.setTop(flagsClass.class.newInstance().flags(hBoxForFlags));
        /*hBoxForQuesBackButtons must be at the bottom of the screen - from the class dictOff.quesBackClass with quesBack method, because we
        use question mark (help button) and back mark(to go back button) images more than one time.*/
        borderPane.setBottom(total);

        borderPane.setStyle("-fx-background-color:gainsboro");
        Scene scene = new Scene(borderPane, 700, 500);
        stage.setTitle("DictOff");
        stage.setScene(scene);
        stage.show();
        return scene;
    }

    public static String choosingLanguage1() {
        lang1 = choosingLanguage1.getValue();
        return lang1;
    }

    public static String choosingLanguage2() {
        lang2 = choosingLanguage2.getValue();
        return lang2;
    }
}

