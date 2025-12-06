package oop.simulatingoperationflighttrainingacademy.Sabbir.User_4;

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

public class feeStructureController {

    @FXML
    private ComboBox<String> feeProgramEditComboBox;
    @FXML
    private TableColumn<feeStructure, Double> feeAmountColumn;
    @FXML
    private ComboBox<String> feeCurrencyComboBox;
    @FXML
    private TableColumn<feeStructure, String> feeNameColumn;
    @FXML
    private TextField feesLastUpdatedTextField;
    @FXML
    private TextField feeSearchTextField;
    @FXML
    private TextField feeIdTextField;
    @FXML
    private TableView<feeStructure> feePlansTableView;
    @FXML
    private TableColumn<feeStructure, String> feeEffectiveFromColumn;
    @FXML
    private TableColumn<feeStructure, String> feeEffectiveToColumn;
    @FXML
    private DatePicker feeEffectiveToDatePicker;
    @FXML
    private Label feeFormStatusLabel;
    @FXML
    private TableColumn<feeStructure, String> feeIdColumn;
    @FXML
    private Button applyFeeFilterButton;
    @FXML
    private TextArea feeRemarksTextArea;
    @FXML
    private DatePicker feeEffectiveFromDatePicker;
    @FXML
    private ComboBox<String> feeProgramComboBox;
    @FXML
    private Button saveFeeButton;
    @FXML
    private ComboBox<String> feeCategoryComboBox;
    @FXML
    private ComboBox<String> feeTypeFilterComboBox;
    @FXML
    private TextField feeNameTextField;
    @FXML
    private Button clearFeeFormButton;
    @FXML
    private TableColumn<feeStructure, String> feeCategoryColumn;
    @FXML
    private Label notificationLabel;
    @FXML
    private TextField activeFeePlansTextField;
    @FXML
    private TableColumn<feeStructure, String> feeCurrencyColumn;
    @FXML
    private TextField feeAmountTextField;
    @FXML
    private TableColumn<feeStructure, String> feeProgramColumn;

    private ArrayList<feeStructure> feeBuffer;

