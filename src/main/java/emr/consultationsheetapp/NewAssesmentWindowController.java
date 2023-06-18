package emr.consultationsheetapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
            int gender;
            if (priaSelected.isSelected()) {
                gender = 1;
            } else {
                gender = 0;
            }
            LocalDate localDate = InputBirthDate.getValue();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            String dropdownValue = clinicDropdownOption.getValue();
            int clinic;
            switch (dropdownValue) {
                case "Klinik Anak":
                    clinic = 1;
                    break;
                case "Klinik Gigi":
                    clinic = 2;
                    break;
                case "Klinik Jantung":
                    clinic = 3;
                    break;
                default:
                    clinic = 0;
            }
            // String patientName, int patientGender, Date patientBirthdate, int clinic, int diagnoseStatus
            PatientDAO patient = new PatientDAO(InputTextName.getText(), gender, date , clinic , 0 );
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SUCCESS!");
            alert.setContentText("Data patient was succesfully added to database");
            alert.show();
        }
    }

    public void setPatient(PatientDAO patient) {
        InputTextName.setText(patient.getPatientName());
        Date date = patient.getPatientBirthdate();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        InputBirthDate.setValue(localDate);
        int genderValue = patient.getPatientGender();
        if (genderValue == 0) {
            priaSelected.isSelected();
        }else {
            wanitaSelected.isSelected();
        }
        int clinicValue = patient.getClinic();
        switch (clinicValue) {
            case 1:
                clinicDropdownOption.setValue("Klinik Anak");
                break;
            case 2:
                clinicDropdownOption.setValue("Klinik Gigi");
                break;
            case 3:
                clinicDropdownOption.setValue("Klinik Jantung");
                break;
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> List = FXCollections.observableArrayList("Klinik Anak", "Klinik Gigi", "Klinik Jantung");
        clinicDropdownOption.setItems(List);
        ;
    }
}
