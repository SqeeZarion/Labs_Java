package com.example.smarthome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("com/example/javafxdemo/sql.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.setTitle("Start window!");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void showEmptyData() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Parent root = FXMLLoader.load(Main.class.getResource("ErrorAllInputLogin.fxml"));
        Stage stage = new Stage();

        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public static void showLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Parent root = FXMLLoader.load(Main.class.getResource("Login.fxml"));
        Stage stage = new Stage();
        stage.getIcons().add(new Image("http://t0.gstatic.com/licensed-image?q=tbn:ANd9GcRVhjNNpCrRRbLbovpJmghyPzdWVg9_6spz6Zk9F5-DIdzLGtfgrYEljbGOwzjCbcHiVFlFNfeaAsSwauRVPUs"));
        stage.setTitle("ComplexWorkCW!");

        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void SwitchScene(String str, Button but, Boolean hide) {
        if (hide)
            but.getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(str));

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setTitle("Smart Home");
        stage.setScene(new Scene(fxmlLoader.getRoot()));
        stage.getIcons().add(new Image("http://t0.gstatic.com/licensed-image?q=tbn:ANd9GcRVhjNNpCrRRbLbovpJmghyPzdWVg9_6spz6Zk9F5-DIdzLGtfgrYEljbGOwzjCbcHiVFlFNfeaAsSwauRVPUs"));
        stage.setResizable(false);
        stage.show();
    }

    ;

    public static void main(String[] args) {
        launch(args);
    }
}