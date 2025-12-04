package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class medicalCheckUpController {

    @FXML
    private TableColumn<MedicalCheckUp, LocalDate> appointmentDate2TableColumn;
    @FXML
    private TableColumn<MedicalCheckUp, LocalDate> appointmentDateTableColumn;
    @FXML
    private TableColumn<MedicalCheckUp, String> doctorNameTableColumn;
    @FXML
    private TableColumn<MedicalCheckUp, LocalDateTime> appointmentTimeTableColumn;
    @FXML
    private TableColumn<MedicalCheckUp, String> appointmentTypeTableColumn;
    @FXML
    private TableView<MedicalCheckUp> availableDoctorTableView;
    @FXML
    private TableColumn<MedicalCheckUp, String> doctorName2TableColumn;
    @FXML
    private TableView<MedicalCheckUp> appointmentTableView;
    @FXML
    private TableColumn<MedicalCheckUp, LocalDateTime> timeSlotTableColumn;
    @FXML
    private Label appointmentStatusLabel;
    @FXML
    private TextField selectedDoctorTextField;
    @FXML
    private Label cancelStatusLabel;
    @FXML
    private TextField newAppointmentDetailsTextField;
    @FXML
    private TextField cancelAppointmentTextField;

    ArrayList<MedicalCheckUp> list = new ArrayList<>();
    @FXML
    private VBox notificationLabel;

    @FXML
    public void initialize() {
        timeSlotTableColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        appointmentTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        doctorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        doctorName2TableColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        appointmentTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        appointmentDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        appointmentDate2TableColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));

        commonMethods.showTableDataFromBinFile("medical.bin", availableDoctorTableView);
        commonMethods.showTableDataFromBinFile("medical.bin", appointmentTableView);
    }

    @FXML
    public void bookAppoitntmentOnActionButton(ActionEvent actionEvent) {

        String doctor = selectedDoctorTextField.getText().trim();
        String appointmentType = newAppointmentDetailsTextField.getText().trim();

        if (doctor.isEmpty() || appointmentType.isEmpty()) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        MedicalCheckUp m = new MedicalCheckUp(
                doctor,
                appointmentType,
                "10:00 AM",
                LocalDate.now(),
                LocalDateTime.now()
        );

        String key = m.toString();

        if (commonMethods.existsInBinFile("medical.bin", key)) {
            appointmentStatusLabel.setText("Appointment already exists");
            return;
        }

        list.clear();
        list.add(m);

        commonMethods.saveToBinFile("medical.bin", list);

        appointmentTableView.getItems().add(m);

        appointmentStatusLabel.setText("Appointment Booked Successfully");

        selectedDoctorTextField.clear();
        newAppointmentDetailsTextField.clear();
    }

    @FXML
    public void cancelOnActionButton(ActionEvent actionEvent) {

        String doc = cancelAppointmentTextField.getText().trim();

        if (doc.isEmpty()) {

            commonMethods.showError("Empty Field", "Please enter doctor name");
            return;
        }

        MedicalCheckUp remove = null;

        for (MedicalCheckUp medicalCheckUp : appointmentTableView.getItems()) {
            if (medicalCheckUp.getDoctorName().equalsIgnoreCase(doc)) {
                remove = medicalCheckUp;
                break;
            }
        }

        if (remove == null) {
            cancelStatusLabel.setText("No matching appointment found");
            return;
        }

        appointmentTableView.getItems().remove(remove);

        cancelStatusLabel.setText("Appointment Cancelled");

        cancelAppointmentTextField.clear();
    }

    @FXML
    public void ScheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/trainingSession.fxml");
    }

    @FXML
    public void viewDetailOnActionButton(ActionEvent actionEvent) {
    }


    @FXML
    public void billOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/Bill.fxml");
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
