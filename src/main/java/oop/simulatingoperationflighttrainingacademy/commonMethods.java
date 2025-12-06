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
        }
    }

    public static <T> void saveToBinFile(String fileName, List<T> dataList) {
        try {
            File dir = new File("data");
            if (!dir.exists()) dir.mkdir();

            File file = new File("data/" + fileName);

            FileOutputStream fos;
            ObjectOutputStream oos;

            if (!file.exists() || file.length() == 0) {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            }

            for (T m : dataList) {
                oos.writeObject(m);
            }

            oos.close();

        } catch (Exception e) {
            showError("Save Error", "Could not save data: " + fileName);
        }
    }

    public static <T> void showTableDataFromBinFile(String fileName, TableView<T> table) {
        try {
            File file = new File("data/" + fileName);

            if (!file.exists() || file.length() == 0) return;

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    table.getItems().add((T) ois.readObject());
                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    public static <T> boolean existsInBinFile(String fileName, String valueToCheck) {
        try {
            File file = new File("data/" + fileName);

            if (!file.exists() || file.length() == 0) return false;

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    T obj = (T) ois.readObject();
                    if (obj.toString().contains(valueToCheck)) return true;
                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error checking file: " + e.getMessage());
        }

        return false;
    }

    static class AppendableObjectOutputStream extends ObjectOutputStream {

        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
        }
    }
}

