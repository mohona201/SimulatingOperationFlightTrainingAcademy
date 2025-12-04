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
    @FXML private TextField enterTransactionIdTextField1;
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
    }

    @FXML
    public void clearBillOnActionButton(ActionEvent actionEvent) {

        String billIdText = billIdTextField.getText();
        String trxText = enterTransactionIdTextField.getText();

        if (billIdText == null || billIdText.isEmpty() ||
                trxText == null || trxText.isEmpty()) {

            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        Integer billId = Integer.parseInt(billIdText);
        Integer trxId = Integer.parseInt(trxText);

        String name = "Bill-" + billId;
        Float amount = 2789f;
        LocalDate today = LocalDate.now();

        Boolean sameData = false;

        if (commonMethods.existsInBinFile("bill.bin", billIdText) &&
                commonMethods.existsInBinFile("bill.bin", trxText)) {

            sameData = true;
            billingMessageLabel.setText("Same bill exists");
            return;
        }

        if (sameData == false) {

            Bill bill = new Bill(billId, name, amount, today);

            billArrayList.add(bill);
            commonMethods.saveToBinFile("bill.bin", billArrayList);

            paidBillsTableView.getItems().add(bill);
            billingMessageLabel.setText("Payment Successful");

            enterTransactionIdTextField.setText("");
            billIdTextField.setText("");

            return;
        }

        Bill bill = new Bill(billId, name, amount, today);

        paidBillsTableView.getItems().add(bill);

        enterTransactionIdTextField.setText("");
        enterTransactionIdTextField1.setText("");
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
