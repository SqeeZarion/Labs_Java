package com.example.smarthome.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.smarthome.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserSettingController {

    @FXML
    private Button butSwitchLogin;

    @FXML
    private Button butSwitchPassword;

    @FXML
    void initialize() {
        butSwitchLogin.setOnAction(Event -> {
            Main.SwitchScene("SwitchLog.fxml", butSwitchLogin,true);
        });

        butSwitchPassword.setOnAction(Event -> {
            Main.SwitchScene("SwitchPass.fxml", butSwitchPassword,true);
        });

    }
}
