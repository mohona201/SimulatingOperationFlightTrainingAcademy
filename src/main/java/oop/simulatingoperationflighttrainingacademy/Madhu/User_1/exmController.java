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

    @FXML
    private TableView<Exm> theoreticalExamTableView;
    @FXML
    private TableColumn<Exm, String> examNameColumn;
    @FXML
    private TableColumn<Exm, LocalDate> endExmTableColumn;
    @FXML
    private TableColumn<Exm, String> instructorNameTableColumn;
    @FXML
    private TableColumn<Exm, LocalDate> startExmTableColumn;
    @FXML
    private Label notificationLabel;
    @FXML
    private TableColumn<Exm, LocalDate> exmEndTableColumn;
    @FXML
    private TableColumn<Exm, Integer> examIDColumn;
    @FXML
    private TableColumn<Exm, String> theoryExamNameColumn;
    @FXML
    private TableColumn<Exm, String> roomTableColumn;
    @FXML
    private TableView<Exm> practicalExamTableView;
    @FXML
    private TextField examIDtextField;
    @FXML
    private TextArea prequisiteLable;
    @FXML
    private Label missinfPrerequisiteLabel;
    @FXML
    private ToggleGroup examTypeToggleGroup;
    @FXML
    private TableColumn<Exm, LocalDateTime> startTimeTableColumn;
    @FXML
    private TableColumn<Exm, Integer> theoryExamIDColumn;

    ArrayList<Exm> list = new ArrayList<>();

    @FXML
    public void initialize() {

        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));
        roomTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        theoryExamNameColumn.setCellValueFactory(new PropertyValueFactory<>("exmName"));
        exmEndTableColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        startExmTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        examNameColumn.setCellValueFactory(new PropertyValueFactory<>("exmName"));
        theoryExamIDColumn.setCellValueFactory(new PropertyValueFactory<>("exmId"));
        startTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        examIDColumn.setCellValueFactory(new PropertyValueFactory<>("exmId"));

        commonMethods.showTableDataFromBinFile("exam.bin", practicalExamTableView);
        commonMethods.showTableDataFromBinFile("exam.bin", theoreticalExamTableView);
    }

    @FXML
    public void applyExamOnActionButton(ActionEvent actionEvent) {

        String idText = examIDtextField.getText().trim();
        RadioButton selected = (RadioButton) examTypeToggleGroup.getSelectedToggle();
        String pre = prequisiteLable.getText().trim();

        if (idText.isEmpty() || selected == null || pre.isEmpty()) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        if (!idText.matches("[0-9]+")) {
            notificationLabel.setText("Exam ID must contain only numbers");
            return;
        }

        int examID = Integer.parseInt(idText);
        String examType = selected.getText();

        Exm exam = new Exm();
        exam.setExmId(examID);
        exam.setExmName(examType);
        exam.setExmDate(LocalDate.now());
        exam.setStartTime(LocalDateTime.now());
        exam.setEndTime(LocalDateTime.now().plusHours(1));
        exam.setAvailableSeats(20);
        exam.setRoomNumber(101);

        String key = exam.toString();

        if (commonMethods.existsInBinFile("exam.bin", key)) {
            notificationLabel.setText("This exam already exists");
            return;
        }

        list.add(exam);
        commonMethods.saveToBinFile("exam.bin", list);

        practicalExamTableView.getItems().add(exam);
        theoreticalExamTableView.getItems().add(exam);

        notificationLabel.setText("Exam Added Successfully!");

        examIDtextField.clear();
        prequisiteLable.clear();
        examTypeToggleGroup.selectToggle(null);
    }

    @FXML
    public void theoreticalExamOnActionButton(ActionEvent actionEvent) {}

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
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/logBook.fxml");
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
    public void practicalExamOnActionButton(ActionEvent actionEvent) {}

    @FXML
    public void exmOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/exm.fxml");
    }

    @FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/studentPilotDashBoard.fxml");
    }

    @FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/leave.fxml");
    }
}
