module com.example.directorychooser {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.directorychooser to javafx.fxml;
    exports com.example.directorychooser;
}