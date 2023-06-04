package tubespbo.lembarkonsultasi.Model;

import tubespbo.lembarkonsultasi.Util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOModel {
    DBUtil connectNow = new DBUtil();
    Connection connectDB = connectNow.getConnection();
    public String getUsername(String username) {
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery("SELECT * FROM user_account WHERE username = '" + username + "'");
            if (queryResult.next()) {
                queryResult.getString("username");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return null;
    }
    public String getPassword(String password) {
        try {
            Statement statement = connectDB.createStatement();
            ResultSet  queryResult = statement.executeQuery("SELECT * FROM user_account WHERE password = '" + password + "'");
            if (queryResult.next()) {
                return queryResult.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return null;
    }

    public int getUserIdByName(String username) {
        try {
            Statement statement = connectDB.createStatement();
            ResultSet  queryResult = statement.executeQuery("SELECT * FROM user_account WHERE username = '" + username + "'");
            if (queryResult.next()) {
                return queryResult.getInt("user_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return -1;
    }

    public int getClinicById(int id) {
        try {
            Statement statement = connectDB.createStatement();
            ResultSet  queryResult = statement.executeQuery("SELECT clinic FROM user_account WHERE user_id = '" + id + "'");
            if (queryResult.next()) {
                return queryResult.getInt("clinic");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return -1;
    }
}
