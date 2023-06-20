package emr.consultationsheetapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class PatientDAO extends PatientModel {
    static DBUtil database = new DBUtil();
    int patientId;
    public PatientDAO(String patientName, int patientGender, Date patientBirthdate, int clinic, int diagnoseStatus, int patientId) {
        super(patientName, patientGender, patientBirthdate, clinic, diagnoseStatus);
        this.patientId = patientId;
    }

    public PatientDAO(String patientName, int patientGender, Date patientBirthdate, int clinic, int diagnoseStatus) {
        super(patientName, patientGender, patientBirthdate, clinic, diagnoseStatus);
    }

    public PatientDAO() {
        super();
    }


    public int getPatientId() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT patient_id FROM patient_table WHERE patient_name  = '" + this.patientName +"' AND patient_birthdate = '" + this.patientBirthdate +"' AND patient_gender = '" + this.patientGender + "' AND clinic = '" + this.clinic + "' AND diagnose = '" + this.diagnoseStatus + "'";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            if (queryResult.next()) {
                return queryResult.getInt("patient_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    public String getPatientName() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT patient_name FROM patient_table WHERE patient_id = '" + getPatientId() + "'";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            if (queryResult.next()) {
                return queryResult.getString("patient_name");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void setPatientName(String patientName) {
        try (Connection connectDB = database.getConnection()) {
            String query = "UPDATE patient_table SET patient_name = '" + patientName + "' WHERE patient_id = '" + getPatientId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPatientGender() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT patient_gender FROM patient_table WHERE patient_id = '" + getPatientId() + "'";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            if (queryResult.next()) {
                return queryResult.getInt("patient_gender");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public void setPatientGender(int patientGender) {
        try (Connection connectDB = database.getConnection()) {
        String query = "UPDATE patient_table SET patient_gender = '" + patientGender + "' WHERE patient_id = '" + getPatientId() + "'";
        Statement statement = connectDB.createStatement();
        statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Date getPatientBirthdate() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT patient_birthdate FROM patient_table WHERE patient_id = '" + getPatientId() + "'";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            if (queryResult.next()) {
                return queryResult.getDate("patient_birthdate");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void setPatientBirthdate(Date patientBirthdate) {
        try (Connection connectDB = database.getConnection()) {
            String query = "UPDATE patient_table SET patient_birthdate = '" + patientBirthdate + "' WHERE patient_id = '" + getPatientId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getdiagnoseStatus() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT diagnose FROM patient_table WHERE patient_id = '" + getPatientId() + "'";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            if (queryResult.next()) {
                queryResult.getInt("diagnose");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public void setdiagnoseStatus(int diagnoseStatus) {
        try (Connection connectDB = database.getConnection()) {
            String query = "UPDATE patient_table SET diagnose = '" + diagnoseStatus + "' WHERE patient_id = '" + getPatientId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getClinic() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT clinic FROM patient_table WHERE patient_id = '" + getPatientId() + "'";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            if (queryResult.next()) {
                return queryResult.getInt("clinic");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public void setClinic(int clinic) {
        try (Connection connectDB = database.getConnection()) {
            String query = "UPDATE patient_table SET clinic = '" + clinic + "' WHERE patient_id = '" + getPatientId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addPatient(String patientName, int patientGender, Date patientBirthdate, int clinic) {
        try (Connection connectDB = database.getConnection()) {
            String query = "INSERT INTO patient_table (patient_name, patient_gender, patient_birthdate, clinic, diagnose) VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement statement = connectDB.prepareStatement(query);
            statement.setString(1, patientName);
            statement.setInt(2, patientGender);
            statement.setDate(3, (java.sql.Date) patientBirthdate);
            statement.setInt(4, clinic);
            statement.setInt(5, 0);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePatient() {
        try (Connection connectDB = database.getConnection()) {
            String query = "DELETE FROM patient_table WHERE patient_id = '" + getPatientId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<PatientDAO> getAllPatients() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT * FROM patient_table";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            ArrayList<PatientDAO> patients = new ArrayList<>();
            while (queryResult.next()) {
               patients.add(new PatientDAO(queryResult.getString("patient_name"), queryResult.getInt("patient_gender"), queryResult.getDate("patient_birthdate"), queryResult.getInt("clinic"), queryResult.getInt("diagnose"), queryResult.getInt("patient_id")));
            }
            System.out.println(patients.toString());
            return patients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
