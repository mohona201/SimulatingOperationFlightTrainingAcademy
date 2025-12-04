package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class exmController
{
    @javafx.fxml.FXML
    private TableColumn<Exm, String> instructorNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Exm, LocalDateTime> startTimeTableColumn;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableView <Exm>studentTableView;
    @javafx.fxml.FXML
    private ComboBox <String>instructorComboBox;
    @javafx.fxml.FXML
    private TableColumn <Exm,LocalDateTime>endTimeTableColumn;
    @javafx.fxml.FXML
    private TableColumn <Exm,LocalDate>dateTableColumn;
    @javafx.fxml.FXML
    private TextField averageFlightTextField;
    @javafx.fxml.FXML
    private Label NotificationTextField;
    @javafx.fxml.FXML
    private TextField totalFlightHourTextField;
    @javafx.fxml.FXML
    private TableColumn <Exm,String>aircraftModelTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        instructorComboBox.getItems().addAll("Md Sfk","Ms pkf","Phd Bdh");


        startTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));
        aircraftModelTableColumn.setCellValueFactory(new PropertyValueFactory<Exm,String>("airModel"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<Exm,LocalDate>("date"));
        endTimeTableColumn.setCellValueFactory(new PropertyValueFactory<Exm,LocalDateTime>("endTime"));


    }


    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/resultAndCertificate.fxml");
    }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/bill.fxml");
    }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/logBook.fxml");
    }


    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/medicalCheckUp.fxml");
    }


    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/studentPilotDashBoard.fxml");
    }


    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/leave.fxml");

    }

    @javafx.fxml.FXML
    public void ScheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/trainingSession.fxml");
    }

    @javafx.fxml.FXML
    public void examsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/exm.fxml");
    }

    @javafx.fxml.FXML
    public void selectSlotOnActionButton(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void bookFlightOnActionButton(ActionEvent actionEvent) {
    }
    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
