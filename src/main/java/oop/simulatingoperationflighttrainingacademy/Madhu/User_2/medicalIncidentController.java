package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;

public class medicalIncidentController {
    @javafx.fxml.FXML
    private TableColumn<MedicalIncident, String> incidentSeverityTableColumn;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private DatePicker incidentDatePicker;
    @javafx.fxml.FXML
    private TextArea incidentDescriptionTextArea;
    @javafx.fxml.FXML
    private TableColumn<MedicalIncident, String> incidentStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<MedicalIncident, String> incidentTypeTableColumn;
    @javafx.fxml.FXML
    private TableView<MedicalIncident> incidentHistoryTableView;
    @javafx.fxml.FXML
    private TextField incidentStudentNameTextField;
    @javafx.fxml.FXML
    private TableColumn<MedicalIncident, LocalDate> incidentDateTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> severityComboBox;
    @javafx.fxml.FXML
    private TextField incidentStudentIdTextField;
    @javafx.fxml.FXML
    private Label incidentStatusLabel;

    @javafx.fxml.FXML
    public void initialize() {
        severityComboBox.getItems().addAll("");
        incidentDateTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalIncident, LocalDate>("incidentDate"));
        incidentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalIncident, String>("incidentType"));
        incidentSeverityTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalIncident, String>("incidentSeverity"));
        incidentStatusTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalIncident, String>("incidentStatus"));


    }

    @javafx.fxml.FXML
    public void vaccinationsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalIncident.fxml");
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalIncident.fxml");
    }

    @javafx.fxml.FXML
    public void renewalsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void suspensionsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void incidentsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitIncidentOnActionButton(ActionEvent actionEvent) {

        String id = incidentStudentIdTextField.getText();
        String name = incidentStudentNameTextField.getText();
        String incidentType = incidentTypeTableColumn.getText();
        String severity = severityComboBox.getValue();
        String incidentStatus = incidentStatusTableColumn.getText();
        LocalDate date = incidentDatePicker.getValue();

        if (id.isEmpty() || name.isEmpty() || incidentType.isEmpty() ||
                severity == null || date == null || incidentStatus.isEmpty()) {

            incidentStatusLabel.setText("Please fill all fields.");
            showError("Missing Data: All fields must be filled.");
            return;
        }

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("medicalIncidents.txt", true));

            bw.write(id + "," + name + "," + incidentType + "," + severity + "," + incidentStatus + "," + date);
            bw.newLine();
            bw.close();

            incidentStatusLabel.setText("Incident submitted successfully.");
            notificationLabel.setText("Incident recorded for student.");

        } catch (Exception e) {
            incidentStatusLabel.setText("Error submitting incident.");
            notificationLabel.setText("Could not write to file.");
            showError("Error: Failed to write medicalIncidents.txt");
        }

    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}




