package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentClassroomController implements Initializable {

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
    private Label subject1;
    @FXML
    private Label subject2;
    @FXML
    private Label subject3;
    @FXML
    private Label subject4;
    @FXML
    private Label subject5;
    @FXML
    private Label subject6;
    @FXML
    private Label time1;
    @FXML
    private Label time2;
    @FXML
    private Label time3;
    @FXML
    private Label time4;
    @FXML
    private Label time5;
    @FXML
    private Label time6;
    private TextField textField = new TextField();
    Button btn = new Button();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NavigationHandler.Navigation(home,classroom,hireTutors,inbox,payment,logout);
        String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
        if (information[0] != null) {
            setEverything(information);
        }
        subject1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(subject1);
                System.out.println("Sub 1 Clicked");
            }
        });
        subject2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(subject2);
            }
        });
        subject3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(subject3);
            }
        });
        subject4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(subject4);
            }
        });
        subject5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(subject5);
            }
        });
        subject6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(subject6);
            }
        });

        time1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(time1);
            }
        });
        time2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(time2);
            }
        });
        time3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(time3);
            }
        });
        time4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(time4);
            }
        });
        time5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(time5);
            }
        });
        time6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                generateDialog(time6);
            }
        });


    }
    public void generateDialog(Label label) {
        Dialog dialog = new Dialog();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setText("Ok");
        dialog.getDialogPane().setPrefWidth(400);
        dialog.getDialogPane().setPrefHeight(500);
        dialog.show();
        dialog.getDialogPane().setContent(showCustomView());
        okButton.setOnAction( e -> {
            if(label.getId().equals("subject1")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, textField.getText(), subject2.getText(), subject3.getText(), subject4.getText(), subject5.getText(), subject6.getText(), time1.getText(), time2.getText(), time3.getText(), time4.getText(), time5.getText(), time6.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
            else if(label.getId().equals("subject2")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, subject1.getText(), textField.getText(), subject3.getText(), subject4.getText(), subject5.getText(), subject6.getText(), time1.getText(), time2.getText(), time3.getText(), time4.getText(), time5.getText(), time6.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
            else if(label.getId().equals("subject3")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, subject1.getText(), subject2.getText(), textField.getText(), subject4.getText(), subject5.getText(), subject6.getText(), time1.getText(), time2.getText(), time3.getText(), time4.getText(), time5.getText(), time6.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
            else if(label.getId().equals("subject4")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, subject1.getText(), subject2.getText(), subject3.getText(), textField.getText(), subject5.getText(), subject6.getText(), time1.getText(), time2.getText(), time3.getText(), time4.getText(), time5.getText(), time6.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
            else if(label.getId().equals("subject5")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, subject1.getText(), subject2.getText(), subject3.getText(), subject4.getText(), textField.getText(), subject6.getText(), time1.getText(), time2.getText(), time3.getText(), time4.getText(), time5.getText(), time6.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
            else if(label.getId().equals("subject6")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, subject1.getText(), subject2.getText(), subject3.getText(), subject4.getText(), subject5.getText(), textField.getText(), time1.getText(), time2.getText(), time3.getText(), time4.getText(), time5.getText(), time6.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
            else if(label.getId().equals("time1")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, subject1.getText(), subject2.getText(), subject3.getText(), subject4.getText(), subject5.getText(), subject6.getText(), textField.getText(), time2.getText(), time3.getText(), time4.getText(), time5.getText(), time6.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
            else if(label.getId().equals("time2")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, subject1.getText(), subject2.getText(), subject3.getText(), subject4.getText(), subject5.getText(), subject6.getText(), time1.getText(), textField.getText(), time3.getText(), time4.getText(), time5.getText(), time6.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
            else if(label.getId().equals("time3")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, subject1.getText(), subject2.getText(), subject3.getText(), subject4.getText(), subject5.getText(), subject6.getText(), time1.getText(), time2.getText(), textField.getText(), time4.getText(), time5.getText(), time6.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
            else if(label.getId().equals("time4")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, subject1.getText(), subject2.getText(), subject3.getText(), subject4.getText(), subject5.getText(), subject6.getText(), time1.getText(), time2.getText(), time3.getText(), textField.getText(), time5.getText(), time6.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
            else if(label.getId().equals("time5")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, subject1.getText(), subject2.getText(), subject3.getText(), subject4.getText(), subject5.getText(), subject6.getText(), time1.getText(), time2.getText(), time3.getText(), time4.getText(), textField.getText(), time6.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
            else if(label.getId().equals("time6")) {
                TutorsNestUtils.updateClassSchedule(LoginScreenController.LoginEmailInput, subject1.getText(), subject2.getText(), subject3.getText(), subject4.getText(), subject5.getText(), subject6.getText(), time1.getText(), time2.getText(), time3.getText(), time4.getText(), time5.getText(), textField.getText());
                String[] information = TutorsNestUtils.retrieveClassSchedule(LoginScreenController.LoginEmailInput);
                setEverything(information);
                textField.setText("");
            }
        });


    }
    private Node showCustomView() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(2.0);
        gridPane.setVgap(3.0);

        Label nameLabel = new Label("Please Enter New Value : ");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        nameLabel.setPrefHeight(100.0);
        gridPane.add(nameLabel, 0, 0);

        textField.setPrefHeight(50.0);
        textField.setPrefWidth(400.0);
        gridPane.add(textField, 0, 1);

        return gridPane;
    }
    public void setEverything(String[] information) {
        subject1.setText(information[0]);
        subject2.setText(information[1]);
        subject3.setText(information[2]);
        subject4.setText(information[3]);
        subject5.setText(information[4]);
        subject6.setText(information[5]);
        time1.setText(information[6]);
        time2.setText(information[7]);
        time3.setText(information[8]);
        time4.setText(information[9]);
        time5.setText(information[10]);
        time6.setText(information[11]);
    }
}
