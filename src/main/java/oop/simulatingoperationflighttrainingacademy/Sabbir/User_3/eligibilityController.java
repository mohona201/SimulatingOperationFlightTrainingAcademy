package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.util.ArrayList;

public class eligibilityController
{
    @FXML
    private TextField approvedEligibilityTextField;
    @FXML
    private TextField pendingEligibilityTextField;
    @FXML
    private TextField completedHoursTextField;
    @FXML
    private TextField endorsementStatusTextField;
    @FXML
    private TextField feeStatusTextField;
    @FXML
    private Label eligibilityStatusLabel;
    @FXML
    private Label notificationLabel;
    @FXML
    private ComboBox<String> eligibilityExamComboBox;
    @FXML
    private TextField eligibilityRemarksTextField;
    @FXML
    private TextField medicalStatusTextField;
    @FXML
    private TextField studentIdTextField;
    @FXML
    private Button loadStudentButton;
    @FXML
    private Button updateEligibilityButton;
    @FXML
    private Label NameView;
    @FXML
    private TableColumn<eligibility, String> studentIdColumn;
    @FXML
    private TableColumn<eligibility, String> eligibilityStatusColumn;
    @FXML
    private TableColumn<eligibility, String> eligibilityExamColumn;
    @FXML
    private Label IDView;
    @FXML
    private TableColumn<eligibility, String> eligibilityRemarksColumn;
    @FXML
    private TableView<eligibility> eligibilityTableView;
    @FXML
    private TableColumn<eligibility, String> studentNameColumn;

    ArrayList<eligibility> eligibilityList;
    @FXML
    private RadioButton RejectRadioButton;
    @FXML
    private RadioButton approveRadiotButton;

    public void initialize() {
        eligibilityList = new ArrayList<>();
        eligibilityExamComboBox.getItems().setAll(
                "Theory Exam",
                "Flight Test"
        );

        ToggleGroup group = new ToggleGroup();
        approveRadiotButton.setToggleGroup(group);
        RejectRadioButton.setToggleGroup(group);


        studentIdColumn.setCellValueFactory(new PropertyValueFactory<eligibility, String>("studentId"));
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<eligibility, String>("studentName"));
        eligibilityExamColumn.setCellValueFactory(new PropertyValueFactory<eligibility, String>("examName"));
        eligibilityRemarksColumn.setCellValueFactory(new PropertyValueFactory<eligibility, String>("remarks"));
        eligibilityStatusColumn.setCellValueFactory(new PropertyValueFactory<eligibility, String>("eligibilityStatus"));

        eligibilityTableView.getItems().setAll(eligibilityList);
    }

    @javafx.fxml.FXML
    public void seatingPlanOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resitRequestsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void certificatesOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadStudentOnActionButton(ActionEvent actionEvent) {
        String studentId = studentIdTextField.getText();
        if (studentId.isEmpty()) {commonMethods.showError(
                "Student ID is Empty",
                "Please enter student ID");}
    }

    @javafx.fxml.FXML
    public void questionBankOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void markingOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void eligibilityOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateEligibilityOnActionButton(ActionEvent actionEvent) {
        String exam = this.eligibilityExamComboBox.getValue();
        String studentId = this.studentIdTextField.getText();
        boolean approved = this.approveRadiotButton.isSelected();
        boolean rejected = this.RejectRadioButton.isSelected();
        String eligibilityRemarks = this.eligibilityRemarksTextField.getText();

        if (exam.isEmpty() || studentId.isEmpty() || eligibilityRemarks.isEmpty()) {
            commonMethods.showError("Empty Fields",
                    "Pleas fill all the fields");
            return;

        }
        String decision = null;
        if (approved) {decision = "Approved";} else if (rejected) {decision = "Rejected";}


    }

    @javafx.fxml.FXML
    public void misconductOnActionButton(ActionEvent actionEvent) {
    }
}