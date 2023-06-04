module tubespbo.lembarkonsultasi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens tubespbo.lembarkonsultasi to javafx.fxml;
    exports tubespbo.lembarkonsultasi;
    exports tubespbo.lembarkonsultasi.Controller;
    opens tubespbo.lembarkonsultasi.Controller to javafx.fxml;
    exports tubespbo.lembarkonsultasi.Model;
    opens tubespbo.lembarkonsultasi.Model to javafx.fxml;
}