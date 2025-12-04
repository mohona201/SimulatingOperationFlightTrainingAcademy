package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;

public class leaveController
{
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private DatePicker leaveDatepicker;
    @javafx.fxml.FXML
    private TextField studentNameTextField;
    @javafx.fxml.FXML
    private TextField studentIdTextField;
    @javafx.fxml.FXML
    private Label leaveHistoryTableView;
    @javafx.fxml.FXML
    private TextField reasonForLeaveTextField;
    @javafx.fxml.FXML
    private TableColumn <Leave,StudentPilot>reasonTableColumn;
    @javafx.fxml.FXML
    private TableColumn <Leave,String>submissionTableColumn;
    @javafx.fxml.FXML
    private TableColumn <Leave,LocalDate>leaveStartDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn <Leave,LocalDate>leaveEndDateTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        leaveStartDateTableColumn.setCellValueFactory(new PropertyValueFactory<Leave,LocalDate>("date"));
        leaveEndDateTableColumn.setCellValueFactory(new PropertyValueFactory<Leave,LocalDate>("endDAte"));
        submissionTableColumn.setCellValueFactory(new PropertyValueFactory<Leave,String>("submission"));
        reasonTableColumn.setCellValueFactory(new PropertyValueFactory<Leave,StudentPilot>("reason"));


    }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/resultAndCertificate.fxml");
    }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/bill.fxml");

    }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/logBook.fxml");
    }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/medicalCheckUp.fxml");
    }

    @javafx.fxml.FXML
    public void submitLeaveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/trainingSession.fxml");
    }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/studentPilotDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/leave.fxml");
    }

    @javafx.fxml.FXML
    public void examOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/Exm.fxml");
    }
}