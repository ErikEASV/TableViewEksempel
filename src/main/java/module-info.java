module com.example.tablevieweksempel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tablevieweksempel to javafx.fxml;
    exports com.example.tablevieweksempel;
}