package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class chooseScreenController implements Initializable {

    @FXML
    private Button chooseStudentButton;

    @FXML
    private Button chooseTeacherButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        chooseStudentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                TutorsNestUtils.switchScene(event,"studentSignUp.fxml","Sign Up");
            }
        });

        chooseTeacherButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                TutorsNestUtils.switchScene(event,"teacherSignUp.fxml","Sign Up");
            }
        });
    }
}
