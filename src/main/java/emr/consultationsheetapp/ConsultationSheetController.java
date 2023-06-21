package emr.consultationsheetapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ConsultationSheetController {

    @FXML
    private Button kembaliKeLamanDokter;

    @FXML
    private TextField inputBloodPressure;

    @FXML
    private TextField inputHeartRateBeat;

    @FXML
    private TextField inputBodyTemperature;

    @FXML
    private ToggleGroup feelingRateRadioButton;

    @FXML
    private RadioButton sangatSehatSelected;

    @FXML
    private RadioButton sehatSelected;

    @FXML
    private RadioButton sedangSelected;

    @FXML
    private RadioButton tidakSehatSelected;

    @FXML
    private RadioButton sakitSelected;

    @FXML
    private TextArea physicalExamTextArea;

    @FXML
    private TextArea diagnosisDetailTextArea;

    @FXML
    private TextArea patientEducationTextArea;

    @FXML
    private Button submitSheetConsultation;

    int patientId;

    @FXML
    public void receiveId(int patientId) {
        this.patientId = patientId;
    }

    @FXML
    void kembaliKeLamanDokterButton(ActionEvent event) {

    }

    @FXML
    void submitSheetConsultationButton(ActionEvent event) {
        boolean validateEmpty = (inputBloodPressure.getText().isBlank() || inputHeartRateBeat.getText() == null || inputBodyTemperature.getText() == null ||!(sangatSehatSelected.isSelected() || sehatSelected.isSelected() || sedangSelected.isSelected() || tidakSehatSelected.isSelected() || sakitSelected.isSelected()) || physicalExamTextArea.getText() == null || diagnosisDetailTextArea.getText() == null || patientEducationTextArea.getText() == null);
        if (validateEmpty) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR INPUT");
            alert.setContentText("Please input sheet data");
            alert.show();
        } else {
            int id = patientId;
            int bloodPressure = Integer.parseInt(inputBloodPressure.getText());
            int heartRateBeat = Integer.parseInt(inputHeartRateBeat.getText());
            int bodyTemperature = Integer.parseInt(inputBodyTemperature.getText());
            int feelingRate = 0;
            if (sakitSelected.isSelected()) {
                feelingRate = 5;
            } else if (tidakSehatSelected.isSelected()) {
                feelingRate = 4;
            } else if (sedangSelected.isSelected()) {
                feelingRate = 3;
            } else if (sehatSelected.isSelected()) {
                feelingRate = 2;
            } else if (sangatSehatSelected.isSelected()) {
                feelingRate = 1;
            }
//
            String physicalExam = physicalExamTextArea.getText();
            String diagnosisDetail = diagnosisDetailTextArea.getText();
            String patientEducation = patientEducationTextArea.getText();


            ConsultationSheetDAO inputSheet = new ConsultationSheetDAO();
             inputSheet.createConsultationDAO(id, bloodPressure, heartRateBeat, bodyTemperature, feelingRate, physicalExam, diagnosisDetail, patientEducation);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SUCCES!!");
            alert.setContentText("Patient data was succesfully added to database");
            alert.show();

            Stage stage = (Stage) submitSheetConsultation.getScene().getWindow();
        }
    }


}
