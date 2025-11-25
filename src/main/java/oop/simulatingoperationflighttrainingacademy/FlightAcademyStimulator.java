package oop.simulatingoperationflighttrainingacademy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FlightAcademyStimulator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlightAcademyStimulator.class.getResource("signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Flight Academy");
        stage.setScene(scene);
        stage.show();
    }
}
