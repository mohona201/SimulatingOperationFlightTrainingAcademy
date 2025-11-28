package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class resultAndCertificateController
{
    @javafx.fxml.FXML
    private TableColumn <ResultAndCertificate,Integer>markTableColumn;
    @javafx.fxml.FXML
    private TableView <ResultAndCertificate>theoreticalExamTableView;
    @javafx.fxml.FXML
    private TableColumn <ResultAndCertificate,String>status2TableColumn;
    @javafx.fxml.FXML
    private TableColumn <ResultAndCertificate,String>exmNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn <ResultAndCertificate,String>exmName2TableColumn;
    @javafx.fxml.FXML
    private Label theoreticalTableView;
    @javafx.fxml.FXML
    private TableColumn <ResultAndCertificate,String>statusTableColumn;
    @javafx.fxml.FXML
    private TableColumn <ResultAndCertificate,Integer>scoreTableColumn;
    @javafx.fxml.FXML
    private TableView <ResultAndCertificate>practicalExmResultTableView;
    @javafx.fxml.FXML
    private Label practicalExamTableView;
    @javafx.fxml.FXML
    private Label NotificationLabel;
    @javafx.fxml.FXML
    private Label missinfPrerequisiteLabel;
    @javafx.fxml.FXML
    private Label registeredSuccessfullLabel;

    @javafx.fxml.FXML
    public void initialize() {
        scoreTableColumn.setCellValueFactory(new PropertyValueFactory<ResultAndCertificate,Integer>("score"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<ResultAndCertificate,String>("status"));
        exmNameTableColumn.setCellValueFactory(new PropertyValueFactory<ResultAndCertificate,String>("exmName"));
        exmName2TableColumn.setCellValueFactory(new PropertyValueFactory<ResultAndCertificate,String>("exmName2"));
        status2TableColumn.setCellValueFactory(new PropertyValueFactory<ResultAndCertificate,String>("status"));
        markTableColumn.setCellValueFactory(new PropertyValueFactory<ResultAndCertificate,Integer>("mark"));
    }

    @javafx.fxml.FXML
    public void reapplyExamOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void okOnActionbutton(ActionEvent actionEvent) {

        if (instructorNameTextField.getText().isEmpty() ||
                aircraftModelTextField.getText().isEmpty() ||
                datePicker.getValue() == null ||
                startTimeTextField.getText().isEmpty() ||
                endTimeTextField.getText().isEmpty()) {

            statusLabel.setText("Please fill all fields.");
            showError("All fields must be filled.");
            return;
        }

        StudentPilot sp = new StudentPilot(
                instructorNameTextField.getText(),
                aircraftModelTextField.getText(),
                datePicker.getValue(),
                startTimeTextField.getText(),
                endTimeTextField.getText()
        );

        certificateTableView.getItems().add(sp);
        statusLabel.setText("Data added.");
        showError("Entry added successfully.");
    }

}

    @javafx.fxml.FXML
    public void practicalExamOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exmOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void theoreticalExamOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateCertificatePDFOnActionButton(ActionEvent actionEvent) {

        StudentPilot selected = certificateTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            statusLabel.setText("Select a record first.");
            showError("No record selected.");
            return;
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("certificateRecords.txt", true));

            String data = selected.getInstructorName() + "," +
                    selected.getAircraftModel() + "," +
                    selected.getDate() + "," +
                    selected.getStartTime() + "," +
                    selected.getEndTime();

            bw.write(data);
            bw.newLine();
            bw.close();

            statusLabel.setText("Certificate generated.");
            showError("Certificate saved.");

        } catch (Exception e) {
            statusLabel.setText("Error.");
            showError("Failed to generate certificate.");
        }
    }



    @javafx.fxml.FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewCertificateOnActionButton(ActionEvent actionEvent) {
    }

    private void showError(String msg) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText(msg);
    alert.showAndWait();
    }
