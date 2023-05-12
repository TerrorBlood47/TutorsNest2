package com.example.javaproject;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
//import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.sql.*;
import java.util.Random;

public class TutorsNestUtils { //A utility class
    static String username = "fahim";
    static String url = "jdbc:mysql://127.0.0.1:3306/project";
    static String databasePassword = "Baba733700!@#$%";
    static Connection connection;
    static PreparedStatement statement;
    static ResultSet resultSet;
    static String[] imageNames = {"1.png", "2.png", "3.png", "4.png", "5.png", "6.png"};

///////////////////////
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getInstitution() {
        return institution;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setStudentClass(String studentClass) {
        StudentClass = studentClass;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String firstName;
    private String lastName;

    private String email;

    private String password;

    private String institution;

    private String StudentClass;

    private String phoneNumber;
/////////////////////

    public static void switchScene(ActionEvent event, String fxmlFile, String Title){
        //could not add css file

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(TutorsNestUtils.class.getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root,1200,800);
            //scene.getStylesheets().add(getClass().getResource(cssFile).toExternalForm());

            // Create a new FadeTransition object
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), root);
            // Set the fade in and out effect
            fadeTransition.setFromValue(0.25);
            fadeTransition.setToValue(1);

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            fadeTransition.play();

            stage.setResizable(false);
            stage.setTitle(Title);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void switchScene(ActionEvent event, String fxmlFile, String Title, String email){
        //could not add css file

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(TutorsNestUtils.class.getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root,1200,800);
            //scene.getStylesheets().add(getClass().getResource(cssFile).toExternalForm());

            // Create a new FadeTransition object
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), root);
            // Set the fade in and out effect
            fadeTransition.setFromValue(0.25);
            fadeTransition.setToValue(1);

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            fadeTransition.play();

