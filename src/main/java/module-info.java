module com.team1.ce216project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.team1.ce216project to javafx.fxml;
    exports com.team1.ce216project;
}