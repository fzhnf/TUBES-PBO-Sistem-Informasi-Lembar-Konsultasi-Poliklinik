package emr.consultationsheetapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.time.LocalDate;

public class EditAssesmentWindowController {


    @FXML
    private Button EditAssesmentButton;

    @FXML
    private TextField InputTextName;

    @FXML
    private DatePicker InputBirthDate;

    @FXML
    private RadioButton priaSelected, wanitaSelected;

    @FXML
    private ComboBox<String> clinicDropdownOption;

    public PatientDAO patient;

    public void setPatient(PatientDAO patient) {
        this.patient = patient;
        if (patient != null) {
            InputTextName.setText(patient.getPatientName());
            InputBirthDate.setValue(patient.getPatientBirthdate().toLocalDate());

            int gender = priaSelected.isSelected() ? 1 : 2;
            if (gender == 1) {
                priaSelected.setSelected(true);
            } else if (gender == 2) {
                wanitaSelected.setSelected(true);
            }

            ObservableList<String> list = FXCollections.observableArrayList("Klinik Anak", "Klinik Gigi", "Klinik Jantung");
            clinicDropdownOption.setItems(list);

            int clinic = patient.getClinic();
            if (clinic >= 1 && clinic <= clinicDropdownOption.getItems().size()) {
                clinicDropdownOption.getSelectionModel().select(clinic - 1);
            }

        }
    }

    @FXML
    public void EditAsssesment() {
        String name = InputTextName.getText();
        LocalDate birthdateValue = InputBirthDate.getValue();
        Date birthdate = null;
        if (birthdateValue != null) {
            birthdate = java.sql.Date.valueOf(birthdateValue);
        }
        int gender = priaSelected.isSelected() ? 1 : 2;
        int clinicIndex = clinicDropdownOption.getSelectionModel().getSelectedIndex();
        int clinic = clinicIndex + 1;

        patient.setPatientName(name);
        patient.setPatientBirthdate(birthdate);
        patient.setPatientGender(gender);
        patient.setClinic(clinic);
        System.out.println(patient.patientId);
        // Panggil metode updatePatient() dari PatientDAO untuk mengupdate data pasien ke database
        patient.updatePatient();



    }
}
