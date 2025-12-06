package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class suspensionsController {

    @FXML private TableView<Suspension> incidentDetailsTableView;
    @FXML private TableColumn<Suspension, String> incidentTypeTableColumn;
    @FXML private TableColumn<Suspension, String> incidentDescriptionTableColumn;
    @FXML private TableColumn<Suspension, LocalDate> incidentDateTableColumn;
    @FXML private TableColumn<Suspension, String> patientNameTableColumn;
    @FXML private TableColumn<Suspension, Integer> patiedntIdTableColumn;

    @FXML private TextField patientIdTextField;
    @FXML private TextField patientNameTextField;
    @FXML private DatePicker datePicker;

    @FXML private TextArea suspensionReasonTextArea;
    @FXML private DatePicker suspensionStartDatePicker;
    @FXML private DatePicker suspensionEndDatePicker;

    @FXML private RadioButton suspendRadioButton;
    @FXML private RadioButton noSuspendRadioButton;

    @FXML private Label notificationLabel;

    ArrayList<Suspension> list = new ArrayList<>();
    boolean isSuspend = false;
    boolean noSuspend = false;

    @FXML
    public void initialize() {
        incidentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("incidentType"));
        incidentDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("suspensionDescription"));
        incidentDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        patiedntIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        commonMethods.showTableDataFromBinFile("suspension.bin", incidentDetailsTableView);
    }

    @FXML
    public void suspendOnActionButton(ActionEvent actionEvent) {
        isSuspend = true;
        noSuspend = false;
        suspendRadioButton.setSelected(true);
        noSuspendRadioButton.setSelected(false);
    }

    @FXML
    public void noSuspendOnActionButton(ActionEvent actionEvent) {
        noSuspend = true;
        isSuspend = false;
        noSuspendRadioButton.setSelected(true);
        suspendRadioButton.setSelected(false);
    }

    @FXML
    public void loadIncidentOnActionButton(ActionEvent actionEvent) {

        String idText = patientIdTextField.getText().trim();
        String name = patientNameTextField.getText().trim();
        String incident = suspensionReasonTextArea.getText().trim();
        String type = "Medical";
        LocalDate date = datePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || incident.isEmpty() || date == null) return;

        Integer id = Integer.parseInt(idText);

        Suspension record = new Suspension(id, name, incident, type, incident, date);

        list.clear();
        list.addAll(incidentDetailsTableView.getItems());
        list.add(record);

        commonMethods.saveToBinFile("suspension.bin", list);
        incidentDetailsTableView.getItems().add(record);

        notificationLabel.setText("Incident Loaded Successfully");

        patientIdTextField.clear();
        patientNameTextField.clear();
        suspensionReasonTextArea.clear();
        datePicker.setValue(null);
    }

    @FXML
    public void confirmSuspensionOnActionButton(ActionEvent actionEvent) {

        String idText = patientIdTextField.getText().trim();
        String name = patientNameTextField.getText().trim();
        String desc = suspensionReasonTextArea.getText().trim();
        String type = "Suspension";
        LocalDate date = suspensionStartDatePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || desc.isEmpty() || date == null) return;
        if (!isSuspend && !noSuspend) return;

        Integer id = Integer.parseInt(idText);

        Suspension record = new Suspension(id, name, desc, type, desc, date);

        list.clear();
        list.addAll(incidentDetailsTableView.getItems());
        list.add(record);

        commonMethods.saveToBinFile("suspension.bin", list);
        incidentDetailsTableView.getItems().add(record);

        notificationLabel.setText("Suspension Saved");

        patientIdTextField.clear();
        patientNameTextField.clear();
        suspensionReasonTextArea.clear();
        suspensionStartDatePicker.setValue(null);
        suspensionEndDatePicker.setValue(null);
        suspendRadioButton.setSelected(false);
        noSuspendRadioButton.setSelected(false);
        isSuspend = false;
        noSuspend = false;
    }

    @FXML public void vaccinationsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/vaccination.fxml");
    }
    @FXML public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalSpecialistDashboard.fxml");
    }
    @FXML public void renewalsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/renewal.fxml");
    }
    @FXML public void suspensionsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/suspension.fxml");
    }
    @FXML public void incidentsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalIncident.fxml");
    }
    @FXML public void preFlightOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/preFlight.fxml");
    }
    @FXML public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalReport.fxml");
    }
    @FXML public void regularPatientsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/regularPatient.fxml");
    }
}
