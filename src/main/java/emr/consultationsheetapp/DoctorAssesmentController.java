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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class DoctorAssesmentController implements Initializable {
    int clinic;
    ObservableList<PatientDAO> dataPatient;

    @FXML
    private Button changeSceneToLembarKonsultasiButton;

    @FXML
    private TableView<PatientDAO> TabelAssesmentBaru;

    @FXML
    private TableColumn<PatientDAO, Integer> listNomorTabelAssesmenBaru;

    @FXML
    private TableColumn<PatientDAO, Date> listTglAssesmentTabelAssesmenBaru;

    @FXML
    private TableColumn<PatientDAO, String> listNamaTabelAssesmenBaru;

    @FXML
    private TableColumn<PatientDAO, Integer> listJenisKelaminTabelAssesmenBaru;

    @FXML
    private TableColumn<PatientDAO, Date> listTglLahirTabelAssesmenBaru;

    @FXML
    private TableColumn<PatientDAO, Void> listActionAssesmenBaru;

    @FXML
    private Button logoutButton;
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
    public void receiveClinic(int clinic) {
        this.clinic = clinic;
        dataPatient.removeIf(patient -> patient.getClinic() != clinic);
        TabelAssesmentBaru.setItems(dataPatient);
        listNomorTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        listTglAssesmentTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        listNamaTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        listJenisKelaminTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientGender"));
        listTglLahirTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientBirthdate"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PatientDAO assesment = new PatientDAO();
        ArrayList<PatientDAO> assements = assesment.getAllPatients();
        this.dataPatient = FXCollections.observableArrayList(assements);
        listActionAssesmenBaru.setCellFactory(param -> new TableCell<>() {
            private final Button editButton = new Button("Do");
            {
                editButton.setOnAction(event -> {
                    PatientDAO selectedPatient = getTableView().getItems().get(getIndex());

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("consultationsheet-view.fxml"));
                    Parent root = null;
                    try {
                        root = loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) editButton.getScene().getWindow();
                    FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), stage.getScene().getRoot());
                    fadeOut.setFromValue(1.0);
                    fadeOut.setToValue(0.0);

                    FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), root);
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);

                    ParallelTransition transition = new ParallelTransition(fadeOut, fadeIn);
                    transition.setOnFinished(e -> {
                        stage.setScene(scene);
                        stage.setTitle("Consultation Sheet");
                    });
                    transition.play();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(new HBox(editButton));
                }
            }
        });
    }
}
