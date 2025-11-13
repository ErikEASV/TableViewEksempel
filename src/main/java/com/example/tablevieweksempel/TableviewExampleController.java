package com.example.tablevieweksempel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.Optional;

public class TableviewExampleController {
    // Def. af tableview med Person-klassen
    @FXML
    private TableView<Person> minTabel = new TableView<Person>();

    // Def. af kolonnerne
    @FXML
    private TableColumn<Person, String> kolonneID = new TableColumn(); // Property virker nemmest med String, da felter i GUI altid er strings

    @FXML
    private TableColumn<Person, String> kolonneNavn  = new TableColumn();

    // Def. af listen der holder dataene
    private final ObservableList<Person> tabeldata = FXCollections.observableArrayList();

    public void initialize() {
        //minTabel.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Kolonnerne sættes op med forbindelse til klassen Person med hver sit felt
        kolonneID.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
        kolonneNavn.setCellValueFactory(new PropertyValueFactory<Person, String>("navn"));

        // Data lægges i listen (ObservableList) som objekterne af klassen Person
        tabeldata.add(new Person(1,"Jacob"));
        tabeldata.add(new Person(3,"Isabella"));
        tabeldata.add(new Person(6,"Else"));
        tabeldata.add(new Person(4,"Emma"));
        tabeldata.add(new Person(4,"Michael"));
        tabeldata.add(new Person(1,"Nanna"));
        tabeldata.add(new Person(8,"Nana"));
        tabeldata.add(new Person(2,"Bella"));
        tabeldata.add(new Person(4,"Neo"));
        tabeldata.add(new Person(4,"Bea"));

        // Data lægges over i tabellen
        minTabel.setItems(tabeldata);

        // Sortér som udgangspunkt efter id
        kolonneID.setSortType(TableColumn.SortType.ASCENDING);
        kolonneNavn.setSortType(TableColumn.SortType.DESCENDING);
        minTabel.getSortOrder().add(kolonneID);
        minTabel.getSortOrder().add(kolonneNavn);
        minTabel.sort();

        // Gør tabellen redigerbar direkte i cellerne
        minTabel.setEditable(true);

        // Opsætning af kode der aktiveres ved "commit"(enter) af et felt i en række. Husk også at sortere.
        kolonneID.setCellFactory(TextFieldTableCell.forTableColumn());
        kolonneID.setOnEditCommit(event -> {
            Person person = event.getRowValue();
            person.setId(event.getNewValue());
            minTabel.sort();
        });
        kolonneNavn.setCellFactory(TextFieldTableCell.forTableColumn());
        kolonneNavn.setOnEditCommit(event -> {
            Person person = event.getRowValue();
            person.setNavn(event.getNewValue());
            minTabel.sort();
        });
        // ---

    }

    // Rediger ved dobbeltklik og åben redigervindue
    @FXML
    public void museklik(MouseEvent event) {
        // Check for dobbeltklik
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
            Person p = minTabel.getSelectionModel().getSelectedItem();
            if (p != null)
                redigerLinje(p);
        }
    }

    @FXML
    public void erSorteret(SortEvent<TableView<Person>> tableViewSortEvent) {
        // Event der reagerer på når der sker en sortering
        System.out.println("Sorteret");
    }

    // Når der trykkes på "Fjern linje"-knappen så slettes linjen
    @FXML
    public void fjernLinje(ActionEvent actionEvent) {
        try {
            tabeldata.remove(minTabel.getSelectionModel().getSelectedIndex());
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("listen er tom");
        }
    }

    // Rediger ved at åbne modalt dialogvindue med data i.
    private void redigerLinje(Person p1) {
        // Lav vinduet som en dialog med to tekstfelter med data
        Dialog<ButtonType> dialogvindue = new Dialog();
        dialogvindue.setTitle("Rediger person");
        dialogvindue.setHeaderText("Person");
        dialogvindue.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField idfelt = new TextField();
        TextField navnefelt = new TextField();
        VBox box = new VBox(idfelt, navnefelt);
        dialogvindue.getDialogPane().setContent(box);

        // Sæt data i felterne fra personobjektet p1
        idfelt.setText(p1.getId());
        navnefelt.setText(p1.getNavn());

        // Her afsluttes dialogen med at man kan trykke på OK
        Optional<ButtonType> knap = dialogvindue.showAndWait();

        // Hvis man trykker OK gemmes data fra felterne og tabellen opdateres
        if (knap.get() == ButtonType.OK) {
            p1.setId(idfelt.getText());
            p1.setNavn(navnefelt.getText());
            minTabel.refresh();   // refresh er nødvendig... hvorfor?
            minTabel.sort();
        }
    }

}
