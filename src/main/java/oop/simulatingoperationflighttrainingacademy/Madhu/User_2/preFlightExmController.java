package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class preFlightExmController {

    @FXML
    private TextField patientIdTextField;
    @FXML
    private TableColumn<PreFlight, Integer> patientIdTableColumn;
    @FXML
    private Label notificationLabel;
    @FXML
    private TableColumn<PreFlight, LocalDate> appointmentDateTableColumn;
    @FXML
    private TableColumn<PreFlight, String> patientNameTableColumn;
    @FXML
    private TableView<PreFlight> patientListTableView;
    @FXML
    private TextField patientNameTextField;
    @FXML
    private DatePicker dateComboBox;
    @FXML
    private RadioButton approvedRadioButton;
    @FXML
    private RadioButton notApprovedRadioButton;

    boolean isApproved = false;
    boolean isNotApproved = false;

    ArrayList<PreFlight> list = new ArrayList<>();
    @FXML
    private TextField heightTextField;
    @FXML
    private TextField bloodPressureTextField;
    @FXML
    private TextField heartRateTextField;

    @FXML
    public void initialize() {
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        appointmentDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        commonMethods.showTableDataFromBinFile("preflight.bin", patientListTableView);
    }



    @FXML
    public void loadRecordsOnActionButton(ActionEvent actionEvent) {

        String idText = patientIdTextField.getText().trim();
        String name = patientNameTextField.getText().trim();
        LocalDate date = dateComboBox.getValue();

        if (idText.isEmpty() || name.isEmpty() || date == null) return;
        if (!isApproved && !isNotApproved) return;

        int id = Integer.parseInt(idText);

        PreFlight record = new PreFlight(id, name, date);

        list.clear();
        list.addAll(patientListTableView.getItems());
        list.add(record);

        commonMethods.saveToBinFile("preflight.bin", list);

        patientListTableView.getItems().add(record);

        notificationLabel.setText("Record Saved & Loaded Successfully");

        patientIdTextField.clear();
        patientNameTextField.clear();
        dateComboBox.setValue(null);
        approvedRadioButton.setSelected(false);
        notApprovedRadioButton.setSelected(false);
        isApproved = false;
        isNotApproved = false;
    }

    @FXML
    public void preFlightOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/preFlightExm.fxml");
    }

    @FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/medicalSpecialistDashboard.fxml");
    }

    @FXML
    public void renewalsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/renewal.fxml");
    }

    @FXML
    public void incidentsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/medicalIncident.fxml");
    }

    @FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/medicalReport.fxml");
    }

    @FXML
    public void suspensionsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/suspension.fxml");
    }

    @FXML
    public void vaccinationOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/vaccination.fxml");
    }

    @FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/regularPatient.fxml");
    }
}
