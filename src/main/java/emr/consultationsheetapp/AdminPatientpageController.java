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
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminPatientpageController implements Initializable {


    @FXML
    private Button changeScenetoAddNewPatientButton;

    @FXML
    private Button changeScenetoAdministrasiDokterButton;

    @FXML
    private TableView<PatientDAO> patientTable;

    @FXML
    private TableColumn<PatientDAO, Integer> listNomorTabelAssesmen;

    @FXML
    private TableColumn<PatientDAO, String> listNamaPasien;

    @FXML
    private TableColumn<PatientDAO, Date> listTglLahir;

    @FXML
    private TableColumn<PatientDAO, Integer> listKlinik;

    @FXML
    private TableColumn<PatientDAO, Boolean> listBooleanSelesai;

    @FXML
    private TableColumn<PatientDAO, Integer> listGender;

    @FXML
    private TableColumn<PatientDAO, String> ListActionAssesmen;


    @FXML
    private Button logoutButton;

    @FXML
    public void refresh(ActionEvent event) {
        PatientDAO patientDAO = new PatientDAO();
        ArrayList<PatientDAO> patients = patientDAO.getAllPatients();

        ObservableList<PatientDAO> dataPatient = FXCollections.observableArrayList(patients);

        patientTable.setItems(dataPatient);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PatientDAO patient = new PatientDAO();
        ArrayList<PatientDAO> patients = patient.getAllPatients();
        ObservableList<PatientDAO> dataPatient = FXCollections.observableArrayList(patients);

        patientTable.setItems(dataPatient);
        listNomorTabelAssesmen.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
        listNamaPasien.setCellValueFactory(new PropertyValueFactory<>("patient_name"));
        listTglLahir.setCellValueFactory(new PropertyValueFactory<>("patient_birthdate"));
        listKlinik.setCellValueFactory(new PropertyValueFactory<>("clinic"));
        listBooleanSelesai.setCellValueFactory(new PropertyValueFactory<>("diagnose"));
        listGender.setCellValueFactory(new PropertyValueFactory<>("patient_gender"));
    }
}
