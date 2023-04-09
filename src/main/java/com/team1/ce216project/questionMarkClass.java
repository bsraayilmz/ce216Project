package com.team1.ce216project;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
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


        //to set the size of the question mark image
        questionMarkView.setFitHeight(50);
        questionMarkView.setFitWidth(45);

        HBox box = new HBox(helpButton, questionMarkView);
        box.setAlignment(Pos.BOTTOM_RIGHT);




        return box;
    }

}
