package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class trainingSessionController {

    @FXML
    private TextArea cancelReasontextField;
    @FXML
    private TableColumn<TrainingSession, LocalDate> sessionDateTableColumn;
    @FXML
    private TableView<TrainingSession> upcomingFlightTableView;
    @FXML
    private TableColumn<TrainingSession, LocalDateTime> classTimingTableColumn;
    @FXML
    private TableColumn<TrainingSession, LocalDateTime> flightSessiontableColumn;
    @FXML
    private TableColumn<TrainingSession, String> instructorNameTableColumn;
    @FXML
    private TableColumn<TrainingSession, LocalDate> classDateTableColumn;
    @FXML
    private TableColumn<TrainingSession, String> courseNameTableColumn;
    @FXML
    private TextField flightSessionIdentifierTextField;
    @FXML
    private Label notificationLabel;
    @FXML
    private TableView<TrainingSession> upcomingTheoryTableView;

    @FXML
    private TextField instructorNameTextField;

    ArrayList<TrainingSession> list = new ArrayList<>();
    @FXML
    private DatePicker datePicker;
    @FXML
    private TableColumn courseNmTableColumn;
    @FXML
    private TextField courseNameTextField1;

    @FXML
    public void initialize() {
//        sessionTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("sessionTime"));
        sessionDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("sessionDate"));
        courseNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        classTimingTableColumn.setCellValueFactory(new PropertyValueFactory<>("sessionTime"));
        flightSessiontableColumn.setCellValueFactory(new PropertyValueFactory<>("sessionTime"));
        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("instructorName"));
        classDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("sessionDate"));

        commonMethods.showTableDataFromBinFile("trainingSession.bin", upcomingFlightTableView);
        commonMethods.showTableDataFromBinFile("trainingSession.bin", upcomingTheoryTableView);
    }

    @FXML
    public void confirmCancellationOnActionButton(ActionEvent actionEvent) {

        String sessionName = flightSessionIdentifierTextField.getText().trim();
        String reason = cancelReasontextField.getText().trim();

        if (sessionName.isEmpty() || reason.isEmpty()) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        TrainingSession cancelSession = new TrainingSession(sessionName, "Instructor Not Required", "Course Not Required", LocalDate.now(), LocalDateTime.now());

        String key = cancelSession.toString();

        if (commonMethods.existsInBinFile("cancelTraining.bin", key)) {
            notificationLabel.setText("Cancellation already submitted");
            return;
        }

        ArrayList<TrainingSession> list = new ArrayList<>();
        list.add(cancelSession);

        commonMethods.saveToBinFile("cancelTraining.bin", list);

        upcomingFlightTableView.getItems().add(cancelSession);
        upcomingTheoryTableView.getItems().add(cancelSession);

        notificationLabel.setText("Session Cancellation Submitted");

        flightSessionIdentifierTextField.clear();
        cancelReasontextField.clear();
    }

    @FXML
    public void ScheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/trainingSession.fxml");
    }

    @FXML
    public void billOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/Bill.fxml");
    }

    @FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/logbook.fxml");
    }

    @FXML
    public void DashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/studentPilotDashboard.fxml");
    }

    @FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/medicalCheckUp.fxml");
    }

    @FXML
    public void exmOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/exm.fxml");
    }

    @FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/leave.fxml");
    }

    @FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/resultAndCertificate.fxml");
    }
}
