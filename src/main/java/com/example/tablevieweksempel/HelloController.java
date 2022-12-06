package com.example.tablevieweksempel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    // Def. af tableview med Person-klassen
    @FXML
    private TableView<Person> minTabel = new TableView<Person>();

    // Def. af kolonnerne
    @FXML
    private TableColumn<Person, String> kolonneID = new TableColumn();

    @FXML
    private TableColumn<Person, String> kolonneNavn  = new TableColumn();

    // Def. af listen der holder dataene
    private final ObservableList<Person> data = FXCollections.observableArrayList();

    public void initialize() {
        // Kolonnerne sættes op med forbindelse til klassen Person med hver sit felt
        kolonneID.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
        kolonneNavn.setCellValueFactory(new PropertyValueFactory<Person, String>("navn"));

        // Data lægges i listen som objekterne af klassen Person
        data.add(new Person("1","Jacob"));
        data.add(new Person("2","Isabella"));
        data.add(new Person("3","Ethan"));
        data.add(new Person("4","Emma"));
        data.add(new Person("5","Michael"));

        // Data lægges over i tabellen
        minTabel.setItems(data);
    }
}
