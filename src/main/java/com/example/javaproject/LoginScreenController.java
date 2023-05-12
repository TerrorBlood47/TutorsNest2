package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginScreenController {
    @FXML
    private TextField emailInput;
    @FXML
    private PasswordField passwordInput;

    public static String LoginEmailInput ;

    @FXML
    private Button SignUpButton;

    @FXML
    private Button loginButton;

    @FXML
    private CheckBox studentChecker;

    @FXML
    void loginSelected(ActionEvent event) {
        LoginEmailInput = emailInput.getText();
        if (studentChecker.isSelected()) {
            Boolean ans = TutorsNestUtils.identifyStudent(emailInput.getText(), passwordInput.getText(), true);
            if (ans) {
                TutorsNestUtils.switchScene(event,"StudentTemporaryDashBoard.fxml", "Hire Tutors", emailInput.getText());
            }
            else {
                System.out.println("No user found with the given information");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No user found with the given information!!!");
                alert.show();
            }
        }
        else {
            Boolean ans = TutorsNestUtils.identifyStudent(emailInput.getText(), passwordInput.getText(), false);
            if (ans) {
                TutorsNestUtils.switchScene(event,"teacherTemporaryDashBoard.fxml","Hire Tutors", emailInput.getText(), null);
            }
            else {
                System.out.println("No user found with the given information");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No user found with the given information!!!");
                alert.show();
            }
        }
    }

    @FXML
    void signUpSelected(ActionEvent event) {
        TutorsNestUtils.switchScene(event,"choose.fxml","Sign Up");
    }

}






