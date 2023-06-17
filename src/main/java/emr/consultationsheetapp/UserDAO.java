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
        } else {
            try (Connection connection = dbConnect.getConnection()) {
                Statement statement = connection.createStatement();
                String idQuery = "SELECT user_id FROM user_table WHERE username = '" + this.username + "' AND password = '" + this.password + "'";
                ResultSet resultSet = statement.executeQuery(idQuery);
                int id = 0;
                while (resultSet.next()) {
                    id = 1;
                }
                return id;
            } catch (SQLException e) {
                System.out.println("error");
                return -1;
            }
//        String verifyLogin = "SELECT * FROM user_table WHERE username = '" + username + "' AND password ='" + password + "'";
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet queryResult = statement.executeQuery(verifyLogin);
//            if (queryResult.next()) {
//                return queryResult.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            e.getCause();
        }
    }
}