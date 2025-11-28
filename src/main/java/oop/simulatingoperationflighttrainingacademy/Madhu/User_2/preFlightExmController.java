package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

public class preFlightExmController
{
    @javafx.fxml.FXML
    private Button renewalsButton;
    @javafx.fxml.FXML
    private TableColumn<PreFlight,Integer> patientIdTableColumn;
    @javafx.fxml.FXML
    private TextField visionTextField;
    @javafx.fxml.FXML
    private Label examStatusLabel;
    @javafx.fxml.FXML
    private TableColumn<PreFlight,LocalDate> appointmentDateTableColumn;
    @javafx.fxml.FXML
    private Button loadRecordsButton;
    @javafx.fxml.FXML
    private TableColumn<PreFlight,String> patientNameTableColumn;
    @javafx.fxml.FXML
    private Button suspensionButton;
    @javafx.fxml.FXML
    private RadioButton approvedRadioTextField;
    @javafx.fxml.FXML
    private Button vaccinationButton;
    @javafx.fxml.FXML
    private Button regularPatientsButton;
    @javafx.fxml.FXML
    private RadioButton notApprovedRadioTextField;
    @javafx.fxml.FXML
    private TextField weightTextField;
    @javafx.fxml.FXML
    private TextArea notesTextArea;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private Button dashboardButton;
    @javafx.fxml.FXML
    private Button incidentsButton;
    @javafx.fxml.FXML
    private Button submitExamButton;
    @javafx.fxml.FXML
    private TableView<PreFlight> patientListTableView;
    @javafx.fxml.FXML
    private TextField heightTextField;
    @javafx.fxml.FXML
    private Button preFlightButton;
    @javafx.fxml.FXML
    private Button reportsButton;
    @javafx.fxml.FXML
    private TextField bloodPressureTextField;
    @javafx.fxml.FXML
    private TextField heartRateTextField;

    @javafx.fxml.FXML
    public void initialize() {
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("pId"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        appointmentDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML public void vaccinationOnActionButton(ActionEvent actionEvent) { }
    @javafx.fxml.FXML public void suspensionOnActionButton(ActionEvent actionEvent) { }
    @javafx.fxml.FXML public void dashboardOnActionButton(ActionEvent actionEvent) { }
    @javafx.fxml.FXML public void renewalsOnActionButton(ActionEvent actionEvent) { }
    @javafx.fxml.FXML public void incidentsOnActionButton(ActionEvent actionEvent) { }
    @javafx.fxml.FXML public void preFlightOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void submitExamOnActionButton(ActionEvent actionEvent) {

        PreFlight selected = patientListTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            notificationLabel.setText("Select a patient first.");
            showError("No patient selected.");
            return;
        }

        int idValue = selected.getPatientId();
        String nameValue = selected.getPatientName();

        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Enter Health Status");
        dialog.setContentText("Health Status:");
        String statusValue = dialog.showAndWait().orElse("");

        if (statusValue.isEmpty()) {
            notificationLabel.setText("Enter Health Status.");
            showError("Health Status field is empty.");
            return;
        }

        LocalDate lastVisitValue = LocalDate.now();

        try {
            PreFlight record = new PreFlight(idValue, nameValue, statusValue, lastVisitValue);
            patientListTableView.getItems().add(record);

            BufferedWriter bw = new BufferedWriter(new FileWriter("medicalRecords.txt", true));
            bw.write(idValue + "," + nameValue + "," + statusValue + "," + lastVisitValue);
            bw.newLine();
            bw.close();

            notificationLabel.setText("Record submitted.");
            showError("Medical record has been submitted.");

        } catch (Exception e) {
            notificationLabel.setText("Submission failed.");
            showError("Failed to save medical record.");
        }
    }

    @javafx.fxml.FXML public void reportsOnActionButton(ActionEvent actionEvent) { }
    @javafx.fxml.FXML public void regularPatientsOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void loadRecordsOnActionButton(ActionEvent actionEvent) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("medicalRecords.txt"));
            String line = br.readLine();
            String line2 = br.readLine();
            br.close();
            notificationLabel.setText("Records loaded.");
            showError("Medical records loaded.");
        } catch (Exception e) {
            notificationLabel.setText("File error.");
            showError("Failed to load medicalRecords.txt");
        }
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
