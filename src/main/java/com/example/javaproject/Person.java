package com.example.javaproject;

public class Person { //an abstract class



        protected  String  firstname;
        protected String lastname;
        protected  String email;
        protected String  password;
        protected String mobileNumber;

        public Person(String firstname, String lastname,String email, String password, String mobileNumber) {
                this.firstname = firstname;
                this.lastname = lastname;
                this.email = email;
                this.password = password;
                this.mobileNumber = mobileNumber;
        }

        public Person(String name, String phonenumber) {

                this.lastname = name;
                this.mobileNumber = phonenumber;
        }

        public Person() {

        }

        public String getFirstname() {
                return firstname;
        }

        public void setFirstname(String firstname) {
                this.firstname = firstname;
        }

        public String getLastname() {
                return lastname;
        }

        public void setLastname(String lastname) {
                this.lastname = lastname;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }


        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getMobileNumber() {
                return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
                this.mobileNumber = mobileNumber;
        }





}
