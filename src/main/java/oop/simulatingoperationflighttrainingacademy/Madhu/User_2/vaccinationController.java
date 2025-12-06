package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class vaccinationController {

    @FXML private Label notificationLabel;
    @FXML private TableColumn<Vaccination, String> administeredByTableColumn;
    @FXML private TextField vaccineNameTextField;
    @FXML private DatePicker vaccineDatePicker;
    @FXML private TableColumn<Vaccination, LocalDate> vaccinationDateTableColumn;
    @FXML private TableView<Vaccination> vaccinationHistoryTableView;
    @FXML private TextField studentNameTextField;
    @FXML private TableColumn<Vaccination, String> vaccineNameTableColumn;
    @FXML private TextField studentIdTextField;
    @FXML private TextField administerNameTextField;
    @FXML private TableColumn<Vaccination, String> nameTableColumn;

    ArrayList<Vaccination> list = new ArrayList<>();

    @FXML
    public void initialize() {

        vaccinationDateTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination,LocalDate>("vaccinationDate"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination,String>("name"));
        vaccineNameTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination,String>("vacName"));
        administeredByTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination,String>("administer"));

        commonMethods.showTableDataFromBinFile("vaccination.bin", vaccinationHistoryTableView);
    }

    @FXML
    public void saveVaccineOnActionButton(ActionEvent actionEvent) {

        String idText = studentIdTextField.getText().trim();
        String name = studentNameTextField.getText().trim();
        String vacName = vaccineNameTextField.getText().trim();
        String admin = administerNameTextField.getText().trim();
        LocalDate date = vaccineDatePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || vacName.isEmpty() || admin.isEmpty() || date == null) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        int id = Integer.parseInt(idText);

        Vaccination record = new Vaccination(vacName, name, admin, date, id);

        list.clear();
        list.addAll(vaccinationHistoryTableView.getItems());
        list.add(record);

        commonMethods.saveToBinFile("vaccination.bin", list);

        vaccinationHistoryTableView.getItems().add(record);

        notificationLabel.setText("Vaccination Record Saved Successfully!");

        studentIdTextField.clear();
        studentNameTextField.clear();
        vaccineNameTextField.clear();
        administerNameTextField.clear();
        vaccineDatePicker.setValue(null);
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
