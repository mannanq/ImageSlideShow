package com.example.directorychooser;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ImageViewController implements Initializable {

    @FXML

    ImageView myImageView;
    private List<String> myImageList;
    Image myImage;
    int imageCounter;
    Timeline timeline;


    public void displayImage() {
//         first image
        myImageView.setImage(myImage);
        timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {

            try {
                myImageView.setImage(new Image(new FileInputStream(String.valueOf(myImageList.get(imageCounter)))));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imageCounter++;
            System.out.println("count: " + imageCounter);
            System.out.println("myImage: " + myImage);
            // reset to beginning
            if(imageCounter == myImageList.size()) {
                imageCounter = 0;
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void setImageList(List<String> imageList) {
        this.myImageList =  imageList;
        try {
            if(!myImageList.isEmpty()) {
                myImage = new Image(new FileInputStream(String.valueOf(myImageList.get(0))));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void pauseSlideShow(ActionEvent e) {
        System.out.println("clicked pause");
        timeline.pause();
    }

    public void continueSlideShow(ActionEvent e) {
        System.out.println("click again");
        timeline.play();
    }

    public void stopSlideShow(ActionEvent e) {
        myImageView.setImage(myImage);
        imageCounter = 0;
        timeline.stop();
    }

    public void stopSlideShow() {
        timeline.stop();
    }

    public void displayList() {
        System.out.println("image list exists: " + myImageList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        displayImage();
    }
}
