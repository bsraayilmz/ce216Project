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
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"eng-fra.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"eng-ita.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"tur-eng.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"fra-eng.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"eng-swe.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"swe-eng.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"ita-eng.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"ell-eng.dict");
        ConvertToFiles.replaceLines(scanningFile.DATA_PATH+"eng-ell.dict");


        LoginScreen loginScreen = new LoginScreen();
        loginScreen.displayLoginScreen(stage);

    }
}
