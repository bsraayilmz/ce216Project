package dictOff;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class SynonymScreen {
    Button helpButton;
    Button backButton;
    Stage window;
    Button translateButton;

    public void displaySynonymScreen(Stage stage) throws Exception {
        window = stage;
        window.setTitle("SynonymScreen");

        //Instruction text
        Text text = new Text(" Type a word to find its synonyms:"); //in order to centre the text
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));


        //Translate bar
        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter the word here");

        //Translate button
        translateButton = new Button("Find Synonyms");
        translateButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        translateButton.setTextFill(Color.BLACK);
        translateButton.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, new Insets(0))));

        //Adding the flags image
        Image image = new Image("img.png");
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

        GridPane.setConstraints(translateButton,11,6);
        GridPane.setMargin(translateButton,new Insets(0, 0,0,26)); //In order to centre the button

        GridPane.setConstraints(text, 11, 4);

        translateButton.setPrefSize(200,50);
        wordInput.setMaxSize(300,50);

        wordInput.setFont(Font.font("Times New Roman",20));

        //Creating the Help button
        Image questionMark = new Image("questionMark.png");
        ImageView questionMarkView = new ImageView(questionMark);
        questionMarkView.setFitHeight(50);
        questionMarkView.setFitWidth(45);

        helpButton = new Button();
        helpButton.setGraphic(questionMarkView);
        helpButton.setBorder(new Border(new BorderStroke(Color.GAINSBORO,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        helpButton.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(0))));
        helpButton.setOnAction(e -> System.out.println("Heyo its Sedo"));

        //Creating the Back button
        Image back = new Image("backButton.png");
        ImageView backView = new ImageView(back);
        backView.setFitHeight(50);
        backView.setFitWidth(47);

        backButton = new Button();
        backButton.setGraphic(backView);
        backButton.setBorder(new Border(new BorderStroke(Color.GAINSBORO,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        backButton.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(0))));
        backButton.setOnAction(e -> System.out.println("Heyo its Sedo"));


        //HBox for Help and Back buttons
        HBox buttonsBox = new HBox(backButton,helpButton,backView,questionMarkView);
        buttonsBox.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(0,0,0,0))));
        buttonsBox.setSpacing(567);

        //Adding to GridPane
        gridPane.getChildren().addAll(translateButton,text,wordInput);

        //Main Layout
        BorderPane layout = new BorderPane();
        layout.setCenter(gridPane);
        layout.setTop(imageBox);
        layout.setBottom(buttonsBox);
        layout.setStyle("-fx-background-color: gainsboro");

        //Setting scene into the Stage
        Scene scene = new Scene(layout, 700, 500);
        window.setScene(scene);
        window.show();
    }
}
