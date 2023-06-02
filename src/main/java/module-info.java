module tubespbo.emedicalrecords {
    requires javafx.controls;
    requires javafx.fxml;


    opens tubespbo.emedicalrecords to javafx.fxml;
    exports tubespbo.emedicalrecords;
}