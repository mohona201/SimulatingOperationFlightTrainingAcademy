package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class logbookController {

    @FXML
    private Label notificationLabel;
    @FXML
    private ComboBox<String> airCraftModelComboBox;
    @FXML
    private TextField flightTimeTextField;
    @FXML
    private TextField instructorNameTextField;
    @FXML
    private TableColumn<LogBook, String> instructorNameTableColumn;
    @FXML
    private TableColumn<LogBook, String> flightPathTableColumn;
    @FXML
    private TableColumn<LogBook, LocalDate> dateTableColumn;
    @FXML
    private DatePicker dateDatePickerComboBox;
    @FXML
    private TableColumn<LogBook, String> airCraftModelTableColumn;
    @FXML
    private TableColumn<LogBook, String> flightTimeTableColumn;
    @FXML
    private TableView<LogBook> flightBookTableView;

    ArrayList<LogBook> filtered = new ArrayList<>();


    @FXML
    public void initialize() {
        airCraftModelComboBox.getItems().addAll("A2KS", "Air20W", "KG25");

        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("instructorName"));
        flightPathTableColumn.setCellValueFactory(new PropertyValueFactory<>("flightPath"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        airCraftModelTableColumn.setCellValueFactory(new PropertyValueFactory<>("aircraftModel"));
        flightTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("flightTime"));

        commonMethods.showTableDataFromBinFile("logbook.bin", flightBookTableView);
    }

    @FXML
    public void applyFilterOnActionButton(ActionEvent actionEvent) {

        String instructor = instructorNameTextField.getText().trim();
        String model = airCraftModelComboBox.getValue();
        LocalDate date = dateDatePickerComboBox.getValue();

        if (instructor.isEmpty()  && model == null && date == null) {
            commonMethods.showError("Empty Filter", "Please enter at least one filter");
            notificationLabel.setText("Fields are empty");
            return;
        }

        ArrayList<LogBook> allLogs = new ArrayList<>();
        flightBookTableView.getItems().clear();
        commonMethods.showTableDataFromBinFile("logbook.bin", flightBookTableView);
        allLogs.addAll(flightBookTableView.getItems());
        flightBookTableView.getItems().clear();

        ArrayList<LogBook> filtered = new ArrayList<>();

        for (LogBook log : allLogs) {

            if (!instructor.isEmpty() && !log.getInstructorName().equalsIgnoreCase(instructor)) continue;
            if (model != null && !log.getAircraftModel().equalsIgnoreCase(model)) continue;
            if (date != null && !log.getDate().equals(date)) continue;

            filtered.add(log);
        }

        flightBookTableView.getItems().setAll(filtered);
        notificationLabel.setText("Filter Applied Successfully!");
    }

    @FXML
    public void clearFilterOnActionButton(ActionEvent actionEvent) {
        instructorNameTextField.clear();
        airCraftModelComboBox.setValue(null);
        dateDatePickerComboBox.setValue(null);

        flightBookTableView.getItems().clear();
        commonMethods.showTableDataFromBinFile("logbook.bin", flightBookTableView);

        notificationLabel.setText("Filter Cleared");
    }

    @FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/resultAndCertificate.fxml");
    }

    @FXML
    public void billOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/bill.fxml");
    }

    @FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/studentPilotDashboard.fxml");
    }

    @FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/medicalCheckUp.fxml");
    }

    @FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/trainingSession.fxml");
    }

    @FXML
    public void exmOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/exm.fxml");
    }

    @FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/leave.fxml");
    }
}
