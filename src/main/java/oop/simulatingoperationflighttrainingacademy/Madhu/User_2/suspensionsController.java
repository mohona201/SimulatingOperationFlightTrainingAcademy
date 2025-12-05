package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;

public class suspensionsController {

    @javafx.fxml.FXML
    private TableColumn<Suspension, String> recentIncidentTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Suspension, Integer> patientIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Suspension, String> patientNameTableColumn;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableView<Suspension> patientSuspensionTableView;
    @javafx.fxml.FXML
    private TableView<Suspension> incidentDetailsTableView;
    @javafx.fxml.FXML
    private TableColumn<Suspension, String> incidentTypeTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Suspension, String> incidentDescriptionTableColumn;
    @javafx.fxml.FXML
    private TextArea suspensionReasonTextArea;
    @javafx.fxml.FXML
    private DatePicker suspensionStartDatePicker;
    @javafx.fxml.FXML
    private Label suspensionStatusLabel;
    @javafx.fxml.FXML
    private TableColumn<Suspension, LocalDate> incidentDateTableColumn;
    @javafx.fxml.FXML
    private DatePicker suspensionEndDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
        incidentDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("incidentDetail"));
        incidentDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("suspensionDescription"));
        incidentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("incidentType"));
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        recentIncidentTableColumn.setCellValueFactory(new PropertyValueFactory<>("recentIncident"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
    }

    @javafx.fxml.FXML
    public void loadIncidentOnActionButton(ActionEvent actionEvent) {


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
    public void suspendOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/suspension.fxml");
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
    public void noSuspendOnActionButton(ActionEvent actionEvent) {


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
    public void confirmSuspensionOnActionButton(ActionEvent actionEvent) {


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
