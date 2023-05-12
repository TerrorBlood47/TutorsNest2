package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
    protected Student studentSelected;
    private String[] messages;
    private TextField teacherMessage = new TextField();



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


    public void onRowDoubleClicked(MouseEvent mouseEvent) {

        studentSelected = studentsList.getSelectionModel().getSelectedItem();
        Dialog dialog = new Dialog();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setText("Send Message");

        dialog.getDialogPane().setPrefWidth(800);
        dialog.getDialogPane().setPrefHeight(700);
        dialog.show();
        String studentName = studentSelected.lastname;
        String mail = emailField.getText();
        String teacherName = TutorsNestUtils.identifyStudent(mail, null);
        messages = TutorsNestUtils.retrieveMessage(teacherName, studentName, false);
        System.out.println(messages[0]);
        System.out.println(messages[1]);
        dialog.getDialogPane().setContent(showCustomView());

        okButton.setOnAction( e -> {
            TutorsNestUtils.saveMessage(teacherName, studentName, "No response yet", teacherMessage.getText());
            teacherMessage.setText("");
            teacherMessage.setPromptText("Write your messages here");
        });
    }
    private Node showCustomView() {
        GridPane gridPane = new GridPane();
        gridPane.setMinHeight(600.0);
        gridPane.setMinWidth(600.0);
        gridPane.setHgap(2.0);
        gridPane.setVgap(3.0);
        gridPane.setMaxHeight(700.0);
        gridPane.setMaxWidth(800.0);


        Label nameLabel = new Label("Your student's Message : ");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        nameLabel.setPrefWidth(600);
        nameLabel.setPrefHeight(50);
        nameLabel.setMinWidth(600);
        gridPane.add(nameLabel, 0, 0);

        Label universityLabel = new Label(messages[1]);
        universityLabel.setFont(Font.font("Arial", 20));
        universityLabel.setPrefWidth(600);
        universityLabel.setPrefHeight(100);
        universityLabel.setMinWidth(600);
        gridPane.add(universityLabel, 0, 1);

        Label departmentLabel = new Label("Your Response :");
        departmentLabel.setFont(Font.font("Arial", FontWeight.BOLD , 26));
        departmentLabel.setPrefWidth(600);
        departmentLabel.setPrefHeight(50);
        departmentLabel.setMinWidth(600);
        gridPane.add(departmentLabel, 0, 3);

        Label yearLabel = new Label(messages[0]);
        yearLabel.setFont(Font.font("Arial", 20));
        yearLabel.setPrefWidth(600);
        yearLabel.setPrefHeight(100);
        yearLabel.setMinWidth(600);
        gridPane.add(yearLabel, 0, 4);

        teacherMessage.setPrefHeight(200);
        teacherMessage.setPrefWidth(600);
        teacherMessage.setPromptText("Write your messages here");
        gridPane.add(teacherMessage, 0, 5);




        return gridPane;
    }
}
