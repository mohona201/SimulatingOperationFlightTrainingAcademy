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

    @FXML private TextArea cancelReasontextField;
    @FXML private TableColumn<TrainingSession, LocalDate> sessionDateTableColumn;
    @FXML private TableView<TrainingSession> upcomingFlightTableView;
    @FXML private TableColumn<TrainingSession, LocalDateTime> classTimingTableColumn;
    @FXML private TableColumn<TrainingSession, LocalDateTime> flightSessiontableColumn;
    @FXML private TableColumn<TrainingSession, String> instructorNameTableColumn;
    @FXML private TableColumn<TrainingSession, LocalDate> classDateTableColumn;
    @FXML private TableColumn<TrainingSession, String> courseNameTableColumn;
    @FXML private TableView<TrainingSession> upcomingTheoryTableView;

    @FXML private TextField flightSessionIdentifierTextField;
    @FXML private Label notificationLabel;

    @FXML private TextField instructorNameTextField;
    @FXML private TextField courseNameTextField1;
    @FXML private DatePicker datePicker;

    ArrayList<TrainingSession> list = new ArrayList<>();

    @FXML
    public void initialize() {
        sessionDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("sessionDate"));
        classDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("sessionDate"));
        classTimingTableColumn.setCellValueFactory(new PropertyValueFactory<>("sessionTime"));
        flightSessiontableColumn.setCellValueFactory(new PropertyValueFactory<>("sessionTime"));
        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("instructorName"));
        courseNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));

        commonMethods.showTableDataFromBinFile("trainingSession.bin", upcomingFlightTableView);
        commonMethods.showTableDataFromBinFile("trainingSession.bin", upcomingTheoryTableView);
    }

    @FXML
    public void updateUpcomingOnActionButton(ActionEvent actionEvent) {
        String instructor = instructorNameTextField.getText().trim();
        String course = courseNameTextField1.getText().trim();
        LocalDate date = datePicker.getValue();

        if (instructor.isEmpty() || course.isEmpty() || date == null) {
            notificationLabel.setText("Fill all fields");
            return;
        }

        TrainingSession session = new TrainingSession(
                0,
                instructor,
                course,
                date,
                LocalDateTime.now(),
                date
        );

        ArrayList<TrainingSession> all = new ArrayList<>();
        all.addAll(upcomingFlightTableView.getItems());
        all.add(session);

        commonMethods.saveToBinFile("trainingSession.bin", all);

        upcomingFlightTableView.getItems().add(session);
        upcomingTheoryTableView.getItems().add(session);

        notificationLabel.setText("Upcoming Session Updated");

        instructorNameTextField.clear();
        courseNameTextField1.clear();
        datePicker.setValue(null);
    }

    @FXML
    public void confirmCancellationOnActionButton(ActionEvent actionEvent) {
        String sessionName = flightSessionIdentifierTextField.getText().trim();
        String reason = cancelReasontextField.getText().trim();

        if (sessionName.isEmpty() || reason.isEmpty()) {
            notificationLabel.setText("Fill all fields");
            return;
        }

        TrainingSession cancelSession = new TrainingSession(
                0,
                "Instructor Not Required",
                "Course Not Required",
                LocalDate.now(),
                LocalDateTime.now(),
                LocalDate.now()
        );

        ArrayList<TrainingSession> old = new ArrayList<>();
        old.addAll(upcomingFlightTableView.getItems());
        old.add(cancelSession);

        commonMethods.saveToBinFile("cancelTraining.bin", old);

        upcomingFlightTableView.getItems().add(cancelSession);
        upcomingTheoryTableView.getItems().add(cancelSession);

        notificationLabel.setText("Session Cancellation Submitted");

        flightSessionIdentifierTextField.clear();
        cancelReasontextField.clear();
    }

    @FXML public void ScheduleOnActionButton(ActionEvent e) {
        commonMethods.sceneChange(e,"Madhu/User_1/trainingSession.fxml");
    }

    @FXML public void billOnActionButton(ActionEvent e) {
        commonMethods.sceneChange(e,"Madhu/User_1/Bill.fxml");
    }

    @FXML public void logBookOnActionButton(ActionEvent e) {
        commonMethods.sceneChange(e,"Madhu/User_1/logbook.fxml");
    }

    @FXML public void DashBoardOnActionButton(ActionEvent e) {
        commonMethods.sceneChange(e,"Madhu/User_1/studentPilotDashboard.fxml");
    }

    @FXML public void medicalCheckUpOnActionButton(ActionEvent e) {
        commonMethods.sceneChange(e,"Madhu/User_1/medicalCheckUp.fxml");
    }

    @FXML public void exmOnActionButton(ActionEvent e) {
        commonMethods.sceneChange(e,"Madhu/User_1/exm.fxml");
    }

    @FXML public void leaveOnActionButton(ActionEvent e) {
        commonMethods.sceneChange(e,"Madhu/User_1/leave.fxml");
    }

    @FXML public void resultAndCertificateOnActionButton(ActionEvent e) {
        commonMethods.sceneChange(e,"Madhu/User_1/resultAndCertificate.fxml");
    }
}
