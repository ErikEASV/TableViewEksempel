package com.example.tablevieweksempel;

public class Person {
    private int id;         // Vi lader id være en int, men sørger for konvertering til String aht. GUI.
    private String navn;

    public Person(int id1, String navn1) {
        id = id1;
        navn = navn1;
    }

    // Der skal være get-metoder for at tableview kan hente data
    public String getId() {
        return String.valueOf(id);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String n) {
        navn = n;
    }

    public void setId(String id1) {
        id = Integer.parseInt(id1);
    }


}

