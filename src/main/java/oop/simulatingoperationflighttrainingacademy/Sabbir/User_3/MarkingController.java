package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.*;
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
    private TableColumn<examCandidate, String> StudentListStudentNameColumn;
    @FXML
    private TableColumn<examCandidate, String> StudentListExamNameColumn;
    @FXML
    private TableColumn<examCandidate, String> StudentListStudentIdColumn;
    @FXML
    private TableView<examCandidate> marksTableView1;

    @FXML
    private TableColumn<marking, String> marksRemarksColumn;

    ArrayList<marking> markingList;

    @FXML
    public void initialize() {
        markingList = new ArrayList<>();

        markingExamComboBox.getItems().setAll("Theory Exam", "Flight Test");

        StudentListStudentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        StudentListStudentNameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        StudentListExamNameColumn.setCellValueFactory(new PropertyValueFactory<>("exam"));

        marksStudentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        marksStudentNameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        marksExamNameColumn.setCellValueFactory(new PropertyValueFactory<>("exam"));
        marksScoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        marksStatusColumn.setCellValueFactory(new PropertyValueFactory<>("passFailStatus"));
        marksRemarksColumn.setCellValueFactory(new PropertyValueFactory<>("remarks"));

        commonMethods.showTableDataFromBinFile("stundentMark.bin", marksTableView);

        commonMethods.showTableDataFromBinFile("examCandiates.bin", marksTableView1);
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
        String exam = markingExamComboBox.getValue();

        if (exam == null || exam.isEmpty()) {
            commonMethods.showError("No Exam Selected", "Please select an exam first.");
            return;
        }

        ArrayList<examCandidate> candidateList = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            File file = new File("data/examCandiates.bin");
            if (!file.exists()) {
                commonMethods.showError("Load Error", "Could not load: examCandiates.bin");
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    examCandidate c = (examCandidate) ois.readObject();

                    if (c.getExam().equals(exam)) {
                        candidateList.add(c);
                    }



                } catch (EOFException eof) {
                    break;   // normal end of file
                }
            }

            ois.close();  // explicit close, no finally

        } catch (Exception e) {
            System.out.println("Error loading exam candidates: " + e.getMessage());
            notificationLabel.setText("Error loading exam candidates.");
            return;
        }

        marksTableView1.getItems().clear();
        marksTableView1.getItems().addAll(candidateList);

        examsToMarkTextField.setText(String.valueOf(candidateList.size()));

        if (candidateList.isEmpty()) {
            notificationLabel.setText("No candidates found for this exam.");
        } else {
            notificationLabel.setText("Exam candidates loaded.");
        }
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

        marking newMark = new marking(
                id,
                name,
                exam,
                score,
                remarks,
                passFailStatus
        );

        markingList = new ArrayList<>();
        markingList.add(newMark);
        commonMethods.saveToBinFile("stundentMark.bin", markingList);

        marksTableView.getItems().add(newMark);
        notificationLabel.setText("Mark saved for student " + id);

        markingScoreTextField.clear();
        markingRemarksTextField.clear();
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

    public static class marking implements Serializable {
        String studentId;
        String studentName;
        String exam;
        Integer score;
        String remarks;
        String passFailStatus;

        public marking(String studentId, String studentName, String exam,
                       Integer score, String remarks, String passFailStatus) {
            this.studentId = studentId;
            this.studentName = studentName;
            this.exam = exam;
            this.score = score;
            this.remarks = remarks;
            this.passFailStatus = passFailStatus;
        }


        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getExam() {
            return exam;
        }

        public void setExam(String exam) {
            this.exam = exam;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getPassFailStatus() {
            return passFailStatus;
        }

        public void setPassFailStatus(String passFailStatus) {
            this.passFailStatus = passFailStatus;
        }

        @Override
        public String toString() {
            return "marking{" +
                    "studentId='" + studentId + '\'' +
                    ", studentName='" + studentName + '\'' +
                    ", exam='" + exam + '\'' +
                    ", score=" + score +
                    ", remarks='" + remarks + '\'' +
                    ", passFailStatus='" + passFailStatus + '\'' +
                    '}';
        }
    }

    public static class examCandidate implements Serializable {
        private String studentId;
        private String studentName;
        private String exam;

        public examCandidate(String studentId, String studentName, String exam) {
            this.studentId = studentId;
            this.studentName = studentName;
            this.exam = exam;
        }

        public String getStudentId() {
            return studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getExam() {
            return exam;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public void setExam(String exam) {
            this.exam = exam;
        }

        @Override
        public String toString() {
            return "examCandidate{" +
                    "studentId='" + studentId + '\'' +
                    ", studentName='" + studentName + '\'' +
                    ", exam='" + exam + '\'' +
                    '}';
        }
    }
}
