package tubespbo.emedicalrecords;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "emrsdb";
        String databaseUser = "root";
        String databasePassword = "rafi1234";
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