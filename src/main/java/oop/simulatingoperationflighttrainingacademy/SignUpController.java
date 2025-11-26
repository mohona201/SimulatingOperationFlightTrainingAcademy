package oop.simulatingoperationflighttrainingacademy;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.Random;

public class SignUpController
{
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TextField userIdTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField fullNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> roleComboBox;
    @javafx.fxml.FXML
    private Button signUpButton;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private PasswordField confirmPasswordField;

    @javafx.fxml.FXML
    public void initialize() {
        roleComboBox.getItems().setAll(
                "Student Pilot",
                "Medical Specialist",
                "Examination Officer",
                "Financial Officer",
                "Flight Instructor",
                "Air Traffic Controller"
        );


        userIdTextField.setText(String.valueOf(randomID()));
        userIdTextField.setEditable(false);

    }

    @javafx.fxml.FXML
    public void signUpOnActionButton(ActionEvent actionEvent) {
        String username = userIdTextField.getText();
        String email = emailTextField.getText();
        String fullName = fullNameTextField.getText();
        String role = roleComboBox.getValue();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String id = userIdTextField.getText();


        if (username.isEmpty() || email.isEmpty() || fullName.isEmpty()
                || role == null || role.isEmpty()
                || password.isEmpty() || confirmPassword.isEmpty()) {

            showAlert(Alert.AlertType.ERROR, "Information Missing",
                    "Please fill in all fields.");
            return;
        }
        if (!emailTextField.getText().contains("@")){
            showAlert(Alert.AlertType.ERROR, "Invalid Email", "Please enter a valid email.");
            return;
        }
        if (!password.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Password Mismatch",
                    "Password and Confirm Password do not match.");
            return;
        }
    }
    @javafx.fxml.FXML
    public void clearOnActionButton(ActionEvent actionEvent) {
        userIdTextField.clear();
        emailTextField.clear();
        fullNameTextField.clear();
        passwordField.clear();
        confirmPasswordField.clear();
        roleComboBox.setValue(null);

        userIdTextField.setText(randomID());


    }
    public String randomID() {
        Random random = new Random();
        StringBuilder randomID = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            randomID.append(random.nextInt(10));
        }
        return String.valueOf(randomID);
    }
    private void showAlert(Alert.AlertType alertType,String titleMessage, String errorMessage) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titleMessage);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}
