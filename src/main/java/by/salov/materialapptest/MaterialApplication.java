package by.salov.materialapptest;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MaterialApplication extends Application {
    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new MFXButton("mfx")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
