package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;

public class resultAndCertificateController {

    @javafx.fxml.FXML
    private TableView <ResultAndCertificate>examResultTableView;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn <ResultAndCertificate,String>examTypeTableColumn;
    @javafx.fxml.FXML
    private TableColumn <ResultAndCertificate, LocalDate>examDateTableColumn;
    @javafx.fxml.FXML
    private Button reapplyExamButton;
    @javafx.fxml.FXML
    private TableColumn <ResultAndCertificate,Integer>examScoreTableColumn;
    @javafx.fxml.FXML
    private TableColumn <ResultAndCertificate,String>examStatusTableColumn;
    @javafx.fxml.FXML
    private TextField reapplyExamTextField;
    @javafx.fxml.FXML
    private TextArea reapplyNoteTextArea;
    @javafx.fxml.FXML
    private Label resultStatusLabel;

    @javafx.fxml.FXML
    public void initialize() {
        scoreTableColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        exmNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("exmName"));
        exmName2TableColumn.setCellValueFactory(new PropertyValueFactory<>("exmName2"));
        status2TableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        markTableColumn.setCellValueFactory(new PropertyValueFactory<>("mark"));
    }

    @javafx.fxml.FXML
    public void reapplyExamOnActionButton(ActionEvent actionEvent) { }

    @Deprecated
    public void viewOnActionButton(ActionEvent actionEvent) { }

    @Deprecated
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) { }

    @Deprecated
    public void okOnActionbutton(ActionEvent actionEvent) {

        ResultAndCertificate selected = theoreticalExamTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            NotificationLabel.setText("Select a row first.");
            showError("No exam record selected.");
            return;
        }

        practicalExmResultTableView.getItems().add(selected);
        NotificationLabel.setText("Data added.");
        showError("Entry added successfully.");
    }

    @Deprecated
    public void practicalExamOnActionButton(ActionEvent actionEvent) { }

    @Deprecated
    public void exmOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) { }

    @Deprecated
    public void theoreticalExamOnActionButton(ActionEvent actionEvent) { }

    @Deprecated
    public void billOnActionButton(ActionEvent actionEvent) { }

    @Deprecated
    public void generateCertificatePDFOnActionButton(ActionEvent actionEvent) {

        ResultAndCertificate selected = practicalExmResultTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            NotificationLabel.setText("Select a record first.");
            showError("No record selected.");
            return;
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("certificateRecords.txt", true));

            String data =
                    selected.getExamName() + "," +
                            selected.getExamName() + "," +
                            selected.getStatus() + "," +
                            selected.getScore() + "," +
                            selected.getScore();

            bw.write(data);
            bw.newLine();
            bw.close();

            NotificationLabel.setText("Certificate saved.");
            showError("Certificate saved.");

        } catch (Exception e) {
            NotificationLabel.setText("Error.");
            showError("Failed to generate certificate.");
        }
    }

    @javafx.fxml.FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) { }

    @Deprecated
    public void viewCertificateOnActionButton(ActionEvent actionEvent) { }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void billingOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resultsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void examsOnActionButton(ActionEvent actionEvent) {
    }
}
