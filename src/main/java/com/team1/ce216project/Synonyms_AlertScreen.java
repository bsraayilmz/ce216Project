package com.team1.ce216project;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Synonyms_AlertScreen {

    public static void displaySynonymsScreen(String language, String synonyms){
        Stage stage = new Stage();
        stage.setTitle("DictOff");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(350);

        Text languageT = new Text("Language: " + language);
        languageT.setFont(Font.font("Times New Roman", FontPosture.REGULAR,25));
        Text synonymsT = new Text("Synonyms:\n" + synonyms);
        synonymsT.setFont(Font.font("Times New Roman", FontPosture.REGULAR,20));



        Button button = new Button("Okay");
        button.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: black; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
        button.setFont(Font.font("Times New Roman", FontPosture.REGULAR,25));
        button.setTextFill(Color.GRAY);
        button.setOnAction(e -> {
            try {
                SynonymScreen.window.close();
                SynonymScreen.displaySynonymScreen(stage);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox vBox = new VBox(languageT,synonymsT,button);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(70);
        vBox.setStyle("-fx-background-color: #DCDCDC");

        Scene scene = new Scene(vBox,650,450);
        stage.setScene(scene);
        stage.showAndWait();




    }
}
