package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentDashBoardController extends StudentDashboard implements Initializable {
    String url = "jdbc:mysql://" + DataHub.Host + ":" + DataHub.Port_number + "/" + DataHub.Database_name;
    static Connection connection;
    static PreparedStatement statement;

    @FXML
    private SplitMenuButton areaSelected;
    @FXML
    private Button searchBtn;

    @FXML
    private MenuItem banani;

    @FXML
    private TableColumn<Teacher, String> cgpaColumn;

    @FXML
    private TableColumn<Teacher, String> departmentColumn;

    @FXML
    private MenuItem dhanmondi;

    @FXML
    private MenuItem gulshan;

    @FXML
    private MenuItem mirpur;

    @FXML
    private MenuItem mohammadpur;

    @FXML
    private MenuItem motijheel;

    @FXML
    private TableColumn<Teacher, String> nameColumn;

    @FXML
    private SplitMenuButton salaryRangeSelected;

    @FXML
    private SplitMenuButton subjectSelected;

    @FXML
    private TableColumn<Teacher, String> universityColumn;

    @FXML
    private TableColumn<Teacher, String> yearColumn;
    @FXML
    private TableView<Teacher> teachersList;


    @FXML
    private Label cgpaDialog;

    @FXML
    private Label departmentDialog;

    @FXML
    private AnchorPane dialogPaneView;

    @FXML
    private DialogPane dialogPaneView1;

    @FXML
    private Label nameDialog;

    @FXML
    private Label universityDialog;

    @FXML
    private Label topNameLabel;

    @FXML
    private Label yearDialog;

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


    protected String prefTuitionArea;     /////pore private banaite hobe
    protected String salary;
    protected String prefSubject;
    protected Teacher teacherSelected;


    @FXML
    void bananiSelected(ActionEvent event) {
        prefTuitionArea = "Banani";
        areaSelected.setText("Banani");
    }

    @FXML
    void biologySelected(ActionEvent event) {
        prefSubject = "Biology";
        subjectSelected.setText("Biology");
    }

    @FXML
    void chemistrySelected(ActionEvent event) {
        prefSubject = "Chemistry";
        subjectSelected.setText("Biology");
    }

    @FXML
    void dhanmondiSelected(ActionEvent event) {
        prefTuitionArea = "Dhanmondi";
        areaSelected.setText("Dhanmondi");
    }

    @FXML
    void eightToTenSelected(ActionEvent event) {
        salary = "8000 - 10000";
        salaryRangeSelected.setText("8000 - 10000");
    }

    @FXML
    void gulshanSelected(ActionEvent event) {
        prefTuitionArea = "Gulshan";
        areaSelected.setText("Gulshan");
    }

    @FXML
    void mathematicsSelected(ActionEvent event) {
        prefSubject = "Mathematics";
        subjectSelected.setText("Mathematics");
    }

    @FXML
    void mirpurSelected(ActionEvent event) {
        prefTuitionArea = "Mirpur";
        areaSelected.setText("Mirpur");
    }

    @FXML
    void mohammadpurSelected(ActionEvent event) {
        prefTuitionArea = "Mohammadpur";
        areaSelected.setText("Mohammadpur");
    }

    @FXML
    void motijheelSelected(ActionEvent event) {
        prefTuitionArea = "Motijheel";
        areaSelected.setText("Motijheel");
    }

    @FXML
    void physicsSelected(ActionEvent event) {
        prefSubject = "Physics";
        subjectSelected.setText("Physics");
    }

    @FXML
    void sixToEightSelected(ActionEvent event) {
        salary = "6000 - 8000";
        salaryRangeSelected.setText("6000 - 8000");
    }

    @FXML
    void tenToTwelveSelected(ActionEvent event) {
        salary = "10000 - 12000";
        salaryRangeSelected.setText("10000 - 12000");
    }

    @FXML
    void twelveToFifteenSelected(ActionEvent event) {
        salary = "12000 - 15000";
        salaryRangeSelected.setText("12000 - 15000");
    }

    @FXML
    void searchBtnClicked(ActionEvent event) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        universityColumn.setCellValueFactory(new PropertyValueFactory<>("university"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        cgpaColumn.setCellValueFactory(new PropertyValueFactory<>("cgpa"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        teachersList.setItems(TutorsNestUtils.getTeachersList(prefTuitionArea, prefSubject, salary));

    }

    @FXML
    void onRowDoubleClicked(MouseEvent event) {
        teacherSelected = teachersList.getSelectionModel().getSelectedItem();
        Dialog dialog = new Dialog();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setText("Add This Teacher");
        dialog.getDialogPane().setPrefWidth(400);
        dialog.getDialogPane().setPrefHeight(400);
        dialog.show();
        dialog.getDialogPane().setContent(showCustomView());

        okButton.setOnAction( e -> {
            String phoneNumber = TutorsNestUtils.getTeacherPhoneNumber(teacherSelected.getName());
            connect( teacherSelected.getName(), topNameLabel.getText(), phoneNumber);
        });

    }

    private Node showCustomView() {
        GridPane gridPane = new GridPane();
        gridPane.setMinHeight(200.0);
        gridPane.setMinWidth(200.0);
        gridPane.setHgap(2.0);
        gridPane.setVgap(3.0);


        Label nameLabel = new Label(teacherSelected.getName());
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 26)); // set font size to 16
        gridPane.add(nameLabel, 0, 0);

        Label universityLabel = new Label(teacherSelected.getUniversity() + ",");
        universityLabel.setFont(Font.font("Arial", 20)); // set font size to 14
        gridPane.add(universityLabel, 0, 1);

        Label departmentLabel = new Label(teacherSelected.getDepartment() );
        departmentLabel.setFont(Font.font("Arial", 20)); // set font size to 14
        gridPane.add(departmentLabel, 1, 1);

        Label yearLabel = new Label(teacherSelected.getYear() + " Year");
        yearLabel.setFont(Font.font("Arial", 20)); // set font size to 14
        gridPane.add(yearLabel, 0, 2);

        Label cgpaLabel = new Label("Current CGPA : " + teacherSelected.getCgpa());
        cgpaLabel.setFont(Font.font("Arial", 20)); // set font size to 14
        gridPane.add(cgpaLabel, 0, 3);

        return gridPane;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NavigationHandler.Navigation(home,classroom,hireTutors,inbox,payment,logout);

        nameColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        universityColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("university"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("department"));
        cgpaColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("cgpa"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("year"));
        teachersList.setItems(TutorsNestUtils.getTeachersList());
    }

    public void displayName(String name) {
        topNameLabel.setText(name);
    }

    public void connect(String teacherName, String studentName, String phoneNumber) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, DataHub.Database_user, DataHub.Database_password);
            String sql = "INSERT INTO teacher_student (teacher_name, student_name, phoneNumber) VALUES (?, ?, ?)";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, teacherName);
                statement.setString(2, studentName);
                statement.setString(3, phoneNumber);

                statement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        catch (Exception e) {
            System.out.println("No Connection");
        }
    }



}
