package dictOff;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class flagsClass {
    public HBox flags(HBox hBox){
        /*We designed our dictionary as the dictOff.flags of the languages that user can translate at the top.
        This image includes the set of the dictOff.flags.  */
        Image flags = new Image("img.png");//img.png is in the project
        ImageView flagsView = new ImageView(flags);

        /* to use the hBoxForFlags layout to separate the images from the grid pane layout and have
        them in horizontal order. */
        hBox= new HBox(flagsView);

        //to set the visual properties of the hBoxForFlags layout and image
        hBox.setBackground(Background.fill(Color.GAINSBORO));
        hBox.setSpacing(20);
        flagsView.setFitHeight(70);
        flagsView.setFitWidth(710);

        //to be able to use at the bottom of the screen by helping Border Pane layout, we return the hBox
        return hBox;
    }
}
