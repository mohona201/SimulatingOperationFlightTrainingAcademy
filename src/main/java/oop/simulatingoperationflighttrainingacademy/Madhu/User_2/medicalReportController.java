package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class medicalReportController {

    @FXML private TableView<MedicalReport> statisticsTableView;
    @FXML private TableView<MedicalReport> reportTableView;

    @FXML private TextField reportNameTextField;
    @FXML private TextField reportStatusTextField;
    @FXML private TextField reportCategoryTextField;
    @FXML private TextField statValueTextField;

    @FXML private DatePicker reportDatePicker;
    @FXML private DatePicker statYearPicker;

    @FXML private Label notificationLabel;

    @FXML private TableColumn<MedicalReport, String> reportNameTableColumn;
    @FXML private TableColumn<MedicalReport, String> reportStatusTableColumn;
    @FXML private TableColumn<MedicalReport, String> statCategoryTableColumn;
    @FXML private TableColumn<MedicalReport, String> statValueTableColumn;
    @FXML private TableColumn<MedicalReport, LocalDate> reportDateTableColumn;
    @FXML private TableColumn<MedicalReport, LocalDate> statYearTableColumn;

    ArrayList<MedicalReport> list = new ArrayList<>();

    @FXML
    public void initialize() {

        reportNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("reportName"));
        reportStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("reportStatus"));
        statCategoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("statusCategory"));
        statValueTableColumn.setCellValueFactory(new PropertyValueFactory<>("statValue"));
        reportDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("reportDate"));
        statYearTableColumn.setCellValueFactory(new PropertyValueFactory<>("statYear"));

        commonMethods.showTableDataFromBinFile("report.bin", reportTableView);
        commonMethods.showTableDataFromBinFile("report.bin", statisticsTableView);
    }

    @FXML
    public void loadReportOnActionButton(ActionEvent actionEvent) {

        String name = reportNameTextField.getText().trim();
        String status = reportStatusTextField.getText().trim();
        String category = reportCategoryTextField.getText().trim();
        String statValue = statValueTextField.getText().trim();
        LocalDate date = reportDatePicker.getValue();
        LocalDate year = statYearPicker.getValue();

        if (name.isEmpty() || status.isEmpty() || category.isEmpty() ||
                statValue.isEmpty() || date == null || year == null) {

            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        MedicalReport report = new MedicalReport(
                name,
                status,
                category,
                statValue,
                date,
                year
        );

        list.clear();
        list.add(report);
        commonMethods.saveToBinFile("report.bin", list);

        reportTableView.getItems().add(report);
        statisticsTableView.getItems().add(report);

        notificationLabel.setText("Report Submitted Successfully!");

        reportNameTextField.clear();
        reportStatusTextField.clear();
        reportCategoryTextField.clear();
        statValueTextField.clear();
        reportDatePicker.setValue(null);
        statYearPicker.setValue(null);
    }

    @FXML
    public void downloadReportOnActionButton(ActionEvent actionEvent) {

        MedicalReport selected = reportTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            commonMethods.showError("No Selection", "Please select a report first");
            return;
        }

        ArrayList<MedicalReport> list = new ArrayList<>();
        list.add(selected);
        commonMethods.saveToBinFile("downloaded_reports.bin", list);

        notificationLabel.setText("Report Downloaded Successfully!");
    }

    @FXML
    public void exportPdfOnActionButton(ActionEvent actionEvent) {

        MedicalReport selected = reportTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            commonMethods.showError("No Selection", "Please select a report first");
            return;
        }

        ArrayList<MedicalReport> list = new ArrayList<>();
        list.add(selected);
        commonMethods.saveToBinFile("exported_reports.bin", list);

        notificationLabel.setText("Report Exported Successfully!");
    }

    @FXML
    public void vaccinationsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalIncident.fxml");
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
