package com.example.javaproject;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentPaymentController implements Initializable {
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
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Label teacher1;
    @FXML
    private Label teacher2;
    @FXML
    private Label teacher3;
    @FXML
    private Label teacher4;
    @FXML
    private Label teacher5;
    @FXML
    private Label teacher6;
    @FXML
    private Label dueText;
    private int paidNumber = 0;
    private ObservableList<Teacher> teachers = TutorsNestUtils.getTeachersList2(LoginScreenController.LoginEmailInput);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NavigationHandler.Navigation(home, classroom, hireTutors, inbox, payment, logout);
        String due = Integer.toString(teachers.size() * 10000);
        dueText.setText("Your Total Due : " + due + " Taka");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generateDialog(btn1, dueText);
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generateDialog(btn2, dueText);
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generateDialog(btn3, dueText);

            }
        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generateDialog(btn4, dueText);
            }
        });
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generateDialog(btn5, dueText);
            }
        });
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generateDialog(btn6, dueText);
            }
        });

        if (teachers.size() == 0) {
            btn1.setVisible(false);
            btn2.setVisible(false);
            btn3.setVisible(false);
            btn4.setVisible(false);
            btn5.setVisible(false);
            btn6.setVisible(false);
            teacher1.setVisible(false);
            teacher2.setVisible(false);
            teacher3.setVisible(false);
            teacher4.setVisible(false);
            teacher5.setVisible(false);
            teacher6.setVisible(false);
        }
        else if (teachers.size() == 1) {
            teacher1.setText(teachers.get(0).getFirstname());
            btn2.setVisible(false);
            btn3.setVisible(false);
            btn4.setVisible(false);
            btn5.setVisible(false);
            btn6.setVisible(false);
            teacher2.setVisible(false);
            teacher3.setVisible(false);
            teacher4.setVisible(false);
            teacher5.setVisible(false);
            teacher6.setVisible(false);
        }
        else if (teachers.size() == 2) {
            teacher1.setText(teachers.get(0).getFirstname());
            teacher2.setText(teachers.get(1).getFirstname());

            btn3.setVisible(false);
            btn4.setVisible(false);
            btn5.setVisible(false);
            btn6.setVisible(false);
            teacher3.setVisible(false);
            teacher4.setVisible(false);
            teacher5.setVisible(false);
            teacher6.setVisible(false);
        }
        else if (teachers.size() == 3) {
            teacher1.setText(teachers.get(0).getFirstname());
            teacher2.setText(teachers.get(1).getFirstname());
            teacher3.setText(teachers.get(2).getFirstname());
            btn4.setVisible(false);
            btn5.setVisible(false);
            btn6.setVisible(false);
            teacher4.setVisible(false);
            teacher5.setVisible(false);
            teacher6.setVisible(false);
        }
        else if (teachers.size() == 4) {
            teacher1.setText(teachers.get(0).getFirstname());
            teacher2.setText(teachers.get(1).getFirstname());
            teacher3.setText(teachers.get(2).getFirstname());
            teacher4.setText(teachers.get(3).getFirstname());
            btn5.setVisible(false);
            btn6.setVisible(false);
            teacher5.setVisible(false);
            teacher6.setVisible(false);
        }
        else if (teachers.size() == 5) {
            teacher1.setText(teachers.get(0).getFirstname());
            teacher2.setText(teachers.get(1).getFirstname());
            teacher3.setText(teachers.get(2).getFirstname());
            teacher4.setText(teachers.get(3).getFirstname());
            teacher5.setText(teachers.get(4).getFirstname());

            btn6.setVisible(false);
            teacher6.setVisible(false);
        }
        else if (teachers.size() == 6) {
            teacher1.setText(teachers.get(0).getFirstname());
            teacher2.setText(teachers.get(1).getFirstname());
            teacher3.setText(teachers.get(2).getFirstname());
            teacher4.setText(teachers.get(3).getFirstname());
            teacher5.setText(teachers.get(4).getFirstname());
            teacher6.setText(teachers.get(5).getFirstname());
        }
    }
    public void generateDialog(Button btn, Label dueText) {
            if (btn.getText() != "Payment Done") {
                paidNumber++;
                Dialog dialog = new Dialog();
                dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
                dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
                dialog.getDialogPane().setContent(showCustomView());
                Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
                okButton.setText("Yes, Send Money");
                dialog.show();
                okButton.setOnAction( e -> {
                    btn.setText("Payment Done");
                    String money = Integer.toString((teachers.size() - paidNumber) * 10000);
                    dueText.setText("Your Total Due : " + money + " Taka");
                });
            }

    }
    private Node showCustomView() {
        GridPane gridPane = new GridPane();
        gridPane.setMinHeight(400.0);
        gridPane.setMinWidth(400.0);
        gridPane.setHgap(2.0);
        gridPane.setVgap(3.0);

        Label nameLabel = new Label("Do you want to pay monthly salary of 10000 Taka?");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 26)); // set font size to 16
        gridPane.add(nameLabel, 0, 0);

        return gridPane;
    }
}
