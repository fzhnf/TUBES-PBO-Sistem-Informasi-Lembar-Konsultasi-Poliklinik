package emr.consultationsheetapp;

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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import static emr.consultationsheetapp.App.transition;

public class DoctorHistoryPageController implements Initializable {

    int clinic;
    ObservableList<PatientDAO> dataPatient;

    @FXML
    private Button changeSceneTindakLanjut;

    @FXML
    private Button changeSceneTindakLanjutButton;

    @FXML
    private TableView<PatientDAO> TabelAssesmentLama;

    @FXML
    private TableColumn<PatientDAO, Integer> listNomorTabelAssesmenLama;

    @FXML
    private TableColumn<PatientDAO, Date> listTglAssesmentTabelAssesmenLama;

    @FXML
    private TableColumn<PatientDAO, String> listNamaTabelAssesmenLama;

    @FXML
    private TableColumn<PatientDAO, Integer> listJenisKelaminTabelAssesmenLama;

    @FXML
    private TableColumn<PatientDAO, Date> listTglLahirTabelAssesmenLama;

    @FXML
    private TableColumn<PatientDAO, Void> listActionAssesmenLama;

    @FXML
    private Button logoutButton;

    @FXML
    void changeSceneTindakLanjut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("doctorasesmentpage-view.fxml"));
        Parent root = loader.load();
        DoctorAssesmentController doctorAssesmentController = loader.getController();
        doctorAssesmentController.receiveClinic(clinic);
        doctorAssesmentController.showTableItems();
        Scene scene = new Scene(root);
        Stage stage = (Stage) changeSceneTindakLanjutButton.getScene().getWindow();
        stage.setResizable(false);
        transition(root, scene, stage, "Assesment e-ConsultationSheet");
    }

    public void receiveClinic(int clinic) {
        this.clinic = clinic;
        dataPatient.removeIf(patient -> patient.getClinic() != clinic);
    }
    void showTableItems() {
//        TabelAssesmentBaru.setItems(dataPatient);
//        listNomorTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientId"));
//        listTglAssesmentTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
//        listNamaTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientName"));
//        listJenisKelaminTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientGender"));
//        listTglLahirTabelAssesmenBaru.setCellValueFactory(new PropertyValueFactory<>("patientBirthdate"));
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
        stage.setResizable(false);
        transition(root, scene, stage, "e-ConsultationSheet");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PatientDAO assesment = new PatientDAO();
        ArrayList<PatientDAO> assements = assesment.getAllPatients();
        this.dataPatient = FXCollections.observableArrayList(assements);
        listActionAssesmenLama.setCellFactory(param -> new TableCell<>() {
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
                    stage.setResizable(false);
                    transition(root, scene, stage, "Consultation Sheet");
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
