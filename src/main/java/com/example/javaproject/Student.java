package com.example.javaproject;

public class Student extends Person implements StudentInterface{
    protected String studentName;
    private String institution;
    
    private String cla_ss;

    public Student(String firstname,String lastname,String email, String password, String mobileNumber,String institution, String cla_ss) {
        super(firstname,lastname,email,password,mobileNumber);
        this.institution = institution;
        this.cla_ss = cla_ss;
        studentName = firstname+" "+lastname;
    }

    public Student(String name, String phonenumber){
        super(name,phonenumber);
        studentName = name;
    }

    @Override
    public String getInstitutionName() {
        return institution;
    }

    @Override
    public String getClassName() {
        return cla_ss;
    }
}
