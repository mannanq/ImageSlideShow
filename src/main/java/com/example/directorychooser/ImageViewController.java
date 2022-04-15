package com.example.directorychooser;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ImageViewController implements Initializable {

    @FXML

    ImageView myImageView;
    @FXML
    Button myButton;

    private List<String> myImageList = null;

    Image myImage;


    public void displayImage() {
        myImageView.setImage(myImage);
    }

    public void setImageList(List<String> imageList) {
        this.myImageList = imageList;
        try {
            myImage = new Image(new FileInputStream(myImageList.get(0)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayList() {
        System.out.println("image list exists: " + myImageList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
