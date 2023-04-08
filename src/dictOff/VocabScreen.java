package dictOff;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VocabScreen {

    public static Scene displayVocabScreen(Stage stage, String word) throws Exception {
        StackPane stack = new StackPane();

        stage.setTitle("DictOff");


        VBox vBox1= new VBox();
        Text text = new Text("TRANSLATIONS OF " + word);
        Text text1 = new Text("(Source Language: ENG)");
        text.setFont(Font.font("Times New Roman", FontPosture.REGULAR,45));
        text1.setFont(Font.font("Times New Roman", FontPosture.REGULAR,45));
        vBox1.setMaxHeight(200);
        vBox1.setMaxWidth(600);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(text,text1);

        VBox vBox= new VBox();
        Text ita = new Text("tur-fra");
        ita.setFont(Font.font("Times New Roman", FontPosture.REGULAR,15));
        vBox.setMaxHeight(200);
        vBox.setMaxWidth(500);
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.getChildren().add(ita);
        Text vocbIta = new Text();
        scanningFile.add("tur","fra",word,vBox,vocbIta);
        System.out.println(scanningFile.readFile("data/eng-ita.dict",word));

       /* VBox vBox3= new VBox();
        Text fra = new Text("fra");
        ita.setFont(Font.font("Times New Roman", FontPosture.REGULAR,15));
        vBox3.setMaxHeight(100);
        vBox3.setMaxWidth(400);
        vBox3.setAlignment(Pos.TOP_LEFT);
        vBox3.getChildren().add(fra);
        Text vocbFra = new Text();
        scanningFile.add("data/eng-fra.dict",word,vBox3,vocbFra);
        System.out.println(scanningFile.readFile("data/eng-fra.dict",word));

        VBox vBox2= new  VBox();

        Text vocbTur = new Text();
        Text tur = new Text("TUR");
        tur.setFont(Font.font("Times New Roman", FontPosture.REGULAR,15));
        vBox2.getChildren().add(tur);
        scanningFile.add("data/eng-tur.dict",word,vBox2,vocbTur);



        vBox2.setMaxHeight(200);
        vBox2.setMaxWidth(500);
        vBox2.setPadding(new Insets(10));
        vBox2.setAlignment(Pos.TOP_LEFT);


*/
        VBox vBoxMain = new VBox();
        vBoxMain.setMaxWidth(500);
        vBoxMain.setMaxHeight(700);
        vBoxMain.setStyle("-fx-background-color: gainsboro; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-width: 1;");
        vBoxMain.setAlignment(Pos.TOP_CENTER);
        vBoxMain.getChildren().addAll(vBox1,vBox);
        vBoxMain.setSpacing(70);

        stack.setStyle("-fx-background-color: #DCDCDC");

        backClass backButton = new backClass();
        HBox backBox = new HBox(backButton.quesBack());
        backButton.returnButton.setOnAction(e -> {
            stage.close();
            try {
                ActionScreen.displayActionScreen(stage);
            } catch (InstantiationException | IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        });
        backBox.setAlignment(Pos.BOTTOM_LEFT);




        HBox quesButton = new HBox(questionMarkClass.class.newInstance().questionMark());
        quesButton.setAlignment(Pos.BOTTOM_RIGHT);


        HBox total = new HBox(backBox,quesButton);
        total.setSpacing(572);

        BorderPane layout = new BorderPane();
        layout.setBottom(total);
        layout.setStyle("-fx-background-color: gainsboro");

        stack = new StackPane(vBoxMain);
        layout.setCenter(stack);
        Scene scene = new Scene(layout,700,500);
        stage.setScene(scene);
        stage.show();
        return scene;
    }
}
