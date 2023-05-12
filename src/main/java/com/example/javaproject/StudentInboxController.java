package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentInboxController implements Initializable {
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
    private TableView<Teacher> teacherInbox;
    @FXML
    private TableColumn<Teacher, String> teacherName;
    @FXML
    private Button messageSendBtn;
    @FXML
    private Label inboxHead;
    @FXML
    private TextField studentTextField;
    @FXML
    private Label teacherResponse;
    protected Teacher teacherSelected;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NavigationHandler.Navigation(home, classroom, hireTutors, inbox, payment, logout);
    }
    public void displayName(String email) {
        teacherName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("lastname"));
        teacherInbox.setItems(TutorsNestUtils.getTeachersList2(email));
    }

    public void onRowDoubleClicked(MouseEvent mouseEvent) {
        teacherSelected = teacherInbox.getSelectionModel().getSelectedItem();
        String studentEmail = LoginScreenController.LoginEmailInput;
        String[] studentName = TutorsNestUtils.identifyStudent(studentEmail);
        String[] messages = TutorsNestUtils.retrieveMessage(teacherSelected.getName(), studentName[0],true);
        inboxHead.setText(messages[1]);
        teacherResponse.setText(messages[0]);
    }

    public void messageSendMethod(ActionEvent event) {
        teacherSelected = teacherInbox.getSelectionModel().getSelectedItem();
        String studentEmail = LoginScreenController.LoginEmailInput;
        String[] studentName = TutorsNestUtils.identifyStudent(studentEmail);
        String studentMessage = studentTextField.getText();
        String teacherMessage = "No response yet";
        TutorsNestUtils.saveMessage(teacherSelected.lastname, studentName[0], studentMessage, teacherMessage);
        String[] messages = TutorsNestUtils.retrieveMessage(teacherSelected.lastname, studentName[0],true);
        inboxHead.setText(messages[1]);
        teacherResponse.setText(messages[0]);
        studentTextField.setText("");
    }
}
