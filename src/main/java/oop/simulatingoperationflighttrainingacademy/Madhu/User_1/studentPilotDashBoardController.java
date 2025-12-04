package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class studentPilotDashBoardController {

    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableView<StudentPilot> studentTableView;
    @javafx.fxml.FXML
    private ComboBox<String> instructorComboBox;
    @javafx.fxml.FXML
    private TableColumn<StudentPilot, LocalDateTime> endTimeTableColumn;
    @javafx.fxml.FXML
    private TableColumn<StudentPilot, String> instructorNameTableColumn;
    @javafx.fxml.FXML
    private TextField averageFlightTextField;
    @javafx.fxml.FXML
    private Label NotificationTextField;
    @javafx.fxml.FXML
    private TableColumn<StudentPilot, LocalDateTime> startTimeTableColumn;
    @javafx.fxml.FXML
    private TextField totalFlightHourTextField;
    @javafx.fxml.FXML
    private TableColumn<StudentPilot, String> aircraftModelTableColumn;
    @javafx.fxml.FXML
    private TableColumn<StudentPilot, LocalDate> dateTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        instructorComboBox.getItems().addAll("Md.Ahsan", "phd Mostafizur", "Ms Shila");
        startTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        aircraftModelTableColumn.setCellValueFactory(new PropertyValueFactory<>("airCraftModel"));
        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("instructorName"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        endTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
    }

    @javafx.fxml.FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/trainingSession.fxml");
    }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/resultAndCertificate.fxml");
    }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/bill.fxml");
    }

    @javafx.fxml.FXML
    public void exmOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/exm.fxml");
    }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/logbook.fxml");
    }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/medicalCheckUp.fxml");
    }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/studentPilotDashBoard.fxml");
    }

    @javafx.fxml.FXML
    public void selectSlotOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void bookFlightOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/leave.fxml");
    }
}
