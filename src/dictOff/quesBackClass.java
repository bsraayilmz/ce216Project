package dictOff;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class quesBackClass {
    Button helpButton;
    Button returnButton;

    public HBox quesBack(HBox box) {
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

        //to go back prev page
        Image returnImage = new Image("return.png");
        ImageView returnView = new ImageView(returnImage);

        returnButton = new Button();
        returnButton.setGraphic(returnView);//to add button property to the sign of return (to go back prev page)
        returnButton.setBorder(Border.stroke(Color.GAINSBORO));
        returnButton.setBackground(Background.fill(Color.GAINSBORO));

        //to set the size of the question mark image
        returnView.setFitHeight(50);
        returnView.setFitWidth(47);

        //to take the images, and their button structures into the horizontal modal
        box = new HBox(returnButton, helpButton, returnView, questionMarkView);
        box.setSpacing(571);//the space between images which are question mark and return

        //to be able to use at the bottom of the screen by helping Border Pane layout, we return the hBox
        return box;
    }
}
