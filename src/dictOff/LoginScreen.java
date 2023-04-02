package dictOff;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class LoginScreen {
    Button returnButton;
    public void displayLoginScreen(Stage primaryStage) throws InstantiationException, IllegalAccessException {
        primaryStage.setTitle("DictOff");
        Label welcomeLabel = new Label("Welcome to Dictoff");
        welcomeLabel.setFont(Font.font("Arial", 36));

        Label teamLabel = new Label("Produced by Team 1");
        teamLabel.setFont(Font.font("Arial", 12));

        Button startButton = new Button("Start");
        startButton.setPrefWidth(120);
        startButton.setPrefHeight(60);
        startButton.setFont(Font.font("Arial",20));
        startButton.setStyle("-fx-background-color: grey;");
        startButton.setOnAction(e -> {});

        VBox vbox = new VBox(10, welcomeLabel, teamLabel, startButton);
        vbox.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane(vbox);

        BorderPane borderPane = new BorderPane(stackPane);
        BorderPane.setAlignment(stackPane, Pos.CENTER);


        HBox box = new HBox(questionMarkClass.class.newInstance().questionMark());

        borderPane.setBottom(box);
        borderPane.setStyle("-fx-background-color:gainsboro");

        Scene scene = new Scene(borderPane, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
