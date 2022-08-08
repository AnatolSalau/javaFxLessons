package by.salov.lesson_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();

        VBox vbox = new VBox(10);
        HBox hbox = new HBox(10);

        hbox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);


        Button btn1 = addButton("1");
        Button btn2 = addButton("2");
        Button btn3 = addButton("3");
        Button btn4 = addButton("4");
        Button btn5 = addButton("5");
        Button btn6 = addButton("6");
        Button btn7 = addButton("7");
        Button btn8 = addButton("8");


        TextField textField = new TextField("Dimension one");



        vbox.getChildren().addAll(
                btn1,btn2,btn3,btn4);
        hbox.getChildren().addAll(
                btn5,btn6,btn7,btn8);

        root.setBottom(hbox);
        root.setLeft(vbox);


        Scene scene = new Scene(root,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Button addButton(String label) {
        Button btn = new Button(label);
        btn.setPrefSize(70,20);
        return btn;
    }

    public static void main (String[] args) {
        launch(args);
    }
}
