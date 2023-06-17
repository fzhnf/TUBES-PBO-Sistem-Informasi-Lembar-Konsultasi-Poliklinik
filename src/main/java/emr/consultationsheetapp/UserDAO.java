package emr.consultationsheetapp;

import java.sql.*;

public class UserDAO extends UserModel {
    DBUtil dbConnect = new DBUtil();
    public UserDAO(String username, String password) {
        super(username, password);
    }

    public int getUserId() {
        if (username.equals("admin") && password.equals("14124")) {
            return 0;
        } else {
            try {
                Connection connect = dbConnect.getConnection();
                Statement statement = connect.createStatement();
                ResultSet queryResult = statement.executeQuery("SELECT user_id FROM user_table WHERE username = '" + username + "' AND password = '" + password + "'");
                if (queryResult.next()) {
                    return queryResult.getInt("user_id");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } return -1;
    }
//    public int getClinic(int id) {
//        //try {
//            Statement statement = connectDB.createStatement();
//            ResultSet  queryResult = statement.executeQuery("SELECT clinic FROM user_account WHERE user_id = '" + id + "'");
//            if (queryResult.next()) {
//                return queryResult.getInt("clinic");
//            }
//        //} catch (Exception e) {
//        //    e.printStackTrace();
//        //    e.getCause();
//        //}
//        //return -1;
//        return id;
//    }
}