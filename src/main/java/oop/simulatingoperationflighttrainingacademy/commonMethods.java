package oop.simulatingoperationflighttrainingacademy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    public static void saveToTextFile(String fileName, String data) {
        try {
            File folder = new File("data");
            if (!folder.exists()) folder.mkdirs();
            File file = new File(folder, fileName);
            if (!file.exists()) file.createNewFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e) {
            showError("Save File Error", "Could not save to: " + fileName);
            System.out.println("Error saving to file: " + fileName);
            System.out.println("Error: " + e.getMessage());
        }
    }

//    public static ArrayList<String[]> readData(String filePath, String separator) {
//        ArrayList<String[]> dataList = new ArrayList<>();
//
//        try {
//            File file = new File("data" + filePath);
//            Scanner scan = new Scanner(file);
//
//            while (scan.hasNextLine()) {
//                String line = scan.nextLine().trim();
//                if (line.isEmpty()) continue;
//
//                String[] tokens = line.split(separator);
//
//                for (int i = 0; i < tokens.length; i++) {
//                    tokens[i] = tokens[i].trim();
//                }
//
//                dataList.add(tokens);
//            }
//
//            scan.close();
//        } catch (Exception e) {
//            System.out.println("File read error: " + e.getMessage());
//        }
//
//        return dataList;
//    }

}