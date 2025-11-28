package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class vaccinationController {
    @javafx.fxml.FXML
    private Label notificationLabel;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, String> administeredByTableColumn;
    @javafx.fxml.FXML
    private TextField vaccineNameTextField;
    @javafx.fxml.FXML
    private DatePicker vaccineDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, LocalDate> vaccinationDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, String> notesTableColumn;
    @javafx.fxml.FXML
    private TableView<Vaccination> vaccinationHistoryTableView;
    @javafx.fxml.FXML
    private TextField studentNameTextField;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, String> vaccineNameTableColumn;
    @javafx.fxml.FXML
    private TextField studentIdTextField;
    @javafx.fxml.FXML
    private Label saveStatusLabel;

    @javafx.fxml.FXML
    public void initialize() {
        vaccinationDateTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination, LocalDate>("vaccinationDate"));
        notesTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination, String>("note"));
        vaccineNameTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination, String>("vacName"));
        administeredByTableColumn.setCellValueFactory(new PropertyValueFactory<Vaccination, String>("administer"));
    }


    @javafx.fxml.FXML
    public void vaccinationsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void renewalsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void suspensionsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void incidentsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void preFlightOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reportsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void regularPatientsOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveVaccineOnActionButton(ActionEvent actionEvent) {
        String name = studentNameTextField.getText();
        String vacName = vaccineNameTextField.getText();
        LocalDate date = vaccineDatePicker.getValue();

        if (studentIdTextField.getText().isEmpty()) {
            saveStatusLabel.setText("Please fill all fields.");
            showError("Missing Fields: All fields must be filled.");
            return;
        }

        int studentId = Integer.parseInt(studentIdTextField.getText());

        if (name.isEmpty() || vacName.isEmpty() || date == null) {
            saveStatusLabel.setText("Please fill all fields.");
            showError("Missing Fields: All fields must be filled.");
            return;
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("vaccinationRecords.txt", true));

            bw.write(
                    name + "," +
                            vacName + "," +
                            date + "," +
                            studentId + "," +
                            ";"
            );
            bw.newLine();
            bw.close();

            vaccinationHistoryTableView.getItems().add(
                    new Vaccination(vacName, name, "Dr. Alex", date, studentId)
            );

            saveStatusLabel.setText("Vaccination saved.");
            notificationLabel.setText("New vaccination has been recorded.");

        } catch (Exception e) {
            saveStatusLabel.setText("Error while saving.");
            notificationLabel.setText("Unable to write to file.");
        }
    }


    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Input Error");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}


