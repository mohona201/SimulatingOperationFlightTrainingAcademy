package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class trainingSessionController
{
    @javafx.fxml.FXML
    private TextArea cancelReasontextField;
    @javafx.fxml.FXML
    private TableColumn <TrainingSession, LocalDate>sessionDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn <TrainingSession, LocalDateTime>sessionTimeTableColumn;
    @javafx.fxml.FXML
    private TableView <TrainingSession>upcomingFlightTableView;
    @javafx.fxml.FXML
    private TableColumn <TrainingSession, LocalDateTime>classTimingTableColumn;
    @javafx.fxml.FXML
    private TableColumn <TrainingSession, LocalDateTime>flightSessiontableColumn;
    @javafx.fxml.FXML
    private TableColumn <TrainingSession, String>instructorNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn <TrainingSession, LocalDate>classDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn <TrainingSession, String>courseNameTableColumn;
    @javafx.fxml.FXML
    private TextField flightSessionIdentifierTextField;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableView <TrainingSession>upcomingTheoryTableView;

    @javafx.fxml.FXML
    public void initialize() {
        sessionTimeTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingSession,LocalDateTime>(""));
        sessionDateTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingSession,LocalDate>(""));
        courseNameTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingSession,String>(""));
        classTimingTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingSession,LocalDateTime>(""));
        flightSessiontableColumn.setCellValueFactory(new PropertyValueFactory<TrainingSession,LocalDateTime>(""));
        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingSession,String>(""));
        classTimingTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingSession,LocalDateTime>(""));
        classDateTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingSession,LocalDate>(""));
    }

    @Deprecated
    public void actionOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmCancellationOnActionButton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void backOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ScheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/trainingSession.fxml");
    }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void DashBoardOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exmOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/leave.fxml");
    }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/resultAndCertificate.fxml");
    }
}