package emr.consultationsheetapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AdminDoctorpageController {

    @FXML
    private TableColumn<?, ?> ListActionAssesmen;

    @FXML
    private Button addDoctorButton;

    @FXML
    private Button changeScenetoAddNewPatientButton;

    @FXML
    private Button changeScenetoAdministrasiDokterButton;

    @FXML
    private TableColumn<?, ?> listKlinik;

    @FXML
    private TableColumn<?, ?> listNomorTabelAssesmen;

    @FXML
    private TableColumn<?, ?> listTglAssesmenTabelAssesmen;

    @FXML
    private Button logoutButton;

    @FXML
    private Button refreshButton;


    @FXML
    void refresh(ActionEvent event) {

    }

    @FXML
    void addDoctor(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("newuserdoctor-window.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("e-ConsultationSheet");
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    @FXML
    void changeScenetoAddNewPatient(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminpatientpage-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) changeScenetoAddNewPatientButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("e-ConsultationSheet");
    }

    //@FXML
    //void changeScenetoAdministrasiDokter(ActionEvent event) {

    //}

    @FXML
    void logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginpage-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("e-ConsultationSheet");
    }

}
