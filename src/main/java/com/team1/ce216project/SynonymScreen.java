package com.team1.ce216project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.team1.ce216project.scanningFile.IMAGES_PATH;

public class SynonymScreen {
    static String engPath = scanningFile.DATA_PATH + "engSyn.txt";
    static String gerPath = scanningFile.DATA_PATH + "gerSyn.txt";
    static String ellPath = scanningFile.DATA_PATH + "greekSyn.txt";

    private static Button synonymButton;
    private static ChoiceBox <String> choiceBox;
    public static Scene displaySynonymScreen(Stage stage) throws Exception {
        stage.setTitle("DictOff");

        //Instruction text
        Text text = new Text(" Type a word to find its synonyms:"); //in order to centre the text
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));


        //Translate bar
        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter the word here");

        //Translate button
        synonymButton = new Button("Find Synonyms");
        synonymButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        synonymButton.setTextFill(Color.BLACK);
        synonymButton.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, new Insets(0))));
        synonymButton.setOnAction(e -> {
            if(choiceBox.getValue().equals("deu")){
                System.out.println(oneLineSynonym(wordInput.getText(), gerPath));
            }
            else if(choiceBox.getValue().equals("ell")){
                System.out.println(oneLineSynonym(wordInput.getText(), ellPath));
            }
        });

        choiceBox = new ChoiceBox<>();
        // WORK IN PROGRESS DO NOT TOUCH
        choiceBox.getItems().addAll("tur" , "eng" , "deu" , "fra" , "ita" , "swe" , "ell");
        choiceBox.setValue("Select Language");

        //Adding the flags image
        Image image = new Image(new FileInputStream(IMAGES_PATH+"img.png"));
        ImageView img1 = new ImageView(image);

        HBox imageBox = new HBox(img1);
        imageBox.setSpacing(20);
        img1.setFitHeight(70);
        img1.setFitWidth(710);


        //GridPane to be added in BorderPane(main layout)
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15,15, 15,15));
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        GridPane.setConstraints(wordInput,11,5);

        GridPane.setConstraints(synonymButton,11,6);
        GridPane.setMargin(synonymButton,new Insets(0, 0,0,26)); //In order to centre the button
        GridPane.setConstraints(choiceBox, 11, 7);
        GridPane.setMargin(choiceBox,new Insets(0, 0 ,0, 70));
        GridPane.setConstraints(text, 11, 4);

        synonymButton.setPrefSize(200,50);
        wordInput.setMaxSize(300,50);

        wordInput.setFont(Font.font("Times New Roman",20));

        //Creating the Help button

        //HBox for Help and Back buttons
        HBox backButton = new HBox(backClass.class.newInstance().quesBack());
        backButton.setAlignment(Pos.BOTTOM_LEFT);


        HBox quesButton = new HBox(questionMarkClass.class.newInstance().questionMark());
        quesButton.setAlignment(Pos.BOTTOM_RIGHT);


        HBox total = new HBox(backButton,quesButton);
        total.setSpacing(572);

        //Adding to GridPane
        gridPane.getChildren().addAll(synonymButton,text,wordInput,choiceBox);

        //Main Layout
        BorderPane layout = new BorderPane();
        layout.setCenter(gridPane);
        layout.setTop(imageBox);
        layout.setBottom(total);
        layout.setStyle("-fx-background-color: gainsboro");

        //Setting scene into the Stage
        Scene scene = new Scene(layout, 700, 500);
        stage.setScene(scene);
        stage.show();
        return scene;
    }
    public static String oneLineSynonym(String word, String fileName){
        String str = "";
        word = word.trim();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))){
            String line;
            while((line = br.readLine()) != null){
                if(line.startsWith(word)){
                    return line;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



}
