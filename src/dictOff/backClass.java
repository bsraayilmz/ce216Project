package dictOff;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class backClass {
    Button returnButton;

    public HBox quesBack() {

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
        HBox box = new HBox(returnButton, returnView);
        box.setAlignment(Pos.BOTTOM_LEFT);


        //to be able to use at the bottom of the screen by helping Border Pane layout, we return the hBox
        return box;
    }
}
