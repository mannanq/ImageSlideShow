package com.example.directorychooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HelloController  {

    private Scene scene;
    @FXML
    private Label welcomeText;
    @FXML
    private Button button;
    @FXML
    private AnchorPane mainAnchor;

    private Stage stage;

    public List<String> myStringList;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML
    protected void openDialog(ActionEvent event) throws IOException {
        myStringList = new ArrayList<String>();
        stage = (Stage) mainAnchor.getScene().getWindow();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Directory Chooser");
        directoryChooser.setInitialDirectory(new File("src"));
        File file = directoryChooser.showDialog(stage);

        if(file != null) {
            System.out.println("Path " + file.getAbsolutePath());
            Path dir = file.toPath();
            System.out.println("dir is: " + dir);
            int depth = Integer.MAX_VALUE;
            try {
                // input to smaller function: dir, depth
                Files.find(dir, depth, (path, SomeAttribute) -> path.getFileName().toString().toLowerCase().endsWith(".jpg"))
                        .forEach(item -> {
                                myStringList.add(String.valueOf(item));
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // sort the myStringList file in ascending order! here
        if(!myStringList.isEmpty()) {
            List<String> sortedImageList = sortImageList(myStringList);
            System.out.println("Sorted List is!!!: " + sortedImageList);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Slideshow.fxml"));
            Parent root = loader.load();
            ImageViewController imageViewController = loader.getController();
            imageViewController.setImageList(sortedImageList);
            imageViewController.displayList();
            imageViewController.displayImage();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnCloseRequest(e -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Closing Window");
                alert.setHeaderText("You are closing the window");
                alert.setContentText("Bye Bye");
                if(alert.showAndWait().get() == ButtonType.OK) {
                    System.out.println("Close called!!");
                    imageViewController.stopSlideShow();
                    stage.close();
                }
            });
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Slideshow.fxml"));
            Parent root = loader.load();
            ImageViewController imageViewController = loader.getController();
            FileInputStream input = new FileInputStream("src/main/resources/com/example" +
                    "/directorychooser/Not_found.jpg");
            // credit for not_found file: From Alamy stock images
            imageViewController.myImageView.setImage(
                    new Image(input)
            );
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }



    }

    List<String> sortImageList(List<String> imageList) {
        return imageList.stream().sorted().collect(Collectors.toList());
    }


    public void initialize() {

    }
}