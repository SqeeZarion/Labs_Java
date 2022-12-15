package com.example.smarthome.Controllers.Add;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.example.smarthome.DataBase.DBConnection;
import com.example.smarthome.DataBase.DeviceRepository;
import com.example.smarthome.DataBase.RoomRepository;
import com.example.smarthome.Entity.Device;
import com.example.smarthome.Entity.Room;
import com.example.smarthome.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddDeviceController {

    private final ObservableList<Room> roomList = FXCollections.observableArrayList();

    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtCapacity;

    @FXML
    private Button btnGoBack;

    @FXML
    private ComboBox<Room> RoomList;

    @FXML
    void btnGoBackMethod(ActionEvent event) {
        Main.SwitchScene("Information.fxml", btnGoBack, true);
    }

    @FXML
    void btnAddMethod(ActionEvent event) throws IOException {

        String name = txtName.getText().trim();
        String model = txtModel.getText().trim();
        String capacity = txtCapacity.getText().trim();

        if (!name.equals("") && !model.equals("") && !capacity.equals("")) {
            try {
                addDevice();
            } catch (SQLException e) {

                e.printStackTrace();
            }
            Main.SwitchScene("Information.fxml", btnAdd, true);
        } else
            Main.showEmptyData();


    }

    private void addDevice() throws SQLException {
        DeviceRepository deviceRepository = new DeviceRepository(DBConnection.URL);

        String name = txtName.getText();
        String model = txtModel.getText();
        int capacity = Integer.parseInt(txtCapacity.getText());

        Room room = RoomList.getValue();
        int roomId = room.getId();

        String isConnected = "No";
        Device device = new Device(name, model, capacity, isConnected, roomId);

        deviceRepository.addDevice(device);

    }

    @FXML
    void initialize() throws SQLException {
        RoomRepository rr = new RoomRepository(DBConnection.URL);

        List<Room> rooms = rr.getAllRooms();
        roomList.addAll(rooms);

        RoomList.setItems(roomList);
        RoomList.setId("id");

    }
}