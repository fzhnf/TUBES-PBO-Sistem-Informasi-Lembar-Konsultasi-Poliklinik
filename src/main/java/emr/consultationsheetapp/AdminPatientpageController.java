package emr.consultationsheetapp;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class AdminPatientpageController {


    @FXML
    private Button changeScenetoAddNewPatientButton;

    @FXML
    private Button changeScenetoAdministrasiDokterButton;

    @FXML
    private TableColumn<?, ?> listNomorTabelAssesmen;

    @FXML
    private TableColumn<?, ?> listTglAssesmenTabelAssesmen;

    @FXML
    private TableColumn<?, ?> listKlinik;

    @FXML
    private TableColumn<?, ?> listBooleanSelesai;

    @FXML
    private TableColumn<?, ?> ListActionAssesmen;





    @FXML
    private Button logoutButton;

    @FXML
    public void refresh(ActionEvent event) {

    }

    @FXML
    public void addPatient(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("newassesment-window.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("e-ConsultationSheet");
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }


//    @FXML
//    void changeScenetoAddNewPatient(ActionEvent event) throws IOException {
//
//    }

    @FXML
    void changeScenetoAdministrasiDokter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admindoctorpage-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) changeScenetoAdministrasiDokterButton.getScene().getWindow();
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), stage.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        ParallelTransition transition = new ParallelTransition(fadeOut, fadeIn);
        transition.setOnFinished(e -> {
            stage.setScene(scene);
            stage.setTitle("e-ConsultationSheet");
        });
        transition.play();
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginpage-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), stage.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        ParallelTransition transition = new ParallelTransition(fadeOut, fadeIn);
        transition.setOnFinished(e -> {
            stage.setScene(scene);
            stage.setTitle("e-ConsultationSheet");
        });
        transition.play();
    }

    public void clinicDropdown(ActionEvent event) {
    }
}
