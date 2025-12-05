package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class exmController {

    @FXML private ToggleGroup examTypeToggleGroup;

    @FXML private TableView<Exm> practicalExamTable;
    @FXML private TableView<Exm> theoreticalExamTable;

    @FXML private TableColumn<Exm, Integer> pExamIdCol;
    @FXML private TableColumn<Exm, String> pInstructorCol;
    @FXML private TableColumn<Exm, LocalDateTime> pStartTimeCol;
    @FXML private TableColumn<Exm, LocalDateTime> pEndTimeCol;
    @FXML private TableColumn<Exm, String> pExamNameCol;

    @FXML private TableColumn<Exm, Integer> tExamIdCol;
    @FXML private TableColumn<Exm, LocalDateTime> tStartTimeCol;
    @FXML private TableColumn<Exm, LocalDateTime> tEndTimeCol;
    @FXML private TableColumn<Exm, String> tRoomCol;
    @FXML private TableColumn<Exm, String> tExamNameCol;

    @FXML private TextField examIdTextField;
    @FXML private TextArea missingPrerequisitesTextArea;
    @FXML private Label notificationLabel;

    boolean isPractical = false;
    boolean isTheoretical = false;

    ArrayList<Exm> list = new ArrayList<>();

    @FXML
    public void initialize() {

        pInstructorCol.setCellValueFactory(new PropertyValueFactory<>("instructor"));
        pStartTimeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        pEndTimeCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        pExamIdCol.setCellValueFactory(new PropertyValueFactory<>("exmId"));
        pExamNameCol.setCellValueFactory(new PropertyValueFactory<>("exmName"));

        tExamIdCol.setCellValueFactory(new PropertyValueFactory<>("exmId"));
        tStartTimeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        tEndTimeCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        tRoomCol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        tExamNameCol.setCellValueFactory(new PropertyValueFactory<>("exmName"));

        commonMethods.showTableDataFromBinFile("practical.bin", practicalExamTable);
        commonMethods.showTableDataFromBinFile("theoretical.bin", theoreticalExamTable);
    }

    @FXML
    public void practicalExamOnActionButton(ActionEvent e) {
        isPractical = true;
        isTheoretical = false;
    }

    @FXML
    public void theoreticalExamOnActionButton(ActionEvent e) {
        isPractical = false;
        isTheoretical = true;
    }

    @FXML
    public void applyExamOnActionButton(ActionEvent actionEvent) {

        String idText = examIdTextField.getText().trim();
        RadioButton selected = (RadioButton) examTypeToggleGroup.getSelectedToggle();
        String pre = missingPrerequisitesTextArea.getText().trim();

        if (idText.isEmpty() || selected == null || pre.isEmpty()) {
            commonMethods.showError("Empty Fields", "Please fill all fields");
            return;
        }

        if (!idText.matches("[0-9]+")) {
            notificationLabel.setText("Exam ID must be numeric");
            return;
        }

        if (!isPractical && !isTheoretical) {
            notificationLabel.setText("Please select an exam type");
            return;
        }

        int id = Integer.parseInt(idText);
        String type = selected.getText();

        Exm exam = new Exm(
                id,
                type,
                LocalDate.now(),
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                20,
                101
        );

        list.clear();
        list.add(exam);

        if (isPractical) {
            commonMethods.saveToBinFile("practical.bin", list);
            practicalExamTable.getItems().add(exam);
        }

        if (isTheoretical) {
            commonMethods.saveToBinFile("theoretical.bin", list);
            theoreticalExamTable.getItems().add(exam);
        }

        notificationLabel.setText("Exam added successfully");

        examIdTextField.clear();
        missingPrerequisitesTextArea.clear();
        examTypeToggleGroup.selectToggle(null);
        isPractical = false;
        isTheoretical = false;
    }

    @FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/resultAndCertificate.fxml");
    }

    @FXML
    public void billOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/bill.fxml");
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
    public void scheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/trainingSession.fxml");
    }

    @FXML
    public void exmOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/exm.fxml");
    }

    @FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/studentPilotDashboard.fxml");
    }

    @FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/leave.fxml");
    }
}
