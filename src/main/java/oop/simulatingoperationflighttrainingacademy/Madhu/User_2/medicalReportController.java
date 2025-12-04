package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;

public class medicalReportController {

    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableView<MedicalReport> statisticsTableView;
    @javafx.fxml.FXML
    private TableView<MedicalReport> reportTableView;
    @javafx.fxml.FXML
    private Label reportStatusLabel;
    @javafx.fxml.FXML
    private TableColumn<MedicalReport, String> reportNameTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<MedicalReport, String> statValueTableColumn;
    @javafx.fxml.FXML
    private TableColumn<MedicalReport, String> statCategoryTableColumn;
    @javafx.fxml.FXML
    private TableColumn<MedicalReport, LocalDate> reportDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<MedicalReport, String> reportStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<MedicalReport, LocalDate> statYearTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        reportTypeComboBox.getItems().add("");

        statCategoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("statusCategory"));
        reportDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("reportDate"));
        reportStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("reportStatus"));
        statYearTableColumn.setCellValueFactory(new PropertyValueFactory<>("statYear"));
        statValueTableColumn.setCellValueFactory(new PropertyValueFactory<>("statValue"));
        reportNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("reportName"));
    }

    @javafx.fxml.FXML
    public void loadReportOnActionButton(ActionEvent actionEvent) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data"));

            for (MedicalReport mr : reportTableView.getItems()) {
                bw.write("Report: " + mr.getReportName() + "\n");
                bw.write("Date: " + mr.getReportDate() + "\n");
                bw.write("Status: " + mr.getReportStatus() + "\n\n");
            }

            bw.write("");

            for (MedicalReport st : statisticsTableView.getItems()) {
                bw.write(st.getStatusCategory() + ": " +
                        st.getStatValue() + " (" +
                        st.getStatYear() + ")\n");
            }

            bw.close();

            reportStatusLabel.setText("PDF exported successfully.");
            notificationLabel.setText("PDF saved as exportedReport.pdf");
            showError("Medical Report has been exported.");

        } catch (Exception e) {
            reportStatusLabel.setText("PDF export failed.");
            notificationLabel.setText("Could not save exportedReport.pdf");
            showError("Failed to export PDF.");
        }
    }

    @javafx.fxml.FXML
    public void vaccinationsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalIncident.fxml");
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
        commonMethods.sceneChange(actionEvent,"Madhu/User_2/medicalReport.fxml");
    }

    @javafx.fxml.FXML
    public void exportPdfOnActionButton(ActionEvent actionEvent) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("exportedReport.pdf"));

            for (MedicalReport mr : reportTableView.getItems()) {
                bw.write("Report: " + mr.getReportName() + "\n");
                bw.write("Date: " + mr.getReportDate() + "\n");
                bw.write("Status: " + mr.getReportStatus() + "\n\n");
            }

            bw.write("");

            for (MedicalReport st : statisticsTableView.getItems()) {
                bw.write(st.getStatusCategory() + ": " +
                        st.getStatValue() + " (" +
                        st.getStatYear() + ")\n");
            }

            bw.close();

            reportStatusLabel.setText("PDF exported successfully.");
            notificationLabel.setText("File saved as exportedReport.pdf");
            showError("Medical Report has been exported.");

        } catch (Exception e) {
            reportStatusLabel.setText("PDF export failed.");
            notificationLabel.setText("Could not save exportedReport.pdf");
            showError("Failed to export PDF.");
        }
    }

    @javafx.fxml.FXML
    public void downloadReportOnActionButton(ActionEvent actionEvent) {

        try {
            java.io.File file = new java.io.File("exportedReport.pdf");

            if (!file.exists()) {
                notificationLabel.setText("PDF not found.");
                reportStatusLabel.setText("Download failed.");
                showError("The report was not found. Please export it first.");
                return;
            }

            notificationLabel.setText("PDF is ready for download.");
            reportStatusLabel.setText("PDF found.");
            showError("The PDF report is available: exportedReport.pdf");

        } catch (Exception e) {
            notificationLabel.setText("Download failed.");
            reportStatusLabel.setText("Error opening PDF.");
            showError("Something went wrong while downloading the report.");
        }
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
