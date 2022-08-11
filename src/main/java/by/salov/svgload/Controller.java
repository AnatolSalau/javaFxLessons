package by.salov.svgload;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label myLabel1;

    @FXML
    private JFXButton myButton1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myButton1.setText("");
    }
}
