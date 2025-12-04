package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

public class seatingPlanController
{
    @javafx.fxml.FXML
    private TextField todaySeatingPlansTextField;
    @javafx.fxml.FXML
    private Button downloadSeatingPlanPdfButton;
    @javafx.fxml.FXML
    private ComboBox seatingExamComboBox;
    @javafx.fxml.FXML
    private Button generateSeatingPlanButton;
    @javafx.fxml.FXML
    private TableColumn seatingSeatNumberColumn;
    @javafx.fxml.FXML
    private Label seatingGenerateStatusLabel;
    @javafx.fxml.FXML
    private ComboBox seatingPlanTypeComboBox;
    @javafx.fxml.FXML
    private TableView seatingPlanTableView;
    @javafx.fxml.FXML
    private Button regenerateSeatingPlanButton;
    @javafx.fxml.FXML
    private TextField seatingRoomTextField;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField totalSeatingPlansTextField;
    @javafx.fxml.FXML
    private TableColumn seatingStudentNameColumn;
    @javafx.fxml.FXML
    private TableColumn seatingRowColumn;
    @javafx.fxml.FXML
    private Button loadSeatingCandidatesButton;
    @javafx.fxml.FXML
    private TableColumn seatingExamNameColumn;
    @javafx.fxml.FXML
    private TableColumn seatingRoomColumn;
    @javafx.fxml.FXML
    private DatePicker seatingExamDatePicker;
    @javafx.fxml.FXML
    private TableColumn seatingStudentIdColumn;
    @javafx.fxml.FXML
    private Label seatingHeaderStatusLabel;

    @javafx.fxml.FXML
    public void initialize() {
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
    }

    @javafx.fxml.FXML
    public void certificatesOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/certificates.fxml");

    }

    @javafx.fxml.FXML
    public void generateSeatingPlanOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void regenerateSeatingPlanOnActionButton(ActionEvent actionEvent) {
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
    public void loadSeatingCandidatesOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void downloadSeatingPlanPdfOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void misconductOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/misconduct.fxml");

    }
}