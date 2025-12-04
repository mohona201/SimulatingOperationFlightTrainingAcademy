package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class studentPilotDashBoardController
{
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableView <StudentPilot>studentTableView;
    @javafx.fxml.FXML
    private ComboBox <String>instructorComboBox;
    @javafx.fxml.FXML
    private TableColumn <StudentPilot, LocalDateTime>endTimeTableColumn;
    @javafx.fxml.FXML
    private TableColumn <StudentPilot,String>instructorNameTableColumn;
    @javafx.fxml.FXML
    private TextField averageFlightTextField;
    @javafx.fxml.FXML
    private Label NotificationTextField;
    @javafx.fxml.FXML
    private TableColumn <StudentPilot,LocalDateTime>startTimeTableColumn;
    @javafx.fxml.FXML
    private TextField totalFlightHourTextField;
    @javafx.fxml.FXML
    private TableColumn <StudentPilot,String>aircraftModelTableColumn;
    @javafx.fxml.FXML
    private TableColumn <StudentPilot,LocalDate>dateTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        instructorComboBox.getItems().addAll(" Md.Ahsan","phd Mostafizur","Ms Shila");
        startTimeTableColumn.setCellValueFactory(new PropertyValueFactory<StudentPilot,LocalDateTime>("Start Time"));
        aircraftModelTableColumn.setCellValueFactory(new PropertyValueFactory<StudentPilot,String>("air Craft Model"));
        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<StudentPilot,String>("Instructor Name"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<StudentPilot,LocalDate>("date"));
        endTimeTableColumn.setCellValueFactory(new PropertyValueFactory<StudentPilot,LocalDateTime>("endTime"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<StudentPilot,LocalDate>("date"));
    }

    @javafx.fxml.FXML
    public void ScheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/trainingSession.fxml");
    }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/resultAndCertificate.fxml");
    }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/Bill.fxml");
    }

    @javafx.fxml.FXML
    public void examsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/exm.fxml");
    }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/logbook");
    }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/medicalCheckUp.fxml");
    }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/studentPilotDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void selectSlotOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void bookFlightOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/leave.fxml");
    }
}