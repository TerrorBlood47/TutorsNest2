package com.example.javaproject;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class StudentHomeController implements Initializable {
    @FXML
    private Button home;

    @FXML
    private Button classroom;

    @FXML
    private Button hireTutors;

    @FXML
    private Button inbox;

    @FXML
    private Button payment;

    @FXML
    private Button logout;
    @FXML
    private Label studentClass;
    @FXML
    private Label studentInstitute;
    @FXML
    private Label teacherNumber;
    @FXML
    private TableView<Teacher> teachersList;
    @FXML
    private TableColumn<Teacher, String> teacherNameField;
    @FXML
    private TableColumn<Teacher, String> mobileNumberField;
    private int teacherTNumber = -1;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NavigationHandler.Navigation(home, classroom, hireTutors, inbox, payment, logout);
    }
    public void displayName(String studentCurrentClass,String studentCurrentInstitute, int teacherTotalNumber ,String email) {
        studentClass.setText(studentCurrentClass);
        studentInstitute.setText(studentCurrentInstitute);
        teacherNumber.setText(Integer.toString(teacherTotalNumber));
        teacherNameField.setCellValueFactory(new PropertyValueFactory<Teacher, String>("lastname"));
        mobileNumberField.setCellValueFactory(new PropertyValueFactory<Teacher, String>("mobileNumber"));
        teachersList.setItems(TutorsNestUtils.getTeachersList2(email));
    }

}
