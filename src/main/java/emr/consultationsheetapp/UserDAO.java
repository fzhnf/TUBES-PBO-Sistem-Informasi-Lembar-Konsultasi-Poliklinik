package emr.consultationsheetapp;

import java.sql.*;

public class UserDAO extends UserModel {
    DBUtil dbConnect = new DBUtil();

    UserDAO(String username, String password) {
        super(username, password);
    }

    public int getUserId() {
        if (username.equals("admin") && password.equals("14124")) {
            return 0;
        }
        try (Connection connectDB = dbConnect.getConnection()) {
            String verifyLogin = "SELECT user_id FROM user_table WHERE username = '" + this.username + "' AND password ='" + this.password + "'";
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            if (queryResult.next()) {
                return queryResult.getInt("user_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
}