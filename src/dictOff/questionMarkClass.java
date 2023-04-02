package dictOff;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class questionMarkClass {
    Button helpButton;
    public HBox questionMark(){
        Stage stage = new Stage();
        //to help when the users cannot understand what they do.
        Image questionMark = new Image("questionMark.png");
        ImageView questionMarkView = new ImageView(questionMark);

        helpButton = new Button();
        helpButton.setGraphic(questionMarkView); //to add button property to the question mark (help)
        helpButton.setBorder(Border.stroke(Color.GAINSBORO));
        helpButton.setBackground(Background.fill(Color.GAINSBORO));


        //to set the size of the question mark image
        questionMarkView.setFitHeight(50);
        questionMarkView.setFitWidth(45);

        HBox box = new HBox(helpButton, questionMarkView);
        box.setAlignment(Pos.BOTTOM_RIGHT);




        return box;
    }

}
