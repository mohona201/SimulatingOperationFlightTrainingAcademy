package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class exmController
{
    @javafx.fxml.FXML
    private TableColumn<Exm, LocalDate> exmEndTableColumn;
    @javafx.fxml.FXML
    private TableView<Exm> theoreticalExamTableView;
    @javafx.fxml.FXML
    private TableColumn<Exm, LocalDate> endExmTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Exm, Integer> roomTableColumn;
    @javafx.fxml.FXML
    private TableView<Exm> practicalExamTableView;
    @javafx.fxml.FXML
    private Label NotificationLabel;
    @javafx.fxml.FXML
    private RadioButton practicalExam;
    @javafx.fxml.FXML
    private TableColumn<Exm, String> instructorNameTableColumn;
    @javafx.fxml.FXML
    private Label missinfPrerequisiteLabel;
    @javafx.fxml.FXML
    private TableColumn<Exm, LocalDate> startExmTableColumn;
    @javafx.fxml.FXML
    private Label registeredSuccessfulLabel;
    @javafx.fxml.FXML
    private TableColumn<Exm, LocalDateTime> startTimeTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        startTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        startExmTableColumn.setCellValueFactory(new PropertyValueFactory<>("exmDate"));
        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));
        exmEndTableColumn.setCellValueFactory(new PropertyValueFactory<>("exmEnd"));
        roomTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        endExmTableColumn.setCellValueFactory(new PropertyValueFactory<>("exmEnd"));
    }

    @javafx.fxml.FXML
    public void theoreticalExamOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void returnExamListOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void practicalExamOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void exmOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void okOnActionButton(ActionEvent actionEvent) {

        Exm selected = theoreticalExamTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            NotificationLabel.setText("Select an exam first.");
            showError("No exam selected.");
            return;
        }

        LocalDate startDate = selected.getExmDate();
        LocalDate endDate = selected.getExmDate();
        int room = selected.getRoomNumber();

        if (startDate == null || endDate == null || room <= 0) {
            NotificationLabel.setText("Incomplete exam details.");
            showError("Exam row contains missing data.");
            return;
        }

        practicalExamTableView.getItems().add(selected);

        NotificationLabel.setText("Exam added successfully.");
        showError("Exam selection confirmed.");
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) { }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
