package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.util.ArrayList;

public class MarkingController
{
    @javafx.fxml.FXML
    private DatePicker markingExamDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> markingExamComboBox;
    @javafx.fxml.FXML
    private TextField markingStudentIdTextField;
    @javafx.fxml.FXML
    private TableColumn<marking, String> marksStatusColumn;
    @javafx.fxml.FXML
    private TextField examsToMarkTextField;
    @javafx.fxml.FXML
    private TableColumn<marking, Integer> marksScoreColumn;
    @javafx.fxml.FXML
    private Button exportMarksPdfButton;
    @javafx.fxml.FXML
    private TextField markingStudentNameTextField;
    @javafx.fxml.FXML
    private Button saveMarkButton;
    @javafx.fxml.FXML
    private Button loadExamCandidatesButton;
    @javafx.fxml.FXML
    private TableColumn<marking, String> marksStudentNameColumn;
    @javafx.fxml.FXML
    private TableColumn<marking, String> marksExamNameColumn;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private Label markingStatusLabel;
    @javafx.fxml.FXML
    private Label markingHeaderStatusLabel;
    @javafx.fxml.FXML
    private TextField markingRemarksTextField;
    @javafx.fxml.FXML
    private TableColumn<marking, String> marksStudentIdColumn;
    @javafx.fxml.FXML
    private TextField markingScoreTextField;
    @javafx.fxml.FXML
    private TableView marksTableView;
    @javafx.fxml.FXML
    private TextField recentlyMarkedTextField;
    @javafx.fxml.FXML
    private TableView marksTableView1;
    @javafx.fxml.FXML
    private TableColumn<marking, String> StudentListStudentNameColumn;
    @javafx.fxml.FXML
    private TableColumn<marking, String> StudentListExamNameColumn;
    @javafx.fxml.FXML
    private TableColumn<marking, String> StudentListStudentIdColumn;

    ArrayList<marking> markingList;

    @javafx.fxml.FXML
    public void initialize() {
        markingExamComboBox.getItems().setAll("Theory Exam", "Flight Test");

        StudentListStudentIdColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("studentId"));
        StudentListStudentNameColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("studentName"));
        StudentListExamNameColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("exam"));

        marksStudentIdColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("studentId"));
        marksStudentNameColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("studentName"));
        marksExamNameColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("exam"));
        marksScoreColumn.setCellValueFactory(new PropertyValueFactory<marking, Integer>("score"));
        marksStatusColumn.setCellValueFactory(new PropertyValueFactory<marking, String>("passFailStatus"));

    }

    @javafx.fxml.FXML
    public void seatingPlanOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resitRequestsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadExamCandidatesOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void certificatesOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exportMarksPdfOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveMarkOnActionButton(ActionEvent actionEvent) {
        String name = markingStudentNameTextField.getText();
        String id  =  markingStudentIdTextField.getText();
        String exam = markingExamComboBox.getValue();
        String remarks = markingRemarksTextField.getText();
        String score = markingScoreTextField.getText();

        if(name.isEmpty() || exam.isEmpty() || remarks.isEmpty() || score.isEmpty() || id.isEmpty()){
            commonMethods.showError("Empty Field", "Please fill all the fields");
            return;
        }

        String passFailStatus = "";
        if(Integer.parseInt(score)>=50){
            passFailStatus = "Passed";
        } else if (Integer.parseInt(score) <50) {
            passFailStatus = "Failed";
        }


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
    public void misconductOnActionButton(ActionEvent actionEvent) {
    }
}