package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class certificateController
{
    @javafx.fxml.FXML
    private TextField generatedTodayTextField;
    @javafx.fxml.FXML
    private TableColumn<MarkingController.marking, String> certStudentIdColumn;
    @javafx.fxml.FXML
    private TableColumn certExamDateColumn;
    @javafx.fxml.FXML
    private ComboBox<String> certificateExamComboBox;
    @javafx.fxml.FXML
    private TableColumn<MarkingController.marking, String> certStudentNameColumn;
    @javafx.fxml.FXML
    private Label certificateHeaderStatusLabel;
    @javafx.fxml.FXML
    private TableColumn<MarkingController.marking, String> certStatusColumn;
    @javafx.fxml.FXML
    private Button selectAllCertificatesButton;
    @javafx.fxml.FXML
    private TableColumn<MarkingController.marking, String> certScoreColumn;
    @javafx.fxml.FXML
    private TableView<MarkingController.marking> passedStudentsTableView;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField pendingCertificatesTextField;
    @javafx.fxml.FXML
    private Button loadPassedStudentsButton;
    @javafx.fxml.FXML
    private DatePicker certificateExamDatePicker;
    @javafx.fxml.FXML
    private TableColumn<MarkingController.marking, String> certExamNameColumn;
    @javafx.fxml.FXML
    private Button generateCertificatesButton;

    @javafx.fxml.FXML
    public void initialize() {
        certificateExamComboBox.getItems().setAll(
                "Theory Exam",
                "Flight Test"
        );

        certificateExamDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void loadPassedStudentsOnActionButton(ActionEvent actionEvent) {
        String exam = this.certificateExamComboBox.getValue();
        LocalDate date = this.certificateExamDatePicker.getValue(); // currently only used for display

        if (exam == null || exam.isEmpty()) {
            commonMethods.showError("No Exam Selected", "Please select an exam.");
            return;
        }

        if (date == null) {
            commonMethods.showError("No Date Selected", "Please select an exam date.");
            return;
        }

        ArrayList<MarkingController.marking> tempList = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            File file = new File("data/stundentMark.bin");
            if (!file.exists()) {
                commonMethods.showError("Load Error", "Could not load: stundentMark.bin");
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    MarkingController.marking m = (MarkingController.marking) ois.readObject();

                    if (m.getExam().equals(exam)
                            && "Passed".equalsIgnoreCase(m.getPassFailStatus())) {
                        tempList.add(m);
                    }

                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading passed students: " + e.getMessage());
            notificationLabel.setText("Error loading passed students.");
            return;
        }

        ArrayList<MarkingController.marking> passedList = tempList;
        passedStudentsTableView.getItems().clear();
        passedStudentsTableView.getItems().addAll(passedList);

        pendingCertificatesTextField.setText(String.valueOf(passedList.size()));

        if (passedList.isEmpty()) {
            certificateHeaderStatusLabel.setText("No passed students for " + exam);
            notificationLabel.setText("No passed students found for this exam.");
        } else {
            certificateHeaderStatusLabel.setText(
                    "Loaded " + passedList.size() + " passed students for " + exam
            );
            notificationLabel.setText("Passed students loaded.");
        }
    }
    @javafx.fxml.FXML
    public void generateCertificatesOnActionButton(ActionEvent actionEvent) {
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
    public void misconductOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/misconduct.fxml");

    }
}