package com.example.icachatviewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatViewer extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            VBox root = FXMLLoader.load(getClass().getResource("/com/example/icachatviewer/ChatViewerView.fxml"));
            Scene scene = new Scene(root, 600, 400);
            scene.getStylesheets().add(getClass().getResource("/com/example/icachatviewer/styles.css").toExternalForm());

            primaryStage.setTitle("Chat Viewer");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
