package com.team1.ce216project;

import com.team1.ce216project.ConvertToFiles;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //ConvertToFiles.fixBlank(scanningFile.DATA_PATH+"eng-fra.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"eng-fra.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"eng-ita.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"tur-eng.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"fra-eng.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"eng-swe.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"swe-eng.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"ita-eng.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"ell-eng.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"eng-ell.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"fra-ell.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"fra-deu.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"fra-ita.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"fra-swe.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"fra-tur.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"deu-ell.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"deu-ita.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"deu-swe.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"deu-tur.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"deu-fra.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"ita-deu.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"ita-ell.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"ita-swe.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"ita-tur.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"tur-deu.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"swe-deu.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"swe-ell.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"swe-fra.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"swe-ita.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"swe-tur.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"ell-fra.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"ell-ita.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"ell-swe.dict");
        //ConvertToFiles.fixBlank(scanningFile.DATA_PATH+"deu-eng.dict");// only need to run for one time







        LoginScreen loginScreen = new LoginScreen();
        loginScreen.displayLoginScreen(stage);

    }
}
