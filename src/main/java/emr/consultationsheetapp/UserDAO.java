package emr.consultationsheetapp;

import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class UserDAO extends UserModel {
    DBUtil database = new DBUtil();
    int userId;

    UserDAO(String username, String password, int clinic, int userId) {
        super(username, password, clinic);
        this.userId = userId;
    }

    UserDAO(String username, String password, int clinic) {
        super(username, password, clinic);
    }

    UserDAO(String username, String password) {
        super(username, password);
    }

    public UserDAO() {
        super();
    }

    public int getUserId() {
        if (username.equals("admin") && password.equals("14124")) {
            return 0;
        }
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT user_id FROM user_table WHERE username = '" + this.username + "' AND password ='" + this.password + "'";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            if (queryResult.next()) {
                return queryResult.getInt("user_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    public String getUsername() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT username FROM user_table WHERE user_id = '" + getUserId() + "'";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            if (queryResult.next()) {
                return queryResult.getString("username");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int getClinic() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT clinic FROM user_table WHERE user_id = '" + getUserId() + "'";
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

    @Override
    public void setUsername(String username) {
        try (Connection connectDB = database.getConnection()) {
            String query = "UPDATE user_table SET username = '" + username + "' WHERE user_id = '" + getUserId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void setPassword(String password) {
        try (Connection connectDB = database.getConnection()) {
            String query = "UPDATE user_table SET password = '" + password + "' WHERE user_id = '" + getUserId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setClinic(String clinic) {
        try (Connection connectDB = database.getConnection()) {
            String query = "UPDATE user_table SET clinic = '" + clinic + "' WHERE user_id = '" + getUserId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createUser(String username, String password, int clinic) {
        try (Connection connectDB = database.getConnection()) {
            String query = "INSERT INTO user_table (username, password, clinic) VALUES ('" + username + "', '" + password + "', '" + clinic + "')";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteUser() {
        try (Connection connectDB = database.getConnection()) {
            String query = "DELETE FROM user_table WHERE user_id = '" + getUserId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<UserDAO> getAllUsers() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT * FROM user_table";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            ArrayList<UserDAO> users = new ArrayList<>();
            while (queryResult.next()) {
                users.add(new UserDAO(queryResult.getString("username"), queryResult.getString("password"), queryResult.getInt("clinic")));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}