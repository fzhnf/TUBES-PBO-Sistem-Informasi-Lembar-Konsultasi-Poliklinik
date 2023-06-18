package emr.consultationsheetapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewAssesmentWindowController implements Initializable {

    @FXML
    private Button AddNewAssesmentButton;

    @FXML
    private TextField InputTextName;

    @FXML
    private DatePicker InputBirthDate;

    @FXML
    private RadioButton priaSelected, wanitaSelected;



    @FXML
    private ComboBox<String> clinicDropdownOption;

    public static void closeWindow(Stage stage) {
        stage.close();
    }

    @FXML
    void clinicDropdown(ActionEvent event) {
//        String clinicOption = clinicDropdownOption.getSelectionModel().getSelectedItem().toString();
//        label.setText
    }

    @FXML
    void AddNewAssesment(ActionEvent event) throws IOException {
        boolean validateEmpty = (InputTextName.getText().isBlank() || InputBirthDate.getValue() == null || !(priaSelected.isSelected() || wanitaSelected.isSelected()) || clinicDropdownOption.getValue() == null);
        if (validateEmpty) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data nya mana Dekk!!");
            alert.setContentText("Kata nya mau dirawat, kok data ny ga lengkap, kamu pikir rumah sakit ga perlu data? PERLU DEK!!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data nya mana Dekk!!");
            alert.setContentText("Kata nya mau dirawat, kok data ny ga lengkap, kamu pikir rumah sakit ga perlu data? PERLU DEK!!");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> List = FXCollections.observableArrayList("Klinik Anak", "Klinik Gigi", "Klinik Jantung");
        clinicDropdownOption.setItems(List);
    }
}
