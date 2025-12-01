package oop.simulatingoperationflighttrainingacademy;

import javafx.scene.control.Alert;

public class commonMethods {
    public static void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Input Error");
        alert.setContentText(msg);
        alert.showAndWait();
    }






}