package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class medicalCheckUpController
{
    @javafx.fxml.FXML
    private TableColumn <MedicalCheckUp, LocalDate>appointmentDate2TableColumn;
    @javafx.fxml.FXML
    private TableColumn <MedicalCheckUp,LocalDate>appointmentDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn <MedicalCheckUp,String>doctorNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn <MedicalCheckUp, LocalDateTime>appointmentTimeTableColumn;
    @javafx.fxml.FXML
    private TableColumn <MedicalCheckUp,String>appointmentTypeTableColumn;
    @javafx.fxml.FXML
    private TableView <MedicalCheckUp>availableDoctorTableView;
    @javafx.fxml.FXML
    private TableColumn <MedicalCheckUp,String>doctorName2TableColumn;
    @javafx.fxml.FXML
    private TableView <MedicalCheckUp>appointmentTableView;
    @javafx.fxml.FXML
    private TableColumn <MedicalCheckUp,LocalDateTime>timeSlotTableColumn;
    @javafx.fxml.FXML
    private Label appointmentStatusLabel;
    @javafx.fxml.FXML
    private TextField selectedDoctorTextField;
    @javafx.fxml.FXML
    private Label cancelStatusLabel;
    @javafx.fxml.FXML
    private TextField newAppointmentDetailsTextField;
    @javafx.fxml.FXML
    private TextField cancelAppointmentTextField;

    @javafx.fxml.FXML
    public void initialize() {
        timeSlotTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalCheckUp,LocalDateTime>("time"));
        appointmentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalCheckUp,String>("type"));
        doctorNameTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalCheckUp,String>("docName"));
        doctorName2TableColumn.setCellValueFactory(new PropertyValueFactory<MedicalCheckUp,String>("docName2"));
        appointmentTimeTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalCheckUp,LocalDateTime>("time"));
        appointmentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalCheckUp,String>("apType"));
        appointmentDateTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalCheckUp,LocalDate>("date"));
        appointmentDate2TableColumn.setCellValueFactory(new PropertyValueFactory<MedicalCheckUp,LocalDate>("date2"));

    }

    @javafx.fxml.FXML
    public void bookAppoitntmentOnActionButton(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void ScheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/trainingSession.fxml");
    }

    @javafx.fxml.FXML
    public void viewDetailOnActionButton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void newAppointmentOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/Bill.fxml");
    }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/logbook.fxml");
    }

    @javafx.fxml.FXML
    public void DashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/studentPilotDashboard.fxml");
    }


    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/medicalCheckUp.fxml");
    }

    @javafx.fxml.FXML
    public void cancelOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/leave.fxml");
    }

    @javafx.fxml.FXML
    public void ExmOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/exm.fxml");
    }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent,"Madhu/User_1/resultAndCertificate.fxml");
    }
}