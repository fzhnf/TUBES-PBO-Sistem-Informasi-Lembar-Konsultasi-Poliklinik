package tubespbo.lembarkonsultasi.Model;

import java.util.Date;

public class PatientModel {
    private int patientId;
    private String patientName;
    private int patientGender;
    private String patientBirthdate;

    private String clinic;
    private boolean diagnose;

    public PatientModel(int patientId, String patientName, int patientGender, String patientBirthdate, String clinic, boolean diagnose) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientBirthdate = patientBirthdate;
        this.clinic = clinic;
        this.diagnose = diagnose;
    }

    public PatientModel(String patientName, int patientGender, String patientBirthdate, String clinic, boolean diagnose) {
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientBirthdate = patientBirthdate;
        this.clinic = clinic;
        this.diagnose = diagnose;
    }

    public PatientModel(int patientGender, String patientBirthdate, String clinic, boolean diagnose) {
        this.patientGender = patientGender;
        this.patientBirthdate = patientBirthdate;
        this.clinic = clinic;
        this.diagnose = diagnose;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(int patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientBirthdate() {
        return patientBirthdate;
    }

    public void setPatientBirthdate(String patientBirthdate) {
        this.patientBirthdate = patientBirthdate;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public boolean isDiagnose() {
        return diagnose;
    }

    public void setDiagnose(boolean diagnose) {
        this.diagnose = diagnose;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientGender=" + patientGender +
                ", patientBirthdate='" + patientBirthdate + '\'' +
                ", clinic='" + clinic + '\'' +
                ", diagnose=" + diagnose +
                '}';
    }
}
