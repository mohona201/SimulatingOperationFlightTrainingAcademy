package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

public class medicalSpecialistDashboardController {

    @javafx.fxml.FXML
    private TableColumn<MedicalSpecialistDashBoard, String> statusRegularTableColumn;
    @javafx.fxml.FXML
    private TableColumn<MedicalSpecialistDashBoard, String> reasonTabletColumn;
    @javafx.fxml.FXML
    private Button renewalsButton;
    @javafx.fxml.FXML
    private TableView<MedicalSpecialistDashBoard> preFlightTableView;
    @javafx.fxml.FXML
    private TableColumn<MedicalSpecialistDashBoard, String> purposeTableColumn;
    @javafx.fxml.FXML
    private Button suspensionButton;
    @javafx.fxml.FXML
    private TextField searchTextField;
    @javafx.fxml.FXML
    private TableColumn<MedicalSpecialistDashBoard, LocalDate> dateTableColumn;
    @javafx.fxml.FXML
    private Button vaccinationButton;
    @javafx.fxml.FXML
    private Button regularPatientsButton;
    @javafx.fxml.FXML
    private TableColumn<MedicalSpecialistDashBoard, String> patientNameColumn;
    @javafx.fxml.FXML
    private TableColumn<MedicalSpecialistDashBoard, String> statusTableColumn;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private Button dashboardButton;
    @javafx.fxml.FXML
    private Button incidentsButton;
    @javafx.fxml.FXML
    private TableColumn<MedicalSpecialistDashBoard, String> preFlightPatientNameTableColumn;
    @javafx.fxml.FXML
    private Button preFlightButton;
    @javafx.fxml.FXML
    private Button reportsButton;
    @javafx.fxml.FXML
    private TableColumn<MedicalSpecialistDashBoard, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TableView<MedicalSpecialistDashBoard> regularPatientsTableView;

    @javafx.fxml.FXML
    public void initialize() {
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        reasonTabletColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
        preFlightPatientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        statusRegularTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        purposeTableColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
    }

    @javafx.fxml.FXML
    public void vaccinationOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/vaccination.fxml");
    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {

        regularPatientsTableView.getItems().clear();
        preFlightTableView.getItems().clear();

        if (searchTextField.getText().isEmpty()) {
            notificationLabel.setText("Enter Patient Name.");
            showError("Search field is empty.");
            return;
        }

        String searchValue = searchTextField.getText();

        try {

            BufferedReader br = new BufferedReader(new FileReader("medicalSpecialistRecords.txt"));

            String line = br.readLine();
            String line2 = br.readLine();

            br.close();

            MedicalSpecialistDashBoard ms = new MedicalSpecialistDashBoard(
                    searchValue,
                    "General Check",
                    "Active",
                    LocalDate.now()
            );

            regularPatientsTableView.getItems().add(ms);
            preFlightTableView.getItems().add(ms);

            notificationLabel.setText("Record found.");
            showError("Search completed successfully.");

        } catch (Exception e) {

            notificationLabel.setText("Could not load file.");
            showError("Failed to load medicalSpecialistRecords.txt");
        }
    }

    @javafx.fxml.FXML
    public void suspensionOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/suspension.fxml");
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/studentPilotDashBoard.fxml");
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
    public void preFlightOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/preFlight.fxml");
    }

    @javafx.fxml.FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalReport.fxml");
    }


    @javafx.fxml.FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/regularPatient.fxml");
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
