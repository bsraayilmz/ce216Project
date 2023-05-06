package com.team1.ce216project;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TranslationFinder  {

    public static void displayTranslationFScreen(Stage primaryStage)throws Exception {
        ObservableList<SynonymRow>rows ;
        rows = FXCollections.observableArrayList();
        // Initialize the data for the table
        Label wordLabel = new Label("Word:");
        Label languageLabel = new Label("Source Language:");
        ComboBox<Language> languageComboBox = new ComboBox<>(FXCollections.observableArrayList(Language.values()));
        TextField wordTextField = new TextField();
//        wordTextField.setWrapText(true);
//        wordTextField.setEditable(false);
//        wordTextField.setPrefWidth(250);
//        wordTextField.setMaxWidth(600);
//        wordTextField.setMaxHeight(300);
//        wordTextField.setPrefHeight(100);
        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> {
            Language sourceLanguage = languageComboBox.getValue();
            String word = wordTextField.getText();
            rows.clear();
            for (Language language : Language.values()) {
                String[] synonyms = getSynonyms(new Language[]{sourceLanguage, language}, word);
                if (synonyms.length > 0) {
                    rows.add(new SynonymRow(language.getName(), String.join(", ", synonyms)));
                }
            }
        });

        for (Language language : Language.values()) {
            String[] synonyms = getSynonyms(Language.values(), "example");
            if (synonyms.length > 0) { // Check if synonyms exist for the language
                rows.add(new SynonymRow(language.getName(), String.join(", ", synonyms)));
            }
        }

        // Initialize the UI elements for the table
        TableView<SynonymRow> table = new TableView<>();

        TableColumn<SynonymRow, String> languageColumn = new TableColumn<>("Languages");
        languageColumn.setEditable(false);
        TableColumn<SynonymRow, String> translationsColumn = new TableColumn<>("Translations");
        translationsColumn.setEditable(false);
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("language"));
        translationsColumn.setCellValueFactory(new PropertyValueFactory<>("translations"));
        table.getColumns().addAll(languageColumn, translationsColumn);
        table.setItems(rows);

        // Set the style of the table
        table.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        languageColumn.setMinWidth(200);
        translationsColumn.setMinWidth(500);
        languageColumn.setStyle("-fx-font-weight: bold; -fx-alignment: CENTER;");
        translationsColumn.setStyle("-fx-alignment: CENTER;");
        languageColumn.setStyle("-fx-font-weight: bold; -fx-font-size: 14; -fx-alignment: CENTER;");
        translationsColumn.setStyle("-fx-font-weight: bold; -fx-font-size: 14; -fx-alignment: CENTER;");

        table.setEditable(false);
        table.setFocusTraversable(false);
        table.setBackground(Background.EMPTY);
        table.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY)));

        table.setRowFactory(tv -> {
            TableRow<SynonymRow> row = new TableRow<>();
            row.setStyle("-fx-background-color: " + (row.getIndex() % 2 == 0 ? "#f7f7f7;" : "white;"));
            return row;
        });


        table.setStyle("-fx-border-style: none;");

        // Add the UI elements to the scene
        HBox searchBox = new HBox(wordLabel, wordTextField, searchButton);
        searchBox.setAlignment(Pos.CENTER);
        HBox sourceLBox= new HBox(languageLabel,languageComboBox);
        sourceLBox.setAlignment(Pos.CENTER);
        sourceLBox.setSpacing(5);
        searchBox.setSpacing(10);
        VBox vbox = new VBox(sourceLBox, searchBox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(10));
        HBox backButton = new HBox(backClass.class.newInstance().quesBack());
        backButton.setAlignment(Pos.BOTTOM_LEFT);
        backButton.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox quesButton = new HBox(questionMarkClass.class.newInstance().questionMark());
        quesButton.setAlignment(Pos.BOTTOM_RIGHT);
        quesButton.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox total = new HBox(backButton,quesButton);
        total.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY)));
        total.setSpacing(572);
        VBox root = new VBox(vbox,  table,total);
        table.prefHeightProperty().bind(primaryStage.heightProperty().subtract(vbox.heightProperty()));
        table.setItems(rows);
        total.setSpacing(572);
        root.setSpacing(30);
        Scene scene = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            scene.setRoot(new VBox(vbox,  table,total));
        });

        root.setPadding(new Insets(90));

        primaryStage.setTitle("Translation Table");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static String[] getSynonyms(Language[] language, String word) {
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