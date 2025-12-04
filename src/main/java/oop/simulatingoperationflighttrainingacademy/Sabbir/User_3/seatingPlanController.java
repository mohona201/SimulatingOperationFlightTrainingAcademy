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
import java.util.Collections;
import java.util.Comparator;

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
    private ArrayList<MarkingController.examCandidate> seatingCandidatesList;

    @FXML
    public void initialize() {
        seatingPlanList = new ArrayList<>();
        seatingCandidatesList = new ArrayList<>();

        // 1) Load exam names from examSlot.bin instead of hardcoding
        loadExamNamesFromExamSlotFile();

        // Plan types (how we will ORDER / ARRANGE students)
        seatingPlanTypeComboBox.getItems().setAll(
                "Standard Seating Plan",   // ascending ID
                "Alternate Row Plan",      // descending ID
                "Exam Hall Plan"           // prime first, then even, then others
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

    // ----------------- NAV BUTTONS -----------------

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

    // ----------------- LOAD CANDIDATES (TEMPORARY) -----------------

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

        String dateStr = date.toString();

        seatingCandidatesList.clear();
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
                        seatingCandidatesList.add(c);
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

        for (MarkingController.examCandidate c : seatingCandidatesList) {
            seatingPlan sp = new seatingPlan(
                    c.getStudentId(),
                    c.getStudentName(),
                    c.getExam(),
                    dateStr,
                    "",
                    "",
                    "",
                    ""
            );
            seatingPlanTableView.getItems().add(sp);
        }

        seatingHeaderStatusLabel.setText("Loaded " + seatingCandidatesList.size() + " candidates for seating plan.");
        notificationLabel.setText("Candidates loaded. Generate seating plan to assign room and seat.");
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

        if (seatingCandidatesList.isEmpty()) {
            commonMethods.showError("No Candidates", "Please load seating candidates first.");
            return;
        }

        ArrayList<seatingPlan> existing = loadAllSeatingFromFile();
        seatingPlanList = new ArrayList<>();
        String dateStr = date.toString();

        ArrayList<MarkingController.examCandidate> orderedCandidates = new ArrayList<>(seatingCandidatesList);

        // Convert studentId to integer for sorting
        Comparator<MarkingController.examCandidate> ascComparator = (a, b) ->
                Integer.compare(parseStudentId(a.getStudentId()), parseStudentId(b.getStudentId()));

        Comparator<MarkingController.examCandidate> descComparator = (a, b) ->
                Integer.compare(parseStudentId(b.getStudentId()), parseStudentId(a.getStudentId()));

        if (planType.equals("Standard Seating Plan")) {
            // ascending by ID
            Collections.sort(orderedCandidates, ascComparator);

        } else if (planType.equals("Alternate Row Plan")) {
            // descending by ID
            Collections.sort(orderedCandidates, descComparator);

        } else if (planType.equals("Exam Hall Plan")) {
            // simple grouping: prime IDs first, then even IDs, then others (all ascending)
            ArrayList<MarkingController.examCandidate> primes = new ArrayList<>();
            ArrayList<MarkingController.examCandidate> evens = new ArrayList<>();
            ArrayList<MarkingController.examCandidate> others = new ArrayList<>();

            for (MarkingController.examCandidate c : orderedCandidates) {
                int idVal = parseStudentId(c.getStudentId());
                if (isPrime(idVal)) {
                    primes.add(c);
                } else if (idVal % 2 == 0) {
                    evens.add(c);
                } else {
                    others.add(c);
                }
            }

            Collections.sort(primes, ascComparator);
            Collections.sort(evens, ascComparator);
            Collections.sort(others, ascComparator);

            orderedCandidates.clear();
            orderedCandidates.addAll(primes);
            orderedCandidates.addAll(evens);
            orderedCandidates.addAll(others);
        }

        // 2) Assign room, row and seat based on ORDERED list
        int seatsPerRow = 10;
        int index = 0;

        for (MarkingController.examCandidate c : orderedCandidates) {
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

        // Show only this session's generated plan
        seatingPlanTableView.getItems().clear();
        seatingPlanTableView.getItems().addAll(seatingPlanList);

        updateCounters();

        seatingGenerateStatusLabel.setText("Generated seating plan for " + seatingPlanList.size() + " candidates.");
        notificationLabel.setText("Seating plan saved to seatingPlan.bin.");
    }


    @FXML
    public void regenerateSeatingPlanOnActionButton(ActionEvent actionEvent) {
        var items = seatingPlanTableView.getItems();
        if (items == null || items.isEmpty()) {
            commonMethods.showError("Nothing to Re-generate", "No seating plan loaded.");
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


    @FXML
    public void downloadSeatingPlanPdfOnActionButton(ActionEvent actionEvent) {
        notificationLabel.setText("PDF export not implemented.");
    }


    // Load unique exam names from examSlot.bin into the combo box
    private void loadExamNamesFromExamSlotFile() {
        seatingExamComboBox.getItems().clear();
        ArrayList<String> examNames = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            File file = new File("data/examSlot.bin");
            if (!file.exists()) {
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    examOfficerDashboardController.examOfficerDashboard slot = (examOfficerDashboardController.examOfficerDashboard) ois.readObject();
                    String examName = slot.getExamType();

                    if (!examNames.contains(examName)) {
                        examNames.add(examName);
                    }
                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading examSlot.bin: " + e.getMessage());
        }

        seatingExamComboBox.getItems().addAll(examNames);
    }

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

    private int parseStudentId(String idStr) {
        try {
            return Integer.parseInt(idStr.trim());
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
