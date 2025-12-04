package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

public class regularPatientsController {

    @FXML
    private TextArea notesTextArea;
    @FXML
    private Label notificationLabel;
    @FXML
    private TextField patientIdTextField;
    @FXML
    private TableColumn<RegularPatient, LocalDate> lastVisitTableColumn;
    @FXML
    private TableColumn<RegularPatient, String> healthStatusTableColumn;
    @FXML
    private TableColumn<RegularPatient, Integer> patientIdTableColumn;
    @FXML
    private Label updateStatusLabel;
    @FXML
    private TableColumn<RegularPatient, String> patientNameTableColumn;
    @FXML
    private TextField patientNameTextField;
    @FXML
    private TableView <RegularPatient>regularPatientsTableView;


    @FXML
    public void initialize() {
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        healthStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("healthStatus"));
        lastVisitTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastVisit"));
    }

    @FXML
    public void saveNotesOnActionButton(ActionEvent actionEvent) {
         regularPatientsTableView.getItems().clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader("regularPatients.txt"));

            // just reading two lines as you wrote
            String line = br.readLine();
            String line2 = br.readLine();

            br.close();

            notificationLabel.setText("Patient record loaded.");
            updateStatusLabel.setText("Search completed.");

        } catch (Exception e) {
            notificationLabel.setText("Could not load regularPatients.txt");
            updateStatusLabel.setText("Search failed.");
            showError("File loading failed. Could not read regularPatients.txt");
        }
    }


    @FXML
    public void searchPatientOnActionButton(ActionEvent actionEvent) {

        String id = patientIdTextField.getText();
        String name = patientNameTextField.getText();
        String notes = notesTextArea.getText();

        if (id.isEmpty() || name.isEmpty() || notes.isEmpty()) {
            updateStatusLabel.setText("Please fill all fields.");
            notificationLabel.setText("Missing data for notes.");
            showError("All fields (ID, Name, Notes) must be filled.");
            return;
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("regularPatientsNotes.txt", true));

            bw.write(id + "," + name + "," + notes);
            bw.newLine();
            bw.close();

            updateStatusLabel.setText("Notes saved.");
            notificationLabel.setText("Patient notes stored.");

        } catch (Exception e) {
            updateStatusLabel.setText("Saving failed.");
            notificationLabel.setText("Unable to write notes.");
            showError("Could not save notes to regularPatientsNotes.txt");
        }
    }


    @FXML
    public void vaccinationsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/vaccination.fxml");

    }

    @FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalSpecialistDashboard.fxml");
    }

    @FXML
    public void renewalsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/renewal.fxml");
    }

    @FXML
    public void suspensionsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/suspension.fxml");

    }

    @FXML
    public void incidentsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalIncident.fxml");

    }

    @FXML
    public void preFlightOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/preFlight.fxml");

    }

    @FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalReport.fxml");

    }

    @FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/regularPatient.fxml");

    }


    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
