package com.team1.ce216project;
import javafx.scene.layout.VBox;
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
    public static String translate(String startLanguage, String translatedLange, String word){
        String str ="";
        if(!new File(DATA_PATH+startLanguage+"-"+translatedLange+".dict").exists()){
            String arr2 = readFile(DATA_PATH+startLanguage+"-eng.dict",word);
            str=arr2;
            if(str.equals("")){
                isExists=false;
                return str;
            }
            String[] arr = arr2.split("1.");
            System.out.println(arr[1]);
            str=arr[1];
            str=str.trim();
            str=readFile(DATA_PATH+"eng-"+translatedLange+".dict",arr[1]);
            return str;
        }
        if(startLanguage.equals("eng")&& translatedLange.equals("deu")){
            str=readEngDeuFile(DATA_PATH+"eng-deu.dict", word);
            return str;
        }
        str=readFile(DATA_PATH+startLanguage+"-"+translatedLange+".dict",word);
        return str;
    }

    public static String readFile(String fileName, String word){
        String str="";
        word=word.trim();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" /");
                arr[0]=arr[0].trim();
                if(arr[0].equalsIgnoreCase(word)){
                    String s = br.readLine();
                    System.out.println(s);
                    str=s;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static String readEngDeuFile(String fileName, String word){
        word =word.trim();
        String str ="";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] arr = line.split(" /");

                if(arr[0].equalsIgnoreCase(word)){
                    String s = br.readLine();

                    if (s.contains(" <")){
                        String[] arr1 =s.split("<");
                       str=arr1[0];
                        System.out.println(str);
                       str=str.trim();
                        break;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static void add(String StartLanguage, String translatedLanguage,String word, VBox vBox, Text vocbText){
        if(translate(StartLanguage,translatedLanguage,word).equals("") || !isExists){
            isExists=true;
            vocbText = new Text("There is no " + translatedLanguage+" translation for this word.");
            vBox.getChildren().add(vocbText);
        }else {
                vocbText = new Text(translate(StartLanguage, translatedLanguage, word));
                vocbText.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 15));
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
