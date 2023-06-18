package emr.consultationsheetapp;

import java.util.Date;

public class PatientModel {
    private int patientId;
    private String patientName;
    private int patientGender;
    private Date patientBirthdate;

    private int clinic;
    private boolean diagnose;


    public PatientModel(String patientName, int patientGender, Date patientBirthdate, int clinic, boolean diagnose) {
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientBirthdate = patientBirthdate;
        this.clinic = clinic;
        this.diagnose = diagnose;
    }

    public PatientModel(String patientName, int patientGender, Date patientBirthdate, int clinic) {
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientBirthdate = patientBirthdate;
        this.clinic = clinic;
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

    public Date getPatientBirthdate() {
        return patientBirthdate;
    }

    public void setPatientBirthdate(Date patientBirthdate) {
        this.patientBirthdate = patientBirthdate;
    }

    public int getClinic() {
        return clinic;
    }

    public void setClinic(int clinic) {
        this.clinic = clinic;
    }

    public boolean getDiagnose() {
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
