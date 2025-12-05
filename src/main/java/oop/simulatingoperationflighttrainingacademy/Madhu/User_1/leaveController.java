package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    @FXML private TableColumn<Leave, LocalDate> leaveStartDateTableColumn;
    @FXML private TableColumn<Leave, LocalDate> leaveEndDateTableColumn;

    @FXML private Label notificationLabel;

    ArrayList<Leave> allLeave = new ArrayList<>();
    @FXML
    private TableColumn<Leave, String> submissionTableColumn;
    @FXML
    private TableView<Leave> leaveHistoryTableVIew;

    @FXML
    public void initialize() {
        leaveStartDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        leaveEndDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        reasonTableColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
        submissionTableColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));

        commonMethods.showTableDataFromBinFile("leave.bin", leaveHistoryTableVIew);
    }

    @FXML
    public void submitLeaveOnActionButton(ActionEvent actionEvent) {

        String idText = studentIdTextField.getText().trim();
        String name = studentNameTextField.getText().trim();
        String reason = reasonForLeaveTextField.getText().trim();
        LocalDate startDate = leaveDatepicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        if (idText.isEmpty() || name.isEmpty() || reason.isEmpty() || startDate == null || endDate == null) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        Integer id = Integer.parseInt(idText);

        Leave newLeave = new Leave(name,id , startDate,endDate, reason);

        commonMethods.saveToBinFile("leave.bin", java.util.List.of(newLeave));

        leaveHistoryTableVIew.getItems().add(newLeave);

        notificationLabel.setText("Leave Submitted Successfully!");

        studentIdTextField.clear();
        studentNameTextField.clear();
        reasonForLeaveTextField.clear();
        leaveDatepicker.setValue(null);
        endDatePicker.setValue(null);
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
