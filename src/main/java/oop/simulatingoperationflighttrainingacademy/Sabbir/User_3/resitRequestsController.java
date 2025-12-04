package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

public class resitRequestsController
{
    @javafx.fxml.FXML
    private DatePicker resitExamDatePicker;
    @javafx.fxml.FXML
    private ComboBox upcomingExamComboBox;
    @javafx.fxml.FXML
    private TextField pendingResitRequestsTextField;
    @javafx.fxml.FXML
    private ComboBox resitExamComboBox;
    @javafx.fxml.FXML
    private TableView resitRequestsTableView;
    @javafx.fxml.FXML
    private TableColumn resitStudentNameColumn;
    @javafx.fxml.FXML
    private TableColumn resitExamNameColumn;
    @javafx.fxml.FXML
    private Button enrollResitButton;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn resitStatusColumn;
    @javafx.fxml.FXML
    private TextField processedResitRequestsTextField;
    @javafx.fxml.FXML
    private TableColumn resitStudentIdColumn;
    @javafx.fxml.FXML
    private Label resitHeaderStatusLabel;
    @javafx.fxml.FXML
    private TableColumn resitReasonColumn;
    @javafx.fxml.FXML
    private Button rejectResitButton;
    @javafx.fxml.FXML
    private Button loadResitRequestsButton;
    @javafx.fxml.FXML
    private Label resitActionStatusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void rejectResitOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadResitRequestsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void seatingPlanOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/seatingPlan.fxml");

    }

    @javafx.fxml.FXML
    public void resitRequestsOnActionButton(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/examOfficerDashboard.fxml");

    }

    @javafx.fxml.FXML
    public void enrollResitOnActionButton(ActionEvent actionEvent) {
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