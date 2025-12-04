package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class seatingPlanController {

    @FXML
    private TextField todaySeatingPlansTextField;
    @FXML
    private Button downloadSeatingPlanPdfButton;
    @FXML
    private ComboBox<String> seatingExamComboBox;
    @FXML
    private Button generateSeatingPlanButton;
    @FXML
    private TableColumn<seatingPlan, String> seatingSeatNumberColumn;
    @FXML
    private Label seatingGenerateStatusLabel;
    @FXML
    private ComboBox<String> seatingPlanTypeComboBox;
    @FXML
    private TableView<seatingPlan> seatingPlanTableView;
    @FXML
    private Button regenerateSeatingPlanButton;
    @FXML
    private TextField seatingRoomTextField;
    @FXML
    private Label notificationLabel;
    @FXML
    private TextField totalSeatingPlansTextField;
    @FXML
    private TableColumn<seatingPlan, String> seatingStudentNameColumn;
    @FXML
    private TableColumn<seatingPlan, String> seatingRowColumn;
    @FXML
    private Button loadSeatingCandidatesButton;
    @FXML
    private TableColumn<seatingPlan, String> seatingExamNameColumn;
    @FXML
    private TableColumn<seatingPlan, String> seatingRoomColumn;
    @FXML
    private DatePicker seatingExamDatePicker;
    @FXML
    private TableColumn<seatingPlan, String> seatingStudentIdColumn;
    @FXML
    private Label seatingHeaderStatusLabel;

    private ArrayList<seatingPlan> seatingPlanList;
    private ArrayList<MarkingController.examCandidate> seatingCandidates;

    @FXML
    public void initialize() {
        seatingPlanList = new ArrayList<>();
        seatingCandidates = new ArrayList<>();

        seatingExamComboBox.getItems().setAll("Theory Exam", "Flight Test");
        seatingPlanTypeComboBox.getItems().setAll(
                "Standard Seating Plan",
                "Alternate Row Plan",
                "Exam Hall Plan"
        );

        seatingExamDatePicker.setValue(LocalDate.now());

        seatingStudentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        seatingStudentNameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        seatingExamNameColumn.setCellValueFactory(new PropertyValueFactory<>("examName"));
        seatingSeatNumberColumn.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        seatingRowColumn.setCellValueFactory(new PropertyValueFactory<>("row"));
        seatingRoomColumn.setCellValueFactory(new PropertyValueFactory<>("room"));

        refreshSeatingPlanData();
    }


    @FXML
    public void seatingPlanOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/seatingPlan.fxml");
    }

    @FXML
    public void resitRequestsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/resitRequest.fxml");
    }

    @FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/examOfficerDashboard.fxml");
    }

    @FXML
    public void certificatesOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/certificates.fxml");
    }

    @FXML
    public void questionBankOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/questionBank.fxml");
    }

    @FXML
    public void markingOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/marking.fxml");
    }

    @FXML
    public void eligibilityOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/eligibility.fxml");
    }

    @FXML
    public void misconductOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/misconduct.fxml");
    }


    @FXML
    public void loadSeatingCandidatesOnActionButton(ActionEvent actionEvent) {
        String exam = seatingExamComboBox.getValue();
        LocalDate date = seatingExamDatePicker.getValue();

        if (exam == null || exam.isEmpty()) {
            commonMethods.showError("No Exam Selected", "Please select an exam.");
            return;
        }
        if (date == null) {
            commonMethods.showError("No Date Selected", "Please select an exam date.");
            return;
        }

        seatingCandidates.clear();
        ObjectInputStream ois = null;

        try {
            File file = new File("data/examCandiates.bin");
            if (!file.exists()) {
                commonMethods.showError("Load Error", "Could not load: examCandiates.bin");
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    MarkingController.examCandidate c = (MarkingController.examCandidate) ois.readObject();
                    if (c.getExam().equals(exam)) {
                        seatingCandidates.add(c);
                    }
                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading exam candidates: " + e.getMessage());
            notificationLabel.setText("Error loading exam candidates.");
            return;
        }

        seatingPlanTableView.getItems().clear();

        for (MarkingController.examCandidate c : seatingCandidates) {
            seatingPlan sp = new seatingPlan(
                    c.getStudentId(),
                    c.getStudentName(),
                    c.getExam(),
                    date.toString(),
                    "",        // room not assigned yet
                    "",        // row not assigned yet
                    "",        // seat not assigned yet
                    ""         // plan type not assigned yet
            );
            seatingPlanTableView.getItems().add(sp);
        }

        seatingHeaderStatusLabel.setText("Loaded " + seatingCandidates.size() + " candidates for seating plan.");
        notificationLabel.setText("Candidates loaded. Generate seating plan to assign seats.");
    }


    @FXML
    public void generateSeatingPlanOnActionButton(ActionEvent actionEvent) {
        String exam = seatingExamComboBox.getValue();
        LocalDate date = seatingExamDatePicker.getValue();
        String room = seatingRoomTextField.getText().trim();
        String planType = seatingPlanTypeComboBox.getValue();

        if (exam == null || exam.isEmpty()
                || date == null
                || room.isEmpty()
                || planType == null || planType.isEmpty()) {
            commonMethods.showError("Empty Fields", "Please select exam, date, room and plan type.");
            return;
        }

        if (seatingCandidates.isEmpty()) {
            commonMethods.showError("No Candidates", "Please load seating candidates first.");
            return;
        }

        ArrayList<seatingPlan> existing = loadAllSeatingFromFile();

        seatingPlanList = new ArrayList<>();
        String dateStr = date.toString();

        int seatsPerRow = 10;
        int index = 0;

        for (MarkingController.examCandidate c : seatingCandidates) {
            boolean alreadyExists = false;
            for (seatingPlan sp : existing) {
                if (sp.getStudentId().equals(c.getStudentId())
                        && sp.getExamName().equals(exam)
                        && sp.getExamDate().equals(dateStr)
                        && sp.getRoom().equals(room)) {
                    alreadyExists = true;
                    break;
                }
            }
            if (alreadyExists) continue;

            int rowIndex = index / seatsPerRow;
            int seatIndex = (index % seatsPerRow) + 1;
            String rowLabel = String.valueOf((char) ('A' + rowIndex));
            String seatNumber = String.valueOf(seatIndex);

            seatingPlan spNew = new seatingPlan(
                    c.getStudentId(),
                    c.getStudentName(),
                    exam,
                    dateStr,
                    room,
                    rowLabel,
                    seatNumber,
                    planType
            );

            seatingPlanList.add(spNew);
            existing.add(spNew);
            index++;
        }

        if (seatingPlanList.isEmpty()) {
            commonMethods.showError("No New Seats",
                    "No new seating entries to save (possible duplicates).");
            return;
        }

        commonMethods.saveToBinFile("seatingPlan.bin", seatingPlanList);

        // Update table view with the newly generated seating for this session
        seatingPlanTableView.getItems().clear();
        seatingPlanTableView.getItems().addAll(seatingPlanList);

        updateCounters();

        seatingGenerateStatusLabel.setText("Generated seating plan for " + seatingPlanList.size() + " candidates.");
        notificationLabel.setText("Seating plan saved to seatingPlan.bin.");
    }

    // ---------------- REGENERATE SEATING PLAN (UI ONLY) ----------------

    @FXML
    public void regenerateSeatingPlanOnActionButton(ActionEvent actionEvent) {
        var items = seatingPlanTableView.getItems();
        if (items == null || items.isEmpty()) {
            commonMethods.showError("Nothing to Regenerate", "No seating plan loaded.");
            return;
        }

        int seatsPerRow = 10;
        int index = 0;

        for (seatingPlan sp : items) {
            int rowIndex = index / seatsPerRow;
            int seatIndex = (index % seatsPerRow) + 1;
            String rowLabel = String.valueOf((char) ('A' + rowIndex));
            String seatNumber = String.valueOf(seatIndex);

            sp.setRow(rowLabel);
            sp.setSeatNumber(seatNumber);
            index++;
        }

        seatingPlanTableView.refresh();
        seatingGenerateStatusLabel.setText("Seating plan regenerated (UI only).");
        notificationLabel.setText("Seats re-assigned locally. File not changed.");
    }

    // ---------------- DOWNLOAD PDF (STUB) ----------------

    @FXML
    public void downloadSeatingPlanPdfOnActionButton(ActionEvent actionEvent) {
        notificationLabel.setText("PDF export not implemented.");
    }

    // ---------------- INTERNAL HELPERS ----------------

    private void refreshSeatingPlanData() {
        seatingPlanTableView.getItems().clear();
        ArrayList<seatingPlan> all = loadAllSeatingFromFile();
        seatingPlanTableView.getItems().addAll(all);
        updateCounters();
    }

    private ArrayList<seatingPlan> loadAllSeatingFromFile() {
        ArrayList<seatingPlan> list = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            File file = new File("data/seatingPlan.bin");
            if (!file.exists()) {
                totalSeatingPlansTextField.setText("0");
                todaySeatingPlansTextField.setText("0");
                return list;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    seatingPlan sp = (seatingPlan) ois.readObject();
                    list.add(sp);
                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading seatingPlan.bin: " + e.getMessage());
        }

        return list;
    }

    private void updateCounters() {
        var items = seatingPlanTableView.getItems();
        int total = items.size();
        int todayCount = 0;
        String today = LocalDate.now().toString();

        for (seatingPlan sp : items) {
            if (sp.getExamDate() != null && sp.getExamDate().equals(today)) {
                todayCount++;
            }
        }

        totalSeatingPlansTextField.setText(String.valueOf(total));
        todaySeatingPlansTextField.setText(String.valueOf(todayCount));
    }
}
