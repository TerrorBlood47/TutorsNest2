package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class TeacherDashBoardController implements Initializable {

    @FXML
    private TableColumn<Student, String> mobileNumberColumn;

    @FXML
    private TableColumn<Student, String> studentNameColumn;
    @FXML
    private Label mobileField;

    @FXML
    private TableView<Student> studentsList;

    @FXML
    private Label topNameLabel;

    @FXML
    private Button logoutButton;
    @FXML
    private Label emailField;
    @FXML
    private AnchorPane profileButton;

    @FXML
    private Label namesFirstCharacter;

    @FXML
    private Label nameUnderProfileButton;
    @FXML
    private ImageView teacherImage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            logoutButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    TutorsNestUtils.switchScene(actionEvent,"letsGetStarted.fxml","Tutor's Nest");
                }
            });

            profileButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    TutorsNestUtils.switchSceneViaMouseEvent(mouseEvent,"TeacherProfile.fxml","Profile",null,null,null);
                }

            });

    }
    public void displayName(String name, String email, String phoneNumber) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(6) + 1;
        topNameLabel.setText(name);
        emailField.setText(email);
        mobileField.setText(phoneNumber);
        String url = "file:/home/fahim/Desktop/java%20project/TutorNest3/tutorsNest2-main/target/classes/com/example/javaproject/images/" + randomIndex + ".png";
        Image image = new Image(url);
        System.out.println(url);
        teacherImage.setImage(image);
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastname"));
        mobileNumberColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("mobileNumber"));
        studentsList.setItems(TutorsNestUtils.getStudentsList(topNameLabel.getText()));
        String namescharAtzero = String.valueOf(name.charAt(0));
        namesFirstCharacter.setText(namescharAtzero);//<- need to design it later
        nameUnderProfileButton.setText(name);
    }




}
