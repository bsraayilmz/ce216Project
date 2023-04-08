package dictOff;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ConvertToFiles.replaceLines("data/eng-fra.dict");
        ConvertToFiles.replaceLines("data/eng-ita.dict");
        ConvertToFiles.replaceLines("data/tur-eng.dict");
        ConvertToFiles.replaceLines("data/fra-eng.dict");
        ConvertToFiles.replaceLines("data/eng-swe.dict");
        ConvertToFiles.replaceLines("data/swe-eng.dict");
        ConvertToFiles.replaceLines("data/ita-eng.dict");
        ConvertToFiles.replaceLines("data/ell-eng.dict");
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.displayLoginScreen(stage);

    }



}
