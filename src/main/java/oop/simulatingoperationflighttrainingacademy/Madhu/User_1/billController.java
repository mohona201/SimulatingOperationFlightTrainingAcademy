package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;

public class billController
{
    @javafx.fxml.FXML
    private TableColumn<Bill, Float> amountTableColumn;
    @javafx.fxml.FXML
    private TextField enterTransactionIdTextField;
    @javafx.fxml.FXML
    private TableColumn<Bill, LocalDate> paymentDateTableColumn;
    @javafx.fxml.FXML
    private TableView<Bill> duePaymentTableView;
    @javafx.fxml.FXML
    private TableColumn<Bill, LocalDate> lastPaymentTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Bill, String> billNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn <Bill,String>billNameTableColumn1;
    @javafx.fxml.FXML
    private TableColumn paidDateTableColumn;
    @javafx.fxml.FXML
    private Label billingNotificationLabel;
    @javafx.fxml.FXML
    private TableColumn paidAmountTableColumn;
    @javafx.fxml.FXML
    private Button logBookButton;
    @javafx.fxml.FXML
    private TableView paidBillsTableView;
    @javafx.fxml.FXML
    private TextField enterTransactionIdTextField1;
    @javafx.fxml.FXML
    private TableColumn paidBillNameTableColumn;
    @javafx.fxml.FXML
    private Button DashBoardButton;
    @javafx.fxml.FXML
    private Button exmButton;
    @javafx.fxml.FXML
    private TableColumn paidBillNameTableColumn1;
    @javafx.fxml.FXML
    private Button resultButton;
    @javafx.fxml.FXML
    private TableColumn paymentMethodTableColumn;
    @javafx.fxml.FXML
    private Label billingMessageLabel;

    @javafx.fxml.FXML
    public void initialize() {
        billNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("billName"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        lastPaymentTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastPaymentDate"));
        paymentDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastPaymentDate"));
        billNameTableColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("billName"));
        billName2TableColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("billName2"));
        paymentDateTableColumn.setCellValueFactory(new PropertyValueFactory<Bill,LocalDate>("paymentDate"));
        amountPaidTableColumn.setCellValueFactory(new PropertyValueFactory<Bill,Integer>("amountPaid"));
    }

    @javafx.fxml.FXML
    public void ScheduleOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void resultAndCertificateOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void billOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void logBookOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void DashBoardOnActionButton(ActionEvent actionEvent) { }

    @Deprecated
    public void submitOnActionButton(ActionEvent actionEvent) {

        String trId = enterTransactionIdTextField.getText();

        if (trId.isEmpty()) {
            showError("Transaction ID is required.");
            return;
        }

        Bill bill = new Bill("Tuition Fee", 5000.0f, LocalDate.now());
        duePaymentTableView.getItems().add(bill);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("billRecords.txt", true));
            bw.write(trId + "," + bill.getBillName() + "," + bill.getAmount() + "," + bill.getLastPaymentDate());
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            showError("Failed to save bill.");
            return;
        }

        showError("Bill submitted.");
    }

    @Deprecated
    public void downloadOnActionButton(ActionEvent actionEvent) {

        File file = new File("billRecords.txt");

        if (!file.exists()) {
            showError("No bill file found.");
            return;
        }

        showError("Bill file is ready for download.");
    }

    @javafx.fxml.FXML
    public void medicalCheckUpOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void clearBillOnActionButton(ActionEvent actionEvent) {

        if (enterTransactionIdTextField.getText().isEmpty()) {
            showError("Enter a transaction ID to clear.");
            return;
        }

        enterTransactionIdTextField.clear();
        duePaymentTableView.getItems().clear();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("billRecords.txt"));
            bw.write("");
            bw.close();
        } catch (Exception e) {
            showError("Failed to clear bill file.");
            return;
        }

        showError("Bill records cleared.");
    }

    @javafx.fxml.FXML
    public void exmOnActionButton(ActionEvent actionEvent) { }

    @javafx.fxml.FXML
    public void leaveOnActionButton(ActionEvent actionEvent) { }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
