package com.team1.ce216project;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TranslationFinder  {



    public static void displayTranslationFScreen(Stage primaryStage)throws Exception {
        ObservableList<SynonymRow> rows;
        // Initialize the data for the table
        rows = FXCollections.observableArrayList();
        for (Language language : Language.values()) {
            String[] synonyms = getSynonyms(language, "example");
            if (synonyms.length > 0) { // Check if synonyms exist for the language
                rows.add(new SynonymRow(language.getName(), String.join(", ", synonyms)));
            }
        }

        // Initialize the UI elements for the table
        TableView<SynonymRow> table = new TableView<>();
        TableColumn<SynonymRow, String> languageColumn = new TableColumn<>("Languages");
        TableColumn<SynonymRow, String> translationsColumn = new TableColumn<>("Translations");
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("language"));
        translationsColumn.setCellValueFactory(new PropertyValueFactory<>("translations"));
        table.getColumns().addAll(languageColumn, translationsColumn);
        table.setItems(rows);
        HBox backButton = new HBox(backClass.class.newInstance().quesBack());
        backButton.setAlignment(Pos.BOTTOM_LEFT);
        HBox quesButton = new HBox(questionMarkClass.class.newInstance().questionMark());
        quesButton.setAlignment(Pos.BOTTOM_RIGHT);
        HBox total = new HBox(backButton,quesButton);
        total.setSpacing(572);
        // Set the style of the table
        table.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        languageColumn.setMinWidth(200);
        translationsColumn.setMinWidth(500);
        languageColumn.setStyle("-fx-font-weight: bold; -fx-alignment: CENTER;");
        translationsColumn.setStyle("-fx-alignment: CENTER;");
        languageColumn.setStyle("-fx-font-weight: bold; -fx-font-size: 14; -fx-alignment: CENTER;");
        translationsColumn.setStyle("-fx-font-weight: bold; -fx-font-size: 14; -fx-alignment: CENTER;");
        table.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY)));
        table.setRowFactory(tv -> {
            TableRow<SynonymRow> row = new TableRow<>();
            row.setStyle("-fx-background-color: " + (row.getIndex() % 2 == 0 ? "#f7f7f7;" : "white;"));
            return row;
        });


        table.setStyle("-fx-border-style: none;");

        // Add the UI elements to the scene
        VBox root = new VBox(table,total);
        Scene scene = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            scene.setRoot(new VBox(table,total));
        });
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        primaryStage.setTitle("Translation Table");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static String[] getSynonyms(Language language, String word) {
        // Use an API to retrieve the synonyms for the given word and language
        return new String[] { "example", "synonym", "test" };
    }


    public static class SynonymRow {
        private final SimpleStringProperty language;
        private final SimpleStringProperty translations;

        public SynonymRow(String language, String translations) {
            this.language = new SimpleStringProperty(language);
            this.translations = new SimpleStringProperty(translations);
        }

        public String getLanguage() {
            return language.get();
        }

        public String getTranslations() {
            return translations.get();
        }
    }

    public enum Language {
        ENGLISH("English"), FRENCH("French"), GERMAN("German"), TURKISH("Turkish"),
        ITALIAN("Italian"), SWEDISH("Swedish"), GREEK("Modern Greek");

        private final String name;

        Language(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}