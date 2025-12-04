package oop.simulatingoperationflighttrainingacademy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;

public class LoginController {

    @FXML
    private Button clearButton;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginStatusLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Button signUp;

    @FXML
    public void initialize() {
    }

    @FXML
    public void loginOnActionButton(ActionEvent actionEvent) {
        String username = usernameTextField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            commonMethods.showError("Empty Fields", "Please fill all the fields");
            return;
        }

        ObjectInputStream ois = null;
        boolean validation = false;
        SignUp matchedUser = null;

        try {
            File file = new File("data/user.bin");
            FileInputStream fis = null;

            if (file.exists()) {
                fis = new FileInputStream(file);
            } else {
                commonMethods.showError("Load Error", "Could not load: user.bin");
                return;
            }

            if (fis != null) {
                ois = new ObjectInputStream(fis);

                while (true) {
                    try {

                        SignUp user = (SignUp) ois.readObject();

                        boolean usernameMatches =
                                user.getId().equals(username) || user.getEmail().equals(username);

                        if (usernameMatches && user.getPassword().equals(password)) {
                            validation = true;
                            matchedUser = user;
                            break;
                        }

                    } catch (EOFException eof) {
                        // reached end of file → stop reading
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error while reading file: " + e.getMessage());
            commonMethods.showError("Login Error", "An error occurred during login.");
        }

        if (!validation || matchedUser == null) {
            commonMethods.showError(
                    "Wrong Login Information",
                    "User ID / Email or password is incorrect."
            );
            loginStatusLabel.setText("Login failed.");
        } else {
            String role = matchedUser.getRole();

            commonMethods.showConfirmation(
                    "Welcome " + matchedUser.getFullname(),
                    "User successfully logged in.\nRole: " + role
            );

            loginStatusLabel.setText("Logged in as: " + role);

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
    }

    @FXML
    public void clearOnActionButton(ActionEvent actionEvent) {
        usernameTextField.clear();
        passwordField.clear();
        loginStatusLabel.setText("");
    }

    @FXML
    public void signUpOnActionButton(ActionEvent actionEvent) {
        commonMethods.sceneChange(actionEvent, "signup.fxml");
    }
}
