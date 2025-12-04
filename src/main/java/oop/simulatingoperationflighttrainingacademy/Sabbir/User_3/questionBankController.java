package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.simulatingoperationflighttrainingacademy.commonMethods;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class questionBankController {

    @FXML
    private TableView<questionBank> questionBankTableView;
    @FXML
    private ComboBox<String> questionExamComboBox;
    @FXML
    private ComboBox<String> difficultyComboBox;
    @FXML
    private Label questionHeaderStatusLabel;
    @FXML
    private TextField optionBTextField;
    @FXML
    private TextField optionCTextField;
    @FXML
    private TableColumn<questionBank, String> questionIdColumn;
    @FXML
    private TextField questionMarksTextField;
    @FXML
    private ComboBox<String> correctOptionComboBox;
    @FXML
    private TableColumn<questionBank, String> questionExamColumn;
    @FXML
    private TableColumn<questionBank, String> questionSectionColumn;
    @FXML
    private TableColumn<questionBank, String> correctOptionColumn;
    @FXML
    private Button exportQuestionBankPdfButton;
    @FXML
    private Button saveQuestionButton;
    @FXML
    private Button clearQuestionFormButton;
    @FXML
    private TableColumn<questionBank, String> questionTextColumn;
    @FXML
    private TextField optionATextField;
    @FXML
    private TextField optionDTextField;
    @FXML
    private TableColumn<questionBank, Integer> marksColumn;
    @FXML
    private Label notificationLabel;
    @FXML
    private TextField questionsTodayTextField;
    @FXML
    private TextArea questionTextArea;
    @FXML
    private Label questionFormStatusLabel;
    @FXML
    private TableColumn<questionBank, String> difficultyColumn;
    @FXML
    private ComboBox<String> questionSectionComboBox;
    @FXML
    private Button deleteQuestionButton;
    @FXML
    private TextField questionIdTextField;
    @FXML
    private TextField totalQuestionsTextField;

    ArrayList<questionBank> questionList;

    @FXML
    public void initialize() {
        questionList = new ArrayList<>();

        questionExamComboBox.getItems().setAll(
                "Theory Exam",
                "Flight Test"
        );

        questionSectionComboBox.getItems().setAll(
                "Section A",
                "Section B",
                "Section C"
        );

        difficultyComboBox.getItems().setAll(
                "Easy",
                "Medium",
                "Hard"
        );

        correctOptionComboBox.getItems().setAll("A", "B", "C", "D");

        questionIdColumn.setCellValueFactory(new PropertyValueFactory<>("questionId"));
        questionExamColumn.setCellValueFactory(new PropertyValueFactory<>("examName"));
        questionSectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));
        questionTextColumn.setCellValueFactory(new PropertyValueFactory<>("questionText"));
        marksColumn.setCellValueFactory(new PropertyValueFactory<>("marks"));
        correctOptionColumn.setCellValueFactory(new PropertyValueFactory<>("correctOption"));
        difficultyColumn.setCellValueFactory(new PropertyValueFactory<>("difficulty"));

        commonMethods.showTableDataFromBinFile("questionBank.bin", questionBankTableView);


    }


    @FXML
    public void saveQuestionOnActionButton(ActionEvent actionEvent) {
        String questionId = questionIdTextField.getText();
        String exam = questionExamComboBox.getValue();
        String section = questionSectionComboBox.getValue();
        String difficulty = difficultyComboBox.getValue();
        String questionText = questionTextArea.getText().trim();
        String optionA = optionATextField.getText().trim();
        String optionB = optionBTextField.getText().trim();
        String optionC = optionCTextField.getText().trim();
        String optionD = optionDTextField.getText().trim();
        String correctOption = correctOptionComboBox.getValue();
        String marksText = questionMarksTextField.getText().trim();

        if (exam == null || exam.isEmpty()
                || section == null || section.isEmpty()
                || difficulty == null || difficulty.isEmpty()
                || questionText.isEmpty()
                || optionA.isEmpty() || optionB.isEmpty()
                || optionC.isEmpty() || optionD.isEmpty()
                || correctOption == null || correctOption.isEmpty()
                || marksText.isEmpty()) {

            commonMethods.showError("Empty Fields",
                    "Please fill all fields and select exam, section, difficulty and correct option.");
            return;
        }

        int marks;
        try {
            marks = Integer.parseInt(marksText);
        } catch (NumberFormatException e) {
            commonMethods.showError("Invalid Marks", "Marks must be a number.");
            return;
        }



        String today = LocalDate.now().toString();
        questionBank qb = new questionBank(
                questionId,
                exam,
                section,
                questionText,
                optionA,
                optionB,
                optionC,
                optionD,
                correctOption,
                marks,
                difficulty,
                today
        );

        questionList = new ArrayList<>();
        questionList.add(qb);
        commonMethods.saveToBinFile("questionBank.bin", questionList);

        questionBankTableView.getItems().add(qb);

        questionFormStatusLabel.setText("Question saved successfully.");
        notificationLabel.setText("Saved to questionBank.bin");

    }

    @FXML
    public void deleteQuestionOnActionButton(ActionEvent actionEvent) {
        questionBank selected = questionBankTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            commonMethods.showError("No Selection", "Please select a question to delete.");
            return;
        }

        questionBankTableView.getItems().remove(selected);
        questionFormStatusLabel.setText("Question removed from table view.");

    }

    @FXML
    public void clearQuestionFormOnActionButton(ActionEvent actionEvent) {
        questionIdTextField.clear();
        questionTextArea.clear();
        optionATextField.clear();
        optionBTextField.clear();
        optionCTextField.clear();
        optionDTextField.clear();
        questionMarksTextField.clear();
        questionFormStatusLabel.setText("Form cleared.");
    }



    @FXML
    public void seatingPlanOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/seatingPlan.fxml");
    }

    @FXML
    public void resitRequestsOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/resitRequest.fxml");
    }

    @FXML
    public void dashboardOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/examOfficerDashboard.fxml");
    }

    @FXML
    public void certificatesOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/certificates.fxml");
    }

    @FXML
    public void questionBankOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/questionBank.fxml");
    }

    @FXML
    public void markingOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/marking.fxml");
    }

    @FXML
    public void eligibilityOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/eligibility.fxml");
    }

    @FXML
    public void misconductOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Sabbir/User_3/misconduct.fxml");
    }


    @FXML
    public void exportQuestionBankPdfOnActionButton(ActionEvent actionEvent) {
        notificationLabel.setText("Question bank PDF export not implemented.");
    }

    @FXML
    public void selectExamOnActionButton(ActionEvent actionEvent) {
        String exam = questionExamComboBox.getValue();
        notificationLabel.setText("Selected Exam: " + exam);

    }


    private ArrayList<questionBank> loadAllQuestionsFromFile() {
        ArrayList<questionBank> list = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            File file = new File("data/questionBank.bin");
            if (!file.exists()) {
                return list;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    questionBank qb = (questionBank) ois.readObject();
                    list.add(qb);
                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading questionBank.bin: " + e.getMessage());
        }

        return list;
    }

}
