package tubespbo.lembarkonsultasi.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import tubespbo.lembarkonsultasi.Model.UserAdminModel;
import tubespbo.lembarkonsultasi.Model.UserDoctorModel;
import tubespbo.lembarkonsultasi.Model.UserModel;

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

    UserModel user = new UserModel();

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
//        UserModel user = new UserModel(username, password);
//        boolean authentication = user.validateLogin();
//
//        if (authentication) {
//            int clinic = user.checkClinic();
//            if (clinic == 0) {
//                UserAdminModel admin = new UserAdminModel(username);
//                loginMessageLabel.setText("welcome to admin page");
//            } else {
//                UserDoctorModel doctor = new UserDoctorModel(username, password, clinic);
//                loginMessageLabel.setText("welcome to doctor page");
//            }
//        } else {
//            loginMessageLabel.setText("Try again");
//        }
    }
}