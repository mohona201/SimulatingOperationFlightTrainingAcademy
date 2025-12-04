package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.studentData;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.*;
import java.util.ArrayList;

public class eligibilityController {

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

    @FXML
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

        commonMethods.showTableDataFromBinFile("eligibilityStudent.bin", eligibilityTableView);
    }

    @FXML
    public void loadStudentOnActionButton(ActionEvent actionEvent) {
        String studentId = studentIdTextField.getText().trim();
        if (studentId.isEmpty()) {
            commonMethods.showError(
                    "Student ID is Empty",
                    "Please enter student ID"
            );
            return;
        }

        ObjectInputStream ois = null;
        boolean found = false;

        try {
            File file = new File("data/studentData.bin");
            FileInputStream fis = null;

            if (file.exists()) {
                fis = new FileInputStream(file);
            } else {
                commonMethods.showError("Load Error", "Could not load: studentData.bin");
                return;
            }

            if (fis != null) {
                ois = new ObjectInputStream(fis);

                while (true) {
                    try {
                        // Adjust 'studentData' to your actual class name for student records
                        studentData student = (studentData) ois.readObject();

                        if (student.getStudentId().equals(studentId)) {
                            found = true;


                            IDView.setText(student.getStudentId());
                            completedHoursTextField.setText(String.valueOf(student.getCompletedHours()));
                            endorsementStatusTextField.setText(student.getEndorsementStatus());
                            feeStatusTextField.setText(student.getFeeStatus());
                            medicalStatusTextField.setText(student.getMedicalStatus());

                            notificationLabel.setText("Student loaded successfully.");
                            break;
                        }
                    } catch (EOFException eof) {
                        // reached end of file
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error while loading student: " + e.getMessage());
            commonMethods.showError("Load Error", "An error occurred while loading student.");
        }

        if (!found) {
            commonMethods.showError(
                    "Student Not Found",
                    "No student found with ID: " + studentId
            );
            notificationLabel.setText("Student not found.");
            IDView.setText("");
            completedHoursTextField.clear();
            endorsementStatusTextField.clear();
            feeStatusTextField.clear();
            medicalStatusTextField.clear();
        }
    }

    @FXML
    public void updateEligibilityOnActionButton(ActionEvent actionEvent) {
        String exam = this.eligibilityExamComboBox.getValue();
        String studentId = this.studentIdTextField.getText().trim();
        boolean approved = this.approveRadiotButton.isSelected();
        boolean rejected = this.RejectRadioButton.isSelected();
        String eligibilityRemarks = this.eligibilityRemarksTextField.getText().trim();

        if (studentId.isEmpty() ||
                exam == null || exam.isEmpty() ||
                eligibilityRemarks.isEmpty()) {
            commonMethods.showError("Empty Fields",
                    "Pleas fill all the fields");
            return;
        }



        if (!approved && !rejected) {
            commonMethods.showError(
                    "No Decision Selected",
                    "Please select Approved or Rejected."
            );
            return;
        }

        String decision = null;
        if (approved) {
            decision = "Approved";
        } else if (rejected) {
            decision = "Rejected";
        }

        if (decision.equals("Approved")) {
            if (feeStatusTextField.getText().trim().isEmpty() ||
                    medicalStatusTextField.getText().trim().isEmpty() ||
                    endorsementStatusTextField.getText().trim().isEmpty() ||
                    completedHoursTextField.getText().trim().isEmpty()) {

                commonMethods.showError(
                        "Incomplete Data",
                        "Please make sure student details are loaded correctly."
                );
                return;
            }
        }

        eligibility newRecord = new eligibility(
                studentId,
                exam,
                decision,
                eligibilityRemarks
        );

        eligibilityList = new ArrayList<>();
        eligibilityList.add(newRecord);
        commonMethods.saveToBinFile("eligibilityStudent.bin", eligibilityList);

        eligibilityTableView.getItems().add(newRecord);


        notificationLabel.setText("Eligibility updated for student " + studentId);

        approveRadiotButton.setSelected(false);
        RejectRadioButton.setSelected(false);
        eligibilityRemarksTextField.clear();
        eligibilityExamComboBox.setValue(null);
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
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/examOfficerDashboard.fxml");
    }

    @FXML
    public void certificatesOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/certificates.fxml");
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

    public static class eligibility implements Serializable {
        private String studentId;
        private String examName;
        private String eligibilityStatus;
        private String remarks;

        public eligibility(String studentId, String studentName, String examName, String eligibilityStatus) {
            this.studentId = studentId;
            this.examName = examName;
            this.eligibilityStatus = eligibilityStatus;
            this.remarks = remarks;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getExamName() {
            return examName;
        }

        public void setExamName(String examName) {
            this.examName = examName;
        }

        public String getEligibilityStatus() {
            return eligibilityStatus;
        }

        public void setEligibilityStatus(String eligibilityStatus) {
            this.eligibilityStatus = eligibilityStatus;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        @Override
        public String toString() {
            return "eligibility{" +
                    "studentId='" + studentId + '\'' +
                    ", examName='" + examName + '\'' +
                    ", eligibilityStatus='" + eligibilityStatus + '\'' +
                    ", remarks='" + remarks + '\'' +
                    '}';
        }
    }
}
