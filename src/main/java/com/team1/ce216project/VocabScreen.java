package com.team1.ce216project;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public class VocabScreen {
    private static boolean answer;
    public static Scene displayVocabScreen(Stage stage, String word,String startLanguage) throws Exception {
        StackPane stack = new StackPane();
        boolean isTranslated = false;

        stage.setTitle("DictOff");


        VBox vBox1= new VBox();
        Text text = new Text("TRANSLATIONS OF " + word);
        Text text1 = new Text("(Source Language: "+ startLanguage +")");
        text.setFont(Font.font("Times New Roman", FontPosture.REGULAR,45));
        text1.setFont(Font.font("Times New Roman", FontPosture.REGULAR,45));

        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(10));

        vBox1.setMaxHeight(200);
        vBox1.setMaxWidth(600);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(text,text1);

        HBox hBox1= new HBox();
        hBox1.setMaxHeight(200);
        hBox1.setMaxWidth(500);
        hBox1.setAlignment(Pos.TOP_LEFT);
        Text vocb = new Text();


        VBox vBox2= new  VBox();
        vBox2.setMaxHeight(200);
        vBox2.setMaxWidth(500);
        vBox2.setPadding(new Insets(10));
        vBox2.setAlignment(Pos.TOP_LEFT);


        Button English = new Button("eng");
        English.setPrefSize(90,50);
        English.setOnAction(e -> {
            if(!vBox2.getChildren().isEmpty()){
                vBox2.getChildren().remove(0);
            }
            scanningFile.add(startLanguage,"eng",word,vBox2,vocb);

        });
        if(!startLanguage.equals(English.getText())){
            hBox1.getChildren().addAll(English);
        }

        Button Italian = new Button("ita");
        Italian.setPrefSize(90,50);
        Italian.setOnAction(e -> {
            if(!vBox2.getChildren().isEmpty()){
                vBox2.getChildren().remove(0);
            }
            scanningFile.add(startLanguage,"ita",word,vBox2,vocb);

        });
        if(!startLanguage.equals(Italian.getText())){
            hBox1.getChildren().addAll(Italian);
        }

        Button Greek = new Button("gre");
        Greek.setPrefSize(90,50);
        Greek.setOnAction(e -> {
            if(!vBox2.getChildren().isEmpty()){
                vBox2.getChildren().remove(0);
            }
            scanningFile.add(startLanguage,"ell",word,vBox2,vocb);

        });
        if(!startLanguage.equals(Greek.getText())){
            hBox1.getChildren().addAll(Greek);
        }

        Button Turkish = new Button("tur");
        Turkish.setPrefSize(90,50);
        Turkish.setOnAction(e -> {
            if(!vBox2.getChildren().isEmpty()){
                vBox2.getChildren().remove(0);
            }
            scanningFile.add(startLanguage,"tur",word,vBox2,vocb);

        });
        if(!startLanguage.equals(Turkish.getText())){
            hBox1.getChildren().addAll(Turkish);
        }

        Button German = new Button("deu");
        German.setPrefSize(90,50);
        German.setOnAction(e -> {
            if(!vBox2.getChildren().isEmpty()){
                vBox2.getChildren().remove(0);
            }
            scanningFile.add(startLanguage,"deu",word,vBox2,vocb);

        });
        if(!startLanguage.equals(German.getText())){
            hBox1.getChildren().addAll(German);
        }

        Button French  = new Button("fra");
        French.setPrefSize(90,50);
        French.setOnAction(e -> {
            if(!vBox2.getChildren().isEmpty()){
                vBox2.getChildren().remove(0);
            }
            scanningFile.add(startLanguage,"fra",word,vBox2,vocb);
        });
        if(!startLanguage.equals(French.getText())){
            hBox1.getChildren().addAll(French);
        }

        Button Swedish = new Button("swe");
        Swedish.setPrefSize(90,50);
        Swedish.setOnAction(e -> {
            if(!vBox2.getChildren().isEmpty()){
                vBox2.getChildren().remove(0);
            }
            scanningFile.add(startLanguage,"swe",word,vBox2,vocb);
        });
        if(!startLanguage.equals(Swedish.getText())){
            hBox1.getChildren().addAll(Swedish);
        }
        hBox1.setSpacing(10);

        English.setFont(Font.font("Arial",20));
        English.setStyle("-fx-background-color: grey;");
        Italian.setFont(Font.font("Arial",20));
        Italian.setStyle("-fx-background-color: grey;");
        Greek.setFont(Font.font("Arial",20));
        Greek.setStyle("-fx-background-color: grey;");
        Turkish.setFont(Font.font("Arial",20));
        Turkish.setStyle("-fx-background-color: grey;");
        French.setFont(Font.font("Arial",20));
        French.setStyle("-fx-background-color: grey;");
        German.setFont(Font.font("Arial",20));
        German.setStyle("-fx-background-color: grey;");
        Swedish.setFont(Font.font("Arial",20));
        Swedish.setStyle("-fx-background-color: grey;");



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
        vBoxMain.getChildren().addAll(vBox1,hBox1,vBox2);
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