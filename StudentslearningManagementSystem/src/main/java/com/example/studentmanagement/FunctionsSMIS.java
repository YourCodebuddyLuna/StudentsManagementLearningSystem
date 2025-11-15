package com.example.studentmanagement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FunctionsSMIS {

    public static void changePage(String fxmlFile, Node sourceNode) {
        try {
            Parent root = FXMLLoader.load(
                    FunctionsSMIS.class.getResource("/com/example/studentmanagement/" + fxmlFile)
            );

            Stage stage = (Stage) sourceNode.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            showError("Failed to load page: " + fxmlFile + "\n" + e.getMessage());
        }
    }

    public static void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    public static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
    }

    public static String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
    }
}
