package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class renewalController
{
    @javafx.fxml.FXML
    private TableView <Renewal>renewalHistoryTableView;
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
    private DatePicker lastDatePicker;

    @FXML
    private TextField patientIdTextField;
    @FXML
    private TextField paNameTextField1;
    @FXML
    private DatePicker nextDueDatePicker;

    ArrayList<Renewal> list = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        remarksTableColumn.setCellValueFactory(new PropertyValueFactory<Renewal,String>("remark"));
        nextDueTableColumn.setCellValueFactory(new PropertyValueFactory<Renewal,String>("nextDue"));
        doctorNameTableColumn.setCellValueFactory(new PropertyValueFactory<Renewal,String>("doctorName"));
        renewalDateTableColumn.setCellValueFactory(new PropertyValueFactory<Renewal,LocalDate>("renewalDate"));
        doctorNameTableColumn.setCellValueFactory(new PropertyValueFactory<Renewal,String>("doctorName"));

        commonMethods.showTableDataFromBinFile("renewal.bin", renewalHistoryTableView);
    }
    @FXML
    public void submitRenewalOnActionButton(ActionEvent actionEvent) {

        String idText = patientIdTextField.getText().trim();
        String name = paNameTextField1.getText().trim();
        String remarks = doctorNotesTextArea.getText().trim();
        String doctor = studentNameLabel.getText().trim();
        LocalDate renewalDate = lastDatePicker.getValue();
        LocalDate newClearance = newClearanceDatePicker.getValue();
        LocalDate nextDue = nextDueDatePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || remarks.isEmpty() || doctor.isEmpty()
                || renewalDate == null || newClearance == null || nextDue == null) {

            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        Integer id = Integer.parseInt(idText);

        Renewal record = new Renewal(id, name, remarks, doctor, renewalDate, newClearance, nextDue);

        commonMethods.saveToBinFile("renewal.bin", java.util.List.of(record));

        renewalHistoryTableView.getItems().add(record);

        notificationLabel.setText("Renewal Submitted Successfully!");

        patientIdTextField.clear();
        paNameTextField1.clear();
        doctorNotesTextArea.clear();
        lastDatePicker.setValue(null);
        newClearanceDatePicker.setValue(null);
        nextDueDatePicker.setValue(null);
    }





    @FXML
    public void loadRecordOnActionButton(ActionEvent actionEvent) {

        String idText = patientIdTextField.getText().trim();
        String name = paNameTextField1.getText().trim();
        String remarks = doctorNotesTextArea.getText().trim();
        String doctor = studentNameLabel.getText().trim();
        LocalDate renewalDate = lastDatePicker.getValue();
        LocalDate newClearance = newClearanceDatePicker.getValue();
        LocalDate nextDue = nextDueDatePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || remarks.isEmpty() || doctor.isEmpty()
                || renewalDate == null || newClearance == null || nextDue == null) {

            commonMethods.showError("Empty Fields", "Please fill all fields");
            return;
        }

        Integer id = Integer.parseInt(idText);

        Renewal record = new Renewal(id, name, remarks, doctor, renewalDate, newClearance, nextDue);

        commonMethods.saveToBinFile("renewal.bin", java.util.List.of(record));

        renewalHistoryTableView.getItems().clear();

        commonMethods.showTableDataFromBinFile("renewal.bin", renewalHistoryTableView);

        notificationLabel.setText("Record Saved & Loaded Successfully!");

        patientIdTextField.clear();
        paNameTextField1.clear();
        doctorNotesTextArea.clear();
        lastDatePicker.setValue(null);
        newClearanceDatePicker.setValue(null);
        nextDueDatePicker.setValue(null);
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


}
