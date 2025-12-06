package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class regularPatientsController {

    @FXML
    private TextArea notesTextArea;
    @FXML
    private Label notificationLabel;
    @FXML
    private TextField patientIdTextField;
    @FXML
    private TableColumn<RegularPatient, LocalDate> lastVisitTableColumn;
    @FXML
    private TableColumn<RegularPatient, String> healthStatusTableColumn;
    @FXML
    private TableColumn<RegularPatient, Integer> patientIdTableColumn;
    @FXML
    private Label updateStatusLabel;
    @FXML
    private TableColumn<RegularPatient, String> patientNameTableColumn;
    @FXML
    private TextField patientNameTextField;
    @FXML
    private TableView <RegularPatient>regularPatientsTableView;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField healthStatusTextField;

    ArrayList<RegularPatient> list = new ArrayList<>();


    @FXML
    public void initialize() {
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        healthStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("healthStatus"));
        lastVisitTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        commonMethods.showTableDataFromBinFile("regularPatients.bin", regularPatientsTableView);
    }


    @FXML
    public void saveNotesOnActionButton(ActionEvent actionEvent) {
        RegularPatient selected = regularPatientsTableView.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        String newNotes = notesTextArea.getText().trim();
        selected.setNotes(newNotes);

        list.clear();
        list.addAll(regularPatientsTableView.getItems());

        commonMethods.saveToBinFile("regularPatients.bin", list);

        updateStatusLabel.setText("Notes updated");

    }


    @FXML
    public void searchPatientOnActionButton(ActionEvent actionEvent) {
        String idText = patientIdTextField.getText().trim();
        String name = patientNameTextField.getText().trim();
        String health = healthStatusTextField.getText().trim();
        LocalDate date = datePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || health.isEmpty() || date == null)
            return;

        int id = Integer.parseInt(idText);

        RegularPatient p = new RegularPatient(id, name, "", health, date);

        list.clear();
        list.addAll(regularPatientsTableView.getItems());
        list.add(p);

        commonMethods.saveToBinFile("regularPatients.bin", list);
        regularPatientsTableView.getItems().add(p);

        notificationLabel.setText("Patient added successfully");


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
