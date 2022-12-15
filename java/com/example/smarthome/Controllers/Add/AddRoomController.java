package com.example.smarthome.Controllers.Add;

import com.example.smarthome.DataBase.DBConnection;
import com.example.smarthome.DataBase.RoomRepository;
import com.example.smarthome.Entity.Room;
import com.example.smarthome.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;


public class AddRoomController {

    @FXML
    private Button btnAddRoom;

    @FXML
    private TextField txtCountOfSockets;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSquareMeters;

    @FXML
    private Button btnGoBack;

    @FXML
    void btnGoBackMethod(ActionEvent event) {
        Main.SwitchScene("Information.fxml", btnGoBack, true);
    }


    @FXML
    void btnAddRoomMethod(ActionEvent event) throws IOException {

        String name = txtName.getText().trim();
        String countOfSockets = txtCountOfSockets.getText().trim();
        String squareMeters = txtSquareMeters.getText().trim();

        if (!name.equals("") && !countOfSockets.equals("") && !squareMeters.equals("")) {
            try {
                addRoom();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Main.SwitchScene("Information.fxml", btnAddRoom, true);
        } else
            Main.showEmptyData();

    }

    private void addRoom() throws SQLException {
        RoomRepository roomRepository = new RoomRepository(DBConnection.URL);

        String name = txtName.getText();
        Integer countOfSockets = Integer.valueOf(txtCountOfSockets.getText());
        Integer squareMeters = Integer.valueOf(txtSquareMeters.getText());
        Room room = new Room(name, countOfSockets, squareMeters);
        roomRepository.addRoom(room);
    }

    @FXML
    void initialize() {

    }
}