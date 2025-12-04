package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;

public class logbookController
{
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn <LogBook, LocalDate>flightTimeTableColumn;
    @javafx.fxml.FXML
    private ComboBox <String>airCraftModelComboBox;
    @javafx.fxml.FXML
    private TextField flightPathTextField;
    @javafx.fxml.FXML
    private TextField flightTimeTextField;
    @javafx.fxml.FXML
    private TextField instructorNameTextField;
    @javafx.fxml.FXML
    private TableColumn <LogBook, LocalDate>instructorNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn <LogBook, String>flightPathTableColumn;
    @javafx.fxml.FXML
    private TableColumn <LogBook, LocalDate>dateTableColumn;
    @javafx.fxml.FXML
    private DatePicker dateDatePickerComboBox;
    @javafx.fxml.FXML
    private TableColumn <LogBook, String>airCraftModelTableColumn;
    @javafx.fxml.FXML
    private TableView <LogBook>flightBookTableView;

    @javafx.fxml.FXML
    public void initialize() {
        airCraftModelComboBox.getItems().addAll("A2KS","Air20W","KG25");
        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<LogBook,LocalDate>("instructorName"));
        flightPathTableColumn.setCellValueFactory(new PropertyValueFactory<LogBook,String>("flightPath"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<LogBook,LocalDate>("date"));
        airCraftModelTableColumn.setCellValueFactory(new PropertyValueFactory<LogBook,String>("airCraftModel"));




    }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/resultAndCertificate.fxml");
    }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/studentPilotDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void applyFilterOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/trainingSession.fxml");
    }

    @javafx.fxml.FXML
    public void exmOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/exm.fxml");
    }

    @javafx.fxml.FXML
    public void logbookOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateToPdfOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/leave.fxml");
    }

    @javafx.fxml.FXML
    public void clearFilterOnActionButton(ActionEvent actionEvent) {
    }
}