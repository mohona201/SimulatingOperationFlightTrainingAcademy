package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

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
        examStatusTableColumn.setCellValueFactory(new PropertyValueFactory<ResultAndCertificate,String>("exmStatus"));
        examScoreTableColumn.setCellValueFactory(new PropertyValueFactory<ResultAndCertificate,Integer>("exmScore"));
        examDateTableColumn.setCellValueFactory(new PropertyValueFactory<ResultAndCertificate,LocalDate>("exmDate"));
        examTypeTableColumn.setCellValueFactory(new PropertyValueFactory<ResultAndCertificate,String>("exmType"));



    }

    @javafx.fxml.FXML
    public void reapplyExamOnActionButton(ActionEvent actionEvent) {
        String  reapplyExm =reapplyExamTextField.getText();
    }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/logbook.fxml");
    }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/medicalCheckUp.fxml");
    }

    @javafx.fxml.FXML
    public void dashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/studentPilotDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/leave.fxml");
    }

    @javafx.fxml.FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/trainingSession.fxml");
    }

    @javafx.fxml.FXML
    public void billingOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/bill.fxml");
    }

    @javafx.fxml.FXML
    public void resultsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/resultAndCertificate.fxml");
    }

    @javafx.fxml.FXML
    public void examsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/exm.fxml");
    }
}
