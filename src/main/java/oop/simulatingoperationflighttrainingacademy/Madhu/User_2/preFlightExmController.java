package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;

public class preFlightExmController {

    @javafx.fxml.FXML
    private Button renewalsButton;
    @javafx.fxml.FXML
    private TableColumn<PreFlight, Integer> patientIdTableColumn;
    @javafx.fxml.FXML
    private TextField visionTextField;
    @javafx.fxml.FXML
    private Label examStatusLabel;
    @javafx.fxml.FXML
    private TableColumn<PreFlight, LocalDate> appointmentDateTableColumn;
    @javafx.fxml.FXML
    private Button loadRecordsButton;
    @javafx.fxml.FXML
    private TableColumn<PreFlight, String> patientNameTableColumn;
    @javafx.fxml.FXML
    private Button suspensionButton;
    @javafx.fxml.FXML
    private Button vaccinationButton;
    @javafx.fxml.FXML
    private Button regularPatientsButton;
    @javafx.fxml.FXML
    private TextField weightTextField;
    @javafx.fxml.FXML
    private TextArea notesTextArea;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private Button dashboardButton;
    @javafx.fxml.FXML
    private RadioButton approvedRadioButton;
    @javafx.fxml.FXML
    private Button incidentsButton;
    @javafx.fxml.FXML
    private Button submitExamButton;
    @javafx.fxml.FXML
    private RadioButton notApprovedRadioButton;
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

    @javafx.fxml.FXML
    public void vaccinationOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/vaccination.fxml");
    }

    @javafx.fxml.FXML
    public void suspensionOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/suspension.fxml");
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalSpecialistDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void renewalsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/renewal.fxml");
    }

    @javafx.fxml.FXML
    public void incidentsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalIncident.fxml");
    }

    @javafx.fxml.FXML
    public void preFlightOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/preFlight.fxml");
    }

    @javafx.fxml.FXML
    public void submitExamOnActionButton(ActionEvent actionEvent) {

        PreFlight selected = patientListTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            notificationLabel.setText("Select a patient first.");
            showError("No patient selected.");
            return;
        }

        if (visionTextField.getText().isEmpty() ||
                weightTextField.getText().isEmpty() ||
                heightTextField.getText().isEmpty() ||
                bloodPressureTextField.getText().isEmpty() ||
                heartRateTextField.getText().isEmpty()) {
            notificationLabel.setText("Fill all exam fields.");
            showError("All exam fields must be filled.");
            return;
        }

        String statusValue;
        if (approvedRadioButton.isSelected()) {
            statusValue = "Approved";
        } else if (notApprovedRadioButton.isSelected()) {
            statusValue = "Not Approved";
        } else {
            notificationLabel.setText("Select approval status.");
            showError("Approval status is required.");
            return;
        }

        int idValue = selected.getPatientId();
        String nameValue = selected.getPatientName();
        LocalDate lastVisitValue = LocalDate.now();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("medicalRecords.txt", true));
            bw.write(idValue + "," +
                    nameValue + "," +
                    statusValue + "," +
                    visionTextField.getText() + "," +
                    weightTextField.getText() + "," +
                    heightTextField.getText() + "," +
                    bloodPressureTextField.getText() + "," +
                    heartRateTextField.getText() + "," +
                    lastVisitValue + "," +
                    notesTextArea.getText());
            bw.newLine();
            bw.close();

            notificationLabel.setText("Exam record submitted.");
            examStatusLabel.setText("Submitted");
            showError("Medical record has been submitted.");

        } catch (Exception e) {
            notificationLabel.setText("Submission failed.");
            examStatusLabel.setText("Error");
            showError("Failed to save medical record.");
        }
    }

    @javafx.fxml.FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalReport.fxml");
    }

    @javafx.fxml.FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/regularPatient.fxml");
    }

    @javafx.fxml.FXML
    public void loadRecordsOnActionButton(ActionEvent actionEvent) {
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