            stage.setResizable(false);
            stage.setTitle(Title);
            stage.show();
            StudentDashBoardController st = fxmlLoader.getController();
            String name = identifyStudent(email)[0];
            st.displayName(name);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void switchScene(ActionEvent event, String fxmlFile, String Title, String email, String something){
        //could not add css file
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(TutorsNestUtils.class.getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root,1200,800);
            //scene.getStylesheets().add(getClass().getResource(cssFile).toExternalForm());

            // Create a new FadeTransition object
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.65), root);
            // Set the fade in and out effect
            fadeTransition.setFromValue(0.25);
            fadeTransition.setToValue(1);

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            fadeTransition.play();

            stage.setResizable(false);
            stage.setTitle(Title);
            stage.show();
            TeacherDashBoardController tt = fxmlLoader.getController();
            String name = identifyStudent(email, null);
            String mobileNumber = getMobileNumber(email);
            tt.displayName(name, email, mobileNumber);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void switchSceneViaMouseEvent(MouseEvent event, String fxmlFile, String Title, String email,String password, String name){
            Parent root = null;
            if(name != null){
                try{
                    FXMLLoader loader = new FXMLLoader(TutorsNestUtils.class.getResource(fxmlFile));
                    root = loader.load();

                }

                catch (IOException e){
                    System.out.println(e.getStackTrace());
                }
            }else{
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(TutorsNestUtils.class.getResource(fxmlFile));
                    root = fxmlLoader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle(Title);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root,1200,800));
                    stage.show();
                    if (password == "home") {
                        StudentHomeController studentHomeController = fxmlLoader.getController();
                        String[] array = identifyStudent(email);
                        ObservableList<com.example.javaproject.Teacher> number = getTeachersList2(email);
                        String studentCurrentClass = array[2];
                        String studentCurrentInstitute = array[1];
                        studentHomeController.displayName(studentCurrentClass, studentCurrentInstitute, number.size(),email);
                    }
                    if (password == "inbox") {
                        StudentInboxController studentInboxController = fxmlLoader.getController();
                        String[] array = identifyStudent(email);
                        ObservableList<com.example.javaproject.Teacher> number = getTeachersList2(email);
                        String studentCurrentClass = array[2];
                        String studentCurrentInstitute = array[1];
                        studentInboxController.displayName(email);
                    }




                }catch (IOException e){
                    System.out.println("Can't Load File");
                    e.printStackTrace();
                }
            }
    }

    public static void switchSceneViaMouseEvent(MouseEvent event, String fxmlFile, String Title, String email){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(TutorsNestUtils.class.getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root,1200,800);
            //scene.getStylesheets().add(getClass().getResource(cssFile).toExternalForm());


            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);

            stage.setResizable(false);
            stage.setTitle(Title);
            stage.show();
            StudentDashBoardController st = fxmlLoader.getController();
            String name = identifyStudent(email)[0];
            st.displayName(name);

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static Boolean identifyStudent(String email, String password, Boolean isStudent) {
        Boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            if (isStudent) {
                statement = connection.prepareStatement("SELECT email, studentPassword FROM student_information");
            }
            else {
                statement = null;
                statement = connection.prepareStatement("SELECT email, teacherPassword FROM teacher_primary_information");
            }

            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while(resultSet.next()) {
                    String retrievedEmail = resultSet.getString("email");
                    String retrievedPassword;
                    if (isStudent) {
                        retrievedPassword = resultSet.getString("studentPassword");
                        System.out.println(retrievedEmail);
                    }
                    else {
                        retrievedPassword = resultSet.getString("teacherPassword");
                        System.out.println(retrievedEmail);
                    }

                    if(retrievedEmail.equals(email) && retrievedPassword.equals(password)){
                        flag = true;
                    }

                }
            }
        }
        catch (Exception e) {
            System.out.println("No Connection");
        }
        if (flag) return true;
        else return false;
    }

    public static String[] identifyStudent(String email) {
        String[] studentInformation = new String[5];
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            statement = connection.prepareStatement("SELECT email, firstName, lastName, institution, class FROM student_information");

            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while(resultSet.next()) {
                    String retrievedEmail = resultSet.getString("email");
                    String retrievedInstitution = resultSet.getString("institution");
                    String retrievedClass = resultSet.getString("class");

                    String retrievedName = resultSet.getString("firstName") + " " + resultSet.getString("lastName");
                    if(retrievedEmail.equals(email)){
                        studentInformation[0] = retrievedName;
                        studentInformation[1] = retrievedInstitution;
                        studentInformation[2] = retrievedClass;
                    }

                }
            }
        }
        catch (Exception e) {
            System.out.println("No Connection");
        }

    return studentInformation;
    }

    public static String getMobileNumber(String email) {
        String phoneNumber = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            statement = connection.prepareStatement("SELECT email, phoneNumber FROM teacher_primary_information");

            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while(resultSet.next()) {
                    String retrievedEmail = resultSet.getString("email");
                    String retrievedMobileNumber = resultSet.getString("phoneNumber");
                    if(retrievedEmail.equals(email)){
                        phoneNumber = retrievedMobileNumber;
                    }

                }
            }
        }
        catch (Exception e) {
            System.out.println("No Connection");
        }
        return phoneNumber;
    }

    public static String identifyStudent(String email, String something) {
        String name = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            statement = connection.prepareStatement("SELECT email, firstName, lastName FROM teacher_primary_information");

            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while(resultSet.next()) {
                    String retrievedEmail = resultSet.getString("email");
                    String retrievedName = resultSet.getString("firstName") + " " + resultSet.getString("lastName");
                    if(retrievedEmail.equals(email)){
                        name = retrievedName;
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("No Connection");
        }
        return name;
    }

    public static String getPhoneNumber(String name) {
        String number = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            statement = connection.prepareStatement("SELECT phoneNumber, firstName, lastName FROM student_information");

            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while(resultSet.next()) {
                    String retrievedNumber = resultSet.getString("phoneNumber");
                    String retrievedName = resultSet.getString("firstName") + " " + resultSet.getString("lastName");
                    if(retrievedName.equals(name)){
                        number = retrievedNumber;
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("No Connection");
        }
        return number;
    }

    public static String getTeacherPhoneNumber(String name) {
        String number = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            statement = connection.prepareStatement("SELECT phoneNumber, firstName, lastName FROM teacher_primary_information");

            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while(resultSet.next()) {
                    String retrievedNumber = resultSet.getString("phoneNumber");
                    String retrievedName = resultSet.getString("firstName") + " " + resultSet.getString("lastName");
                    if(retrievedName.equals(name)){
                        number = retrievedNumber;
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("No Connection");
        }
        return number;
    }




    public static ObservableList<Teacher> getTeachersList() {
        ObservableList<Teacher> teachers = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = null;
            connection = DriverManager.getConnection(url, username, databasePassword);
            statement = null;
            String val = "SELECT firstName, lastName, institution, department, cgpa, currYearOfStudy, prefTuitionArea, prefSubject, salary FROM teacher_primary_information JOIN teacher_secondary_information ON teacher_secondary_information.id = teacher_primary_information.id";
            statement = connection.prepareStatement(val);
            resultSet = null;
            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while (resultSet.next()) {
                    String retrievedFirstName =  resultSet.getString("firstName");
                    String retrievedLastName =  resultSet.getString("lastName");
                    String retrievedUniversity = resultSet.getString("institution");
                    String retrievedDepartment = resultSet.getString("department");
                    String retrievedCGPA = resultSet.getString("cgpa");
                    String retrievedYear = resultSet.getString("currYearOfStudy");
                    teachers.add(new Teacher(retrievedFirstName,retrievedLastName, retrievedUniversity, retrievedDepartment, retrievedCGPA, retrievedYear));
                }
            }


        }
        catch (Exception e) {

        }
        return teachers;

    }

    public static ObservableList<Teacher> getTeachersList(String area, String subject, String salary) {
        ObservableList<Teacher> teachers = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = null;
            connection = DriverManager.getConnection(url, username, databasePassword);
            statement = null;
            String val = "SELECT firstName, lastName, institution, department, cgpa, currYearOfStudy, prefTuitionArea, prefSubject, salary FROM teacher_primary_information JOIN teacher_secondary_information ON teacher_secondary_information.id = teacher_primary_information.id";
            statement = connection.prepareStatement(val);
            resultSet = null;
            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while (resultSet.next()) {
                    String retrievedFirstName =  resultSet.getString("firstName");
                    String retrievedLastName =  resultSet.getString("lastName");
                    String retrievedUniversity = resultSet.getString("institution");
                    String retrievedDepartment = resultSet.getString("department");
                    String retrievedCGPA = resultSet.getString("cgpa");
                    String retrievedYear = resultSet.getString("currYearOfStudy");
                    String retrievedArea = resultSet.getString("prefTuitionArea");
                    String retrievedSubject = resultSet.getString("prefSubject");
                    String retrievedSalary = resultSet.getString("salary");

                    if (retrievedArea.equals(area) && retrievedSubject.equals(subject) && retrievedSalary.equals(salary) ) {
                        teachers.add(new Teacher(retrievedFirstName, retrievedLastName, retrievedUniversity, retrievedDepartment, retrievedCGPA, retrievedYear));
                    }
                }
            }


        }
        catch (Exception e) {
        }
        return teachers;

    }


    public static ObservableList<Student> getStudentsList(String teacherName) {
        ObservableList<Student> students = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = null;
            connection = DriverManager.getConnection(url, username, databasePassword);
            statement = null;
            String val = "SELECT teacher_name, student_name, phoneNumber FROM teacher_student";
            statement = connection.prepareStatement(val);
            resultSet = null;
            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while (resultSet.next()) {
                    String retrievedTeacherName = resultSet.getString("teacher_name");
                    String retrievedStudentName = resultSet.getString("student_name");

                    String retrievedPhoneNumber = resultSet.getString("phoneNumber");
                    if (retrievedTeacherName.equals(teacherName)) {
                        students.add(new Student(retrievedStudentName, retrievedPhoneNumber));
                    }
                }
            }


        }
        catch (Exception e) {
        }
        return students;

    }

    public static ObservableList<Teacher> getTeachersList2(String studentEmail) {
        ObservableList<Teacher> teachers = FXCollections.observableArrayList();
        String studentName = identifyStudent(studentEmail)[0];
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = null;
            connection = DriverManager.getConnection(url, username, databasePassword);
            statement = null;
            String val = "SELECT teacher_name, student_name, phoneNumber FROM teacher_student";
            statement = connection.prepareStatement(val);
            resultSet = null;
            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while (resultSet.next()) {
                    System.out.println(studentName);
                    String retrievedTeacherName = resultSet.getString("teacher_name");
                    String retrievedStudentName = resultSet.getString("student_name");

                    String retrievedPhoneNumber = resultSet.getString("phoneNumber");
                    if (retrievedStudentName.equals(studentName)) {
                        System.out.println(retrievedPhoneNumber + " " + retrievedTeacherName);
                        teachers.add(new Teacher(retrievedTeacherName, retrievedPhoneNumber));
                    }
                }
            }


        }
        catch (Exception e) {
        }
        return teachers;

    }

    public static String[] retrieveMessage(String teacherName, String studentName, boolean isStudent) {
        String[] messages = new String[2];
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            statement = connection.prepareStatement("SELECT * FROM teacher_student_messaging");

            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while(resultSet.next()) {
                    String retrievedTeacherName = resultSet.getString("teacher_name");
                    String retrievedStudentName = resultSet.getString("student_name");
                    String retrievedStudentMessage = resultSet.getString("student_message");
                    String retrievedTeacherMessage = resultSet.getString("teacher_message");

                    if(retrievedTeacherName.equals(teacherName) && retrievedStudentName.equals(studentName)){
                        flag = true;
                        messages[0] = retrievedTeacherMessage;
                        messages[1] = retrievedStudentMessage;
                    }
                }
                if (flag == false) {
                    messages[0] = "No Message To Show Yet";
                    messages[1] = "No Message To Show Yet";
                }
            }
        }
        catch (Exception e) {
            System.out.println("No Connection");
        }
        return messages;
    }
    public static void saveMessage(String teacherName, String studentName, String studentMessage, String teacherMessage) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            String sql;
            sql = "INSERT INTO teacher_student_messaging (teacher_name, student_name, student_message, teacher_message) VALUES (?, ?, ?, ?)";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, teacherName);
                statement.setString(2, studentName);
                statement.setString(3, studentMessage);
                statement.setString(4, teacherMessage);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        catch (Exception e) {

        }

    }

    public static void removeTeacher(String mobileNumber) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            String sql;
            sql = "DELETE from teacher_student WHERE phoneNumber = " + mobileNumber;
            try {
                statement = connection.prepareStatement(sql);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        catch (Exception e) {

        }
    }

    public static void updateClassSchedule(String email, String subject1, String subject2, String subject3, String subject4, String subject5, String subject6, String time1, String time2, String time3, String time4, String time5, String time6) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            try {
                System.out.println(subject3 + " " + time4);
                String sql = "INSERT INTO classroom_schedule (email, subject1, subject2, subject3, subject4, subject5, subject6, time1, time2, time3, time4, time5, time6) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                statement = connection.prepareStatement(sql);
                statement.setString(1, email);
                statement.setString(2, subject1);
                statement.setString(3, subject2);
                statement.setString(4, subject3);
                statement.setString(5, subject4);
                statement.setString(6, subject5);
                statement.setString(7, subject6);
                statement.setString(8, time1);
                statement.setString(9, time2);
                statement.setString(10, time3);
                statement.setString(11, time4);
                statement.setString(12, time5);
                statement.setString(13, time6);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("Some problem");
        }
    }

    public static String[] retrieveClassSchedule(String email) {
        String[] information = new String[15];
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, databasePassword);
            statement = connection.prepareStatement("SELECT * FROM classroom_schedule WHERE email = ? ");
            statement.setString(1, email);

            resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Database is empty");
            }
            else {
                while(resultSet.next()) {
                     information[0] = resultSet.getString("subject1");
                     information[1] = resultSet.getString("subject2");
                     information[2] = resultSet.getString("subject3");
                     information[3] = resultSet.getString("subject4");
                     information[4] = resultSet.getString("subject5");
                     information[5] = resultSet.getString("subject6");
                     information[6] = resultSet.getString("time1");
                     information[7] = resultSet.getString("time2");
                     information[8] = resultSet.getString("time3");
                     information[9] = resultSet.getString("time4");
                     information[10] = resultSet.getString("time5");
                     information[11] = resultSet.getString("time6");
                }

            }
        }
        catch (Exception e) {
            System.out.println("No Connection");
        }
        return information;
    }


}

