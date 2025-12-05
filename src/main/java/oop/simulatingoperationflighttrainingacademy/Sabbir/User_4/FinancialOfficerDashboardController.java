package oop.simulatingoperationflighttrainingacademy.Sabbir.User_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FinancialOfficerDashboardController {

    @FXML
    private TextField unpaidInvoicesCountTextField;
    @FXML
    private TableColumn<vendorPayment, Double> recentPaymentAmountColumn;
    @FXML
    private TableColumn<unpaidInvoice, String> studentIdColumn;
    @FXML
    private Button applyInvoiceFilterButton;
    @FXML
    private TextField paymentInvoiceIdTextField;
    @FXML
    private TableColumn<vendorPayment, String> recentPaymentMethodColumn;
    @FXML
    private TableColumn<vendorPayment, String> recentPaymentStudentNameColumn;
    @FXML
    private TableColumn<unpaidInvoice, String> invoiceDueDateColumn;
    @FXML
    private TextField paymentReferenceTextField;
    @FXML
    private TextField paymentStudentIdTextField;
    @FXML
    private TextField paymentAmountTextField;
    @FXML
    private DatePicker paymentDatePicker;
    @FXML
    private Label paymentStatusLabel;
    @FXML
    private TableColumn<unpaidInvoice, String> invoiceIdColumn;
    @FXML
    private TableColumn<unpaidInvoice, String> invoiceStatusColumn;
    @FXML
    private TableColumn<vendorPayment, String> recentPaymentDateColumn;
    @FXML
    private Label notificationLabel;
    @FXML
    private TableView<unpaidInvoice> invoicesTableView;
    @FXML
    private TableView<vendorPayment> recentPaymentsTableView;
    @FXML
    private TableColumn<vendorPayment, String> recentPaymentInvoiceIdColumn;
    @FXML
    private TextField paymentTransactionIdTextField;
    @FXML
    private Button clearPaymentFormButton;
    @FXML
    private ComboBox<String> invoiceFilterComboBox;
    @FXML
    private TableColumn<unpaidInvoice, Double> invoiceAmountColumn;
    @FXML
    private TextField searchStudentTextField;
    @FXML
    private TextField paymentsTodayAmountTextField;
    @FXML
    private ComboBox<String> paymentMethodComboBox;
    @FXML
    private TableColumn<vendorPayment, String> recentPaymentStudentIdColumn;
    @FXML
    private TableColumn<unpaidInvoice, String> studentNameColumn;
    @FXML
    private Button confirmPaymentButton;

    private ArrayList<vendorPayment> paymentBuffer;

    @FXML
    public void initialize() {
        paymentBuffer = new ArrayList<>();

        // Payment methods
        paymentMethodComboBox.getItems().setAll(
                "Cash",
                "Card",
                "Bank Transfer",
                "Mobile Payment"
        );

        // Invoice filter options
        invoiceFilterComboBox.getItems().setAll(
                "All",
                "Unpaid",
                "Overdue",
                "Paid"
        );

        invoiceIdColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        invoiceAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        invoiceDueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        invoiceStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        recentPaymentInvoiceIdColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        recentPaymentStudentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        recentPaymentStudentNameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        recentPaymentAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        recentPaymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        recentPaymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));

        commonMethods.showTableDataFromBinFile("unpaidInvoices.bin", invoicesTableView);
        commonMethods.showTableDataFromBinFile("vendorPayments.bin", recentPaymentsTableView);

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
        commonMethods.sceneChange(actionEvent, "Sabbir/User_4/installmentPlan.fxml");

    }

    @FXML
    public void paymentsOnActionButton(ActionEvent actionEvent) {
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
    public void applyInvoiceFilterOnActionButton(ActionEvent actionEvent) {
        String filter = invoiceFilterComboBox.getValue();
        String searchText = searchStudentTextField.getText().trim();

        var allInvoices = loadAllInvoicesFromFile();
        ArrayList<unpaidInvoice> filtered = new ArrayList<>();

        for (unpaidInvoice inv : allInvoices) {
            boolean match = true;

            if (filter != null && !filter.equals("All")) {
                if (!inv.getStatus().equalsIgnoreCase(filter)) {
                    match = false;
                }
            }

            if (!searchText.isEmpty()) {
                boolean studentMatch =
                        inv.getStudentId().contains(searchText) ||
                                inv.getStudentName().toLowerCase().contains(searchText.toLowerCase());
                if (!studentMatch) {
                    match = false;
                }
            }

            if (match) filtered.add(inv);
        }

        invoicesTableView.getItems().clear();
        invoicesTableView.getItems().addAll(filtered);

        notificationLabel.setText("Invoice filter applied.");
    }

    @FXML
    public void clearPaymentFormOnActionButton(ActionEvent actionEvent) {
        paymentInvoiceIdTextField.clear();
        paymentStudentIdTextField.clear();
        paymentAmountTextField.clear();
        paymentTransactionIdTextField.clear();
        paymentReferenceTextField.clear();
        paymentDatePicker.setValue(null);
        paymentMethodComboBox.setValue(null);
        paymentStatusLabel.setText("");
        notificationLabel.setText("Payment form cleared.");
    }


    @FXML
    public void confirmPaymentOnActionButton(ActionEvent actionEvent) {
        String invoiceId = paymentInvoiceIdTextField.getText().trim();
        String studentId = paymentStudentIdTextField.getText().trim();
        String amountText = paymentAmountTextField.getText().trim();
        String transactionId = paymentTransactionIdTextField.getText().trim();
        String reference = paymentReferenceTextField.getText().trim();
        String method = paymentMethodComboBox.getValue();
        LocalDate date = paymentDatePicker.getValue();

        if (invoiceId.isEmpty() || studentId.isEmpty() || amountText.isEmpty()
                || transactionId.isEmpty() || method == null || method.isEmpty()
                || date == null) {

            commonMethods.showError("Empty Fields",
                    "Please fill all payment details and select date & method.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            commonMethods.showError("Invalid Amount", "Payment amount must be a number.");
            return;
        }

        String studentName = "";
        for (unpaidInvoice inv : invoicesTableView.getItems()) {
            if (inv.getInvoiceId().equals(invoiceId)
                    && inv.getStudentId().equals(studentId)) {
                studentName = inv.getStudentName();
                break;
            }
        }

        vendorPayment payment = new vendorPayment(
                transactionId,
                invoiceId,
                studentId,
                studentName,
                amount,
                method,
                reference,
                date.toString()
        );

        paymentBuffer = new ArrayList<>();
        paymentBuffer.add(payment);
        commonMethods.saveToBinFile("vendorPayments.bin", paymentBuffer);

        // Update recent payments table
        recentPaymentsTableView.getItems().add(payment);

        // Optionally update invoice status in UI
        for (unpaidInvoice inv : invoicesTableView.getItems()) {
            if (inv.getInvoiceId().equals(invoiceId)
                    && inv.getStudentId().equals(studentId)) {
                inv.setStatus("Paid");
            }
        }
        invoicesTableView.refresh();

        paymentStatusLabel.setText("Payment recorded successfully.");
        notificationLabel.setText("Payment saved to vendorPayments.bin");
    }



    private ArrayList<unpaidInvoice> loadAllInvoicesFromFile() {
        ArrayList<unpaidInvoice> list = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            File file = new File("data/unpaidInvoices.bin");
            if (!file.exists()) {
                return list;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    unpaidInvoice inv = (unpaidInvoice) ois.readObject();
                    list.add(inv);
                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading unpaidInvoices.bin: " + e.getMessage());
        }

        return list;
    }

    public static class unpaidInvoice implements Serializable {

        private String invoiceId;
        private String studentId;
        private String studentName;
        private double amount;
        private String dueDate;
        private String status;

        public unpaidInvoice(String invoiceId, String studentId, String studentName, double amount, String dueDate, String status) {
            this.invoiceId = invoiceId;
            this.studentId = studentId;
            this.studentName = studentName;
            this.amount = amount;
            this.dueDate = dueDate;
            this.status = status;
        }

        public String getInvoiceId() {
            return invoiceId;
        }

        public void setInvoiceId(String invoiceId) {
            this.invoiceId = invoiceId;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "unpaidInvoice{" +
                    "invoiceId='" + invoiceId + '\'' +
                    ", studentId='" + studentId + '\'' +
                    ", studentName='" + studentName + '\'' +
                    ", amount=" + amount +
                    ", dueDate='" + dueDate + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    public static class vendorPayment implements Serializable {

        private String transactionId;
        private String invoiceId;
        private String studentId;
        private String studentName;
        private double amount;
        private String paymentMethod;
        private String reference;
        private String paymentDate;

        public vendorPayment(String transactionId, String invoiceId, String studentId, String studentName, double amount, String paymentMethod, String reference, String paymentDate) {
            this.transactionId = transactionId;
            this.invoiceId = invoiceId;
            this.studentId = studentId;
            this.studentName = studentName;
            this.amount = amount;
            this.paymentMethod = paymentMethod;
            this.reference = reference;
            this.paymentDate = paymentDate;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getInvoiceId() {
            return invoiceId;
        }

        public void setInvoiceId(String invoiceId) {
            this.invoiceId = invoiceId;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
        }

        @Override
        public String toString() {
            return "vendorPayment{" +
                    "transactionId='" + transactionId + '\'' +
                    ", invoiceId='" + invoiceId + '\'' +
                    ", studentId='" + studentId + '\'' +
                    ", studentName='" + studentName + '\'' +
                    ", amount=" + amount +
                    ", paymentMethod='" + paymentMethod + '\'' +
                    ", reference='" + reference + '\'' +
                    ", paymentDate='" + paymentDate + '\'' +
                    '}';
        }
    }
}
