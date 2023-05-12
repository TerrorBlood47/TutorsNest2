package com.example.javaproject;

import com.example.javaproject.TutorsNestUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class LetsGetStartedScreenController implements Initializable {

    @FXML
    private Button letsGetStartedButton;

    @FXML
    private Button LoginButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        letsGetStartedButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){

                TutorsNestUtils.switchScene(event,"choose.fxml","Sign Up");
            }
        });

        LoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TutorsNestUtils.switchScene(event,"Login.fxml","Log In");
            }
        });
    }
}
