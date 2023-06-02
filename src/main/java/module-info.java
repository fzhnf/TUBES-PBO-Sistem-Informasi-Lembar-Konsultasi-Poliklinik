module tubespbo.emedicalrecords {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;

    opens tubespbo.emedicalrecords to javafx.fxml;
    exports tubespbo.emedicalrecords;
    exports tubespbo.emedicalrecords.model;
    opens tubespbo.emedicalrecords.model to javafx.fxml;
    exports tubespbo.emedicalrecords.controller;
    opens tubespbo.emedicalrecords.controller to javafx.fxml;
}