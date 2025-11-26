package oop.simulatingoperationflighttrainingacademy;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class LoginController
{
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private Button loginButton;
    @javafx.fxml.FXML
    private ComboBox<String> roleComboBox;
    @javafx.fxml.FXML
    private Hyperlink forgotPasswordLink;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label loginStatusLabel;
    @javafx.fxml.FXML
    private TextField usernameTextField;
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


    }

    @javafx.fxml.FXML
    public void loginOnActionButton(ActionEvent actionEvent) {
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        String role = roleComboBox.getValue();

    }

    @javafx.fxml.FXML
    public void clearOnActionButton(ActionEvent actionEvent) {
        usernameTextField.clear();
        passwordField.clear();
        roleComboBox.setValue(null);
    }
}