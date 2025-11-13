package com.example.tablevieweksempel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TableviewExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TableviewExample.class.getResource("TableviewExampleView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TableView eksempel");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    // Detekterer stop i Javafx.
    @Override
    public void stop(){
        System.out.println("Tak for i dag");
    }
}