package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherSignUpController2 {

    String username = "fahim";
    String url = "jdbc:mysql://127.0.0.1:3306/project";
    String databasePassword = "Baba733700!@#$%";
    private Connection connection;
    private PreparedStatement statement;
    private String prefTuitionArea;
    private String salary;
    private String prefSubject;

    @FXML
    private TextField cgpaField;

    @FXML
    private TextField currentYearField;

    @FXML
    private TextField departmentField;

    @FXML
    private TextField institutionField;

    @FXML
    private SplitMenuButton preferredSubjectField;

    @FXML
    private SplitMenuButton salaryRangeField;

    @FXML
    private Button SignUpButton;

    @FXML
    private SplitMenuButton tuitionAreaField;

    @FXML
    void teacherSignUpClicked(ActionEvent event) {
        connect();
        TutorsNestUtils.switchScene(event,"teacherTemporaryDashBoard.fxml","Home");
    }
    @FXML
    void preferredSubjectSelected(ActionEvent event) {

    }
    @FXML
    void salarySelected(ActionEvent event) {

    }
    @FXML
    void tuitionAreaSelected(ActionEvent event) {

    }
    @FXML
    void bananiSelected(ActionEvent event) {
        prefTuitionArea = "Banani";
        tuitionAreaField.setText("Banani");
    }

    @FXML
    void biologySelected(ActionEvent event) {
        prefSubject = "Biology";
        preferredSubjectField.setText("Biology");
    }

    @FXML
    void chemistrySelected(ActionEvent event) {
        prefSubject = "Chemistry";
        preferredSubjectField.setText("Chemistry");
    }

    @FXML
    void dhanmondiSelected(ActionEvent event) {
        prefTuitionArea = "Dhanmondi";
        tuitionAreaField.setText("Dhanmondi");
    }

    @FXML
    void eightToTenSelected(ActionEvent event) {
        salary = "8000 - 10000";
        salaryRangeField.setText("8000 - 10000");
    }

    @FXML
    void gulshanSelected(ActionEvent event) {
        prefTuitionArea = "Gulshan";
        tuitionAreaField.setText("Gulshan");
    }

    @FXML
    void mathematicsSelected(ActionEvent event) {
        prefSubject = "Mathematics";
        preferredSubjectField.setText("Mathematics");
    }

    @FXML
    void mirpurSelected(ActionEvent event) {
        prefTuitionArea = "Mirpur";
        tuitionAreaField.setText("Mirpur");
    }

    @FXML
    void mohammadpurSelected(ActionEvent event) {
        prefTuitionArea = "Mohammadpur";
        tuitionAreaField.setText("Mohammadpur");
    }

    @FXML
    void motijheelSelected(ActionEvent event) {
        prefTuitionArea = "Motijheel";
        tuitionAreaField.setText("Motijheel");
    }

    @FXML
    void physicsSelected(ActionEvent event) {
        prefSubject = "Physics";
        preferredSubjectField.setText("Physics");
    }

    @FXML
    void sixToEightSelected(ActionEvent event) {
        salary = "6000 - 8000";
        salaryRangeField.setText("6000 - 8000");
    }



    @FXML
    void tenToTwelveSelected(ActionEvent event) {
        salary = "10000 - 12000";
        salaryRangeField.setText("10000 - 12000");
    }


    @FXML
    void twelveToFifteenSelected(ActionEvent event) {
        salary = "12000 - 15000";
        salaryRangeField.setText("12000 - 15000");
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            String sql = "INSERT INTO teacher_secondary_information (institution, department, cgpa, currYearOfStudy, prefTuitionArea, prefSubject, salary) VALUES (?, ?, ?, ?, ?, ?, ?)";
            String institution = institutionField.getText();
            String department = departmentField.getText();
            String cgpa = cgpaField.getText();
            String currYearOfStudy = currentYearField.getText();


            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, institution);
                statement.setString(2, department);
                statement.setString(3, cgpa);
                statement.setString(4, currYearOfStudy);
                statement.setString(5, prefTuitionArea);
                statement.setString(6, prefSubject);
                statement.setString(7, salary);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        catch (Exception e) {
                e.printStackTrace();
        }
    }


}

