package com.example.smarthome.Start;

import com.example.smarthome.DataBase.DBConnection;
import com.example.smarthome.DataBase.UserRepository;
import com.example.smarthome.Entity.UserTable;
import com.example.smarthome.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Button ButtonEnter;

    @FXML
    private Button ButtonRegister;

    @FXML
    private Label lblErrors;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void EnterMethod(ActionEvent event) throws SQLException, IOException {

        String loginText =  txtUsername.getText().trim();
        String passwordText = txtPassword.getText().trim();
        if(!loginText.equals("") && !passwordText.equals(""))
                loginUser(loginText,passwordText);

         else if(!loginText.equals("") || !passwordText.equals(""))
            Main.SwitchScene("ErrorAllInputLogin.fxml",ButtonEnter,false);
        else
            Main.SwitchScene("ErrorAllInputLogin.fxml",ButtonEnter,false);

    }

    @FXML
    void RegisterMethod(ActionEvent event) throws IOException {

        ButtonRegister.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();

        Parent root = FXMLLoader.load(Main.class.getResource("Registration.fxml"));
        Stage stage = new Stage();

        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("http://t0.gstatic.com/licensed-image?q=tbn:ANd9GcRVhjNNpCrRRbLbovpJmghyPzdWVg9_6spz6Zk9F5-DIdzLGtfgrYEljbGOwzjCbcHiVFlFNfeaAsSwauRVPUs"));
        stage.setTitle("Register window!");
        stage.showAndWait();
    }

    private void loginUser(String loginText, String passwordText) throws SQLException, IOException {
        UserRepository userRepository = new UserRepository(DBConnection.URL);


        UserTable user = new UserTable();
        user.setUserName(loginText);
        user.setPassword(passwordText);
        int counter = userRepository.getUser(user);
        if(counter >= 1){
            ButtonRegister.getScene().getWindow().hide();

            Parent root = FXMLLoader.load(Main.class.getResource("Information.fxml"));
            Stage stage = new Stage();
            stage.getIcons().add(new Image("http://t0.gstatic.com/licensed-image?q=tbn:ANd9GcRVhjNNpCrRRbLbovpJmghyPzdWVg9_6spz6Zk9F5-DIdzLGtfgrYEljbGOwzjCbcHiVFlFNfeaAsSwauRVPUs"));
            stage.setScene(new Scene(root));
            stage.setTitle("Information window!");
            stage.showAndWait();
        }
        else
            Main.SwitchScene("IncorrectLogin.fxml",ButtonRegister,false);

    }

    @FXML
    void initialize() {
        assert ButtonEnter != null : "fx:id=\"ButtonEnter\" was not injected: check your FXML file 'Registration.fxml'.";
        assert ButtonRegister != null : "fx:id=\"ButtonRegister\" was not injected: check your FXML file 'Registration.fxml'.";
        assert lblErrors != null : "fx:id=\"lblErrors\" was not injected: check your FXML file 'Registration.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Registration.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'Registration.fxml'.";

    }

}
