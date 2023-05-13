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

public class TeacherSignUpController {
    String url = "jdbc:mysql://" + DataHub.Host + ":" + DataHub.Port_number + "/" + DataHub.Database_name;
    private Connection connection;
    private PreparedStatement statement;

    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField mobileNumberField;

    @FXML
    private Button nextPageBtn;

    @FXML
    private PasswordField passwordField;

    @FXML
    void switchToSecondPage(ActionEvent event) {
        connect();
        TutorsNestUtils.switchScene(event,"teacherSignUpSecondPage.fxml","Sign Up");
    }
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, DataHub.Database_user, DataHub.Database_password);
            String sql = "INSERT INTO teacher_primary_information (firstName, lastName, email, teacherPassword, phoneNumber) VALUES (?, ?, ?, ?, ?)";
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String mobileNum = mobileNumberField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();

            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setString(4, password);
                statement.setString(5, mobileNum);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        catch (Exception e) {

        }
    }

}
