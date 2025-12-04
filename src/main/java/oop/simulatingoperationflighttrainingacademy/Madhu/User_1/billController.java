package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedWriter;
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
    private TableColumn <Bill,LocalDate>paidDateTableColumn;
    @javafx.fxml.FXML
    private Label billingNotificationLabel;
    @javafx.fxml.FXML
    private TableColumn <billController,Integer>paidAmountTableColumn;
    @javafx.fxml.FXML
    private Button logBookButton;
    @javafx.fxml.FXML
    private TableView <Bill>paidBillsTableView;
    @javafx.fxml.FXML
    private TextField enterTransactionIdTextField1;
    @javafx.fxml.FXML
    private TableColumn <Bill,String>paidBillNameTableColumn;
    @javafx.fxml.FXML
    private Button DashBoardButton;
    @javafx.fxml.FXML
    private Button exmButton;
    @javafx.fxml.FXML
    private Button resultButton;
    @javafx.fxml.FXML
    private TableColumn <Bill,Integer>paymentMethodTableColumn;
    @javafx.fxml.FXML
    private Label billingMessageLabel;
    @javafx.fxml.FXML
    private Button ScheduleButton;
    @javafx.fxml.FXML
    private Button leaveButton;
    @javafx.fxml.FXML
    private Button medicalButton;
    @javafx.fxml.FXML
    private Button billButton;
    @javafx.fxml.FXML
    private TableColumn <Bill,Integer>paidBillIdTableColumn1;
    @javafx.fxml.FXML
    private TableColumn <Bill,Integer>billId1TableColumn1;

    @javafx.fxml.FXML
    public void initialize() {
        billNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("billName"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        lastPaymentTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastPaymentDate"));
        paymentDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastPaymentDate"));
        billNameTableColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("billName"));
        paymentDateTableColumn.setCellValueFactory(new PropertyValueFactory<Bill,LocalDate>("paymentDate"));
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
