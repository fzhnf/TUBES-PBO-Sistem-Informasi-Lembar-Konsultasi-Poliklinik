package emr.consultationsheetapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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

    @FXML
    void AddNewAssesment(ActionEvent event) throws IOException {
        boolean validateEmpty = (InputTextName.getText().isBlank() || InputBirthDate.getValue() == null || !(priaSelected.isSelected() || wanitaSelected.isSelected()) || clinicDropdownOption.getValue() == null);
        if (validateEmpty) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR INPUT");
            alert.setContentText("Please input patient data");
            alert.show();
        } else {
            String patientName = InputTextName.getText();
            LocalDate localDate = InputBirthDate.getValue();
            Date date = java.sql.Date.valueOf(localDate);
            int patientGender = priaSelected.isSelected() ? 1 : 0;
            int clinic = clinicDropdownOption.getSelectionModel().getSelectedIndex() + 1;
            PatientDAO selectedPatient = new PatientDAO(
                    patientName,
                    patientGender,
                    Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    clinic,
                    0);
            selectedPatient.addPatient(patientName, patientGender, date, clinic);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SUCCES!!");
            alert.setContentText("Patient data was succesfully added to database");
            alert.show();

            Stage stage = (Stage) AddNewAssesmentButton.getScene().getWindow();
            stage.close();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> List = FXCollections.observableArrayList("Klinik Anak", "Klinik Gigi", "Klinik Jantung");
        clinicDropdownOption.setItems(List);
    }
}
