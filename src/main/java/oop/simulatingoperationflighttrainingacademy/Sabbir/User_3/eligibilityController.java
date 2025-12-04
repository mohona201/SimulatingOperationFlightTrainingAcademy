package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.studentData;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
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

                            // Populate all the student-related views / fields
                            NameView.setText(student.getStudentName());
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
            NameView.setText("");
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

        // Basic field validation
        if (studentId.isEmpty() ||
                exam == null || exam.isEmpty() ||
                eligibilityRemarks.isEmpty()) {
            commonMethods.showError("Empty Fields",
                    "Pleas fill all the fields");
            return;
        }

        // Make sure student is loaded before updating eligibility
        if (NameView.getText() == null) {
            commonMethods.showError(
                    "No Student Loaded",
                    "Please load a student before updating eligibility."
            );
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

        // Simple verification based on loaded status fields (you can add more rules here)
        if (decision.equals("Approved")) {
            // Example checks – adjust to your CRA rules as needed
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

        // Create eligibility record and save
        String studentName = NameView.getText();
        eligibility newRecord = new eligibility(
                studentId,
                studentName,
                exam,
                decision,
                eligibilityRemarks
        );

        // Save just this record (append using commonMethods)
        eligibilityList = new ArrayList<>();
        eligibilityList.add(newRecord);
        commonMethods.saveToBinFile("eligibilityStudent.bin", eligibilityList);

        // Also update table view
        eligibilityTableView.getItems().add(newRecord);


        eligibilityStatusLabel.setText("Eligibility: " + decision);
        notificationLabel.setText("Eligibility updated for student " + studentId);

        // Clear selection & remarks
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
}