    @FXML
    public void initialize() {
        feeBuffer = new ArrayList<>();

        feeProgramComboBox.getItems().setAll(
                "Private Pilot License (PPL)",
                "Commercial Pilot License (CPL)",
                "Instrument Rating (IR)",
                "Flight Instructor Course (FIC)"
        );
        feeProgramEditComboBox.getItems().setAll(
                "Private Pilot License (PPL)",
                "Commercial Pilot License (CPL)",
                "Instrument Rating (IR)",
                "Flight Instructor Course (FIC)"
        );

        feeCategoryComboBox.getItems().setAll(
                "Tuition",
                "Exam Fee",
                "Simulator",
                "Medical"
        );

        feeCurrencyComboBox.getItems().setAll(
                "BDT",
                "USD"
        );

        feeTypeFilterComboBox.getItems().setAll(
                "All",
                "Tuition",
                "Exam Fee",
                "Simulator",
                "Medical"
        );
        feeTypeFilterComboBox.setValue("All");

        feeEffectiveFromDatePicker.setValue(LocalDate.now());

        feeIdColumn.setCellValueFactory(new PropertyValueFactory<feeStructure, String>("feeId"));
        feeNameColumn.setCellValueFactory(new PropertyValueFactory<feeStructure, String>("feeName"));
        feeProgramColumn.setCellValueFactory(new PropertyValueFactory<feeStructure, String>("program"));
        feeCategoryColumn.setCellValueFactory(new PropertyValueFactory<feeStructure, String>("category"));
        feeCurrencyColumn.setCellValueFactory(new PropertyValueFactory<feeStructure, String>("currency"));
        feeAmountColumn.setCellValueFactory(new PropertyValueFactory<feeStructure, Double>("amount"));
        feeEffectiveFromColumn.setCellValueFactory(new PropertyValueFactory<feeStructure, String>("effectiveFrom"));
        feeEffectiveToColumn.setCellValueFactory(new PropertyValueFactory<feeStructure, String>("effectiveTo"));

        commonMethods.showTableDataFromBinFile("feeStructure.bin", feePlansTableView);
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
    public void saveFeeOnActionButton(ActionEvent actionEvent) {
        String feeId = this.feeIdTextField.getText();
        String feeName = this.feeNameTextField.getText();
        String program =  this.feeProgramComboBox.getValue();
        String category =  this.feeCategoryComboBox.getValue();
        String currency =  this.feeCurrencyComboBox.getValue();
        String amountText = this.feeAmountTextField.getText();
        String remarks = this.feeRemarksTextArea.getText();
        LocalDate effectiveToDate = this.feeEffectiveToDatePicker.getValue();

        String effectiveFrom = LocalDate.now().toString();

        String effectiveTo;
        if (effectiveToDate == null) {
            effectiveTo = "";
        } else {
            effectiveTo = effectiveToDate.toString();
        }

        if (feeId.isEmpty() || feeName.isEmpty() || program.isEmpty() || category.isEmpty() || currency.isEmpty() ||
                amountText.isEmpty()) {

            commonMethods.showError("Empty Fields",
                    "Please fill Fee ID, Name, Program, Category, Currency and Amount.");
            return;
        }

        if (!currency.equals("BDT") && !currency.equals("USD")) {
            commonMethods.showError("Currency",
                    "Select either BDT or USD.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            commonMethods.showError("Invalid Amount",
                    "Fee amount must be a number.");
            return;
        }

        ArrayList<feeStructure> existing = loadAllFeesFromFile();

        for (feeStructure f : existing) {
            boolean sameId = f.getFeeId().equalsIgnoreCase(feeId);
            boolean sameEverything =
                    f.getFeeName().equalsIgnoreCase(feeName) &&
                            f.getProgram().equals(program) &&
                            f.getCategory().equals(category) &&
                            f.getCurrency().equals(currency) &&
                            f.getAmount() == amount &&
                            f.getEffectiveFrom().equals(effectiveFrom) &&
                            f.getEffectiveTo().equals(effectiveTo);

            if (sameId || sameEverything) {
                commonMethods.showError("Duplicate Fee",
                        "A similar fee structure or fee ID already exists.");
                return;
            }
        }

        feeStructure newFee = new feeStructure(
                feeId,
                feeName,
                program,
                category,
                currency,
                amount,
                effectiveFrom,
                effectiveTo,
                remarks
        );

        feeBuffer = new ArrayList<>();
        feeBuffer.add(newFee);
        commonMethods.saveToBinFile("feeStructure.bin", feeBuffer);

        feePlansTableView.getItems().add(newFee);
        feeFormStatusLabel.setText("Fee saved for program: " + program);
        notificationLabel.setText("Fee saved to feeStructure.bin");

    }


    @FXML
    public void clearFeeFormOnActionButton(ActionEvent actionEvent) {
        feeIdTextField.clear();
        feeNameTextField.clear();
        feeProgramComboBox.setValue(null);
        feeCategoryComboBox.setValue(null);
        feeCurrencyComboBox.setValue(null);
        feeAmountTextField.clear();
        feeRemarksTextArea.clear();
        feeEffectiveToDatePicker.setValue(null);
        feeEffectiveFromDatePicker.setValue(LocalDate.now());
        feeFormStatusLabel.setText("");
        notificationLabel.setText("Fee form cleared.");
    }



    @FXML
    public void applyFeeFilterOnActionButton(ActionEvent actionEvent) {
        String programFilter =  this.feeProgramComboBox.getValue();
        String typeFilter =  this.feeTypeFilterComboBox.getValue();
        String searchText = this.feeSearchTextField.getText().toLowerCase();

        ArrayList<feeStructure> all = loadAllFeesFromFile();
        ArrayList<feeStructure> filtered = new ArrayList<>();

        for (feeStructure f : all) {
            boolean match = true;

            if (programFilter != null && !programFilter.isEmpty()) {
                if (!f.getProgram().equals(programFilter)) {
                    match = false;
                }
            }

            if (typeFilter != null && !typeFilter.equals("All") && !typeFilter.isEmpty()) {
                if (!f.getCategory().equalsIgnoreCase(typeFilter)) {
                    match = false;
                }
            }

            if (!searchText.isEmpty()) {
                boolean textMatch =
                        f.getFeeId().toLowerCase().contains(searchText) ||
                                f.getFeeName().toLowerCase().contains(searchText) ||
                                f.getProgram().toLowerCase().contains(searchText);
                if (!textMatch) {
                    match = false;
                }
            }

            if (match) {
                filtered.add(f);
            }
        }

        feePlansTableView.getItems().clear();
        feePlansTableView.getItems().addAll(filtered);

        notificationLabel.setText("Fee filter applied (" + filtered.size() + " record(s)).");
    }

    private ArrayList<feeStructure> loadAllFeesFromFile() {
        ArrayList<feeStructure> list = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            File file = new File("data/feeStructure.bin");
            if (!file.exists()) {
                return list;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    feeStructure f = (feeStructure) ois.readObject();
                    list.add(f);
                } catch (EOFException eof) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error loading feeStructure.bin: " + e.getMessage());
        }

        return list;
    }

}
