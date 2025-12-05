package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class leaveController {

    @FXML private DatePicker endDatePicker;
    @FXML private DatePicker leaveDatepicker;
    @FXML private TextField studentNameTextField;
    @FXML private TextField studentIdTextField;
    @FXML private TextField reasonForLeaveTextField;

    @FXML private TableColumn<Leave, String> reasonTableColumn;
    @FXML private TableColumn<Leave, Integer> studentIdTableColumn;
    @FXML private TableColumn<Leave, LocalDate> leaveStartDateTableColumn;
    @FXML private TableColumn<Leave, LocalDate> leaveEndDateTableColumn;
    @FXML private TableColumn<Leave, String> studentNameTableColumn;

    @FXML private TableView<Leave> leaveHistoryTableView;
    @FXML private Label notificationLabel;

    ArrayList<Leave> allLeave = new ArrayList<>();

    @FXML
    public void initialize() {
        studentNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        studentIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        leaveStartDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        leaveEndDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        reasonTableColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));

        commonMethods.showTableDataFromBinFile("leave.bin", leaveHistoryTableView);
    }

    @FXML
    public void submitLeaveOnActionButton(ActionEvent actionEvent) {

        String studentName = studentNameTextField.getText().trim();
        String studentId = studentIdTextField.getText().trim();
        LocalDate startDate = leaveDatepicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        String reason = reasonForLeaveTextField.getText().trim();

        if (studentName.isEmpty() || studentId.isEmpty() || startDate == null || endDate == null || reason.isEmpty()) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        if (!studentId.matches("[0-9]+")) {
            commonMethods.showError("Invalid ID", "Student ID must be numbers only");
            return;
        }

        Integer id = Integer.parseInt(studentId);

        Leave leave = new Leave(studentName, id, startDate, endDate, reason);

        allLeave.clear();
        allLeave.addAll(leaveHistoryTableView.getItems());
        allLeave.add(leave);

        commonMethods.saveToBinFile("leave.bin", allLeave);

        leaveHistoryTableView.getItems().add(leave);

        studentNameTextField.clear();
        studentIdTextField.clear();
        leaveDatepicker.setValue(null);
        endDatePicker.setValue(null);
        reasonForLeaveTextField.clear();

        notificationLabel.setText("Leave Submitted Successfully!");
    }

    @FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/resultAndCertificate.fxml");
    }

    @FXML
    public void billOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/bill.fxml");
    }

    @FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/logbook.fxml");
    }

    @FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/medicalCheckUp.fxml");
    }

    @FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/trainingSession.fxml");
    }

    @FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/studentPilotDashboard.fxml");
    }

    @FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/leave.fxml");
    }

    @FXML
    public void examOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/exm.fxml");
    }
}
