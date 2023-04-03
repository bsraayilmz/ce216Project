package dictOff;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VocabScreen {

    public static Scene displayVocabScreen(Stage stage, String word) throws Exception {

        stage.setTitle("");
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
        Text ita = new Text("ita");
        ita.setFont(Font.font("Times New Roman", FontPosture.REGULAR,15));
        vBox.setMaxHeight(200);
        vBox.setMaxWidth(900);
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.getChildren().add(ita);
        Text vocbIta = new Text();
        add("data/eng-ita.dict",word,vBox,vocbIta);
        System.out.println(readFile("data/eng-ita.dict",word));


        //System.out.println(readFile("data/eng-tur.dict"));

        VBox vBox2= new  VBox();

        Text vocbTur = new Text();
        Text tur = new Text("TUR");
        tur.setFont(Font.font("Times New Roman", FontPosture.REGULAR,15));
        vBox2.getChildren().add(tur);
        add("data/eng-tur.dict",word,vBox2,vocbTur);



        vBox2.setMaxHeight(200);
        vBox2.setMaxWidth(900);
        vBox2.setPadding(new Insets(10));
        vBox2.setAlignment(Pos.TOP_LEFT);



        VBox vBoxMain = new VBox();
        vBoxMain.setMaxWidth(900);
        vBoxMain.setMaxHeight(700);
        vBoxMain.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-width: 1;");
        vBoxMain.setAlignment(Pos.TOP_CENTER);
        vBoxMain.getChildren().addAll(vBox1,vBox,vBox2);
        vBoxMain.setSpacing(70);
        StackPane stack = new StackPane(vBoxMain);
        stack.setStyle("-fx-background-color: #D9D9D9");



        Scene scene = new Scene(stack,1200,800);
        stage.setScene(scene);
        stage.show();
        return scene;
    }

    public static ArrayList<String> readFile(String fileName, String word){
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" /");

                if(arr[0].equals(word)){
                    String s = br.readLine();

                    while (isNumeric(Character.toString(s.charAt(0)))){
                        arrayList.add(s);
                        s = br.readLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    public static void add(String s,String word, VBox vBox, Text vocbText){
        for(int i=0; i<readFile(s,word).size();i++){
            vocbText = new Text(readFile(s,word).get(i));
            vocbText.setFont(Font.font("Times New Roman", FontPosture.REGULAR,15));
            vBox.getChildren().add(vocbText);
        }

    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
