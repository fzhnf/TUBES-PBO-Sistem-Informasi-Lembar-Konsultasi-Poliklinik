module tubespbo.emedicalrecords {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;


    exports tubespbo.emedicalrecords;
    opens tubespbo.emedicalrecords to javafx.fxml, javafx.graphics, javafx.controls, javafx.base;
    exports tubespbo.emedicalrecords.model;
    opens tubespbo.emedicalrecords.model to javafx.fxml, javafx.graphics, javafx.controls,javafx.base;
}