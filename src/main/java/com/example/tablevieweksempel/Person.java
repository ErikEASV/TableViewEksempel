package com.example.tablevieweksempel;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    // Bemærk at attributterne er defineret som "SimpleStringProperty" for at tableview kan få fat i dem til kolonner
    private SimpleStringProperty id;
    private SimpleStringProperty navn;

    public Person(String id1, String navn1) {
        id = new SimpleStringProperty(id1);
        navn = new SimpleStringProperty(navn1);
    }

    // Derskal være get-metoder for at tableview kan hente data
    public String getId() {
        return id.get();
    }

    public String getNavn() {
        return navn.get();
    }
}

