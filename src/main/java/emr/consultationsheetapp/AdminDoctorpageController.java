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
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminDoctorpageController implements Initializable {


    @FXML
    private Button addDoctorButton;

    @FXML
    private Button changeScenetoAddNewPatientButton;

    @FXML
    private Button changeScenetoAdministrasiDokterButton;

    @FXML
    private TableView<UserDAO> doctorTable;

    @FXML
    private TableColumn<UserDAO, Integer> listNomorTabelAssesmen;

    @FXML
    private TableColumn<UserDAO, String > listUsername;

    @FXML
    private TableColumn<UserDAO, Integer> listKlinik;

    @FXML
    private TableColumn<UserDAO, Void> ListActionAssesmen;




    @FXML
    private Button logoutButton;

    @FXML
    private Button refreshButton;


    @FXML
    void refresh(ActionEvent event) {
        UserDAO userDAO = new UserDAO();
        ArrayList<UserDAO> users;
        users = userDAO.getAllUsers();

        ObservableList<UserDAO> dataDoctor = FXCollections.observableArrayList(users);

        doctorTable.setItems(dataDoctor);
    }

    @FXML
    void addDoctor(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("newuserdoctor-window.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Doctor");
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    @FXML
    void changeScenetoAddNewPatient(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminpatientpage-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) changeScenetoAddNewPatientButton.getScene().getWindow();
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), stage.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        ParallelTransition transition = new ParallelTransition(fadeOut, fadeIn);
        transition.setOnFinished(e -> {
            stage.setScene(scene);
            stage.setTitle("AdminPatient e-ConsultationSheet");
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
        UserDAO user = new UserDAO();
        ArrayList<UserDAO> users = user.getAllUsers();

        ObservableList<UserDAO> dataDoctor = FXCollections.observableArrayList(users);

        doctorTable.setItems(dataDoctor);
        listNomorTabelAssesmen.setCellValueFactory(new PropertyValueFactory<>("userId"));
        listUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        listKlinik.setCellValueFactory(new PropertyValueFactory<>("clinic"));

        ListActionAssesmen.setCellFactory(param -> new TableCell<>() {
            private final Button editButton = new Button("Edit");
            private final Button deleteButton = new Button("Delete");

            {
                editButton.setOnAction(event -> {
                    UserDAO user = getTableView().getItems().get(getIndex());
                    // Tambahkan logika untuk melakukan edit data
                });

                deleteButton.setOnAction(event -> {
                    UserDAO user = getTableView().getItems().get(getIndex());
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure you want to delete this data?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        user.deleteUser();
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
