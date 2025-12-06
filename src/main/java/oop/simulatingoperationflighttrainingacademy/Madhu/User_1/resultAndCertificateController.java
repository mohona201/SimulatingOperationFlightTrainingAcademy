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
    private DatePicker datePicker;
    @FXML
    private TextField ScoreTexField;
    @FXML
    private TextField exmIdTextField;
    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Pass", "Fail");

        examTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("examName"));
        examStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        examScoreTableColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        examDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        commonMethods.showTableDataFromBinFile("result.bin", examResultTableView);
    }

    @FXML
    public void submitResultButton(ActionEvent actionEvent) {

        String examName = reapplyExamTextField.getText().trim();
        String status = statusComboBox.getValue();
        String scoreText = ScoreTexField.getText().trim();
        String exmIdText = exmIdTextField.getText().trim();
        LocalDate date = datePicker.getValue();

        if (examName.isEmpty() || status == null || scoreText.isEmpty() || exmIdText.isEmpty() || date == null) {
            notificationLabel.setText("Fill all fields");
            return;
        }

        Integer score = Integer.parseInt(scoreText);
        Integer examId = Integer.parseInt(exmIdText);

        ResultAndCertificate result = new ResultAndCertificate(examName, status, score, examId, date);

        ArrayList<ResultAndCertificate> old = new ArrayList<>();
        old.addAll(examResultTableView.getItems());
        old.add(result);

        commonMethods.saveToBinFile("result.bin", old);

        examResultTableView.getItems().add(result);

        notificationLabel.setText("Result Submitted");

        reapplyExamTextField.clear();
        ScoreTexField.clear();
        exmIdTextField.clear();
        statusComboBox.setValue(null);
        datePicker.setValue(null);
    }

    @FXML
    public void reapplyExamOnActionButton(ActionEvent actionEvent) {

        String examName = reapplyExamTextField.getText().trim();
        String note = reapplyNoteTextArea.getText().trim();

        if (examName.isEmpty() || note.isEmpty()) {
            notificationLabel.setText("Fill all fields");
            return;
        }

        ResultAndCertificate rc = new ResultAndCertificate(examName, "Reapply", 0, 0, LocalDate.now());

        ArrayList<ResultAndCertificate> old = new ArrayList<>();
        old.addAll(examResultTableView.getItems());
        old.add(rc);

        commonMethods.saveToBinFile("result.bin", old);

        examResultTableView.getItems().add(rc);

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
}