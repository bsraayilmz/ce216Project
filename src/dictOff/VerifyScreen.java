package dictOff;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VerifyScreen {
    Stage window;
    Button button1,button2;

    public void displayVerifyScreen(Stage stage) throws Exception {
        window=stage;
        window.setTitle("");

        HBox hBox1= new HBox();
        Text text = new Text("You Typed: ");
        text.setFont(Font.font("Times New Roman", FontPosture.REGULAR,45));
        hBox1.setMaxHeight(200);
        hBox1.setMaxWidth(600);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().add(text);
        HBox hBox2= new HBox();


        button1 = new Button("CONTINUE");
        button1.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: black; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
        button1.setFont(Font.font("Times New Roman", FontPosture.REGULAR,25));
        button1.setTextFill(Color.GRAY);

        button2 = new Button("GO BACK");
        button2.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: black; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
        button2.setFont(Font.font("Times New Roman", FontPosture.REGULAR,25));
        button2.setTextFill(Color.GRAY);

        hBox2.setMaxHeight(200);
        hBox2.setMaxWidth(600);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(button2,button1);
        hBox2.setSpacing(50);


        VBox vBox = new VBox();
        vBox.setMaxHeight(400);
        vBox.setMaxWidth(600);
        vBox.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-width: 1;");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBox1,hBox2);
        vBox.setSpacing(70);
        StackPane stack = new StackPane(vBox);
        stack.setStyle("-fx-background-color: #D9D9D9");

        Scene scene = new Scene(stack,1200,800);
        window.setScene(scene);
        window.show();
    }
}
