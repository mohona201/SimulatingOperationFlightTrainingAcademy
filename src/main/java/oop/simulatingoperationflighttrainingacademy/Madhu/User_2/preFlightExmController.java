package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class preFlightExmController
{
    @javafx.fxml.FXML
    private Button renewalsButton;
    @javafx.fxml.FXML
    private TableColumn <PreFlight,Integer>patientIdTableColumn;
    @javafx.fxml.FXML
    private Label examStatusLabel;
    @javafx.fxml.FXML
    private TableColumn <PreFlight,LocalDate>appointmentDateTableColumn;
    @javafx.fxml.FXML
    private Button loadRecordsButton;
    @javafx.fxml.FXML
    private TableColumn <PreFlight,String>patientNameTableColumn;
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
    private Label notificationLabel;
    @javafx.fxml.FXML
    private Button dashboardButton;
    @javafx.fxml.FXML
    private Button incidentsButton;
    @javafx.fxml.FXML
    private Button submitExamButton;
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
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<PreFlight,String>("patientName"));
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<PreFlight,Integer>("patientId"));
        appointmentDateTableColumn.setCellValueFactory(new PropertyValueFactory<PreFlight,LocalDate>("appointmentDate"));
    }

    @javafx.fxml.FXML
    public void vaccinationOnActionButton(ActionEvent actionEvent) {
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
    }

    @javafx.fxml.FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadRecordsOnActionButton(ActionEvent actionEvent) {
        String idText = patientIdTextField.getText().trim();
        String name = patientNameTextField.getText().trim();
        String status = statusComboBox.getValue();
        LocalDate date = datePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || status == null || date == null) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        if (!idText.matches("[0-9]+")) {
            commonMethods.showError("Invalid ID", "Patient ID must be numeric");
            return;
        }

        Integer id = Integer.parseInt(idText);

        // ✅ Create NEW object (very simple)
        PreFlight newRecord = new PreFlight(id, name, status, date);

        ArrayList<PreFlight> list = new ArrayList<>();
        list.add(newRecord);
        commonMethods.saveToBinFile("preflight.bin", list);

        // Reload all records from bin file
        preFlightTableView.getItems().clear();
        commonMethods.showTableDataFromBinFile("preflight.bin", preFlightTableView);

        notificationLabel.setText("Record Saved & Loaded Successfully");

        patientIdTextField.clear();
        patientNameTextField.clear();
        statusComboBox.setValue(null);
        datePicker.setValue(null);
    }
}