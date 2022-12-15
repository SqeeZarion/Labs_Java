package com.example.smarthome.Controllers.Error;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EmptyData {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnOk;

    @FXML
    void ButtonEnter(ActionEvent event) {
        btnOk.getScene().getWindow().hide();
    }


    @FXML
    void initialize() {
        btnOk.setOnAction(event -> {
            btnOk.getScene().getWindow().hide();
        });
    }

}
