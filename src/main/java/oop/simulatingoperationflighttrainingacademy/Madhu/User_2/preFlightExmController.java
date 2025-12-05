package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class preFlightExmController
{
    @javafx.fxml.FXML
    private TextField patientIdTextField;
    @javafx.fxml.FXML
    private TableColumn <PreFlight,Integer>patientIdTableColumn;
    @javafx.fxml.FXML
    private Label examStatusLabel;
    @javafx.fxml.FXML
    private TableColumn <PreFlight, LocalDate>appointmentDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn <PreFlight,String>patientNameTableColumn;
    @javafx.fxml.FXML
    private RadioButton approvedRadioTextField;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableView <PreFlight>patientListTableView;
    @javafx.fxml.FXML
    private TextField heightTextField;
    @javafx.fxml.FXML
    private TextField patientNameTextField;
    @javafx.fxml.FXML
    private TextField bloodPressureTextField;
    @javafx.fxml.FXML
    private TextField heartRateTextField;
    @javafx.fxml.FXML
    private DatePicker dateComboBox;

    ArrayList<PreFlight> list = new ArrayList<>();

    boolean isApproved = false;
    boolean isNotApproved = false;


    @javafx.fxml.FXML
    public void initialize() {
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<PreFlight,Integer>("patientId"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<PreFlight,String>("patientName"));
        appointmentDateTableColumn.setCellValueFactory(new PropertyValueFactory<PreFlight,LocalDate>("date"));
        commonMethods.showTableDataFromBinFile("preflight.bin", patientListTableView);
    }

    @javafx.fxml.FXML
    public void approvedRadioButton(ActionEvent actionEvent) {
        isApproved = true;
        isNotApproved = false;
    }

    @javafx.fxml.FXML
    public void notApprovedRadioButton(ActionEvent actionEvent) {
        isNotApproved = true;
        isApproved = false;

    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/medicalSpecialistDashboard.fxml");
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
    public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalIncident.fxml");
    }
    @javafx.fxml.FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/regularPatient.fxml");
    }

    @FXML
    public void loadRecordsOnActionButton(ActionEvent actionEvent) {

        String idText = patientIdTextField.getText().trim();
        String name = patientNameTextField.getText().trim();
        LocalDate date = dateComboBox.getValue();

        if (idText.isEmpty() || name.isEmpty() || date == null) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }


        if (!isApproved && !isNotApproved) {
            commonMethods.showError("Select Status", "Please select Approved or Not Approved");
            return;
        }

        Integer id = Integer.parseInt(idText);

        PreFlight newRecord = new PreFlight(id, name, date);

        commonMethods.saveToBinFile("preflight.bin", java.util.List.of(newRecord));

        patientListTableView.getItems().clear();
        commonMethods.showTableDataFromBinFile("preflight.bin", patientListTableView);

        notificationLabel.setText("Record Saved & Loaded Successfully");

        patientIdTextField.clear();
        patientNameTextField.clear();
        dateComboBox.setValue(null);
        approvedRadioTextField.setSelected(false);
        isApproved = false;
        isNotApproved = false;

    }



    @javafx.fxml.FXML
    public void suspensionsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/suspension.fxml");
    }

    @javafx.fxml.FXML
    public void preFlightOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/preFlight.fxml");
    }


    @FXML
    public void vaccinationOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/vaccination.fxml");
    }
}