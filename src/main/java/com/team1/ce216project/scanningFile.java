package com.team1.ce216project;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class scanningFile {
    public static final String DATA_PATH = "src/main/resources/com/team1/ce216project/data/";
    public static final String IMAGES_PATH = "src/main/resources/com/team1/ce216project/images/";
    static boolean isExists=true;

    /*public static ArrayList<String> translate(String StartLanguage, String translatedLanguage,String word){
        if (!StartLanguage.equalsIgnoreCase("eng")&& !translatedLanguage.equalsIgnoreCase("eng")) {
            String[] arr2 = readFile(DATA_PATH+StartLanguage+"-eng.dict",word).get(0).split(",");
            String[] arr = arr2[0].split("1.");
            System.out.println(arr[1]);
            return readFile(DATA_PATH+"eng-"+translatedLanguage+".dict",arr[1]);
        }else if(translatedLanguage.equalsIgnoreCase("deu") && StartLanguage.equalsIgnoreCase("eng")){
            return readEngDeuFile(DATA_PATH+"eng-deu.dict",word);
        }
        else if(StartLanguage.equalsIgnoreCase("eng")){
            return readFile(DATA_PATH+"eng-"+translatedLanguage+".dict",word);
        }else{
            return readFile(DATA_PATH+StartLanguage+"-eng.dict",word);
        }
    }*/
    public static ArrayList<String> translate(String startLanguage, String translatedLange, String word){
        String str ="";
        ArrayList<String>arrayList=new ArrayList<>();
        if(!new File(DATA_PATH+startLanguage+"-"+translatedLange+".dict").exists()){

            if(readFile(DATA_PATH+startLanguage+"-eng.dict",word).isEmpty()){
                isExists=false;
                return arrayList;
            }
            String[] arr = readFile(DATA_PATH+startLanguage+"-eng.dict",word).get(0).split("1.");
            str=arr[0].trim();
            arrayList=readFile(DATA_PATH+"eng-"+translatedLange+".dict",str);
            return arrayList;
        }
        if(startLanguage.equals("eng")&& translatedLange.equals("deu")){
            return readEngDeuFile(DATA_PATH+"eng-deu.dict", word);
        }

        return  readFile(DATA_PATH+startLanguage+"-"+translatedLange+".dict",word);
    }

    public static ArrayList<String> readFile(String fileName, String word){
        ArrayList<String> arrayList = new ArrayList<>();// creating string array list
        // add trim method to get rid of spaces at the end and beginning of words
        word=word.trim();
        //
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" /");
                arr[0]=arr[0].trim();
                if(arr[0].equalsIgnoreCase(word)){
                    String s = br.readLine();
                    while (isNumeric(Character.toString(s.charAt(0)))){
                        arrayList.add(s);
                        s = br.readLine();
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    public static ArrayList<String> readEngDeuFile(String fileName, String word){
        ArrayList<String> arrayList = new ArrayList<>();
        word =word.trim();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] arr = line.split(" /");

                if(arr[0].equalsIgnoreCase(word)){
                    String s = br.readLine();

                    if (s.contains(" <")){
                        String[] arr1 =s.split("<");
                        arr1[0]= arr1[0].trim() ;
                        arrayList.add(arr1[0]);
                        System.out.println(arr1[0]);
                        s = br.readLine();
                        break;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    public static void addExtendedTransation(String StartLanguage, String translatedLanguage,String word, VBox vBox, TextArea vocbText){
        System.out.println(translate(StartLanguage,translatedLanguage,word).size());
        if(translate(StartLanguage,translatedLanguage,word).size()==1){
            if(translate(StartLanguage,translatedLanguage,word).get(0).contains(",")){
                String[]arr= translate(StartLanguage,translatedLanguage,word).get(0).split(",");
                for (int i = 0; i < arr.length; i++) {
                    vocbText = new TextArea(arr[i]);

                    vocbText.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 15));
                    vBox.getChildren().add(vocbText);
                }

            }else{
                isExists=true;
                vocbText = new TextArea("There is no more than one translation for this word "+ "in " + translatedLanguage);
                vBox.getChildren().add(vocbText);
            }
        }
        else if(translate(StartLanguage,translatedLanguage,word).size()>1){
            for (int i = 0; i < translate(StartLanguage, translatedLanguage, word).size(); i++) {
                vocbText = new TextArea(translate(StartLanguage, translatedLanguage, word).get(i));
                vocbText.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 15));
                vBox.getChildren().add(vocbText);
            }
        }
        else{
            isExists=true;
            vocbText = new TextArea("There is no " + translatedLanguage+" translation for this word.");
            vBox.getChildren().add(vocbText);
        }
        vocbText.setWrapText(true);
        vocbText.setEditable(false);
        vocbText.setPrefWidth(500);
        vocbText.setMaxWidth(1200);
        vocbText.setMaxHeight(1000);
        vocbText.setPrefHeight(400);
        vocbText.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, new Insets(0))));

    }
    public static void add(String StartLanguage, String translatedLanguage,String word, VBox vBox, Text vocbText){
        if(translate(StartLanguage,translatedLanguage,word).isEmpty() || !isExists){
            isExists=true;
            vocbText = new Text("There is no " + translatedLanguage+" translation for this word.");
            vBox.getChildren().add(vocbText);
        }else {
            if(translate(StartLanguage,translatedLanguage,word).get(0).contains(",")){
                String[] arr = translate(StartLanguage,translatedLanguage,word).get(0).split(",");
                vocbText = new Text(arr[0]);
                vocbText.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 15));
                vBox.getChildren().add(vocbText);
            }
            else{
                String str=translate(StartLanguage,translatedLanguage,word).get(0);
                vocbText = new Text(str);
                vocbText.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 15));
                vBox.getChildren().add(vocbText);
            }

        }

    }
    public static boolean isNumeric(String str) { // find the string has a number
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
