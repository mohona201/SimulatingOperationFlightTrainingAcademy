package oop.simulatingoperationflighttrainingacademy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        saveUserTextFile(username, fullName, email, role, password);

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
    public String randomID() {
        Random random = new Random();
        StringBuilder randomID = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            randomID.append(random.nextInt(10));
        }
        return String.valueOf(randomID);
    }

    private void saveUserTextFile(String username, String email, String fullName, String role, String password) {
        try {
            File folder = new File("data");
            if (!folder.exists()) folder.mkdirs();
            System.out.println("Folder has been created");

            File file = new File(folder, "user.txt");
            if (!file.exists()) file.createNewFile();
            System.out.println("File has been created");

            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(username + " | " + fullName + " | " + email + " | " + role + " | " + password + "\n");
                System.out.println("Data has been saved");
            }

        } catch (IOException e) {
            System.out.println("Error saving user text file");
        }
    }

    @javafx.fxml.FXML
    public void LogInOnActionButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(FlightAcademyStimulator.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Flight Academy");
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
        }
        catch (Exception e){
            System.out.println("Error login fxml: " + e.getMessage());
        }
    }
}
