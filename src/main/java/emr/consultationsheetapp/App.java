package emr.consultationsheetapp;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("loginpage-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("e-ConsultationSheet");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void transition(Parent root, Scene scene, Stage stage, String title) {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), stage.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        ParallelTransition transition = new ParallelTransition(fadeOut, fadeIn);
        transition.setOnFinished(e -> {
            stage.setScene(scene);
            stage.setTitle(title);
        });
        transition.play();
    }
    public static void main(String[] args) {
        launch();
    }
}