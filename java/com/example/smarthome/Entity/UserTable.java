package com.example.smarthome.Entity;

public class UserTable {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;


    public UserTable() {
    }

    public UserTable(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;

    }

    public String getFirstName() {
        return firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
