package emr.consultationsheetapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewUserDoctorController implements Initializable {

    @FXML
    private Button AddNewUserButton;

    @FXML
    private TextField InputTextName;

    @FXML
    private TextField InputTextPassword;


    @FXML
    private ComboBox<String> clinicDropdownOption;

    @FXML
    void AddNewUser(ActionEvent event) throws IOException {
        boolean validateEmpty = (InputTextPassword.getText().isBlank() || InputTextName.getText().isBlank() || clinicDropdownOption.getValue() == null);
        if (validateEmpty) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR INPUT");
            alert.setContentText("Please input doctor data");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SUCCES!!");
            alert.setContentText("Doctor data was succesfully added to database");
            alert.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> List = FXCollections.observableArrayList("Klinik Anak", "Klinik Gigi", "Klinik Jantung");
        clinicDropdownOption.setItems(List);
    }
}



