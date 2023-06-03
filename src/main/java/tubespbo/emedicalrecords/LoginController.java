package tubespbo.emedicalrecords;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginController extends DButil {
    @FXML
    public Button submitButton;

    @FXML
    public Label loginMessageLabel;

    @FXML
    public TextField name;

    @FXML
    public PasswordField password;

    public void loginButtonOnAction(ActionEvent event) {
        if (name.getText().isBlank() == false && password.getText().isBlank() == false) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }
    public void validateLogin() {
        DButil connectNow = new DButil();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT * FROM user_account WHERE username = '" + name.getText() + "' AND password ='" + password.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            if (queryResult.next()) {
                FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("homepage-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 750, 400);
                Stage stage = (Stage) submitButton.getScene().getWindow(); // Assuming the submitButton is part of the current stagestage.setTitle("e-MedicalRecords");
                stage.setTitle("e-MedicalRecords");
                stage.setScene(scene);

            } else {
                loginMessageLabel.setText("Invalid Login, Please try again!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }
}