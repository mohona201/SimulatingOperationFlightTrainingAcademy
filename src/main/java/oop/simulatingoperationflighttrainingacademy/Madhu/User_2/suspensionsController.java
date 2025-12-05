package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class suspensionsController {

    @FXML
    private TableColumn<Suspension, String> recentIncidentTableColumn;
    @FXML
    private TableColumn<Suspension, Integer> patientIdTableColumn;
    @FXML
    private TableColumn<Suspension, String> patientNameTableColumn;
    @FXML
    private Label notificationLabel;
    @FXML
    private TableView<Suspension> patientSuspensionTableView;
    @FXML
    private TableView<Suspension> incidentDetailsTableView;
    @FXML
    private TableColumn<Suspension, String> incidentTypeTableColumn;
    @FXML
    private TableColumn<Suspension, String> incidentDescriptionTableColumn;
    @FXML
    private TextArea suspensionReasonTextArea;
    @FXML
    private DatePicker suspensionStartDatePicker;
    @FXML
    private Label suspensionStatusLabel;
    @FXML
    private TableColumn<Suspension, LocalDate> incidentDateTableColumn;
    @FXML
    private DatePicker suspensionEndDatePicker;

    boolean isSuspend = false;
    boolean noSuspend = false;

    ArrayList<Suspension> allSuspensions = new ArrayList<>();

    @FXML
    public void initialize() {
        incidentDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("incidentDetail"));
        incidentDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("suspensionDescription"));
        incidentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("incidentType"));
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        recentIncidentTableColumn.setCellValueFactory(new PropertyValueFactory<>("recentIncident"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));

        commonMethods.showTableDataFromBinFile("suspension.bin", patientSuspensionTableView);
        commonMethods.showTableDataFromBinFile("suspension.bin", incidentDetailsTableView);
    }

    @FXML
    public void loadIncidentOnActionButton(ActionEvent actionEvent) {

        String idText = patientIdTableColumn.getText().trim();
        String name = patientNameTableColumn.getText().trim();
        String incident = recentIncidentTableColumn.getText().trim();
        String type = incidentTypeTableColumn.getText().trim();
        LocalDate date = suspensionStartDatePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || incident.isEmpty() || type.isEmpty() || date == null) {
            commonMethods.showError("Empty Fields", "Please fill all fields");
            return;
        }

        Integer id = Integer.parseInt(idText);

        Suspension record = new Suspension(id, name, incident, type, suspensionReasonTextArea.getText().trim(), date);

        commonMethods.saveToBinFile("suspension.bin", java.util.List.of(record));

        patientSuspensionTableView.getItems().clear();
        incidentDetailsTableView.getItems().clear();

        commonMethods.showTableDataFromBinFile("suspension.bin", patientSuspensionTableView);
        commonMethods.showTableDataFromBinFile("suspension.bin", incidentDetailsTableView);

        notificationLabel.setText("Incident Loaded Successfully!");

        suspensionReasonTextArea.clear();
        suspensionStartDatePicker.setValue(null);
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
    public void suspendOnActionButton(ActionEvent actionEvent) {
        isSuspend = true;
        noSuspend = false;
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
    public void noSuspendOnActionButton(ActionEvent actionEvent) {
        noSuspend = true;
        isSuspend = false;
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
    public void confirmSuspensionOnActionButton(ActionEvent actionEvent) {

        String idText = patientIdTableColumn.getText().trim();
        String name = patientNameTableColumn.getText().trim();
        String incident = recentIncidentTableColumn.getText().trim();
        String type = incidentTypeTableColumn.getText().trim();
        String reason = suspensionReasonTextArea.getText().trim();
        LocalDate date = suspensionStartDatePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || incident.isEmpty() || type.isEmpty() || reason.isEmpty() || date == null) {
            commonMethods.showError("Empty Fields", "Please fill all fields");
            return;
        }

        Integer id = Integer.parseInt(idText);

        Suspension confirmRecord = new Suspension(id, name, incident, type, reason, date);

        commonMethods.saveToBinFile("suspension.bin", java.util.List.of(confirmRecord));

        patientSuspensionTableView.getItems().add(confirmRecord);
        incidentDetailsTableView.getItems().add(confirmRecord);

        notificationLabel.setText("Suspension Confirmed!");

        suspensionReasonTextArea.clear();
        suspensionStartDatePicker.setValue(null);
    }

    @FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalIncident.fxml");
    }

    @FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/regularPatient.fxml");
    }
}
