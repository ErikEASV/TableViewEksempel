package com.example.tablevieweksempel;

// Version med simple properties...
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person1 {
    // Bemærk at attributterne er defineret som "SimpleIntegerProperty" og "SimpleStringProperty" for at tableview kan få fat i dem til kolonner
    private SimpleIntegerProperty id;
    private SimpleStringProperty navn;

    public Person1(int id1, String navn1) {
        id = new SimpleIntegerProperty(id1);
        navn = new SimpleStringProperty(navn1);
    }

    // Der skal være get-metoder for at tableview kan hente data
    public String getId() {
        return String.valueOf(id.get());
    }

    public String getNavn() {
        return navn.get();
    }

    public void setNavn(String n) {
        navn.set(n);
    }

    public void setId(String id1) {
        id.set(Integer.parseInt(id1));
    }


}

