package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherProfileController implements Initializable {
    @FXML
    private TextField FirstName;

    @FXML
    private TextField LastName;


    @FXML
    private PasswordField Password;

    @FXML
    private TextField PhoneNumber;
    @FXML
    private Button SaveButton;

    private String firstName;
    private String lastName;

    private String password;
    private String phonenumber;



    public TeacherProfileController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            SaveButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    //DataHandler.EditProfileForTeacherPrimary(actionEvent,);
                }
            });
    }
}
