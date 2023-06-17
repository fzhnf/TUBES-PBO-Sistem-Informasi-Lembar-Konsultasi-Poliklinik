package emr.consultationsheetapp;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
    
    public Connection getConnection() {
        Connection databaseLink = null;
        String databaseName = "emrsdb";
        String databaseUser = "root";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}