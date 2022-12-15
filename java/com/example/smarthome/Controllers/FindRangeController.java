package com.example.smarthome.Controllers;

import com.example.smarthome.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class FindRangeController {

    @FXML
    private Button butAccept;

    @FXML
    private Button butCancel;

    @FXML
    private TextField tfX1;

    @FXML
    private TextField tfX2;

    @FXML
    void butAcceptMethod(ActionEvent event) throws IOException {
        String min =tfX1.getText();
        String max = tfX2.getText();
        if(!min.equals("") && !max.equals("")) {
            DevicesInRangeController deviceInRangeController = new DevicesInRangeController(Integer.parseInt(min),Integer.parseInt(max));
            butAccept.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("DevicesInRange.fxml"));
            fxmlLoader.setController(deviceInRangeController);
            try {
                fxmlLoader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Device in range");
            stage.setScene(new Scene(fxmlLoader.getRoot()));
            stage.getIcons().add(new Image("http://t0.gstatic.com/licensed-image?q=tbn:ANd9GcRVhjNNpCrRRbLbovpJmghyPzdWVg9_6spz6Zk9F5-DIdzLGtfgrYEljbGOwzjCbcHiVFlFNfeaAsSwauRVPUs"));
            stage.setResizable(false);
            stage.show();
        }
        else
            Main.showEmptyData();

    }

    @FXML
    void butCancelMethod(ActionEvent event) {
        Main.SwitchScene("Information.fxml",butCancel,true);
    }

}