package com.example.icachatviewer.ui;

import com.example.icachatviewer.data.ChatMessage;
import com.example.icachatviewer.data.FileReader;
import com.example.icachatviewer.data.InvalidFormatException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ChatViewerController {

    @FXML
    private VBox root;
    @FXML
    private VBox instructionsBox;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Label instructionLabel1;
    @FXML
    private Label instructionLabel2;
    @FXML
    private TextFlow textFlow;
    @FXML
    private Label filePathLabel;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button openButton;
    @FXML
    private Button goBackButton;

    private MessageDisplay messageDisplay = new MessageDisplay();

    @FXML
    public void initialize() {
        textFlow.prefWidthProperty().bind(scrollPane.widthProperty().subtract(20));
        openButton.setOnAction(e -> openFile((Stage) openButton.getScene().getWindow()));
        goBackButton.setOnAction(e -> goBack()); // Handle go back button action
    }

    private void openFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Message Files", "*.msg"));
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            filePathLabel.setText(file.getPath());
            try {
                List<ChatMessage> messages = new FileReader().parse(file);
                messageDisplay.showMessages(textFlow, messages);
                rearrangeLayout(); // Rearrange layout after opening the file
            } catch (IOException ex) {
                showError("Error reading file: " + ex.getMessage());
            } catch (InvalidFormatException ex) {
                showError("Invalid file format: " + ex.getMessage());
            } catch (Exception ex) {
                showError("An unexpected error occurred: " + ex.getMessage());
            }
        }
    }

    private void rearrangeLayout() {
        root.getChildren().clear();
        root.getChildren().addAll(filePathLabel, goBackButton, scrollPane);
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        scrollPane.setVisible(true);
        goBackButton.setVisible(true);
    }

    private void goBack() {
        root.getChildren().clear();
        root.getChildren().addAll(instructionsBox, filePathLabel, openButton);
        scrollPane.setVisible(false);
        goBackButton.setVisible(false);
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
