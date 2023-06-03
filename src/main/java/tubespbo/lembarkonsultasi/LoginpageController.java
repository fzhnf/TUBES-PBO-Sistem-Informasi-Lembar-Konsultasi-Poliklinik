package tubespbo.lembarkonsultasi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginpageController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Username"
    private Label Username; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader

    @FXML // fx:id="loginMessageLabel"
    private Label loginMessageLabel; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader

    @FXML // fx:id="username"
    private TextField username; // Value injected by FXMLLoader

    @FXML
    void loginButtonOnAction(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Username != null : "fx:id=\"Username\" was not injected: check your FXML file 'loginpage-view.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'loginpage-view.fxml'.";
        assert loginMessageLabel != null : "fx:id=\"loginMessageLabel\" was not injected: check your FXML file 'loginpage-view.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'loginpage-view.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'loginpage-view.fxml'.";

    }

}