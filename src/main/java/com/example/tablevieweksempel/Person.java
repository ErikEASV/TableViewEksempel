package com.example.tablevieweksempel;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty id;
    private SimpleStringProperty navn;

    public Person(String id1, String navn1) {
        id = new SimpleStringProperty(id1);
        navn = new SimpleStringProperty(navn1);
    }

    public String getId() {
        return id.get();
    }

    public String getNavn() {
        return navn.get();
    }
}

