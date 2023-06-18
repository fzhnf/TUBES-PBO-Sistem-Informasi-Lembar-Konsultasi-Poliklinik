package emr.consultationsheetapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class PatientDAO extends PatientModel {
    DBUtil database = new DBUtil();
    int patientId;
    public PatientDAO(String patientName, int patientGender, Date patientBirthdate, int clinic, boolean diagnose, int patientId) {
        super(patientName, patientGender, patientBirthdate, clinic, diagnose);
        this.patientId = patientId;
    }

    public PatientDAO(String patientName, int patientGender, Date patientBirthdate, int clinic, boolean diagnose) {
        super(patientName, patientGender, patientBirthdate, clinic, diagnose);
    }

    public PatientDAO() {
        super();
    }


    public int getPatientId() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT patient_id FROM patient_table WHERE patient_name  = '" + this.patientName +"' AND patient_birthdate = '" + this.patientBirthdate +"' AND patient_gender = '" + this.patientGender + "' AND clinic = '" + this.clinic + "' AND diagnose = '" + this.diagnose + "'";
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
    public boolean getDiagnose() {
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
        return false;
    }

    @Override
    public void setDiagnose(boolean diagnose) {
        try (Connection connectDB = database.getConnection()) {
            String query = "UPDATE patient_table SET diagnose = '" + diagnose + "' WHERE patient_id = '" + getPatientId() + "'";
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
    public void addPatient(String patientName, int patientGender, Date patientBirthdate, int clinic, boolean diagnose) {
        try (Connection connectDB = database.getConnection()) {
            String query = "INSERT INTO patient_table WHERE patient_name  = '" + getPatientName() +"' AND patient_birthdate = '" + getPatientBirthdate() +"' AND patient_gender = '" + getPatientGender() + "' AND clinic = '" + getClinic() + "' AND diagnose = '" + getDiagnose() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
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
                patients.add(new PatientDAO(queryResult.getString("patient_name"), queryResult.getInt("patient_gender"), queryResult.getDate("patient_birthdate"), queryResult.getInt("clinic"), queryResult.getBoolean("diagnose"), queryResult.getInt("patient_id")));
            }
            return patients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
