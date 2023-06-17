module emr.consultationsheetapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens emr.consultationsheetapp to javafx.fxml;
    exports emr.consultationsheetapp;
}