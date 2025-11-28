package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import static javafx.scene.control.skin.TableSkinUtils.getSelectionModel;

public class preFlightExmController
{
    @javafx.fxml.FXML
    private Button renewalsButton;
    @javafx.fxml.FXML
    private TableColumn <PreFlight,Integer>patientIdTableColumn;
    @javafx.fxml.FXML
    private TextField visionTextField;
    @javafx.fxml.FXML
    private Label examStatusLabel;
    @javafx.fxml.FXML
    private TableColumn <PreFlight, LocalDate>appointmentDateTableColumn;
    @javafx.fxml.FXML
    private Button loadRecordsButton;
    @javafx.fxml.FXML
    private TableColumn <PreFlight,String>patientNameTableColumn;
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
    private TableView <PreFlight>patientListTableView;
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
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<PreFlight,Integer>("pId"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<PreFlight,String>("name"));
        appointmentDateTableColumn.setCellValueFactory(new PropertyValueFactory<PreFlight,LocalDate>("date"));
    }

    @javafx.fxml.FXML
    public void vaccinationOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approvedOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void suspensionOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void renewalsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void incidentsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void preFlightOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitExamOnActionButton(ActionEvent actionEvent) {

        if (patientIdTableColumn.getText().isEmpty()) {
            notificationLabel.setText("Enter Patient ID.");
            showError("Patient ID field is empty.");
            return;
        }

        int idValue;
        try {
            idValue = Integer.parseInt(patientIdTableColumn.getText());
        } catch (Exception e) {
            notificationLabel.setText("Invalid ID.");
            showError("Patient ID must be a number.");
            return;
        }

        if (patientIdTableColumn.getText().isEmpty()) {
            notificationLabel.setText("Enter Patient Name.");
            showError("Patient name field is empty.");
            return;
        }

        String nameValue = patientNameTableColumn.getText();

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
}

    @javafx.fxml.FXML
    public void notApprovedOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadRecordsOnActionButton(ActionEvent actionEvent) {

    }

    private void showError(String msg){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText(msg);
    alert.showAndWait();
}



