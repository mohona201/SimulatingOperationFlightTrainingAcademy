package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class exmController {

    @javafx.fxml.FXML
    private TableColumn<Exm, String> instructorNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Exm, LocalDateTime> startTimeTableColumn;
    @javafx.fxml.FXML
    private TableView<Exm> theoreticalExamTableView;
    @javafx.fxml.FXML
    private TableColumn<Exm, String> examNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Exm, LocalDate> endExmTableColumn;
    @javafx.fxml.FXML
    private RadioButton practicalExam;
    @javafx.fxml.FXML
    private RadioButton theoreticalExam;
    @javafx.fxml.FXML
    private TableColumn<Exm, LocalDate> startExmTableColumn;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn<Exm, LocalDate> exmEndTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Exm, Integer> examIDColumn;
    @javafx.fxml.FXML
    private TableColumn<Exm, String> theoryExamNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Exm, String> roomTableColumn;
    @javafx.fxml.FXML
    private TableView<Exm> practicalExamTableView;
    @javafx.fxml.FXML
    private TextField examIDtextField;
    @javafx.fxml.FXML
    private TextArea prequisiteLable;
    @javafx.fxml.FXML
    private Label missinfPrerequisiteLabel;
    @javafx.fxml.FXML
    private ToggleGroup examTypeToggleGroup;
    @javafx.fxml.FXML
    private TableColumn<Exm, Integer> theoryExamIDColumn;

    @javafx.fxml.FXML
    public void initialize() {

        startTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));
        examIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        examNameColumn.setCellValueFactory(new PropertyValueFactory<>("exmName"));
        exmEndTableColumn.setCellValueFactory(new PropertyValueFactory<>("exmEnd"));
        startExmTableColumn.setCellValueFactory(new PropertyValueFactory<>("startExm"));
        endExmTableColumn.setCellValueFactory(new PropertyValueFactory<>("exmEnd"));
        roomTableColumn.setCellValueFactory(new PropertyValueFactory<>("room"));
        theoryExamIDColumn.setCellValueFactory(new PropertyValueFactory<>("theoryId"));
        theoryExamNameColumn.setCellValueFactory(new PropertyValueFactory<>("theoryExm"));
    }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/resultAndCertificate.fxml");
    }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/bill.fxml");
    }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/logBook.fxml");
    }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/medicalCheckUp.fxml");
    }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/studentPilotDashBoard.fxml");
    }

    @javafx.fxml.FXML
    public void theoreticalExamOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void applyExamOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/trainingSession.fxml");
    }

    @javafx.fxml.FXML
    public void practicalExamOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exmOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/exm.fxml");
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/leave.fxml");
    }
}
