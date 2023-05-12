package com.example.javaproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("letsGetStarted.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);

        stage.setTitle("Tutor's Nest");
         try {
        Image icon = new Image(getClass().getResourceAsStream("/com/example/javaproject/images/BIRD-ICON.png"));
        stage.getIcons().add(icon);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("icon not loaded ");
        }

        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}