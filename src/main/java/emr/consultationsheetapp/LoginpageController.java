package emr.consultationsheetapp;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LoginpageController {
    @FXML
    private Button loginButton;
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
            openAdminPage();
        } else {
            openDoctorPage(user.getClinic());
        }
    }

    private void openAdminPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminpatientpage-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) loginButton.getScene().getWindow();

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), stage.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        ParallelTransition transition = new ParallelTransition(fadeOut, fadeIn);
        transition.setOnFinished(e -> {
            stage.setScene(scene);
            stage.setTitle("AdminPatient e-ConsultationSheet");
        });
        transition.play();
    }

    private void openDoctorPage(int clinic) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("doctorasesmentpage-view.fxml"));
        Parent root = loader.load();
        DoctorAssesmentController doctorAssesmentController = loader.getController();
        doctorAssesmentController.receiveClinic(clinic);
        Scene scene = new Scene(root);
        Stage stage = (Stage) loginButton.getScene().getWindow();
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), stage.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        ParallelTransition transition = new ParallelTransition(fadeOut, fadeIn);
        transition.setOnFinished(e -> {
            stage.setScene(scene);
            stage.setTitle("Assesment e-ConsultationSheet");
        });
        transition.play();
    }
}