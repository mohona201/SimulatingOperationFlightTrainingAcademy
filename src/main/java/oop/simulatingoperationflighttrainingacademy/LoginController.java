package oop.simulatingoperationflighttrainingacademy;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.util.Scanner;

public class LoginController
{
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private Button loginButton;
    @javafx.fxml.FXML
    private ComboBox<String> roleComboBox;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label loginStatusLabel;
    @javafx.fxml.FXML
    private TextField usernameTextField;
    @javafx.fxml.FXML
    private Button signUp;

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

        if(username.isEmpty() || password.isEmpty() || role.isEmpty()){
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        boolean validation = loginValidation(username, password, role);
        if(validation){
            if(role.equals("Student Pilot")){
                commonMethods.sceneChange(actionEvent, "Madhu/User_1/studentPilotDashBoard.fxml");
            }else if(role.equals("Medical Specialist")){
                commonMethods.sceneChange(actionEvent, "Madhu/User_2/medicalSpecialistDashboard.fxml");
            }else if(role.equals("Examination Officer")){
                commonMethods.sceneChange(actionEvent, "Sabbir/User_3/examOfficerDashboard.fxml");
            }else if(role.equals("Financial Officer")){
                commonMethods.sceneChange(actionEvent, "Sabbir/User_4/FinancialOfficerDashboard.fxml");
            }else if(role.equals("Flight Instructor")){
                commonMethods.sceneChange(actionEvent, "flightInstructorDashboard.fxml");
            }else if(role.equals("Air Traffic Controller")){
                commonMethods.sceneChange(actionEvent, "airTrafficController.fxml");
            }else System.out.println("Scene switch error \n" + role);;
        }



    }

    @javafx.fxml.FXML
    public void clearOnActionButton(ActionEvent actionEvent) {
        usernameTextField.clear();
        passwordField.clear();
        roleComboBox.setValue(null);
    }

    @javafx.fxml.FXML
    public void signUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "signup.fxml");
    }

    public static boolean loginValidation(String username, String password, String role) {
        try {
            File file = new File("data/user.txt");

            Scanner scan = new Scanner(file);
            boolean validation = false;

            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] tokens = line.split("\\|");
                if (tokens.length < 5) continue;

                String userId = tokens[0].trim();
                String userName = tokens[1].trim();
                String userEmail = tokens[2].trim();
                String userRole = tokens[3].trim();
                String userPassword = tokens[4].trim();

                if ((userId.equals(username) || userEmail.equals(username)) &&
                        userPassword.equals(password) &&
                        userRole.equals(role)) {

                    validation = true;
                    commonMethods.showConfirmation(
                            "Welcome " + userName,
                            "User successfully logged in.\nRole: " + userRole
                    );
                    break;
                }
            }

            scan.close();

            if (!validation) {
                commonMethods.showError(
                        "Wrong Login Information",
                        "User ID / Email, password or role is incorrect."
                );
            }

            return validation;
        } catch (Exception e) {
            System.out.println("Login file read error: " + e.getMessage());
            commonMethods.showError("Login Error", "An error occurred during login.");
            return false;
        }
    }

}