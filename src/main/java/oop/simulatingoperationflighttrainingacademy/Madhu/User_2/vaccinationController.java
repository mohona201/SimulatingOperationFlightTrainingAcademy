package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;

public class vaccinationController {
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, String> administeredByTableColumn;
    @javafx.fxml.FXML
    private TextField vaccineNameTextField;
    @javafx.fxml.FXML
    private DatePicker vaccineDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, LocalDate> vaccinationDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, String> notesTableColumn;
    @javafx.fxml.FXML
    private TableView<Vaccination> vaccinationHistoryTableView;
    @javafx.fxml.FXML
    private TextField studentNameTextField;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, String> vaccineNameTableColumn;
    @javafx.fxml.FXML
    private TextField studentIdTextField;
    @javafx.fxml.FXML
    private Label saveStatusLabel;

    @javafx.fxml.FXML
    public void initialize() {
        vaccinationDateTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination, LocalDate>("vaccinationDate"));
        notesTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination, String>("note"));
        vaccineNameTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination, String>("vacName"));
        administeredByTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination, String>("administer"));
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
    public void renewalsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/renewal.fxml");
    }

    @javafx.fxml.FXML
    public void suspensionsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/suspension.fxml");
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
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalIncident.fxml");
    }

    @javafx.fxml.FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/regularPatient.fxml");
    }

    @FXML
    public void saveVaccineOnActionButton(ActionEvent actionEvent) {

        String idText = studentIdTextField.getText().trim();
        String name = studentNameTextField.getText().trim();
        String vacName = vaccineNameTextField.getText().trim();
        String admin = administeredByTableColumn.getText().trim();
        LocalDate date = vaccineDatePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || vacName.isEmpty() || admin.isEmpty() || date == null) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }


        Integer id = Integer.parseInt(idText);

        Vaccination record = new Vaccination(vacName, name, admin, date, id);

        commonMethods.saveToBinFile("vaccination.bin", java.util.List.of(record));

        vaccinationHistoryTableView.getItems().clear();
        commonMethods.showTableDataFromBinFile("vaccination.bin", vaccinationHistoryTableView);

        notificationLabel.setText("Vaccination Record Saved Successfully!");

        studentIdTextField.clear();
        studentNameTextField.clear();
        vaccineNameTextField.clear();
        vaccineDatePicker.setValue(null);
    }




}


