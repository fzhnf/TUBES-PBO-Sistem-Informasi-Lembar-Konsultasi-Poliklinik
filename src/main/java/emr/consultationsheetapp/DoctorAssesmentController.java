package emr.consultationsheetapp;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class DoctorAssesmentController implements Initializable {



    @FXML
    private Button changeSceneTindakLanjutButton;

    @FXML
    private Button changeSceneToLembarKonsultasiButton;

    @FXML
    private TableView<ConsultationSheetDAO> TabelAssesmentBaru;

    @FXML
    private TableColumn<ConsultationSheetDAO, Integer> listNomorTabelAssesmenBaru;

    @FXML
    private TableColumn<ConsultationSheetDAO, Date> listTglAssesmentTabelAssesmenBaru;

    @FXML
    private TableColumn<ConsultationSheetDAO, String> listNamaTabelAssesmenBaru;

    @FXML
    private TableColumn<ConsultationSheetDAO, Integer> listJenisKelaminTabelAssesmenBaru;

    @FXML
    private TableColumn<ConsultationSheetDAO, Date> listTglLahirTabelAssesmenBaru;

    @FXML
    private TableColumn<ConsultationSheetDAO, Void> ListActionAssesmenBaru;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConsultationSheetDAO sheet = new ConsultationSheetDAO();
        ArrayList<ConsultationSheetDAO> sheets = sheet.getAllConsultationSheet();

        ObservableList<ConsultationSheetDAO> dataSheet = FXCollections.observableArrayList(sheets);

        TabelAssesmentBaru.setItems(dataSheet);
        listNomorTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        listTglAssesmentTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        listNamaTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientBirthdate"));
        listJenisKelaminTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("clinic"));
        listTglLahirTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientGender"));

    }
}
