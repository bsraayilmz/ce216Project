package com.team1.ce216project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import java.util.ArrayList;

import static com.team1.ce216project.scanningFile.IMAGES_PATH;

public class SynonymScreen {
    static Stage window;
    private static String gerPath = scanningFile.DATA_PATH + "gerSyn.txt";
    private static String ellPath = scanningFile.DATA_PATH + "greekSyn.txt";
    private static String pathTurkishSynonym = scanningFile.DATA_PATH+"trSyn.txt";
    private static Button synonymButton;
    private static ChoiceBox <String> choiceBox;
    public static Scene displaySynonymScreen(Stage stage) throws Exception {
        window = stage;
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
           /* SynonymScreen.window.close();*/
            if(choiceBox.getValue().equals("deu")){
                Synonyms_AlertScreen.displaySynonymsScreen("German",oneLineSynonym(wordInput.getText(), gerPath) );
            }
            else if(choiceBox.getValue().equals("ell")){
                Synonyms_AlertScreen.displaySynonymsScreen("Modern Greek",oneLineSynonym(wordInput.getText(), ellPath));
            }
            else if(choiceBox.getValue().equals("tur")){
                Synonyms_AlertScreen.displaySynonymsScreen("Turkish", String.valueOf(TurkishSynonym(wordInput.getText())));
            }
            else{

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Warning");
                    alert.setHeaderText("Warning");
                    alert.setContentText("Please type word or select a language from the choice box.");
                    alert.showAndWait();
            }
        });

        choiceBox = new ChoiceBox<>();
        // WORK IN PROGRESS DO NOT TOUCH
        choiceBox.getItems().addAll("tur" ,"deu" ,"ell");
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
        backClass backButton = new backClass();
        HBox backBox = new HBox(backButton.quesBack());
        backBox.setAlignment(Pos.BOTTOM_LEFT);
        backButton.returnButton.setOnAction(e -> {
            stage.close();
            try {
                ActionScreen.displayActionScreen(stage);
            } catch (InstantiationException | IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        });


        HBox quesButton = new HBox(questionMarkClass.class.newInstance().questionMark());
        quesButton.setAlignment(Pos.BOTTOM_RIGHT);


        HBox total = new HBox(backBox,quesButton);
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

    public static ArrayList<String> TurkishSynonym(String word) {
        ArrayList<String> sameWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathTurkishSynonym, StandardCharsets.UTF_8))) {
            String str = "";
            String line;

            while ((line = br.readLine()) != null) {
                if(line.startsWith(word)) {
                    String[] words = line.trim().split("\\s+");
                    if(words[0].equals(word)) {
                        for(int i=1; i<words.length; i++){
                            sameWords.add(words[i]);
                        }

                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sameWords;
    }

}




