module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.smarthome to javafx.  fxml;
    exports com.example.smarthome;
    exports com.example.smarthome.Controllers;
    opens com.example.smarthome.Controllers to javafx.fxml;
    exports com.example.smarthome.DataBase;
    opens com.example.smarthome.DataBase to javafx.fxml;
    exports com.example.smarthome.Entity;
    opens com.example.smarthome.Entity to javafx.fxml;
    exports com.example.smarthome.Controllernotuse;
    opens com.example.smarthome.Controllernotuse to javafx.fxml;
    exports com.example.smarthome.Controllers.Error;
    opens com.example.smarthome.Controllers.Error to javafx.fxml;
    exports com.example.smarthome.Start;
    opens com.example.smarthome.Start to javafx.fxml;
    exports com.example.smarthome.Controllers.Delete;
    opens com.example.smarthome.Controllers.Delete to javafx.fxml;
    exports com.example.smarthome.Controllers.Add;
    opens com.example.smarthome.Controllers.Add to javafx.fxml;

}