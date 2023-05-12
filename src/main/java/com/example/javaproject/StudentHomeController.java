package com.example.javaproject;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
    private Teacher teacherSelected;
    private String neededEmail;



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
        neededEmail = email;
    }

    @FXML
    void onRowDoubleClicked(MouseEvent event) {
        teacherSelected = teachersList.getSelectionModel().getSelectedItem();
        Dialog dialog = new Dialog();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        dialog.getDialogPane().setContent(showCustomView());
        Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setText("Yes, Remove");
        dialog.show();


        okButton.setOnAction( e -> {
            TutorsNestUtils.removeTeacher(teacherSelected.getMobileNumber());
            teachersList.setItems(TutorsNestUtils.getTeachersList2(neededEmail));
            int teacherNum = Integer.parseInt(teacherNumber.getText());
            teacherNum--;
            teacherNumber.setText(Integer.toString(teacherNum));
        });

    }

    private Node showCustomView() {
        GridPane gridPane = new GridPane();
        gridPane.setMinHeight(300.0);
        gridPane.setMinWidth(300.0);
        gridPane.setHgap(2.0);
        gridPane.setVgap(3.0);

        Label nameLabel = new Label("Do you want to remove this teacher ?");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 26)); // set font size to 16
        gridPane.add(nameLabel, 0, 0);

        return gridPane;
    }

}
