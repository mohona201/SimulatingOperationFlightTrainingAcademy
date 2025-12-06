package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class billController {

    @FXML private TableColumn<Bill, Float> amountTableColumn;
    @FXML private TextField enterTransactionIdTextField;
    @FXML private TableColumn<Bill, LocalDate> paymentDateTableColumn;
    @FXML private TableView<Bill> duePaymentTableView;
    @FXML private TableColumn<Bill, LocalDate> lastPaymentTableColumn;
    @FXML private TableColumn<Bill, String> billNameTableColumn;
    @FXML private TableColumn<Bill, LocalDate> paidDateTableColumn;
    @FXML private Label billingNotificationLabel;
    @FXML private TableColumn<Bill, Integer> paidAmountTableColumn;
    @FXML private TableView<Bill> paidBillsTableView;
    @FXML private TableColumn<Bill, String> paidBillNameTableColumn;
    @FXML private TableColumn<Bill, String> paymentMethodTableColumn;
    @FXML private Label billingMessageLabel;
    @FXML private TableColumn<Bill, Integer> paidBillIdTableColumn1;
    @FXML private TableColumn<Bill, Integer> billId1TableColumn1;
    @FXML private TextField billIdTextField;

    ArrayList<Bill> billArrayList = new ArrayList<>();

    @FXML
    public void initialize() {
        billNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("billName"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        lastPaymentTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastPaymentDate"));
        paymentDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        billId1TableColumn1.setCellValueFactory(new PropertyValueFactory<>("billId_1"));
        paidBillIdTableColumn1.setCellValueFactory(new PropertyValueFactory<>("paidBillId"));
        paymentMethodTableColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        paidBillNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("paidBill"));
        paidDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("paidDate"));
        paidAmountTableColumn.setCellValueFactory(new PropertyValueFactory<>("paidAmount"));

        commonMethods.showTableDataFromBinFile("bill.bin", paidBillsTableView);
    }

    @FXML
    public void addBillOnActionButton(ActionEvent actionEvent) {

        String billIdText = billIdTextField.getText().trim();
        String trxText = enterTransactionIdTextField.getText().trim();

        if (billIdText.isEmpty() || trxText.isEmpty()) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        Integer billId = Integer.parseInt(billIdText);
        String billName = "Bill-" + billId;
        Float amount = 987f;
        LocalDate date = LocalDate.now();

        Bill bill = new Bill(billId, billName, amount, date);

        ArrayList<Bill> oldBills = new ArrayList<>();
        oldBills.addAll(paidBillsTableView.getItems());
        oldBills.add(bill);

        commonMethods.saveToBinFile("bill.bin", oldBills);

        paidBillsTableView.getItems().add(bill);

        billingMessageLabel.setText("Payment Successful");

        billIdTextField.clear();
        enterTransactionIdTextField.clear();
    }

    @FXML
    public void ScheduleOnActionButton(ActionEvent actionEvent) {
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
    public void exmOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/exm.fxml");
    }

    @FXML
    public void leaveOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Madhu/User_1/leave.fxml");
    }
}
