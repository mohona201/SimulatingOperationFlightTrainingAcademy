package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class medicalSpecialistDashboardController {

    @FXML private TableColumn<MedicalSpecialistDashBoard, String> statusRegularTableColumn;
    @FXML private TableColumn<MedicalSpecialistDashBoard, String> reasonTabletColumn;
    @FXML private TableView<MedicalSpecialistDashBoard> preFlightTableView;
    @FXML private TableColumn<MedicalSpecialistDashBoard, String> purposeTableColumn;
    @FXML private TextField searchTextField;
    @FXML private TableColumn<MedicalSpecialistDashBoard, LocalDate> dateTableColumn;
    @FXML private Label notificationLabel;
    @FXML private TableColumn<MedicalSpecialistDashBoard, String> patientNameColumn;
    @FXML private TableColumn<MedicalSpecialistDashBoard, String> statusTableColumn;
    @FXML private TableColumn<MedicalSpecialistDashBoard, LocalDate> dateColumn;
    @FXML private TableView<MedicalSpecialistDashBoard> regularPatientsTableView;

    @FXML
    public void initialize() {

        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        reasonTabletColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
        purposeTableColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
        statusRegularTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        commonMethods.showTableDataFromBinFile("dashboard.bin", preFlightTableView);
        commonMethods.showTableDataFromBinFile("dashboard.bin", regularPatientsTableView);
    }

    @FXML
    public void searchOnActionButton(ActionEvent actionEvent) {

        String key = searchTextField.getText().trim();

        if (key.isEmpty()) {
            commonMethods.showError("Empty Search", "Enter a name or reason to search");
            return;
        }

        ArrayList<MedicalSpecialistDashBoard> all = new ArrayList<>();
        preFlightTableView.getItems().clear();
        commonMethods.showTableDataFromBinFile("dashboard.bin", preFlightTableView);
        all.addAll(preFlightTableView.getItems());
        preFlightTableView.getItems().clear();

        ArrayList<MedicalSpecialistDashBoard> result = new ArrayList<>();

        for (MedicalSpecialistDashBoard m : all) {
            if (m.getName().equalsIgnoreCase(key) ||
                    m.getReason().equalsIgnoreCase(key) ||
                    m.getStatus().equalsIgnoreCase(key))
            {
                result.add(m);
            }
        }

        preFlightTableView.getItems().setAll(result);
        notificationLabel.setText("Search Completed");
    }

    @FXML
    public void vaccinationOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/vaccination.fxml");
    }

    @FXML
    public void suspensionOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/suspension.fxml");
    }

    @FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/studentPilotDashBoard.fxml");
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
    public void preFlightOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/preFlight.fxml");
    }

    @FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/medicalReport.fxml");
    }

    @FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_2/regularPatient.fxml");
    }
}
