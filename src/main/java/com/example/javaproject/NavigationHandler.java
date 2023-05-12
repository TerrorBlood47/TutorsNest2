package com.example.javaproject;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class NavigationHandler {

    public static  void Navigation(Button Home, Button Classroom, Button HireTutors, Button Inbox, Button Payment,Button LogOut){
            Home.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    TutorsNestUtils.switchSceneViaMouseEvent(mouseEvent,"studentDashBoard.fxml","Home", LoginScreenController.LoginEmailInput,"home",null);
                }
            });

            Classroom.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    TutorsNestUtils.switchSceneViaMouseEvent(mouseEvent,"studentClassroom.fxml","Classroom",null,null,null);
                }
            });

        HireTutors.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override    public void handle(MouseEvent event) {
                TutorsNestUtils.switchSceneViaMouseEvent(event,"StudentTemporaryDashBoard.fxml", "Hire Tutors", LoginScreenController.LoginEmailInput);    }
        });


        Inbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    TutorsNestUtils.switchSceneViaMouseEvent(mouseEvent,"student_Inbox.fxml","Inbox",LoginScreenController.LoginEmailInput,"inbox",null);
                }
            });

            Payment.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    TutorsNestUtils.switchSceneViaMouseEvent(mouseEvent,"studentPayment.fxml","Payment",null,null,null);
                }
            });

            LogOut.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    TutorsNestUtils.switchSceneViaMouseEvent(mouseEvent,"letsGetStarted.fxml","Lets Get Started",null,null,null);
                }
            });

    }
}
