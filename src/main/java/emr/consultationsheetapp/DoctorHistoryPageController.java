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
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Date;

public class DoctorHistoryPageController {


    @FXML
    private Button changeSceneTindakLanjut;

    @FXML
    private Button changeSceneTindakLanjutButton;

    @FXML
    private TableView<ConsultationSheetDAO> TabelAssesmentLama;

    @FXML
    private TableColumn<ConsultationSheetDAO, Integer> listNomorTabelAssesmenLama;

    @FXML
    private TableColumn<ConsultationSheetDAO, Date> listTglAssesmentTabelAssesmenLama;

    @FXML
    private TableColumn<ConsultationSheetDAO, String> listNamaTabelAssesmenLama;

    @FXML
    private TableColumn<ConsultationSheetDAO, Integer> listJenisKelaminTabelAssesmenLama;

    @FXML
    private TableColumn<ConsultationSheetDAO, Date> listTglLahirTabelAssesmenLama;

    @FXML
    private TableColumn<ConsultationSheetDAO, Void> ListActionAssesmenLama;

    @FXML
    private Button logoutButton;

    @FXML
    void changeSceneTindakLanjut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("doctorasesmentpage-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) changeSceneTindakLanjutButton.getScene().getWindow();
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

    @FXML
    void changeSceneToLembarKonsultasi(ActionEvent event) throws IOException  {

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
