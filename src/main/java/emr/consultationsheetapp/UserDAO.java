package emr.consultationsheetapp;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO extends UserModel {
    static DBUtil database = new DBUtil();
    int userId;

    public UserDAO(String username, String password, int clinic, int userID) {
        super(username, password, clinic);
        this.userId = userId;
    }

    public UserDAO(String username, String password, int clinic) {
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
            String query = "SELECT user_id FROM user_table WHERE user_name = '" + this.username + "' AND user_password ='" + this.password + "'";
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
            String query = "SELECT user_name FROM user_table WHERE user_id = '" + getUserId() + "'";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            if (queryResult.next()) {
                return queryResult.getString("user_name");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int getClinic() {
        try (Connection connectDB = database.getConnection()) {
            String query = "SELECT user_clinic FROM user_table WHERE user_id = '" + getUserId() + "'";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            if (queryResult.next()) {
                return queryResult.getInt("user_clinic");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    @Override
    public void setUsername(String username) {
        try (Connection connectDB = database.getConnection()) {
            String query = "UPDATE user_table SET user_name = '" + username + "' WHERE user_id = '" + getUserId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void setPassword(String password) {
        try (Connection connectDB = database.getConnection()) {
            String query = "UPDATE user_table SET user_password = '" + password + "' WHERE user_id = '" + getUserId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setClinic(String clinic) {
        try (Connection connectDB = database.getConnection()) {
            String query = "UPDATE user_table SET user_clinic = '" + clinic + "' WHERE user_id = '" + getUserId() + "'";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createUser(String username, String password, int clinic) {
        try (Connection connectDB = database.getConnection()) {
            String query = "INSERT INTO user_table (user_name, user_password, user_clinic) VALUES ( ?, ?, ?)";
            PreparedStatement statement = connectDB.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, clinic);
            statement.executeUpdate();
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
                users.add(new UserDAO(queryResult.getString("user_name"), queryResult.getString("user_password"), queryResult.getInt("user_clinic")));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}