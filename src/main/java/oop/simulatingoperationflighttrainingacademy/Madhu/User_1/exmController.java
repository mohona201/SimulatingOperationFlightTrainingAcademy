package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
        startTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));

    }


    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) { }


    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) { }


    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) { }


    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void ScheduleOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void examsOnActionButton(ActionEvent actionEvent) {
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
