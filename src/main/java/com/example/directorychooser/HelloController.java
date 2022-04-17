package com.example.directorychooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
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
        System.out.println("Hello chooser");
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
                Files.find(dir, depth, (path, attribute) -> path.getFileName().toString().toLowerCase().endsWith(".jpg"))
                        .forEach(item -> {
                            System.out.println("file name is:" + item.getFileName());
                                myStringList.add(String.valueOf(item));

                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("My list now contains: " + myStringList);

        // sort the myStringList file in ascending order! here
        List<String> sortedImageList = sortImageList(myStringList);
        System.out.println("Sorted List is!!!: " + sortedImageList);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Slideshow.fxml"));
        Parent root = loader.load();
        ImageViewController imageViewController = loader.getController();
        imageViewController.setImageList(sortedImageList);
        imageViewController.displayList();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    List<String> sortImageList(List<String> imageList) {
        List<String> sortedList = imageList.stream().sorted().collect(Collectors.toList());
        return sortedList;
    }

//    public void switchToSlideShow(ActionEvent e) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("Slideshow.fxml"));
//        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    public void initialize() {

    }
}