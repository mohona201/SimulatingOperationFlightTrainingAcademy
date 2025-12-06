package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;
import java.time.LocalDate;
import java.util.ArrayList;

public class medicalSpecialistDashboardController {

    @FXML private TableView<MedicalSpecialistDashBoard> preFlightTableView;
    @FXML private TableColumn<MedicalSpecialistDashBoard, String> preFlightPatientNameTableColumn;
    @FXML private TableColumn<MedicalSpecialistDashBoard, LocalDate> dateTableColumn;
    @FXML private TableColumn<MedicalSpecialistDashBoard, Integer> preFlightPatientIdTableColumn1;

    @FXML private TableView<MedicalSpecialistDashBoard> regularPatientsTableView;
    @FXML private TableColumn<MedicalSpecialistDashBoard, String> patientNameColumn;
    @FXML private TableColumn<MedicalSpecialistDashBoard, LocalDate> dateColumn;
    @FXML private TableColumn<MedicalSpecialistDashBoard, Integer> patientIdTabletColumn;

    @FXML private TextField searchIdTextField;
    @FXML private TextField patientNameTextField;
    @FXML private DatePicker preDatePicker;

    @FXML private TextField searchIdTextField1;
    @FXML private TextField patientNameTextField1;
    @FXML private DatePicker preDatePicker1;

    @FXML private Label notificationLabel;

    ArrayList<MedicalSpecialistDashBoard> preflightList = new ArrayList<>();
    ArrayList<MedicalSpecialistDashBoard> regularList = new ArrayList<>();

    @FXML
    public void initialize() {

        preFlightPatientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        preFlightPatientIdTableColumn1.setCellValueFactory(new PropertyValueFactory<>("id"));

        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        patientIdTabletColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        commonMethods.showTableDataFromBinFile("preflight.bin", preFlightTableView);
        commonMethods.showTableDataFromBinFile("regular.bin", regularPatientsTableView);
    }

    @FXML
    public void searchOnActionButton(ActionEvent actionEvent) {

        String idText = searchIdTextField.getText().trim();
        String name = patientNameTextField.getText().trim();
        LocalDate date = preDatePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || date == null) return;

        Integer id = Integer.parseInt(idText);

        MedicalSpecialistDashBoard record = new MedicalSpecialistDashBoard(name, date, id);

        preflightList.clear();
        preflightList.addAll(preFlightTableView.getItems());
        preflightList.add(record);

        commonMethods.saveToBinFile("preflight.bin", preflightList);
        preFlightTableView.getItems().add(record);

        notificationLabel.setText("Pre-Flight Record Saved");
    }

    @FXML
    public void reSearchOnActionButton(ActionEvent actionEvent) {

        String idText = searchIdTextField1.getText().trim();
        String name = patientNameTextField1.getText().trim();
        LocalDate date = preDatePicker1.getValue();

        if (idText.isEmpty() || name.isEmpty() || date == null) return;

        Integer id = Integer.parseInt(idText);

        MedicalSpecialistDashBoard record = new MedicalSpecialistDashBoard(name, date, id);

        regularList.clear();
        regularList.addAll(regularPatientsTableView.getItems());
        regularList.add(record);

        commonMethods.saveToBinFile("regular.bin", regularList);
        regularPatientsTableView.getItems().add(record);

        notificationLabel.setText("Regular Patient Record Saved");
    }

    @FXML public void vaccinationOnActionButton(ActionEvent actionEvent) { commonMethods.sceneChange(actionEvent, "Madhu/User_2/vaccination.fxml"); }
    @FXML public void suspensionOnActionButton(ActionEvent actionEvent) { commonMethods.sceneChange(actionEvent, "Madhu/User_2/suspension.fxml"); }
    @FXML public void dashboardOnActionButton(ActionEvent actionEvent) { commonMethods.sceneChange(actionEvent, "Madhu/User_2/studentPilotDashBoard.fxml"); }
    @FXML public void renewalsOnActionButton(ActionEvent actionEvent) { commonMethods.sceneChange(actionEvent, "Madhu/User_2/renewal.fxml"); }
    @FXML public void incidentsOnActionButton(ActionEvent actionEvent) { commonMethods.sceneChange(actionEvent, "Madhu/User_2/medicalIncident.fxml"); }
    @FXML public void preFlightOnActionButton(ActionEvent actionEvent) { commonMethods.sceneChange(actionEvent, "Madhu/User_2/preFlight.fxml"); }
    @FXML public void reportsOnActionButton(ActionEvent actionEvent) { commonMethods.sceneChange(actionEvent, "Madhu/User_2/medicalReport.fxml"); }
    @FXML public void regularPatientsOnActionButton(ActionEvent actionEvent) { commonMethods.sceneChange(actionEvent, "Madhu/User_2/regularPatient.fxml"); }
}
