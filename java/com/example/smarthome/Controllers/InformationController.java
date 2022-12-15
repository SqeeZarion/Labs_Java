package com.example.smarthome.Controllers;

import java.net.URL;

import com.example.smarthome.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class InformationController {

    @FXML
    private Pane pnlStatus;

    @FXML
    private Button btnDevice;

    @FXML
    private Button btnRoom;

    @FXML
    private Button btnUserSettings;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblStatusMini;

    @FXML
    private BorderPane mainPane;

    private Pane view;

    public Pane getPage(String fileName) {

        try {

            URL fileURL = Main.class.getResource(fileName);

            if (fileURL == null)
                throw new java.io.FileNotFoundException("FXML file can't be found");

            view = new FXMLLoader().load(fileURL);

        } catch (Exception e) {
            System.out.println("No page " + fileName + " check FXML loader");
        }

        return view;
    }

    @FXML
    void initialize() {
        assert btnDevice != null : "fx:id=\"btnDevice\" was not injected: check your FXML file 'Information.fxml'.";
        assert btnRoom != null : "fx:id=\"btnRoom\" was not injected: check your FXML file 'Information.fxml'.";
        assert btnUserSettings != null : "fx:id=\"btnUserSettings\" was not injected: check your FXML file 'Information.fxml'.";
        assert lblStatus != null : "fx:id=\"lblStatus\" was not injected: check your FXML file 'Information.fxml'.";
        assert lblStatusMini != null : "fx:id=\"lblStatusMini\" was not injected: check your FXML file 'Information.fxml'.";

    }

    @FXML
    private void handleClick(ActionEvent event) {

        if (event.getSource() == btnDevice) {

            lblStatusMini.setText("Entity/Device");
            lblStatus.setText("Device");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(63, 43, 99),
                    CornerRadii.EMPTY, Insets.EMPTY)));


            InformationController object = new InformationController();
            Pane view = object.getPage("Device.fxml");
            mainPane.setCenter(view);

        }

        if (event.getSource() == btnRoom) {

            lblStatusMini.setText("Entity/Room");
            lblStatus.setText("Room");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(63, 43, 63),
                    CornerRadii.EMPTY, Insets.EMPTY)));

            InformationController object = new InformationController();
            Pane view = object.getPage("Room.fxml");
            mainPane.setCenter(view);

        }

        if (event.getSource() == btnUserSettings) {

            lblStatusMini.setText("Entity/Setting");
            lblStatus.setText("Setting");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(99, 43, 99),
                    CornerRadii.EMPTY, Insets.EMPTY)));

            InformationController object = new InformationController();
            Pane view = object.getPage("UserSetting.fxml");
            mainPane.setCenter(view);
        }
    }
}
