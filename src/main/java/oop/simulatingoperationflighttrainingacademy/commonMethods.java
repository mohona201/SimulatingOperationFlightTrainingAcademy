package oop.simulatingoperationflighttrainingacademy;

import javafx.scene.control.Alert;

public class commonMethods {
    public static void showAlert(Alert.AlertType alertType, String titleMessage, String errorMessage) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titleMessage);
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}