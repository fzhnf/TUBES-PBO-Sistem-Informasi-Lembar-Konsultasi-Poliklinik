module emr.consultationsheetapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens emr.consultationsheetapp to javafx.fxml;
    exports emr.consultationsheetapp;
}