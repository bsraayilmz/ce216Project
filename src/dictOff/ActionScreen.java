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
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ActionScreen  {

    public void displayActionScreen(Stage primaryStage) {
        Label label = new Label("What action would you like to perform?");
        label.setStyle("-fx-font-weight: bold;");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));

        Button btnTranslation = new Button("TRANSLATION");
        btnTranslation.setPrefWidth(140);
        btnTranslation.setPrefHeight(70);
        btnTranslation.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
        btnTranslation.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));

        Button btnSynonyms = new Button("FIND SYNONYMS");
        btnSynonyms.setPrefHeight(70);
        btnSynonyms.setPrefWidth(140);
        btnSynonyms.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
        btnSynonyms.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));

        Button btnAddTranslation = new Button("ADD A TRANSLATION");
        btnAddTranslation.setPrefWidth(140);
        btnAddTranslation.setPrefHeight(70);
        btnAddTranslation.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
        btnAddTranslation.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: gray; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");

        Button button = new Button();
        Image image = new Image("questionMark.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        button.setGraphic(imageView);
        HBox hbox = new HBox();
        hbox.getChildren().add(button);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        VBox vbox = new VBox(20, label, btnTranslation, btnSynonyms, btnAddTranslation,hbox);
        vbox.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane(vbox);
        stackPane.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, null, null)));
        stackPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(stackPane,500, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DictOff");
        primaryStage.show();
    }


}