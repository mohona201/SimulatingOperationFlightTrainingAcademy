package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class misconductReportController {

    @FXML
    private Button refreshMisconductButton;
    @FXML
    private TableColumn<misconductReport, String> misconductIdColumn;
    @FXML
    private TableColumn<misconductReport, String> misconductExamIdColumn;
    @FXML
    private TableColumn<misconductReport, String> misconductDateColumn;
    @FXML
    private TableView<misconductReport> misconductTableView;
    @FXML
    private TableColumn<misconductReport, String> misconductStrikeColumn;
    @FXML
    private Label misconductStatusLabel;
    @FXML
    private TextField misconductStudentIdsTextField;
    @FXML
    private TableColumn<misconductReport, String> misconductSessionIdColumn;
    @FXML
    private TextField totalMisconductTextField;
    @FXML
    private Button createMisconductReportButton;
    @FXML
    private TableColumn<misconductReport, String> misconductStudentIdColumn;
    @FXML
    private TextField todayMisconductTextField;
    @FXML
    private Label notificationLabel;
    @FXML
    private TextField misconductSessionIdTextField;
    @FXML
    private TextField misconductExamIdTextField;
    @FXML
    private TableColumn<misconductReport, String> misconductDescriptionColumn;
    @FXML
    private TextField misconductDescriptionTextField;

    private ArrayList<misconductReport> misconductList;

    @FXML
    public void initialize() {
        misconductList = new ArrayList<>();

        misconductIdColumn.setCellValueFactory(new PropertyValueFactory<>("misconductId"));
        misconductSessionIdColumn.setCellValueFactory(new PropertyValueFactory<>("sessionId"));
        misconductExamIdColumn.setCellValueFactory(new PropertyValueFactory<>("examId"));
        misconductStudentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        misconductDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        misconductStrikeColumn.setCellValueFactory(new PropertyValueFactory<>("strike"));
        misconductDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        refreshMisconductData();
    }


    @FXML
    public void createMisconductReportOnActionButton(ActionEvent actionEvent) {
        String sessionId = misconductSessionIdTextField.getText().trim();
        String examId = misconductExamIdTextField.getText().trim();
        String studentIdsText = misconductStudentIdsTextField.getText().trim();
        String description = misconductDescriptionTextField.getText().trim();

        if (sessionId.isEmpty() || examId.isEmpty() ||
                studentIdsText.isEmpty() || description.isEmpty()) {
            commonMethods.showError("Empty Fields", "Please fill all the fields.");
            return;
        }

        ArrayList<misconductReport> existing = loadAllMisconductFromFile();

        String[] studentIds = studentIdsText.split(",");

        ArrayList<misconductReport> newRecords = new ArrayList<>();
        String today = LocalDate.now().toString();

        int baseCount = existing.size();
        int index = 1;

        for (String rawId : studentIds) {
            String sid = rawId.trim();
            if (sid.isEmpty()) continue;

            int previous = 0;
            for (misconductReport m : existing) {
                if (m.getStudentId().equals(sid)) {
                    previous++;
                }
            }
            String strike = String.valueOf(previous + 1);

            String misconductId = "M" + (baseCount + index);
            index++;

            misconductReport mr = new misconductReport(
                    misconductId,
                    sessionId,
                    examId,
                    sid,
                    today,
                    strike,
                    description
            );

            newRecords.add(mr);
            existing.add(mr);
        }

        if (newRecords.isEmpty()) {
            commonMethods.showError("No Valid Students",
                    "Please enter at least one valid student ID.");
            return;
        }

        commonMethods.saveToBinFile("misconductReport.bin", newRecords);

        misconductTableView.getItems().addAll(newRecords);

        updateCounters();

        notificationLabel.setText("Misconduct records saved.");

        misconductStudentIdsTextField.clear();
        misconductDescriptionTextField.clear();
    }


    @FXML
    public void refreshMisconductOnActionButton(ActionEvent actionEvent) {
        refreshMisconductData();
        notificationLabel.setText("Misconduct data refreshed.");
    }

    private void refreshMisconductData() {
        misconductTableView.getItems().clear();
        ArrayList<misconductReport> all = loadAllMisconductFromFile();
        misconductTableView.getItems().addAll(all);
        updateCounters();
    }


    private ArrayList<misconductReport> loadAllMisconductFromFile() {
        ArrayList<misconductReport> list = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            File file = new File("data/misconductReport.bin");
            if (!file.exists()) {
                totalMisconductTextField.setText("0");
                todayMisconductTextField.setText("0");
                return list;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    misconductReport m = (misconductReport) ois.readObject();
                    list.add(m);
                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading misconductReport.bin: " + e.getMessage());
        }

        return list;
    }


    private void updateCounters() {
        var items = misconductTableView.getItems();
        int total = items.size();
        int todayCount = 0;
        String today = LocalDate.now().toString();

        for (misconductReport m : items) {
            if (m.getDate() != null && m.getDate().equals(today)) {
                todayCount++;
            }
        }

        totalMisconductTextField.setText(String.valueOf(total));
        todayMisconductTextField.setText(String.valueOf(todayCount));
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

    public static class misconductReport implements Serializable {
        public String misconductId;
        public String sessionId;
        public String examId;
        public String studentId;
        public String date;
        public String strike;
        public String description;


        public misconductReport(String examId, String studentId, String date, String strike, String description, String misconductId, String sessionId) {
            this.examId = examId;
            this.studentId = studentId;
            this.date = date;
            this.strike = strike;
            this.description = description;
            this.misconductId = misconductId;
            this.sessionId = sessionId;
        }

        public String getMisconductId() {
            return misconductId;
        }

        public void setMisconductId(String misconductId) {
            this.misconductId = misconductId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getExamId() {
            return examId;
        }

        public void setExamId(String examId) {
            this.examId = examId;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getStrike() {
            return strike;
        }

        public void setStrike(String strike) {
            this.strike = strike;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "misconductReport{" +
                    "misconductId='" + misconductId + '\'' +
                    ", sessionId='" + sessionId + '\'' +
                    ", examId='" + examId + '\'' +
                    ", studentId='" + studentId + '\'' +
                    ", date='" + date + '\'' +
                    ", strike='" + strike + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
