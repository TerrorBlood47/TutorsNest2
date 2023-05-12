package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class studentSignUpScreenController {
    String username = "fahim";
    String url = "jdbc:mysql://127.0.0.1:3306/project";
    String databasePassword = "Baba733700!@#$%";
    private Connection connection;
    private PreparedStatement statement;

    @FXML
    private TextField classField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField institutionField;

    @FXML
    private TextField lastNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpBtn;

    @FXML
    private TextField studentEmailField;

    @FXML
    private TextField studentMobileNum;

    @FXML
    void signUpBtnClicked(ActionEvent event) {
        connect();
        System.out.println("Something");
        TutorsNestUtils.switchScene(event,"StudentTemporaryDashBoard.fxml","Home");
    }
    public void connect() {
        System.out.println(firstNameField.getText());
        System.out.println(lastNameField.getText());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            String sql = "INSERT INTO student_information (firstName, lastName, email, studentPassword, institution, class, phoneNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String institution = institutionField.getText();
            String className = classField.getText();
            String mobileNum = studentMobileNum.getText();
            String email = studentEmailField.getText();
            String password = passwordField.getText();
            System.out.println(firstName + " " + lastName);

            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setString(4, password);
                statement.setString(5, institution);
                statement.setString(6, className);
                statement.setString(7, mobileNum);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        catch (Exception e) {
            System.out.println("No Connection");
        }
    }

}





































