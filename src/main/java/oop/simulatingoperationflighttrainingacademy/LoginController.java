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

        Boolean validation = loginValidation(username, password, role);
        if(validation){
            if(role.equals("Student Pilot")){
                commonMethods.sceneChange(actionEvent, "studentPilotDashBoard.fxml");
            }else if(role.equals("Medical Specialist")){
                commonMethods.sceneChange(actionEvent, "medicalSpecialistDashboard.fxml");
            }else if(role.equals("Examination Officer")){
                commonMethods.sceneChange(actionEvent, "examinationOfficer.fxml");
            }else if(role.equals("Financial Officer")){
                commonMethods.sceneChange(actionEvent, "FinancialOfficerDashboard.fxml");
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
            File file = new File("data");
            Scanner scan = new Scanner("user.txt");

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.isEmpty()) continue;

                String[] tokens = line.split("\\|");
                String userId = tokens[0];
                String userName = tokens[1];
                String userEmail = tokens[2];
                String userRole = tokens[3];
                String userPassword = tokens[4];

                if ((userId.equals(username) || userEmail.equals(username))&&
                        userPassword.equals(password) &&
                        userRole.equals(role)) {
                    scan.close();
                    commonMethods.showConfirmation("Welcome" +userName,
                            "User successfully logged in." +
                                    "\n"+ "Role: "+ userRole);
                    return true;
                }else {
                    commonMethods.showError("Wrong Login Information", "User ID or password is incorrect.");
                    return false;
                }
            }

            scan.close();
        }
        catch (Exception e) {
            System.out.println("Login file read error: " + e.getMessage());
        }

        return false;
    }

}