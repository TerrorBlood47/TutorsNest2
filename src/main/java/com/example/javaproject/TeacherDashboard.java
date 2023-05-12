package com.example.javaproject;

import java.util.ArrayList;

public class TeacherDashboard  {

    ArrayList<String>mobileNumberList;

    ArrayList<String>studentsNameList;

    public String getStudentNameFromList(int id){
            return studentsNameList.get(id);
    }

    public String mobileNumberofTheStudent(int id){
           return  mobileNumberList.get(id);
    }

}
