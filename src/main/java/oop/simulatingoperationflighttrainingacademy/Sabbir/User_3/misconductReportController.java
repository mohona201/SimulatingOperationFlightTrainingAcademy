package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

public class misconductReportController
{
    @javafx.fxml.FXML
    private Button refreshMisconductButton;
    @javafx.fxml.FXML
    private TableColumn misconductIdColumn;
    @javafx.fxml.FXML
    private TableColumn misconductExamIdColumn;
    @javafx.fxml.FXML
    private TableColumn misconductDateColumn;
    @javafx.fxml.FXML
    private TableView misconductTableView;
    @javafx.fxml.FXML
    private TableColumn misconductStrikeColumn;
    @javafx.fxml.FXML
    private Label misconductStatusLabel;
    @javafx.fxml.FXML
    private TextField misconductStudentIdsTextField;
    @javafx.fxml.FXML
    private TableColumn misconductSessionIdColumn;
    @javafx.fxml.FXML
    private TextField totalMisconductTextField;
    @javafx.fxml.FXML
    private Button createMisconductReportButton;
    @javafx.fxml.FXML
    private TableColumn misconductStudentIdColumn;
    @javafx.fxml.FXML
    private TextField todayMisconductTextField;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField misconductSessionIdTextField;
    @javafx.fxml.FXML
    private TextField misconductExamIdTextField;
    @javafx.fxml.FXML
    private TableColumn misconductDescriptionColumn;
    @javafx.fxml.FXML
    private TextField misconductDescriptionTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createMisconductReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void seatingPlanOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/seatingPlan.fxml");

    }

    @javafx.fxml.FXML
    public void resitRequestsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/resitRequest.fxml");

    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/examOfficerDashboard.fxml");

    }

    @javafx.fxml.FXML
    public void refreshMisconductOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void certificatesOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/certificates.fxml");

    }

    @javafx.fxml.FXML
    public void questionBankOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/questionBank.fxml");

    }

    @javafx.fxml.FXML
    public void markingOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/marking.fxml");

    }

    @javafx.fxml.FXML
    public void eligibilityOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/eligibility.fxml");

    }

    @javafx.fxml.FXML
    public void misconductOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/misconduct.fxml");

    }
}