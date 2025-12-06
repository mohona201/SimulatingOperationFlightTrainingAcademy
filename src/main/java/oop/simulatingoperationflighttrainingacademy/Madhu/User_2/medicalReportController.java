package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class medicalReportController {

    @FXML private TableView<MedicalReport> reportTableView;
    @FXML private TableView<MedicalReport> statisticsTableView;

    @FXML private TableColumn<MedicalReport, Integer> reportIdTableColumn;
    @FXML private TableColumn<MedicalReport, String> reportNameTableColumn;
    @FXML private TableColumn<MedicalReport, String> reportStatusTableColumn;
    @FXML private TableColumn<MedicalReport, LocalDate> reportDateTableColumn;

    @FXML private TextField reportIdTextField;
    @FXML private TextField reportNameTextField;
    @FXML private DatePicker reportDatePicker;

    @FXML private ComboBox<String> reportTypeComboBox;
    @FXML private Label notificationLabel;

    @FXML
    public void initialize() {

        reportTypeComboBox.getItems().addAll(
                "CT Scan Report",
                "X-Ray Report",
                "Ultrasound Report",
                "Blood Test Report",
                "Urine Test Report"
        );

        reportIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        reportNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("reportName"));
        reportStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("reportStatus"));
        reportDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("reportDate"));

        commonMethods.showTableDataFromBinFile("report.bin", reportTableView);
        commonMethods.showTableDataFromBinFile("report.bin", statisticsTableView);
    }

    @FXML
    public void loadReportOnActionButton(ActionEvent event) {

        String idText = reportIdTextField.getText().trim();
        String name = reportNameTextField.getText().trim();
        LocalDate date = reportDatePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || date == null) {
            commonMethods.showError("Empty Fields", "Please fill all fields");
            return;
        }

        if (!idText.matches("[0-9]+")) {
            commonMethods.showError("Invalid ID", "Report ID must be numeric");
            return;
        }

        Integer id = Integer.parseInt(idText);
        String status = "Completed";

        MedicalReport report = new MedicalReport(id, name, status, date);

        ArrayList<MedicalReport> old = new ArrayList<>();
        old.addAll(reportTableView.getItems());
        old.add(report);

        commonMethods.saveToBinFile("report.bin", old);

        reportTableView.getItems().add(report);
        statisticsTableView.getItems().add(report);

        notificationLabel.setText("Report Submitted Successfully!");

        reportIdTextField.clear();
        reportNameTextField.clear();
        reportDatePicker.setValue(null);
    }

    @FXML
    public void downloadReportOnActionButton(ActionEvent event) {

        String idText = reportIdTextField.getText().trim();
        String name = reportNameTextField.getText().trim();
        LocalDate date = reportDatePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || date == null) {
            commonMethods.showError("Empty Fields", "Fill all fields before downloading");
            return;
        }

        Integer id = Integer.parseInt(idText);
        String status = "Completed";

        MedicalReport newReport = new MedicalReport(id, name, status, date);

        ArrayList<MedicalReport> downloadList = new ArrayList<>();
        downloadList.add(newReport);
        commonMethods.saveToBinFile("downloaded_reports.bin", downloadList);

        notificationLabel.setText("Report Downloaded Successfully!");
    }

    @FXML
    public void exportPdfOnActionButton(ActionEvent event) {

        MedicalReport selected = reportTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            commonMethods.showError("No Selection", "Please select a report first");
            return;
        }

        ArrayList<MedicalReport> exportList = new ArrayList<>();
        exportList.add(selected);
        commonMethods.saveToBinFile("exported_reports.bin", exportList);

        notificationLabel.setText("Report Exported Successfully!");
    }

    @FXML public void dashboardOnActionButton(ActionEvent e) {
        commonMethods.sceneChange(e,"Madhu/User_2/medicalSpecialistDashboard.fxml");
    }
    @FXML public void renewalsOnActionButton(ActionEvent e) { commonMethods.sceneChange(e,"Madhu/User_2/renewal.fxml"); }
    @FXML public void vaccinationsOnActionButton(ActionEvent e) { commonMethods.sceneChange(e,"Madhu/User_2/vaccination.fxml"); }
    @FXML public void suspensionsOnActionButton(ActionEvent e) { commonMethods.sceneChange(e,"Madhu/User_2/suspension.fxml"); }
    @FXML public void incidentsOnActionButton(ActionEvent e) { commonMethods.sceneChange(e,"Madhu/User_2/medicalIncident.fxml"); }
    @FXML public void preFlightOnActionButton(ActionEvent e) { commonMethods.sceneChange(e,"Madhu/User_2/preFlight.fxml"); }
    @FXML public void reportsOnActionButton(ActionEvent e) { commonMethods.sceneChange(e,"Madhu/User_2/medicalReport.fxml"); }
    @FXML public void regularPatientsOnActionButton(ActionEvent e) { commonMethods.sceneChange(e,"Madhu/User_2/regularPatient.fxml"); }
}
