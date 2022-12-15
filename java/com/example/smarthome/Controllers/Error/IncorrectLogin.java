package com.example.smarthome.Controllers.Error;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IncorrectLogin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonEnter;

    @FXML
    void ButtonEnter(ActionEvent event) {
            ButtonEnter.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
        assert ButtonEnter != null : "fx:id=\"ButtonEnter\" was not injected: check your FXML file 'IncorrectLogin.fxml'.";

    }

}
