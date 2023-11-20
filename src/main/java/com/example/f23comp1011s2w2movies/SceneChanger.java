package com.example.f23comp1011s2w2movies;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneChanger {
    public static void changeScenes(ActionEvent event, String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));

        // Get the stage object from the event that was passed in
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScenes(ActionEvent event, String fxmlFileName, String movieId) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));

        // Get the stage object from the event that was passed in
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

        // Pass the movieId to the controller using the interface
        LoadMovie controller = fxmlLoader.getController();
        controller.loadMovie(movieId);

        stage.setScene(scene);
        stage.show();
    }
}
