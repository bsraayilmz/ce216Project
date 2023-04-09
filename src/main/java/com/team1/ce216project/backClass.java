package com.team1.ce216project;


import com.team1.ce216project.ActionScreen;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.team1.ce216project.scanningFile.IMAGES_PATH;

public class backClass {
    public Button returnButton;

    public HBox quesBack() {
        //to go back prev page
        Image returnImage = null;
        try {
            returnImage = new Image(new FileInputStream(IMAGES_PATH+"return.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ImageView returnView = new ImageView(returnImage);

        returnButton = new Button();
        returnButton.setGraphic(returnView);//to add button property to the sign of return (to go back prev page)
        returnButton.setBorder(new Border(new BorderStroke(Color.GAINSBORO,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        returnButton.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(0))));
        returnButton.setOnAction(e -> {
            try {
                ActionScreen.displayActionScreen(ActionScreen.stage);

            } catch (InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });

        //to set the size of the question mark image
        returnView.setFitHeight(50);
        returnView.setFitWidth(47);

        //to take the images, and their button structures into the horizontal modal
        HBox box = new HBox(returnButton, returnView);
        box.setAlignment(Pos.BOTTOM_LEFT);


        //to be able to use at the bottom of the screen by helping Border Pane layout, we return the hBox
        return box;
    }
}
