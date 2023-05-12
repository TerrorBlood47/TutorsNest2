package com.example.javaproject;

public class StudentDashboard {

    protected String prefTuitionArea;     /////pore private banaite hobe
    protected String salary;
    protected String prefSubject;
    protected Teacher teacherSelected;

    StudentDashboard(){

    }


    public void setPrefSubject(String prefSubject){
        this.prefSubject = prefSubject;
    }

    public void setPrefTuitionArea(String prefTuitionArea){
        this.prefTuitionArea= prefTuitionArea;
    }

    public void setSalary(String salary){
        this.salary = salary;
    }

    public void setTeacherSelected(Teacher teacherSelected){
        this.teacherSelected = teacherSelected;
    }

    public String getPrefSubject(){return this.prefSubject;}

    public String getPrefTuitionArea(){return this.prefTuitionArea;}

    public String  getSalary(){return this.salary;}

    public Teacher getTeacherSelected(){return this.teacherSelected;}



}
