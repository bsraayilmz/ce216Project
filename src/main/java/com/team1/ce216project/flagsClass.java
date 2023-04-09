package com.team1.ce216project;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.team1.ce216project.scanningFile.IMAGES_PATH;

public class flagsClass extends Exception{
    public HBox flags(HBox hBox){
        /*We designed our dictionary as the dictOff.flags of the languages that user can translate at the top.
        This image includes the set of the dictOff.flags.  */
        Image flags = null;//img.png is in the project
        try {
            flags = new Image(new FileInputStream(IMAGES_PATH+"img.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ImageView flagsView = new ImageView(flags);

        /* to use the hBoxForFlags layout to separate the images from the grid pane layout and have
        them in horizontal order. */
        hBox= new HBox(flagsView);

        //to set the visual properties of the hBoxForFlags layout and image
        hBox.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(0)))
        );
        hBox.setSpacing(20);
        flagsView.setFitHeight(70);
        flagsView.setFitWidth(710);

        //to be able to use at the bottom of the screen by helping Border Pane layout, we return the hBox
        return hBox;
    }
}
