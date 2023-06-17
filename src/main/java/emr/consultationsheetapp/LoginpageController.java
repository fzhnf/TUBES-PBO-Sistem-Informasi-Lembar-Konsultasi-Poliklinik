package emr.consultationsheetapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginpageController {
    @FXML
    private Label loginMessageLabel;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private TextField usernameInput;


    @FXML
    void login(ActionEvent event) throws IOException {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        UserDAO user = new UserDAO(username, password);
        int userId = user.getUserId();
        if (userId == -1) {
            loginMessageLabel.setText("Invalid Login, Please try again!");
        } else if ( userId == 0) {
            loginMessageLabel.setText("welcome to admin page");
        } else {
            loginMessageLabel.setText(String.valueOf(userId));
        }
    }
}