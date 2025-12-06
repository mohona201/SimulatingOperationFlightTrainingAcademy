package oop.simulatingoperationflighttrainingacademy.Sabbir.User_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class installmentPlanController {

    @FXML
    private DatePicker installmentFirstDueDatePicker;
    @FXML
    private TextField installmentStudentNameTextField;
    @FXML
    private ComboBox<String> installmentPlanStatusComboBox;
    @FXML
    private TableColumn<studentInstallment, Integer> scheduleInstallmentNoColumn;
    @FXML
    private TableColumn<studentInstallment, String> scheduleStudentNameColumn;
    @FXML
    private ComboBox<String> installmentProgramComboBox;
    @FXML
    private Button saveInstallmentPlanButton;
    @FXML
    private Label installmentPlanStatusLabel;
    @FXML
    private Label assignInstallmentStatusLabel;
    @FXML
    private TextField installmentCountTextField;
    @FXML
    private Button markInstallmentPaidButton;
    @FXML
    private TextArea installmentPlanRemarksTextArea;
    @FXML
    private TextField installmentsDueThisWeekTextField;
    @FXML
    private TextField installmentStudentIdTextField;
    @FXML
    private ComboBox<String> installmentPlanSelectComboBox;
    @FXML
    private TextField installmentPlanIdTextField;
    @FXML
    private ComboBox<String> installmentFrequencyComboBox;
    @FXML
    private DatePicker installmentStartDatePicker;
    @FXML
    private ComboBox<String> installmentFeeTypeComboBox;
    @FXML
    private Button assignInstallmentPlanButton;
    @FXML
    private TableView<studentInstallment> installmentScheduleTableView;
    @FXML
    private Label notificationLabel;
    @FXML
    private Button clearInstallmentPlanFormButton;
    @FXML
    private TableColumn<studentInstallment, String> scheduleStatusColumn;
    @FXML
    private TableColumn<studentInstallment, String> scheduleDueDateColumn;
    @FXML
    private TableColumn<studentInstallment, Double> scheduleAmountColumn;
    @FXML
    private TableColumn<studentInstallment, String> schedulePlanIdColumn;
    @FXML
    private DatePicker installmentStudentStartDatePicker;
    @FXML
    private TextField installmentTotalAmountTextField;
    @FXML
    private TextField activeInstallmentPlansTextField;
    @FXML
    private TableColumn<studentInstallment, String> scheduleStudentIdColumn;

    private ArrayList<installmentPlan> planBuffer;
    private ArrayList<studentInstallment> studentInstallmentBuffer;

    @FXML
    public void initialize() {
        planBuffer = new ArrayList<>();
        studentInstallmentBuffer = new ArrayList<>();

        installmentProgramComboBox.getItems().setAll(
                "Private Pilot License (PPL)",
                "Commercial Pilot License (CPL)",
                "Instrument Rating (IR)",
                "Flight Instructor Course (FIC)"
        );

        installmentFeeTypeComboBox.getItems().setAll(
                "Tuition",
                "Exam Fee",
                "Simulator",
                "Medical"
        );

        installmentFrequencyComboBox.getItems().setAll(
                "Monthly",
                "Weekly",
                "One-time"
        );

        installmentPlanStatusComboBox.getItems().setAll(
                "Active",
                "Inactive"
        );

        installmentStartDatePicker.setValue(LocalDate.now());

        schedulePlanIdColumn.setCellValueFactory(new PropertyValueFactory<>("planId"));
        scheduleStudentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        scheduleStudentNameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        scheduleInstallmentNoColumn.setCellValueFactory(new PropertyValueFactory<>("installmentNo"));
        scheduleDueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        scheduleAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        scheduleStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        ArrayList<studentInstallment> all = loadAllStudentInstallmentsFromFile();
        installmentScheduleTableView.getItems().addAll(all);

        reloadPlanSelectComboBox();

    }


    @FXML
    public void scholarshipsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/scholarship.fxml");
    }

    @FXML
    public void installmentsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/installmentPlan.fxml");
    }

    @FXML
    public void refundsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/refunds.fxml");
    }

    @FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/financialReport.fxml");
    }

    @FXML
    public void feesOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/feeStructure.fxml");
    }

    @FXML
    public void suppliersOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/suppliers.fxml");
    }

    @FXML
    public void paymentsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/financialOfficerDashboard.fxml");
    }

    @FXML
    public void holdsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/hold.fxml");
    }


    @FXML
    public void saveInstallmentPlanOnActionButton(ActionEvent actionEvent) {
        String planId = installmentPlanIdTextField.getText().trim();
        String program = (installmentProgramComboBox.getValue() == null) ? "" : installmentProgramComboBox.getValue();
        String feeType = (installmentFeeTypeComboBox.getValue() == null) ? "" : installmentFeeTypeComboBox.getValue();
        String totalAmountText = installmentTotalAmountTextField.getText().trim();
        String countText = installmentCountTextField.getText().trim();
        String frequency = (installmentFrequencyComboBox.getValue() == null) ? "" : installmentFrequencyComboBox.getValue();
        LocalDate startDate = installmentStartDatePicker.getValue();
        LocalDate firstDue = installmentFirstDueDatePicker.getValue();
        String status = (installmentPlanStatusComboBox.getValue() == null) ? "" : installmentPlanStatusComboBox.getValue();
        String remarks = installmentPlanRemarksTextArea.getText().trim();

        if (planId.isEmpty() || program.isEmpty() || feeType.isEmpty()
                || totalAmountText.isEmpty() || countText.isEmpty()
                || frequency.isEmpty() || startDate == null || firstDue == null
                || status.isEmpty()) {

            commonMethods.showError("Empty Fields",
                    "Please fill all required fields for the installment plan.");
            return;
        }

        double totalAmount;
        int installmentCount;
        try {
            totalAmount = Double.parseDouble(totalAmountText);
            installmentCount = Integer.parseInt(countText);
        } catch (NumberFormatException e) {
            commonMethods.showError("Invalid Number",
                    "Total amount and number of installments must be valid numbers.");
            return;
        }

        ArrayList<installmentPlan> existingPlans = loadAllPlansFromFile();
        for (installmentPlan p : existingPlans) {
            if (p.getPlanId().equalsIgnoreCase(planId)) {
                commonMethods.showError("Duplicate Plan",
                        "An installment plan with this Plan ID already exists.");
                return;
            }
        }

        installmentPlan newPlan = new installmentPlan(
                planId,
                program,
                feeType,
                totalAmount,
                installmentCount,
                frequency,
                startDate.toString(),
                firstDue.toString(),
                status,
                remarks
        );

        planBuffer = new ArrayList<>();
        planBuffer.add(newPlan);
        commonMethods.saveToBinFile("installmentPlans.bin", planBuffer);

        installmentPlanStatusLabel.setText("Installment plan saved: " + planId);
        notificationLabel.setText("Installment plan saved to installmentPlans.bin");

        reloadPlanSelectComboBox();
    }


    @FXML
    public void assignInstallmentPlanOnActionButton(ActionEvent actionEvent) {
        String studentId = installmentStudentIdTextField.getText().trim();
        String studentName = installmentStudentNameTextField.getText().trim();
        String selectedPlanId = (installmentPlanSelectComboBox.getValue() == null)
                ? "" : installmentPlanSelectComboBox.getValue();
        LocalDate startDate = installmentStudentStartDatePicker.getValue();

        if (studentId.isEmpty() || studentName.isEmpty()
                || selectedPlanId.isEmpty() || startDate == null) {

            commonMethods.showError("Empty Fields",
                    "Please fill Student ID, Name, select a Plan and Start Date.");
            return;
        }

        ArrayList<installmentPlan> plans = loadAllPlansFromFile();
        installmentPlan chosenPlan = null;
        for (installmentPlan p : plans) {
            if (p.getPlanId().equals(selectedPlanId)) {
                chosenPlan = p;
                break;
            }
        }

        if (chosenPlan == null) {
            commonMethods.showError("Plan Not Found",
                    "Selected plan does not exist.");
            return;
        }

        // Check if same student already has this plan
        ArrayList<studentInstallment> allStudentInst = loadAllStudentInstallmentsFromFile();
        for (studentInstallment si : allStudentInst) {
            if (si.getPlanId().equals(selectedPlanId)
                    && si.getStudentId().equals(studentId)) {
                commonMethods.showError("Duplicate Assignment",
                        "This student already has this installment plan assigned.");
                return;
            }
        }

        double perInstallmentAmount = chosenPlan.getTotalAmount() / chosenPlan.getInstallmentCount();
        String freq = chosenPlan.getFrequency();
        LocalDate firstDue = LocalDate.parse(chosenPlan.getFirstDueDate());

        studentInstallmentBuffer = new ArrayList<>();

        for (int i = 1; i <= chosenPlan.getInstallmentCount(); i++) {
            LocalDate dueDate = firstDue;

            if ("Monthly".equalsIgnoreCase(freq)) {
                dueDate = firstDue.plusMonths(i - 1);
            } else if ("Weekly".equalsIgnoreCase(freq)) {
                dueDate = firstDue.plusDays(7L * (i - 1));
            }

            studentInstallment si = new studentInstallment(
                    selectedPlanId,
                    studentId,
                    studentName,
                    i,
                    dueDate.toString(),
                    perInstallmentAmount,
                    "Pending"
            );

            studentInstallmentBuffer.add(si);
            allStudentInst.add(si);
        }

        commonMethods.saveToBinFile("studentInstallments.bin", studentInstallmentBuffer);

        installmentScheduleTableView.getItems().addAll(studentInstallmentBuffer);

        assignInstallmentStatusLabel.setText("Installment plan assigned to " + studentName);
        notificationLabel.setText("Installment schedule saved to studentInstallments.bin");

    }


    @FXML
    public void markInstallmentPaidOnActionButton(ActionEvent actionEvent) {
    }



    @FXML
    public void clearInstallmentPlanFormOnActionButton(ActionEvent actionEvent) {
        installmentPlanIdTextField.clear();
        installmentProgramComboBox.setValue(null);
        installmentFeeTypeComboBox.setValue(null);
        installmentTotalAmountTextField.clear();
        installmentCountTextField.clear();
        installmentFrequencyComboBox.setValue(null);
        installmentStartDatePicker.setValue(LocalDate.now());
        installmentFirstDueDatePicker.setValue(null);
        installmentPlanStatusComboBox.setValue(null);
        installmentPlanRemarksTextArea.clear();
        installmentPlanStatusLabel.setText("");
        notificationLabel.setText("Installment plan form cleared.");
    }




    private ArrayList<installmentPlan> loadAllPlansFromFile() {
        ArrayList<installmentPlan> list = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            File file = new File("data/installmentPlans.bin");
            if (!file.exists()) {
                return list;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    installmentPlan p = (installmentPlan) ois.readObject();
                    list.add(p);
                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading installmentPlans.bin: " + e.getMessage());
        }

        return list;
    }

    private ArrayList<studentInstallment> loadAllStudentInstallmentsFromFile() {
        ArrayList<studentInstallment> list = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            File file = new File("data/studentInstallments.bin");
            if (!file.exists()) {
                return list;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    studentInstallment si = (studentInstallment) ois.readObject();
                    list.add(si);
                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading studentInstallments.bin: " + e.getMessage());
        }

        return list;
    }

    private void reloadPlanSelectComboBox() {
        installmentPlanSelectComboBox.getItems().clear();
        ArrayList<installmentPlan> plans = loadAllPlansFromFile();
        for (installmentPlan p : plans) {
            installmentPlanSelectComboBox.getItems().add(p.getPlanId());
        }
    }



    public static class installmentPlan implements Serializable {
        private String planId;
        private String program;
        private String feeType;
        private double totalAmount;
        private int installmentCount;
        private String frequency;
        private String startDate;
        private String firstDueDate;
        private String status;
        private String remarks;

        public installmentPlan(String planId, String program, String feeType,
                               double totalAmount, int installmentCount,
                               String frequency, String startDate,
                               String firstDueDate, String status,
                               String remarks) {
            this.planId = planId;
            this.program = program;
            this.feeType = feeType;
            this.totalAmount = totalAmount;
            this.installmentCount = installmentCount;
            this.frequency = frequency;
            this.startDate = startDate;
            this.firstDueDate = firstDueDate;
            this.status = status;
            this.remarks = remarks;
        }

        public String getPlanId() {
            return planId;
        }

        public String getProgram() {
            return program;
        }

        public String getFeeType() {
            return feeType;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public int getInstallmentCount() {
            return installmentCount;
        }

        public String getFrequency() {
            return frequency;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getFirstDueDate() {
            return firstDueDate;
        }

        public String getStatus() {
            return status;
        }

        public String getRemarks() {
            return remarks;
        }

        @Override
        public String toString() {
            return "installmentPlan{" +
                    "planId='" + planId + '\'' +
                    ", program='" + program + '\'' +
                    ", feeType='" + feeType + '\'' +
                    ", totalAmount=" + totalAmount +
                    ", installmentCount=" + installmentCount +
                    ", frequency='" + frequency + '\'' +
                    ", startDate='" + startDate + '\'' +
                    ", firstDueDate='" + firstDueDate + '\'' +
                    ", status='" + status + '\'' +
                    ", remarks='" + remarks + '\'' +
                    '}';
        }
    }

    public static class studentInstallment implements Serializable {
        private String planId;
        private String studentId;
        private String studentName;
        private int installmentNo;
        private String dueDate;
        private double amount;
        private String status;

        public studentInstallment(String planId, String studentId,
                                  String studentName, int installmentNo,
                                  String dueDate, double amount, String status) {
            this.planId = planId;
            this.studentId = studentId;
            this.studentName = studentName;
            this.installmentNo = installmentNo;
            this.dueDate = dueDate;
            this.amount = amount;
            this.status = status;
        }

        public String getPlanId() {
            return planId;
        }

        public String getStudentId() {
            return studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public int getInstallmentNo() {
            return installmentNo;
        }

        public String getDueDate() {
            return dueDate;
        }

        public double getAmount() {
            return amount;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "studentInstallment{" +
                    "planId='" + planId + '\'' +
                    ", studentId='" + studentId + '\'' +
                    ", studentName='" + studentName + '\'' +
                    ", installmentNo=" + installmentNo +
                    ", dueDate='" + dueDate + '\'' +
                    ", amount=" + amount +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}
