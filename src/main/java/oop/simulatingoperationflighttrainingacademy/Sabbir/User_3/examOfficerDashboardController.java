package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public class examOfficerDashboardController
{
    @javafx.fxml.FXML
    private TextField examTimeTextField;
    @javafx.fxml.FXML
    private TextField capacityTextField;
    @javafx.fxml.FXML
    private Label examStatusLabel;
    @javafx.fxml.FXML
    private TableColumn <examOfficerDashboard, String> examTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<examOfficerDashboard, Integer> examCapacityColumn;
    @javafx.fxml.FXML
    private TextField todaysExamsTextField;
    @javafx.fxml.FXML
    private ComboBox<String> examTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<examOfficerDashboard, LocalDate> examDateColumn;
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TextField pendingResitTextField;
    @javafx.fxml.FXML
    private Label name;
    @javafx.fxml.FXML
    private DatePicker examDatePicker;
    @javafx.fxml.FXML
    private Label id;
    @javafx.fxml.FXML
    private TableView<examOfficerDashboard> examSlotsTableView;
    @javafx.fxml.FXML
    private TableColumn<examOfficerDashboard, String> examTimeColumn;


    ArrayList<examOfficerDashboard> publishedExamList;
    @FXML
    private TextField courseTextArea;
    @FXML
    private TableColumn<examOfficerDashboard, String> CourseColumn;

    @FXML
    public void initialize() {
        publishedExamList = new ArrayList<>();
        examTypeComboBox.getItems().setAll("Theory", "Practical");
        examDatePicker.setValue(LocalDate.now());

        examDateColumn.setCellValueFactory(new PropertyValueFactory<>("examDate"));
        examTimeColumn.setCellValueFactory(new PropertyValueFactory<examOfficerDashboard, String>("time"));
        examCapacityColumn.setCellValueFactory(new PropertyValueFactory<examOfficerDashboard, Integer>("examType"));
        examTypeColumn.setCellValueFactory(new PropertyValueFactory<examOfficerDashboard, String>("examType"));
        CourseColumn.setCellValueFactory(new PropertyValueFactory<examOfficerDashboard, String>("course"));
    }

    @Deprecated
    public void publishExamsOnActionButton(ActionEvent actionEvent) {
        String examType = this.examTypeComboBox.getValue();
        LocalDate examDate = this.examDatePicker.getValue();
        String time = this.examTimeTextField.getText();
        Integer capacity = Integer.valueOf(this.capacityTextField.getText());
        String course = this.courseTextArea.getText();

        if(examType.isEmpty() || time.isEmpty() || String.valueOf(capacity).isEmpty() || course.isEmpty()) {
            commonMethods.showAlert(Alert.AlertType.ERROR, "Empty Fields", "Please fill all the fields");
            return;
        }





    }

    @javafx.fxml.FXML
    public void createExamOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void seatingPlanOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resitRequestsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void certificatesOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void questionBankOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void markingOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void eligibilityOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void misconductOnActionButton(ActionEvent actionEvent) {
    }
}