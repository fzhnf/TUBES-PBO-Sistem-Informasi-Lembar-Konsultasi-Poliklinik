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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminPatientpageController implements Initializable {

    @FXML
    private Button addPatientButton;

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
    private TableColumn<PatientDAO, Integer> listGender;

    @FXML
    private TableColumn<PatientDAO, Void> ListActionAssesmen;


    @FXML
    private Button logoutButton;


    @FXML
    private Button refreshButton;


    @FXML
    public void refresh(ActionEvent event) {
        PatientDAO patientDAO = new PatientDAO();
        ArrayList<PatientDAO> patients;
        patients = patientDAO.getAllPatients();

        ObservableList<PatientDAO> dataPatient = FXCollections.observableArrayList(patients);

        patientTable.setItems(dataPatient);
    }

    @FXML
    public void addPatient(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("newassesment-window.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Patient");
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

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
            stage.setTitle("AdminDoctor e-ConsultationSheet");
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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PatientDAO patient = new PatientDAO();
        ArrayList<PatientDAO> patients = patient.getAllPatients();

        ObservableList<PatientDAO> dataPatient = FXCollections.observableArrayList(patients);

        patientTable.setItems(dataPatient);
        listNomorTabelAssesmen.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        listNamaPasien.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        listTglLahir.setCellValueFactory(new PropertyValueFactory<>("patientBirthdate"));
        listKlinik.setCellValueFactory(new PropertyValueFactory<>("clinic"));
        listGender.setCellValueFactory(new PropertyValueFactory<>("patientGender"));


        ListActionAssesmen.setCellFactory(param -> new TableCell<>() {
            private final Button editButton = new Button("Edit");
            private final Button deleteButton = new Button("Delete");

            {
                editButton.setOnAction(event -> {
                    PatientDAO selectedPatient = getTableView().getItems().get(getIndex());

//                    try {
                        // Membuka halaman edit pasien dengan mengirim data pasien yang dipilih
//                        FXMLLoader loader = new FXMLLoader(getClass().getResource("newassesmentwindow-window.fxml"));
//                        Parent root = loader.load();
//                        NewAssesmentWindowController controller = loader.getController();
//                        controller.save(selectedPatient);
//                        Scene scene = new Scene(root);
//                        Stage stage = new Stage();
//                        stage.setScene(scene);
//                        stage.setTitle("Edit Patient");
//                        stage.initStyle(StageStyle.UTILITY);
//                        stage.showAndWait();

                        // Setelah dialog edit ditutup, perbarui tabel dengan data yang sudah diubah
                        refresh(null);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                });

                deleteButton.setOnAction(event -> {
                    PatientDAO patient = getTableView().getItems().get(getIndex());
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure you want to delete this data?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        patient.deletePatient();

                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(new HBox(editButton, deleteButton));
                }
            }
        });
    }
}
