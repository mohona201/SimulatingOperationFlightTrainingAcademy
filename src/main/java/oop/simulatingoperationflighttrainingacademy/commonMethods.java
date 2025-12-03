package oop.simulatingoperationflighttrainingacademy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.*;
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
                oos = new AppendableObjectOuputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            for (ModelClass m : dataList) {
                oos.writeObject(m);
            }
            oos.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            showError("Save Error", "Could not save data: " + fileName);
        }
    }


    public static <MethodClass> void showTableDataFromBinFile(String fileName, TableView<MethodClass> table){
        ObjectInputStream ois = null;
        try {
            File file = new File("data/" + fileName);
            FileInputStream fis = null;
            if (file.exists()) {
                fis = new FileInputStream(file);
            } else {
                showError("Load Error", "Could not load: " + fileName);
            }

            if (fis != null) {
                ois = new ObjectInputStream(fis);

                while (true) {
                    table.getItems().add((MethodClass) ois.readObject());
                }
            }

        } catch (EOFException eof) {
            // normal: reached end of file, exit loop
        } catch (Exception e) {
            System.out.println("Error while reading file: " + e.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ignore) {}
            }
        }
    }

    public static <MethodClass> boolean existsInBinFile(String fileName, String valueToCheck){
        ObjectInputStream ois = null;
        try {
            File file = new File("data/" + fileName);
            FileInputStream fis = null;
            if (file.exists()) {
                fis = new FileInputStream(file);
            } else {
                showError("Load Error", "Could not load: " + fileName);
                return false;
            }

            if (fis != null) {
                ois = new ObjectInputStream(fis);

                while (true) {
                    MethodClass obj = (MethodClass) ois.readObject();

                    if (obj.toString().contains(valueToCheck)) {
                        return true;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
        return false;
    }



}