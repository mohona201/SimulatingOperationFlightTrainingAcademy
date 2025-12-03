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
    private Label signUpStatusLabel;

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
        String userId = userIdTextField.getText();
        String email = emailTextField.getText();
        String fullName = fullNameTextField.getText();
        String role = roleComboBox.getValue();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String id = userIdTextField.getText();


        if (userId.isEmpty() || email.isEmpty() || fullName.isEmpty()
                || role == null || role.isEmpty()
                || password.isEmpty() || confirmPassword.isEmpty()) {

            commonMethods.showError("Information Missing",
                    "Please fill in all fields.");
            return;
        }
        if (!emailTextField.getText().contains("@")){
            commonMethods.showError("Invalid Email", "Please enter a valid email.");
            return;
        }
        if (!password.equals(confirmPassword)) {
            commonMethods.showError("Password Mismatch",
                    "Password and Confirm Password do not match.");
            return;
        }

        commonMethods.saveToBinFile(
                "user.bin",
                userId + " | " + fullName + " | " + email + " | " + role + " | " + password
        );


        commonMethods.showConfirmation("Success","User registered successfully!" +
                "\nPress login and enter your username and a password.");

        clearOnActionButton(actionEvent);


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
    private String randomID() {
        Random random = new Random();
        StringBuilder randomID = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            randomID.append(random.nextInt(10));
        }
        return String.valueOf(randomID);
    }

    @javafx.fxml.FXML
    public void LogInOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "Login.fxml");
    }
}
