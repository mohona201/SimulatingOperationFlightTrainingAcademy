package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

public class renewalController
{
    @javafx.fxml.FXML
    private TableView <Renewal>renewalHistoryTableView;
    @javafx.fxml.FXML
    private DatePicker nextRenewalDatePicker;
    @javafx.fxml.FXML
    private TableColumn <Renewal,String>remarksTableColumn;
    @javafx.fxml.FXML
    private Label studentNameLabel;
    @javafx.fxml.FXML
    private TableColumn <Renewal,String>nextDueTableColumn;
    @javafx.fxml.FXML
    private TableColumn <Renewal,String>doctorNameTableColumn;
    @javafx.fxml.FXML
    private Label renewalStatusLabel;
    @javafx.fxml.FXML
    private Label lastMedicalDateLabel;
    @javafx.fxml.FXML
    private DatePicker newClearanceDatePicker;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn <Renewal, LocalDate>renewalDateTableColumn;
    @javafx.fxml.FXML
    private TextArea doctorNotesTextArea;
    @javafx.fxml.FXML
    private TextField studentIdTextField;
    @javafx.fxml.FXML
    private TextField studentNameTextField;

    @javafx.fxml.FXML
    public void initialize() {
        remarksTableColumn.setCellValueFactory(new PropertyValueFactory<Renewal,String>("remark"));
        nextDueTableColumn.setCellValueFactory(new PropertyValueFactory<Renewal,String>("nextDue"));
        doctorNameTableColumn.setCellValueFactory(new PropertyValueFactory<Renewal,String>("doctorName"));
        renewalDateTableColumn.setCellValueFactory(new PropertyValueFactory<Renewal,LocalDate>("renewalDate"));
    }

    @javafx.fxml.FXML
    public void submitRenewalOnActionButton(ActionEvent actionEvent) {

        if (studentIdTextField.getText().isEmpty()) {
            renewalStatusLabel.setText("Fill all fields.");
            showError("All fields must be filled.");
            return;
        }

        Integer studentId = Integer.parseInt(studentIdTextField.getText());
        String studentName = studentNameTextField.getText();
        String remarks = remarksTableColumn.getText();
        String doctorName = doctorNameTableColumn.getText();
        LocalDate renewalDate = newClearanceDatePicker.getValue();
        LocalDate nextDue = nextRenewalDatePicker.getValue();

        if (studentName.isEmpty() || remarks.isEmpty() || doctorName.isEmpty()
                || nextDue == null || renewalDate == null) {

            renewalStatusLabel.setText("Fill all fields.");
            showError("All fields must be filled.");
            return;
        }

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("renewalRecord.txt", true));

            bw.write(studentId + "," +
                    studentName + "," +
                    nextDue + "," +
                    renewalDate + "," +
                    "Dr. Alex Rahman");

            bw.newLine();
            bw.close();

            renewalStatusLabel.setText("Renewal submitted successfully.");
            notificationLabel.setText("Medical clearance updated.");

            showError("Renewal has been recorded.");

        } catch (Exception e) {

            renewalStatusLabel.setText("Submission failed.");
            notificationLabel.setText("Could not update record.");

            showError("Failed to write file.");
        }
    }





    @javafx.fxml.FXML
    public void loadRecordOnActionButton(ActionEvent actionEvent) {

        if (studentIdTextField.getText().isEmpty()) {
            notificationLabel.setText("Please enter Student ID.");
            showError("Enter a valid Student ID first.");
            return;
        }

        Integer studentId = Integer.parseInt(studentIdTextField.getText());
        renewalHistoryTableView.getItems().clear();

        try {

            BufferedReader br = new BufferedReader(new FileReader("vaccinationRecords.txt"));

            String readLine = br.readLine();
            br.readLine();
            br.close();

        } catch (Exception e) {

            notificationLabel.setText("Could not load vaccinationRecords.txt");
            showError("File loading failed.");
        }
    }

    @javafx.fxml.FXML
    public void vaccinationsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/vaccination.fxml");
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
    public void suspensionsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/suspension.fxml");
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
    public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalIncident.fxml");
    }

    @javafx.fxml.FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/regularPatient.fxml");
    }

private void showError(String msg) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setContentText(msg);
    alert.showAndWait();
}
}
