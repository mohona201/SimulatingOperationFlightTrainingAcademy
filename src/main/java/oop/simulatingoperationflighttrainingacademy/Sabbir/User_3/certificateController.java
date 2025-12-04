package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

public class certificateController
{
    @javafx.fxml.FXML
    private TextField generatedTodayTextField;
    @javafx.fxml.FXML
    private TableColumn certStudentIdColumn;
    @javafx.fxml.FXML
    private TableColumn certExamDateColumn;
    @javafx.fxml.FXML
    private ComboBox certificateExamComboBox;
    @javafx.fxml.FXML
    private TableColumn certStudentNameColumn;
    @javafx.fxml.FXML
    private Label certificateHeaderStatusLabel;
    @javafx.fxml.FXML
    private TableColumn certStatusColumn;
    @javafx.fxml.FXML
    private Button selectAllCertificatesButton;
    @javafx.fxml.FXML
    private TableColumn certScoreColumn;
    @javafx.fxml.FXML
    private TableView passedStudentsTableView;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField pendingCertificatesTextField;
    @javafx.fxml.FXML
    private Button generateCertificatesButton;
    @javafx.fxml.FXML
    private Button loadPassedStudentsButton;
    @javafx.fxml.FXML
    private DatePicker certificateExamDatePicker;
    @javafx.fxml.FXML
    private TableColumn certExamNameColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadPassedStudentsOnActionButton(ActionEvent actionEvent) {
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
    public void certificatesOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/certificates.fxml");
    }

    @javafx.fxml.FXML
    public void selectAllCertificatesOnActionButton(ActionEvent actionEvent) {
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
    public void generateCertificatesOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void misconductOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/misconduct.fxml");

    }
}