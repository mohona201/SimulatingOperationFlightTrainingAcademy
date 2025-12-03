package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    }

    @javafx.fxml.FXML
    public void ScheduleOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void examsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void selectSlotOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void bookFlightOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
    }
}