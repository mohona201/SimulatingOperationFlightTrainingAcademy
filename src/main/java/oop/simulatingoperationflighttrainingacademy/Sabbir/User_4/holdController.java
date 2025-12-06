package oop.simulatingoperationflighttrainingacademy.Sabbir.User_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class holdController {

    @FXML
    private TableColumn<studentFinancialHold, String> holdDateColumn;
    @FXML
    private TableView<studentFinancialHold> holdsTableView;
    @FXML
    private TableColumn<studentFinancialHold, String> holdStatusColumn;
    @FXML
    private TextArea holdReasonTextArea;
    @FXML
    private Label holdStatusLabel;
    @FXML
    private Button applyHoldButton;
    @FXML
    private Label notificationLabel;
    @FXML
    private TextField holdStudentIdTextField;
    @FXML
    private TableColumn<studentFinancialHold, String> holdReasonColumn;
    @FXML
    private TextField totalHoldsTextField;
    @FXML
    private TableColumn<studentFinancialHold, String> holdStudentIdColumn;
    @FXML
    private TextField holdsTodayTextField;
    @FXML
    private ComboBox<String> holdActionComboBox;

    private ArrayList<studentFinancialHold> holdBuffer;

    @FXML
    public void initialize() {
        holdBuffer = new ArrayList<>();

        holdActionComboBox.getItems().setAll(
                "On Hold",
                "Released",
                "Pending Clearance"
        );

        holdStudentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        holdStatusColumn.setCellValueFactory(new PropertyValueFactory<>("holdStatus"));
        holdReasonColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
        holdDateColumn.setCellValueFactory(new PropertyValueFactory<>("holdDate"));

        commonMethods.showTableDataFromBinFile("studentFinancialHold.bin", holdsTableView);

        updateCounters();
    }


    @FXML
    public void scholarshipsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/scholarship.fxml");
    }

    @FXML
    public void suppliersOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/suppliers.fxml");
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
    public void paymentsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/financialOfficerDashboard.fxml");
    }

    @FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/financialReport.fxml");
    }

    @FXML
    public void holdsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/hold.fxml");
    }

    @FXML
    public void feesOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/feeStructure.fxml");
    }


    @FXML
    public void applyHoldOnActionButton(ActionEvent actionEvent) {
        String studentId = holdStudentIdTextField.getText().trim();
        String status = holdActionComboBox.getValue();
        String reason = holdReasonTextArea.getText().trim();
        String today = LocalDate.now().toString();

        if (studentId.isEmpty() || status == null || status.isEmpty() || reason.isEmpty()) {
            commonMethods.showError("Empty Fields",
                    "Please enter student ID, select status and provide a reason.");
            return;
        }



        // Check duplicates: same studentId + status + date
        for (studentFinancialHold h : holdsTableView.getItems()) {
            if (h.getStudentId().equals(studentId)
                    && h.getHoldStatus().equals(status)
                    && h.getHoldDate().equals(today)) {

                commonMethods.showError(
                        "Duplicate Hold",
                        "A hold with the same status for this student already exists for today."
                );
                return;
            }
        }

        studentFinancialHold newHold = new studentFinancialHold(
                studentId,
                status,
                reason,
                today
        );

        holdBuffer = new ArrayList<>();
        holdBuffer.add(newHold);
        commonMethods.saveToBinFile("studentFinancialHold.bin", holdBuffer);

        holdsTableView.getItems().add(newHold);
        updateCounters();

        holdStatusLabel.setText("Hold updated for student " + studentId + " (" + status + ")");
        notificationLabel.setText("Hold saved to studentFinancialHold.bin");

        holdReasonTextArea.clear();
        holdActionComboBox.setValue(null);
    }


    private void updateCounters() {
        var items = holdsTableView.getItems();
        int total = items.size();
        int todayCount = 0;
        String today = LocalDate.now().toString();

        for (studentFinancialHold h : items) {
            if (h.getHoldDate() != null && h.getHoldDate().equals(today)) {
                todayCount++;
            }
        }

        totalHoldsTextField.setText(String.valueOf(total));
        holdsTodayTextField.setText(String.valueOf(todayCount));
    }

    public static class studentFinancialHold implements Serializable {
        public String studentId;
        public String holdStatus;
        public String reason;
        public String holdDate;

        public studentFinancialHold(String studentId, String holdStatus, String reason, String holdDate) {
            this.studentId = studentId;
            this.holdStatus = holdStatus;
            this.reason = reason;
            this.holdDate = holdDate;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }


        public String getHoldStatus() {
            return holdStatus;
        }

        public void setHoldStatus(String holdStatus) {
            this.holdStatus = holdStatus;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getHoldDate() {
            return holdDate;
        }

        public void setHoldDate(String holdDate) {
            this.holdDate = holdDate;
        }

        @Override
        public String toString() {
            return "studentFinancialHold{" +
                    "studentId='" + studentId + '\'' +
                    ", holdStatus='" + holdStatus + '\'' +
                    ", reason='" + reason + '\'' +
                    ", holdDate='" + holdDate + '\'' +
                    '}';
        }
    }
}
