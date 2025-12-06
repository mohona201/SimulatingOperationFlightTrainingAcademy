package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class studentPilotDashBoardController {

    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private TableView<StudentPilot> studentTableView;
    @FXML
    private ComboBox<String> instructorComboBox;
    @FXML
    private TableColumn<StudentPilot, String> instructorNameTableColumn;
    @FXML
    private TableColumn<StudentPilot, String> aircraftModelTableColumn;
    @FXML
    private TableColumn<StudentPilot, String> startTimeTableColumn;
    @FXML
    private TableColumn<StudentPilot, String> endTimeTableColumn;
    @FXML
    private TableColumn<StudentPilot, LocalDate> dateTableColumn;
    @FXML
    private Label NotificationTextField;

    ArrayList<StudentPilot> old = new ArrayList<>();

    StudentPilot selectedSlot;


    @FXML
    public void initialize() {
        instructorComboBox.getItems().addAll("Md.Ahsan", "phd Mostafizur", "Ms Shila");

        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("instructorName"));
        aircraftModelTableColumn.setCellValueFactory(new PropertyValueFactory<>("aircraftModel"));
        startTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        commonMethods.showTableDataFromBinFile("studentFlight.bin", studentTableView);
    }

    @FXML
    public void selectSlotOnActionButton(ActionEvent actionEvent) {

        String instructor = instructorComboBox.getValue();
        LocalDate date = dateDatePicker.getValue();

        if (instructor == null || instructor.isEmpty() || date == null) return;

        selectedSlot = new StudentPilot(instructor, "Not Selected", date, "Not Selected", "Not Selected");

        ArrayList<StudentPilot> old = new ArrayList<>();
        old.addAll(studentTableView.getItems());
        old.add(selectedSlot);

        commonMethods.saveToBinFile("studentFlight.bin", old);

        studentTableView.getItems().add(selectedSlot);

        NotificationTextField.setText("Slot Selected");
    }

    @FXML
    public void bookFlightOnActionButton(ActionEvent actionEvent) {

        if (selectedSlot == null) return;

        String instructor = selectedSlot.getInstructorName();
        LocalDate date = selectedSlot.getDate();
        String aircraftModel = "Qdp A25";
        String startTime = "10:00 AM";
        String endTime = "11:00 AM";

        StudentPilot newFlight = new StudentPilot(instructor, aircraftModel, date, startTime, endTime);

        ArrayList<StudentPilot> oldFlights = new ArrayList<>();
        oldFlights.addAll(studentTableView.getItems());
        oldFlights.add(newFlight);

        commonMethods.saveToBinFile("studentFlight.bin", oldFlights);

        studentTableView.getItems().add(newFlight);

        NotificationTextField.setText("Flight Booked Successfully");

        instructorComboBox.setValue(null);
        dateDatePicker.setValue(null);
        selectedSlot = null;
    }

    @FXML
    public void scheduleOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/trainingSession.fxml");
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
    public void exmOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/exm.fxml");
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
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/studentPilotDashBoard.fxml");
    }

    @FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/leave.fxml");
    }
}
