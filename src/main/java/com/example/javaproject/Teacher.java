package com.example.javaproject;

public class Teacher  extends Person implements TeacherInterface{
    String teacherName;
    @Override
    public String getUniversity() {
        return university;
    }

    @Override
    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getCgpa() {
        return cgpa;
    }

    @Override
    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String getYear() {
        return year;
    }

    @Override
    public void setYear(String year) {
        this.year = year;
    }

    public Teacher(String firstname, String lastname,String email, String password, String mobileNumber,String university, String department, String cgpa, String year) {
        super(firstname, lastname,email, password, mobileNumber);
        this.university = university;
        this.department = department;
        this.cgpa = cgpa;
        this.year = year;
    }

    public Teacher(String name,String university, String department, String cgpa, String year) {
        super();
        //this.firstname = name;///////ekhane firstname o pathaite hobe
        this.lastname = name;
        this.university = university;
        this.department = department;
        this.cgpa = cgpa;
        this.year = year;
    }
    public Teacher(String name, String mobileNumber) {
        super();
        //this.firstname = name;///////ekhane firstname o pathaite hobe
        this.lastname = name;
        this.mobileNumber = mobileNumber;
        System.out.println(lastname);
    }
    public Teacher(String firstname ,String lastname,String university, String department, String cgpa, String year) {
        super();
        this.firstname = firstname;///////ekhane firstname o pathaite hobe
        this.lastname = lastname;
        this.university = university;
        this.department = department;
        this.cgpa = cgpa;
        this.year = year;
    }
    private String university;
    private String department;
    private String cgpa;
    private String year;
    private String mobileNumber;

    @Override
    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return lastname;
    }

}
