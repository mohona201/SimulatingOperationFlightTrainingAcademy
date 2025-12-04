package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.util.ArrayList;

public class MarkingController {

    @FXML
    private DatePicker markingExamDatePicker;
    @FXML
    private ComboBox<String> markingExamComboBox;
    @FXML
    private TextField markingStudentIdTextField;
    @FXML
    private TableColumn<marking, String> marksStatusColumn;
    @FXML
    private TextField examsToMarkTextField;
    @FXML
    private TableColumn<marking, Integer> marksScoreColumn;
    @FXML
    private TextField markingStudentNameTextField;
    @FXML
    private Button saveMarkButton;
    @FXML
    private Button loadExamCandidatesButton;
    @FXML
    private TableColumn<marking, String> marksStudentNameColumn;
    @FXML
    private TableColumn<marking, String> marksExamNameColumn;
    @FXML
    private Label notificationLabel;
    @FXML
    private Label markingStatusLabel;
    @FXML
    private Label markingHeaderStatusLabel;
    @FXML
    private TextField markingRemarksTextField;
    @FXML
    private TableColumn<marking, String> marksStudentIdColumn;
    @FXML
    private TextField markingScoreTextField;
    @FXML
    private TableView<marking> marksTableView;
    @FXML
    private TextField recentlyMarkedTextField;
    @FXML
    private TableColumn<marking, String> StudentListStudentNameColumn;
    @FXML
    private TableColumn<marking, String> StudentListExamNameColumn;
    @FXML
    private TableColumn<marking, String> StudentListStudentIdColumn;

    ArrayList<marking> markingList;
    @FXML
    private TableView marksTableView1;
    @FXML
    private TableColumn marksRemarksColumn;

    @FXML
    public void initialize() {
        markingList = new ArrayList<>();

        markingExamComboBox.getItems().setAll("Theory Exam", "Flight Test");

        StudentListStudentIdColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("studentId"));
        StudentListStudentNameColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("studentName"));
        StudentListExamNameColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("exam"));

        marksStudentIdColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("studentId"));
        marksStudentNameColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("studentName"));
        marksExamNameColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("exam"));
        marksScoreColumn.setCellValueFactory(new PropertyValueFactory<marking, Integer>("score"));
        marksStatusColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("passFailStatus"));

        commonMethods.showTableDataFromBinFile("stundentMark.bin", marksTableView);
    }

    @FXML
    public void seatingPlanOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/seatingPlan.fxml");
    }

    @FXML
    public void resitRequestsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/resitRequest.fxml");
    }

    @FXML
    public void loadExamCandidatesOnActionButton(ActionEvent actionEvent) {
        // If you later store exam candidate list in a bin file, you can load it here
        // For now, just a status message:
        notificationLabel.setText("Load exam candidates feature not implemented yet.");
    }

    @FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/examOfficerDashboard.fxml");
    }

    @FXML
    public void certificatesOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/certificates.fxml");
    }

    @Deprecated
    public void exportMarksPdfOnActionButton(ActionEvent actionEvent) {
        // PDF export logic can be added later (not required for bin save)
        notificationLabel.setText("PDF export not implemented.");
    }

    @FXML
    public void saveMarkOnActionButton(ActionEvent actionEvent) {
        String name = markingStudentNameTextField.getText().trim();
        String id  = markingStudentIdTextField.getText().trim();
        String exam = markingExamComboBox.getValue();
        String remarks = markingRemarksTextField.getText().trim();
        String scoreText = markingScoreTextField.getText().trim();

        if (name.isEmpty() || exam == null || exam.isEmpty()
                || remarks.isEmpty() || scoreText.isEmpty() || id.isEmpty()) {
            commonMethods.showError("Empty Field", "Please fill all the fields");
            return;
        }

        int score;
        try {
            score = Integer.parseInt(scoreText);
        } catch (NumberFormatException e) {
            commonMethods.showError("Invalid Score", "Score must be a number.");
            return;
        }

        String passFailStatus;
        if (score >= 50) {
            passFailStatus = "Passed";
        } else {
            passFailStatus = "Failed";
        }

        // Create marking record
        marking newMark = new marking(
                id,
                name,
                exam,
                score,
                remarks,
                passFailStatus
        );

        // Save to bin file (append mode via commonMethods)
        markingList = new ArrayList<>();
        markingList.add(newMark);
        commonMethods.saveToBinFile("stundentMark.bin", markingList);

        // Update tables and UI
        marksTableView.getItems().add(newMark);
        recentlyMarkedTextField.setText(id + " - " + name);
        markingStatusLabel.setText("Saved: " + passFailStatus);
        markingHeaderStatusLabel.setText("Last marked: " + exam);
        notificationLabel.setText("Mark saved for student " + id);

        // Clear fields (optional)
        markingScoreTextField.clear();
        markingRemarksTextField.clear();
        // keep name/id if you want to mark multiple exams for same student, or clear:
        // markingStudentNameTextField.clear();
        // markingStudentIdTextField.clear();
        markingExamComboBox.setValue(null);
    }

    @FXML
    public void questionBankOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/questionBank.fxml");
    }

    @FXML
    public void markingOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/marking.fxml");
    }

    @FXML
    public void eligibilityOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/eligibility.fxml");
    }

    @FXML
    public void misconductOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/misconduct.fxml");
    }
}
