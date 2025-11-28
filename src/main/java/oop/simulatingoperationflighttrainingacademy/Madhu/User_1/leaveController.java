package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class leaveController
{
    @javafx.fxml.FXML
    private TextField easonForLeaveTextField;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn  <Leave,String>rreasonTableColumn;
    @javafx.fxml.FXML
    private DatePicker leaveDatepicker;
    @javafx.fxml.FXML
    private TableColumn  <Leave, LocalDateTime>rsubmissionTableColumn;
    @javafx.fxml.FXML
    private TextField studentNameTextField;
    @javafx.fxml.FXML
    private TableColumn  <Leave,LocalDate>rleaveStartDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn  <Leave, LocalDate>rleaveEndDateTableColumn;
    @javafx.fxml.FXML
    private TextField studentIdTextField;
    @javafx.fxml.FXML
    private Label leaveHistoryTableView;

    @javafx.fxml.FXML
    public void initialize() {
        rleaveEndDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("leaveEndDate"));
        rleaveStartDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("leaveStartDate"));
        rsubmissionTableColumn.setCellValueFactory(new PropertyValueFactory<>("submissionDate"));
        rreasonTableColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));

    }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitLeaveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void examOnActionButton(ActionEvent actionEvent) {
    }
}