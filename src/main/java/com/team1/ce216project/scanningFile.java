package com.team1.ce216project;


import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class scanningFile {
    public static final String DATA_PATH = "src/main/resources/com/team1/ce216project/data/";
    public static final String IMAGES_PATH = "src/main/resources/com/team1/ce216project/images/";
    //resources/com/team1/ce216project/data/eng-ell.dict

    public static ArrayList<String> translate(String StartLanguage, String translatedLanguage,String word){
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
    public static ArrayList<String> readEngDeuFile(String fileName, String word){
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] arr = line.split(" /");

                if(arr[0].equals(word)){
                    String s = br.readLine();

                    if (s.contains(" <")){
                        String[] arr1 =s.split("<");
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
    public static void add(String StartLanguage, String translatedLanguage,String word, VBox vBox, Text vocbText){
        if(translate(StartLanguage,translatedLanguage,word).isEmpty()){
            System.out.println("There is no " + translatedLanguage+" translation for this word.");
            vocbText = new Text("There is no " + translatedLanguage+" translation for this word.");
            vBox.getChildren().add(vocbText);
        }else {
            for (int i = 0; i < translate(StartLanguage, translatedLanguage, word).size(); i++) {
                vocbText = new Text(translate(StartLanguage, translatedLanguage, word).get(i));
                vocbText.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 15));
                vBox.getChildren().add(vocbText);
            }
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
