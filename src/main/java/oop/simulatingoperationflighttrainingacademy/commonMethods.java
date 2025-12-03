package oop.simulatingoperationflighttrainingacademy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class commonMethods {
    public static void showError(String titleMessage, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titleMessage);
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
    public static void showInformation(String titleMessage, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleMessage);
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
    public static void showConfirmation(String titleMessage, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titleMessage);
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
    public static void sceneChange(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(FlightAcademyStimulator.class.getResource(fxmlFile));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Flight Academy Simulator");
            stage.setScene(nextScene);
            stage.show();

        } catch (IOException e) {
            showError("Scene Load Error", "Could not load: " + fxmlFile);
            System.out.println("Error: " + e.getMessage());

        }
    }
    public static <ModelClass> void saveToBinFile(String fileName, List<ModelClass> dataList) {
        try {
            File file =  new File("data/" + fileName);
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new ObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            for (ModelClass m : dataList) {
                oos.writeObject(m);
            }
            oos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }






}