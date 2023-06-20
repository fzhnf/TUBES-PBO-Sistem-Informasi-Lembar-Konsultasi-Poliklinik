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
import javafx.util.Duration;

import java.io.IOException;

public class DoctorAssesmentController {

    @FXML
    private TableColumn<?, ?> ListActionAssesmenBaru;

    @FXML
    private TableColumn<?, ?> ListActionAssesmenLama;

    @FXML
    private Button changeSceneTindakLanjutButton;

    @FXML
    private Button changeSceneToLembarKonsultasiButton;

    @FXML
    private TableColumn<?, ?> listJenisKelaminTabelAssesmenBaru;

    @FXML
    private TableColumn<?, ?> listJenisKelaminTabelAssesmenLama;

    @FXML
    private TableColumn<?, ?> listNamaTabelAssesmenBaru;

    @FXML
    private TableColumn<?, ?> listNamaTabelAssesmenLama;

    @FXML
    private TableColumn<?, ?> listNomorTabelAssesmenBaru;

    @FXML
    private TableColumn<?, ?> listNomorTabelAssesmenLama;

    @FXML
    private TableColumn<?, ?> listTglAssesmentTabelAssesmenBaru;

    @FXML
    private TableColumn<?, ?> listTglAssesmentTabelAssesmenLama;

    @FXML
    private TableColumn<?, ?> listTglLahirTabelAssesmenBaru;

    @FXML
    private TableColumn<?, ?> listTglLahirTabelAssesmenLama;

    @FXML
    private Button logoutButton;

    @FXML
    void changeSceneTindakLanjut(ActionEvent event) throws IOException {

    }

    @FXML
    void changeSceneToLembarKonsultasi(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("doctorhistorypage-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) changeSceneToLembarKonsultasiButton.getScene().getWindow();
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), stage.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        ParallelTransition transition = new ParallelTransition(fadeOut, fadeIn);
        transition.setOnFinished(e -> {
            stage.setScene(scene);
            stage.setTitle("History e-ConsultationSheet");
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

}
