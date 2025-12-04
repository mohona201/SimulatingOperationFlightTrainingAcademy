package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class resultAndCertificateController {

    @FXML
    private TableView<ResultAndCertificate> examResultTableView;
    @FXML
    private Label notificationLabel;
    @FXML
    private TableColumn<ResultAndCertificate, String> examTypeTableColumn;
    @FXML
    private TableColumn<ResultAndCertificate, LocalDate> examDateTableColumn;
    @FXML
    private TableColumn<ResultAndCertificate, Integer> examScoreTableColumn;
    @FXML
    private TableColumn<ResultAndCertificate, String> examStatusTableColumn;
    @FXML
    private TextField reapplyExamTextField;
    @FXML
    private TextArea reapplyNoteTextArea;
    @FXML
    private Label resultStatusLabel;

    @FXML
    public void initialize() {
        examStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        examScoreTableColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        examDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("examDate"));
        examTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("examName"));
        commonMethods.showTableDataFromBinFile("reapplyExam.bin", examResultTableView);
    }

    @FXML
    public void reapplyExamOnActionButton(ActionEvent actionEvent) {

        String examName = reapplyExamTextField.getText().trim();
        String status = reapplyNoteTextArea.getText().trim();

        if (examName.isEmpty() || status.isEmpty()) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }
        Integer score = Integer.parseInt(examScoreTableColumn.getText());

        ResultAndCertificate result = new ResultAndCertificate(examName,status,score);



        String key = result.toString();

        if (commonMethods.existsInBinFile("reapplyExam.bin", key)) {
            notificationLabel.setText("Already requested reapply for this exam");
            return;
        }

        ArrayList<ResultAndCertificate> list = new ArrayList<>();
        list.add(result);
        commonMethods.saveToBinFile("reapplyExam.bin", list);

        examResultTableView.getItems().add(result);

        notificationLabel.setText("Reapply Request Submitted");

        reapplyExamTextField.clear();
        reapplyNoteTextArea.clear();
    }

    @FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/logbook.fxml");
    }

    @FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/medicalCheckUp.fxml");
    }

    @FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/studentPilotDashboard.fxml");
    }

    @FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/leave.fxml");
    }

    @FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/trainingSession.fxml");
    }

    @FXML
    public void billingOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/bill.fxml");
    }

    @FXML
    public void resultsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/resultAndCertificate.fxml");
    }

    @FXML
    public void examsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/exm.fxml");
    }
}
