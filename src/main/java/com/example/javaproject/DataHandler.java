package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.*;

public class DataHandler {
    public static void EditProfileForTeacherPrimary(ActionEvent event, String email){
        Connection connection = null;
        PreparedStatement userInsert = null;
        PreparedStatement finduser = null;
        ResultSet resultSet = null;
        String username = "fahim";
        String url = "jdbc:mysql://127.0.0.1:3306/project";
        String databasePassword = "Baba733700!@#$%";

        try{
            connection = DriverManager.getConnection(url, username, databasePassword);
            finduser = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            finduser.setString(1,email );

            resultSet = finduser.executeQuery();

            if(!resultSet.isBeforeFirst()){
                System.out.println("Invalid email");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid email");
                alert.show();
            }
            else{
                while(resultSet.next()){
                    String findreg = resultSet.getString("email");

                    if(findreg.equals(email)){
                        userInsert = connection.prepareStatement("UPDATE users SET about = ? WHERE email = ?");
                        //userInsert.setString(1, text);
                        userInsert.setString(1, email);
                        userInsert.executeUpdate();
                        //setBio(Bio);
                    }
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (userInsert != null) {
                try {
                    userInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(finduser != null){
                try{
                    finduser.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try{
                    connection.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
