package com.example.smarthome.DataBase;

import com.example.smarthome.Entity.UserTable;

import java.sql.*;

public class UserRepository {

    private final String url;
    private Connection con = null;

    public UserRepository(String url) {
        this.url = url;
    }

    public  void signUpUser(UserTable user) throws SQLException {

        String insert = "INSERT INTO UserTable  (firstName,lastName,userName,password) VALUES(?,?,?,?)";

        try (Connection con = DriverManager.getConnection(url)) {

            try (PreparedStatement pst = con.prepareStatement(insert)) {
                pst.setString(1, user.getFirstName());
                pst.setString(2, user.getLastName());
                pst.setString(3, user.getUserName());
                pst.setString(4, user.getPassword());
                pst.execute();
            }
        }
    }
    public int getUser(UserTable userTable) throws SQLException {
        String select = "SELECT * FROM UserTable WHERE userName=? and password=?";
        int counter = 0;
        try (Connection con = DriverManager.getConnection(url);) {
            try (PreparedStatement pst = con.prepareStatement(select);) {
                pst.setString(1, userTable.getUserName());
                pst.setString(2, userTable.getPassword());
                try (ResultSet resSet = pst.executeQuery()) {
                    if(resSet.next()){
                        counter++;
                    }
                }
                return  counter;
            }
        }
    }
    public int findUser(String login) throws SQLException {
        String select = "SELECT COUNT(*) FROM UserTable WHERE userName=?"; // порівнює з логіном
        int counter = 0;
        try (Connection con = DriverManager.getConnection(url);) { // конект до бд
            try (PreparedStatement pst = con.prepareStatement(select);) { // підготовлює запит до бд
                pst.setString(1, login); // вставляє замість ?
                try (ResultSet resSet = pst.executeQuery()) { //виконує запит
                    if(resSet.next()){  //заповнюється рядок у бд
                        counter++;
                    }
                }
                return  counter;
            }
        }
    }
    public int changeLogin(String login,String newLogin) throws SQLException {
        String update = "UPDATE UserTable SET userName =? where userName = ?"; //оновлює значення в таблиці
        try (Connection con = DriverManager.getConnection(url);) { // конект до бд
            try (PreparedStatement pst = con.prepareStatement(update);) { // підготовлює запит до бд
                pst.setString(1, newLogin); //вставляє замість ?
                pst.setString(2, login); //вставляє замість ?
                int i = pst.executeUpdate();
                return i;
                }
            }
        }

    public int changePassword(String password,String newPassword,String login) throws SQLException {
        String update = "UPDATE UserTable SET password =? where password = ? and userName = ?";
        try (Connection con = DriverManager.getConnection(url);) {
            try (PreparedStatement pst = con.prepareStatement(update);) {
                pst.setString(1, newPassword);
                pst.setString(2, password);
                pst.setString(3, login);
                int i = pst.executeUpdate();
                return i;
            }
        }
    }
}



