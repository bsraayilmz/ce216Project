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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VerifyScreen {
    static Button button1,button2;
    private static boolean answer;
    public static boolean displayVerifyScreen(String title, String word) throws Exception {
        Stage stage = new Stage();
        stage.setTitle("DictOff");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(350);

        Text text = new Text("You Typed: " + word);
        text.setFont(Font.font("Times New Roman", FontPosture.REGULAR,45));

        button1 = new Button("Yes");
        button1.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: black; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
        button1.setFont(Font.font("Times New Roman", FontPosture.REGULAR,25));
        button1.setTextFill(Color.GRAY);
        button1.setOnAction(e -> {
            try {
                answer = true;
                VocabScreen.displayVocabScreen(stage,word,"tur");
                TranslationScreen.window.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        button2 = new Button("No");
        button2.setStyle("-fx-background-radius: 10 10 10 10; -fx-border-color: black; -fx-border-width: 2;-fx-border-radius: 10 10 10 10");
        button2.setFont(Font.font("Times New Roman", FontPosture.REGULAR,25));
        button2.setTextFill(Color.GRAY);
        button2.setOnAction(e -> {
            try{
                answer = false;
                stage.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        HBox hBox1= new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().add(text);


        HBox hBox2= new HBox();
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(button1,button2);
        hBox2.setSpacing(50);


        VBox vBox = new VBox();
        vBox.setMaxHeight(100);
        vBox.setMaxWidth(200);
        vBox.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-width: 1;");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBox1,hBox2);
        vBox.setSpacing(70);
        StackPane stack = new StackPane(vBox);
        stack.setStyle("-fx-background-color: #DCDCDC");

        Scene scene = new Scene(stack,450,450);
        stage.setScene(scene);
        stage.showAndWait();

        return answer;
    }
}
