package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop.simulatingoperationflighttrainingacademy.FlightAcademyStimulator;
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
            commonMethods.showError("Empty Fields",
                    "Please fill all the fields");
            return;
        }





    }

    @javafx.fxml.FXML
    public void createExamOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(FlightAcademyStimulator.class.getResource("signup.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Flight Academy");
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
        } catch (Exception e) {
            System.out.println("createExamOnActionButton: ");
            System.out.println("Error: " + e.getMessage());;
        }
    }

    @javafx.fxml.FXML
    public void seatingPlanOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/seatingPlan.fxml");

    }

    @javafx.fxml.FXML
    public void resitRequestsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/resitRequest.fxml");
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/examOfficerDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void certificatesOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/certificates.fxml");
    }

    @javafx.fxml.FXML
    public void questionBankOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/questionBank.fxml");
    }

    @javafx.fxml.FXML
    public void markingOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/marking.fxml");
    }

    @javafx.fxml.FXML
    public void eligibilityOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/eligibility.fxml");
    }

    @javafx.fxml.FXML
    public void misconductOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/misconduct.fxml");
    }
}