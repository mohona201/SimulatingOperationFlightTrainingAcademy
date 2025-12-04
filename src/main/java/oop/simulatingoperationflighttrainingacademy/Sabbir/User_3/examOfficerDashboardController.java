package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class examOfficerDashboardController
{
    @javafx.fxml.FXML
    private TextField examTimeTextField;
    @javafx.fxml.FXML
    private TextField capacityTextField;
    @javafx.fxml.FXML
    private Label examStatusLabel;
    @javafx.fxml.FXML
    private TableColumn <examOfficerDashboard, String> examTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<examOfficerDashboard, Integer> examCapacityColumn;
    @javafx.fxml.FXML
    private TextField todaysExamsTextField;
    @javafx.fxml.FXML
    private ComboBox<String> examTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<examOfficerDashboard, LocalDate> examDateColumn;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField pendingResitTextField;
    @javafx.fxml.FXML
    private Label name;
    @javafx.fxml.FXML
    private DatePicker examDatePicker;
    @javafx.fxml.FXML
    private Label id;
    @javafx.fxml.FXML
    private TableView<examOfficerDashboard> examSlotsTableView;
    @javafx.fxml.FXML
    private TableColumn<examOfficerDashboard, String> examTimeColumn;


    ArrayList<examOfficerDashboard> ExamList;
    @FXML
    private TextField courseTextArea;
    @FXML
    private TableColumn<examOfficerDashboard, String> CourseColumn;

    @FXML
    public void initialize() {
        ExamList = new ArrayList<>();
        examTypeComboBox.getItems().setAll("Theory", "Practical");
        examDatePicker.setValue(LocalDate.now());

        examDateColumn.setCellValueFactory(new PropertyValueFactory<>("examDate"));
        examTimeColumn.setCellValueFactory(new PropertyValueFactory<examOfficerDashboard, String>("time"));
        examCapacityColumn.setCellValueFactory(new PropertyValueFactory<examOfficerDashboard, Integer>("capacity"));
        examTypeColumn.setCellValueFactory(new PropertyValueFactory<examOfficerDashboard, String>("examType"));
        CourseColumn.setCellValueFactory(new PropertyValueFactory<examOfficerDashboard, String>("course"));

        commonMethods.showTableDataFromBinFile("examSlot.bin",  examSlotsTableView);
    }


    @javafx.fxml.FXML
    public void createExamOnActionButton(ActionEvent actionEvent) {
        String examType = this.examTypeComboBox.getValue();
        LocalDate examDate = this.examDatePicker.getValue();
        String time = this.examTimeTextField.getText();
        Integer capacity = Integer.valueOf(this.capacityTextField.getText());
        String course = this.courseTextArea.getText();

        if(examType.isEmpty() || time.isEmpty() || String.valueOf(capacity).isEmpty() || course.isEmpty()) {
            commonMethods.showError("Empty Fields",
                    "Please fill all the fields");
            return;
        }

        Boolean sameData = false;
        if(commonMethods.existsInBinFile("examSlot.bin", examType) &&
                commonMethods.existsInBinFile("examSlot.bin", String.valueOf(examDate))) {
            sameData = true;
            notificationLabel.setText("Same exam exists");
            return;
        }
        if(capacity <= 0) {
            notificationLabel.setText("Capacity must be greater than 0");
            return;
        } else if (capacity >=40) {
            notificationLabel.setText("Capacity must be less than 40");
            return;
        }
        if(!sameData){
            ExamList.add(new examOfficerDashboard(examType, examDate, time, capacity, course));
            commonMethods.saveToBinFile("examSlot.bin", ExamList);
            notificationLabel.setText("Exam Created");
            examTypeComboBox.setValue(null);
            examDatePicker.setValue(null);
            examTimeTextField.setText(null);
            capacityTextField.setText(null);
            courseTextArea.setText(null);
            return;
        }

        examOfficerDashboard exam = new examOfficerDashboard(examType, examDate, time, capacity, course);
        examSlotsTableView.getItems().add(exam);

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


    public static class examOfficerDashboard implements Serializable {
        private String examType;
        private LocalDate examDate;
        private String time;
        private Integer capacity;
        private String course;

        public examOfficerDashboard(String examType, LocalDate examDate, String time, Integer capacity, String course) {
            this.examType = examType;
            this.examDate = examDate;
            this.time = time;
            this.capacity = capacity;
            this.course = course;
        }

        public String getExamType() {
            return examType;
        }

        public void setExamType(String examType) {
            this.examType = examType;
        }

        public LocalDate getExamDate() {
            return examDate;
        }

        public void setExamDate(LocalDate examDate) {
            this.examDate = examDate;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        @Override
        public String toString() {
            return "examOfficerDashboard{" +
                    "examType='" + examType + '\'' +
                    ", examDate=" + examDate +
                    ", time='" + time + '\'' +
                    ", capacity=" + capacity +
                    ", course='" + course + '\'' +
                    '}';
        }
    }
}