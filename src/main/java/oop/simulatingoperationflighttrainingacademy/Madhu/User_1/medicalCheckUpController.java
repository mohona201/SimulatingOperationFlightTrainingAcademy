package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class medicalCheckUpController {

    @FXML private TableColumn<MedicalCheckUp, LocalDate> appointmentDate2TableColumn;
    @FXML private TableColumn<MedicalCheckUp, LocalDate> appointmentDateTableColumn;
    @FXML private TableColumn<MedicalCheckUp, String> doctorNameTableColumn;
    @FXML private TableColumn<MedicalCheckUp, LocalDateTime> appointmentTimeTableColumn;
    @FXML private TableColumn<MedicalCheckUp, String> appointmentTypeTableColumn;

    @FXML private TableView<MedicalCheckUp> availableDoctorTableView;
    @FXML private TableColumn<MedicalCheckUp, String> doctorName2TableColumn;

    @FXML private TableView<MedicalCheckUp> appointmentTableView;
    @FXML private TableColumn<MedicalCheckUp, LocalDateTime> timeSlotTableColumn;

    @FXML private Label appointmentStatusLabel;
    @FXML private TextField selectedDoctorTextField;
    @FXML private TextField newAppointmentDetailsTextField;

    @FXML private Label cancelStatusLabel;
    @FXML private TextField cancelAppointmentTextField;

    ArrayList<MedicalCheckUp> allAppointments = new ArrayList<>();

    @FXML
    public void initialize() {

        doctorName2TableColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        timeSlotTableColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        appointmentDate2TableColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));

        doctorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        appointmentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        appointmentTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        appointmentDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));

        commonMethods.showTableDataFromBinFile("medical.bin", appointmentTableView);

        availableDoctorTableView.getItems().add(new MedicalCheckUp("Dr. Rahman", "General", "10:00 AM", LocalDate.now(), LocalDateTime.now()));
        availableDoctorTableView.getItems().add(new MedicalCheckUp("Dr. Ali", "Heart", "11:00 AM", LocalDate.now(), LocalDateTime.now()));
        availableDoctorTableView.getItems().add(new MedicalCheckUp("Dr. Karim", "Eye", "12:00 PM", LocalDate.now(), LocalDateTime.now()));
    }

    @FXML
    public void bookAppoitntmentOnActionButton(ActionEvent actionEvent) {

        String doctor = selectedDoctorTextField.getText().trim();
        String appointmentType = newAppointmentDetailsTextField.getText().trim();

        if (doctor.isEmpty() || appointmentType.isEmpty()) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        MedicalCheckUp appointment = new MedicalCheckUp(
                doctor,
                appointmentType,
                "10:00 AM",
                LocalDate.now(),
                LocalDateTime.now()
        );

        allAppointments.clear();
        allAppointments.addAll(appointmentTableView.getItems());
        allAppointments.add(appointment);

        commonMethods.saveToBinFile("medical.bin", allAppointments);

        appointmentTableView.getItems().add(appointment);

        appointmentStatusLabel.setText("Appointment Booked Successfully");
        selectedDoctorTextField.clear();
        newAppointmentDetailsTextField.clear();
    }

    @FXML
    public void cancelOnActionButton(ActionEvent actionEvent) {

        String doctor = cancelAppointmentTextField.getText().trim();

        if (doctor.isEmpty()) {
            commonMethods.showError("Empty Field", "Please enter doctor name");
            return;
        }

        MedicalCheckUp remove = null;

        for (MedicalCheckUp m : appointmentTableView.getItems()) {
            if (m.getDoctorName().equalsIgnoreCase(doctor)) {
                remove = m;
                break;
            }
        }

        if (remove == null) {
            cancelStatusLabel.setText("No Matching Appointment Found");
            return;
        }

        appointmentTableView.getItems().remove(remove);

        allAppointments.clear();
        allAppointments.addAll(appointmentTableView.getItems());
        commonMethods.saveToBinFile("medical.bin", allAppointments);

        cancelStatusLabel.setText("Appointment Cancelled");

        cancelAppointmentTextField.clear();
    }

    @FXML
    public void ScheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/trainingSession.fxml");
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
    public void DashBoardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/studentPilotDashboard.fxml");
    }

    @FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/medicalCheckUp.fxml");
    }

    @FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/leave.fxml");
    }

    @FXML
    public void ExmOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/exm.fxml");
    }

    @FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/resultAndCertificate.fxml");
    }
}
