package emr.consultationsheetapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ConsultationSheetDAO extends ConsultationSheetModel {
    DBUtil database = new DBUtil();
    int consultationSheetId;

    public ConsultationSheetDAO(Date createdAt, int patientId, int bloodPressuremmHg, int heartRateBeatPerMinute, int temperateCelcius, int feelingRate, String physicalExaminationScript, String diagnosisScript, String patientEducation, int consultationSheetId) {
        super(createdAt, patientId, bloodPressuremmHg, heartRateBeatPerMinute, temperateCelcius, feelingRate, physicalExaminationScript, diagnosisScript, patientEducation);
        this.consultationSheetId = consultationSheetId;
    }

    public ConsultationSheetDAO() {
        super();
    }
    public void createConsultationDAO(int patientId, int bloodPressuremmHg, int heartRateBeatPerMinute, int temperateCelcius, int feelingRate, String physicalExaminationScript, String diagnosisScript, String patientEducation) {
        try (Connection connectDB = database.getConnection()) {
            String query = "INSERT INTO consultation_sheet_table (patientId, bloodPressuremmHg, heartRateBeatPerMinute, temperateCelcius, feelingRate, physicalExaminationScript, diagnosisScript, patientEducation) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connectDB.prepareStatement(query);
            statement.setInt(1, patientId);
            statement.setInt(2, bloodPressuremmHg);
            statement.setInt(3, heartRateBeatPerMinute);
            statement.setInt(4, temperateCelcius);
            statement.setInt(5, feelingRate);
            statement.setString(6, physicalExaminationScript);
            statement.setString(7, diagnosisScript);
            statement.setString(8, patientEducation);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteConsultationSheet() {
        try (Connection connectDB = database.getConnection()) {
            String query = "DELETE FROM consultation_sheet_table WHERE patient_id = '" + getPatientId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ConsultationSheetDAO> getAllConsultationSheet() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT * FROM consultation_sheet_table";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            ArrayList<ConsultationSheetDAO> sheets = new ArrayList<>();
            while (queryResult.next()) {
                sheets.add(new ConsultationSheetDAO(
                        queryResult.getDate("sheet_created_date"),
                        queryResult.getInt("patient_id"),
                        queryResult.getInt("blood_pressure"),
                        queryResult.getInt("heart_rate"),
                        queryResult.getInt("temperature"),
                        queryResult.getInt("patient_feeling"),
                        queryResult.getString("physical_examination"),
                        queryResult.getString("diagnosis_analysis"),
                        queryResult.getString("patient_education"),
                        queryResult.getInt("consultation_sheet_id")));
            };
            return sheets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
