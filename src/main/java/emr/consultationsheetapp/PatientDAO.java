package emr.consultationsheetapp;

public class PatientDAO extends PatientModel {

    public PatientDAO(int patientId, String patientName, int patientGender, String patientBirthdate, String clinic, boolean diagnose) {
        super(patientId, patientName, patientGender, patientBirthdate, clinic, diagnose);
    }

    public PatientDAO(String patientName, int patientGender, String patientBirthdate, String clinic, boolean diagnose) {
        super(patientName, patientGender, patientBirthdate, clinic, diagnose);
    }

    public PatientDAO(int patientGender, String patientBirthdate, String clinic, boolean diagnose) {
        super(patientGender, patientBirthdate, clinic, diagnose);
    }
}
