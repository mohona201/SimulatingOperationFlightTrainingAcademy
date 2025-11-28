package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

import java.time.LocalDate;
import java.util.Date;

public class studentPilotDashBoardController
{
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TreeTableView <StudentPilot>studentTableView;
    @javafx.fxml.FXML
    private ComboBox <String>instructorComboBox;
    @javafx.fxml.FXML
    private TreeTableColumn <StudentPilot, String>endTimeTableColumn;
    @javafx.fxml.FXML
    private TreeTableColumn <StudentPilot, String>instructorNameTableColumn;
    @javafx.fxml.FXML
    private TextField averageFlightTextField;
    @javafx.fxml.FXML
    private Label NotificationTextField;
    @javafx.fxml.FXML
    private TreeTableColumn <StudentPilot, String>startTimeTableColumn;
    @javafx.fxml.FXML
    private TextField totalFlightHourTextField;
    @javafx.fxml.FXML
    private TreeTableColumn <StudentPilot, String>aircraftModelTableColumn;
    @javafx.fxml.FXML
    private TreeTableColumn<StudentPilot,LocalDate> dateTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        instructorComboBox.getItems().addAll("Ahmed","Mim","Faruk");

        instructorNameTableColumn.setCellValueFactory(new TreeItemPropertyValueFactory<StudentPilot, String>("Instructor") );

        dateTableColumn.setCellValueFactory(new TreeItemPropertyValueFactory<StudentPilot,LocalDate>("Date"));
        startTimeTableColumn.setCellValueFactory(new TreeItemPropertyValueFactory<StudentPilot,String>("startTime"));
        endTimeTableColumn.setCellValueFactory(new TreeItemPropertyValueFactory<StudentPilot,String>("endtime"));
        aircraftModelTableColumn.setCellValueFactory(new TreeItemPropertyValueFactory<StudentPilot, String>("aircraftModel"));







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