package dictOff;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddingScreen {
    Scene scene;
    public void displayAddingScreen(Stage stage) throws InstantiationException, IllegalAccessException {
        // To be able to use grid pane and hBoxForFlags layouts together
        BorderPane borderPane = new BorderPane();

        GridPane layoutAddTrans = new GridPane();
        layoutAddTrans.setPadding(new Insets(10,5,10,5));
        layoutAddTrans.setVgap(15);
        layoutAddTrans.setHgap(25);

        //informative texts and place for writing the word and its meaning
        Text enterTheWord = new Text("Enter the word: ");
        enterTheWord.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

        Text enterTheMeaning = new Text("Enter the meaning: ");
        enterTheMeaning.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

        TextField enterWordSpace = new TextField();
        enterWordSpace.setPrefSize(250,35);

        TextField enterMeaningSpace = new TextField();
        enterMeaningSpace.setPrefSize(250,35);

        //to locate enterTheWord,enterTheMeaning, enterWordSpace and enterMeaningSpace in the grid pane
        GridPane.setConstraints(enterTheMeaning, 2,7);
        GridPane.setConstraints(enterTheWord, 2,4);
        GridPane.setConstraints(enterWordSpace, 4,4);
        GridPane.setConstraints(enterMeaningSpace, 4,7);

        //to select the languages that user wants to add a new word-translation.
        ChoiceBox<String> choosingLanguage1 = new ChoiceBox<>();
        choosingLanguage1.getItems().addAll("Turkish" , "English" , "German" , "French" , "Italian" , "Swedish" , "Modern Greek");
        choosingLanguage1.setValue("Select Language");

        ChoiceBox<String> choosingLanguage2 = new ChoiceBox<>();
        choosingLanguage2.getItems().addAll("Turkish" , "English" , "German" , "French" , "Italian" , "Swedish" , "Modern Greek");
        choosingLanguage2.setValue("Select Language");

        //to locate choosingLanguage1 and choosingLanguage2 in the grid pane
        GridPane.setConstraints(choosingLanguage1,5, 4);
        GridPane.setConstraints(choosingLanguage2,5, 7);

        //to perform adding
        Button addToTheList = new Button("ADD TO THE LIST");

        //to locate addToTheList in the grid pane
        GridPane.setConstraints(addToTheList, 4,12);

        //to set the visual properties of the addToTheList
        addToTheList.setPrefWidth(150);
        addToTheList.setPrefHeight(70);
        addToTheList.setBorder(Border.stroke(Color.BLACK));
        addToTheList.setTextFill(Color.BLACK);
        addToTheList.setBackground(Background.fill(Color.SILVER));

        //to use in the flags method from the dictOff.flagsClass- horizontally
        HBox hBoxForFlags = new HBox();
        //to use in the quesBack method from the dictOff.quesBackClass - horizontally
        HBox hBoxForQuesBackButtons = new HBox();

        //to make it visible on the screen
        layoutAddTrans.getChildren().addAll(enterTheMeaning,enterTheWord, enterWordSpace,
                enterMeaningSpace, choosingLanguage1, addToTheList,choosingLanguage2);

        //text fields, texts, checkboxes and addToTheList must be at the center of the screen
        borderPane.setCenter(layoutAddTrans);
        /*hBoxForFlags must be at the top of the screen - from the class flags with dictOff.flagsClass method, because we use flags
        images more than one time.*/
        borderPane.setTop(flagsClass.class.newInstance().flags(hBoxForFlags));
        /*hBoxForQuesBackButtons must be at the bottom of the screen - from the class dictOff.quesBackClass with quesBack method, because we
        use question mark (help button) and back mark(to go back button) images more than one time.*/
        borderPane.setBottom(quesBackClass.class.newInstance().quesBack(hBoxForQuesBackButtons));

        borderPane.setStyle("-fx-background-color:gainsboro");
        scene = new Scene(borderPane, 700,500);
        stage.setTitle("DictOff");
        stage.setScene(scene);
        stage.show();
    }
}
