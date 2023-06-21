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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import static emr.consultationsheetapp.App.transition;

public class DoctorAssesmentController implements Initializable {
    int patientId;
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
        DoctorHistoryPageController doctorHistoryPageController = loader.getController();
        doctorHistoryPageController.receiveClinic(clinic);
        doctorHistoryPageController.showTableItems();
        Scene scene = new Scene(root);
        Stage stage = (Stage) changeSceneToLembarKonsultasiButton.getScene().getWindow();
        stage.setResizable(false);
        transition(root, scene, stage, "History e-ConsultationSheet");
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
    public void receiveClinic(int clinic) {
        this.clinic = clinic;
        dataPatient.removeIf(patient -> patient.getClinic() != clinic);
    }



    void showTableItems() {
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
                    int patientId = selectedPatient.getPatientId();
                    try {
                        changeScenetoSheetEditor(patientId);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            private void changeScenetoSheetEditor(int patientId) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("consultationsheet-view.fxml"));
                Parent root = loader.load();
                ConsultationSheetController consultationSheetController = loader.getController();
                consultationSheetController.receiveId(patientId);
                Scene scene = new Scene(root);
                Stage stage = (Stage) editButton.getScene().getWindow();
                stage.setResizable(false);
                transition(root, scene, stage, "Consultation Sheet");
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
