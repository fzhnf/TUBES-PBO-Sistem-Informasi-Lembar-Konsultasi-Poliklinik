package emr.consultationsheetapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import emr.consultationsheetapp.UserAdminModel;
import emr.consultationsheetapp.UserDoctorModel;
import emr.consultationsheetapp.UserModel;

public class LoginpageController {

    @FXML
    private Label Username;

    @FXML
    private Button loginButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private TextField usernameInput;


    @FXML
    void login(ActionEvent event) {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        UserModel user = new UserModel(username, password);
        boolean authentication = user.validateLogin();
        if (authentication) {
            if (user.getUsername().equals("faiz")) {
                loginMessageLabel.setText("welcome to admin page");
            } else  {
                loginMessageLabel.setText("welcome to doctor page");
            }
        }
    }
}