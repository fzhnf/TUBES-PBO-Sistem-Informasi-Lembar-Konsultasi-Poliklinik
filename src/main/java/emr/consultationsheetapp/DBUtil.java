package emr.consultationsheetapp;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
    Connection dbConnection;
    
    public Connection getConnection() {
        String databaseUser = "root";
        String databasePassword = "rafi1234";
        String url = "jdbc:mysql://localhost:3306/emrsdb";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection= DriverManager.getConnection(url,databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return dbConnection;
    }
}