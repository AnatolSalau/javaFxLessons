package by.salov.scrollview_top_down;

import com.jfoenix.controls.JFXButton;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class ScrollViewTopDownController implements Initializable {
    @FXML
    private ScrollPane scroller;
    @FXML
    private VBox vBoxTop;
    @FXML
    private VBox vBox;
    @FXML
    private JFXButton button1;
    @FXML
    private JFXButton button2;
    @FXML
    private JFXButton upButton;
    @FXML
    private JFXButton downButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vBox.setMinHeight(500);
        scroller.setContent(vBox);
        vBoxTop.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        scroller.setFitToHeight(true);
        scroller.setFitToWidth(true);

        scroller.setVvalue(0.5);
        scroller.setHvalue(0.5);

        button1.setText("Button1");
        button2.setText("Button2");
        upButton.setText("TOP");
        downButton.setText("DOWN");


        final double scrollSpeed = 0.5 ; // scrollpane units per second

        AnimationTimer timer = new AnimationTimer() {

            private long lastUpdate = 0 ;
            @Override
            public void handle(long time) {
                if (lastUpdate > 0) {
                    long elapsedNanos = time - lastUpdate ;
                    double elapsedSeconds = elapsedNanos / 1_000_000_000.0 ;
                    double delta = 0 ;
                    if (upButton.isArmed()) {
                        delta = -scrollSpeed * elapsedSeconds ;
                    }
                    if (downButton.isArmed()) {
                        delta = scrollSpeed * elapsedSeconds ;
                    }
                    double newValue =
                            clamp(scroller.getVvalue() + delta, scroller.getVmin(), scroller.getVmax());
                    scroller.setVvalue(newValue);
                }
                lastUpdate = time ;
            }
        };

        timer.start();

    }
    private double clamp(double value, double min, double max) {
        return Math.min(max, Math.max(min, value));
    }

}
