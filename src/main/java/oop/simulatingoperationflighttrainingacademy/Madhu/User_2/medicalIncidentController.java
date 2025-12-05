package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class medicalIncidentController {

    @FXML private TableColumn<MedicalIncident, String> incidentSeverityTableColumn;
    @FXML private Label notificationLabel;
    @FXML private DatePicker incidentDatePicker;
    @FXML private TextArea incidentDescriptionTextArea;
    @FXML private TableColumn<MedicalIncident, String> incidentStatusTableColumn;
    @FXML private TableColumn<MedicalIncident, String> incidentTypeTableColumn;
    @FXML private TableView<MedicalIncident> incidentHistoryTableView;
    @FXML private TextField incidentStudentNameTextField;
    @FXML private TableColumn<MedicalIncident, LocalDate> incidentDateTableColumn;
    @FXML private ComboBox<String> severityComboBox;
    @FXML private TextField incidentStudentIdTextField;
    @FXML private Label incidentStatusLabel;

    ArrayList<MedicalIncident> list = new ArrayList<>();

    @FXML
    public void initialize() {
        severityComboBox.getItems().addAll("Low", "Moderate", "High", "Critical");
        incidentDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("incidentDate"));
        incidentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("incidentType"));
        incidentSeverityTableColumn.setCellValueFactory(new PropertyValueFactory<>("incidentSeverity"));
        incidentStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("incidentStatus"));
        commonMethods.showTableDataFromBinFile("incident.bin", incidentHistoryTableView);
    }

    @FXML
    public void submitIncidentOnActionButton(ActionEvent actionEvent) {

        String idText = incidentStudentIdTextField.getText() == null ? "" : incidentStudentIdTextField.getText().trim();
        String name = incidentStudentNameTextField.getText() == null ? "" : incidentStudentNameTextField.getText().trim();
        String incidentType = incidentTypeTableColumn.getText() == null ? "" : incidentTypeTableColumn.getText().trim();
        String severity = severityComboBox.getValue();
        String incidentStatus = incidentStatusTableColumn.getText() == null ? "" : incidentStatusTableColumn.getText().trim();
        LocalDate date = incidentDatePicker.getValue();
        String description = incidentDescriptionTextArea.getText() == null ? "" : incidentDescriptionTextArea.getText().trim();

        if (idText.isEmpty() || name.isEmpty() || incidentType.isEmpty() ||
                severity == null || date == null || incidentStatus.isEmpty() || description.isEmpty()) {
            notificationLabel.setText("Please fill all fields");
            return;
        }

        if (!idText.matches("[0-9]+")) {
            notificationLabel.setText("Student ID must be numeric");
            return;
        }

        Integer studentId = Integer.parseInt(incidentStudentIdTextField.getText());

        MedicalIncident incident = new MedicalIncident(studentId, name, incidentType, severity, incidentStatus, date);

        if (commonMethods.existsInBinFile("incident.bin", incident.toString())) {
            notificationLabel.setText("Incident already recorded");
            return;
        }

        list.clear();
        list.addAll(incidentHistoryTableView.getItems());
        list.add(incident);
        commonMethods.saveToBinFile("incident.bin", list);

        incidentHistoryTableView.getItems().add(incident);

        notificationLabel.setText("Incident Submitted Successfully");

        incidentStudentIdTextField.clear();
        incidentStudentNameTextField.clear();
        incidentDescriptionTextArea.clear();
        severityComboBox.setValue(null);
        incidentDatePicker.setValue(null);
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
    public void renewalsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/renewal.fxml");
    }

    @FXML
    public void suspensionsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/suspension.fxml");
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
    public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalReport.fxml");
    }

    @FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/regularPatient.fxml");
    }
}
