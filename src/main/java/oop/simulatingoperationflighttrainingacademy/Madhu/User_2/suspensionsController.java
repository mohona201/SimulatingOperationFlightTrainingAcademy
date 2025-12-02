package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

public class suspensionsController {

    @javafx.fxml.FXML
    private TableColumn<Suspension, String> recentIncidentTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Suspension, Integer> patientIdTableColumn;
    @javafx.fxml.FXML
    private RadioButton noSuspendRadioButton;
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
    private RadioButton suspendRadioButton;
    @javafx.fxml.FXML
    private Label suspensionStatusLabel;
    @javafx.fxml.FXML
    private TableColumn<Suspension, LocalDate> incidentDateTableColumn;
    @javafx.fxml.FXML
    private Button confirmSuspensionButton;
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

        incidentDetailsTableView.getItems().clear();
        patientSuspensionTableView.getItems().clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader("incidentRecords.txt"));
            String line;

            while ((line = br.readLine()) != null) {

                String[] cut = line.split(",");

                if (cut.length == 6) {

                    int id = Integer.parseInt(cut[0].trim());
                    LocalDate date = LocalDate.parse(cut[5].trim());

                    incidentDetailsTableView.getItems().add(
                            new Suspension(
                                    id,
                                    cut[1].trim(),
                                    cut[2].trim(),
                                    cut[3].trim(),
                                    cut[4].trim(),
                                    date
                            )
                    );
                }
            }

            br.close();

            notificationLabel.setText("Incident record loaded.");
            suspensionStatusLabel.setText("Data loaded successfully.");
            commonMethod.showError("Incident data has been loaded.");

        } catch (Exception e) {
            notificationLabel.setText("Could not load incidentRecords.txt");
            suspensionStatusLabel.setText("Failed to load data.");
            showError("Incident file loading failed.");
        }
    }

    @javafx.fxml.FXML
    public void vaccinationsOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void suspendOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void renewalsOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void suspensionsOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void noSuspendOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void incidentsOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void preFlightOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void confirmSuspensionOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void reportsOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) { }


}
