package by.salov.lesson_3_label;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import  javafx.scene.image.Image;
import  javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Label label = new Label("Constructor text");
        Label label1 = new Label();
        label1.setText("This is a label");

        HBox hBox = new HBox(10);


        Image image = new Image(getClass().getResourceAsStream("/img.png"));
        ImageView img = new ImageView(image);
        img.setFitHeight(50);
        img.setFitWidth(50);

        Label labelImg = new Label();
        labelImg.setGraphic(img);

        labelImg.setText("Picture");
        label.setGraphicTextGap(20);
        label.setContentDisplay(ContentDisplay.LEFT);

        Label magicLabel = new Label();
        magicLabel.setText("This is a magic label");
/*        magicLabel.setTranslateX(100);
        magicLabel.setTranslateY(100);*/

        magicLabel.setOnMouseEntered(event -> {
            magicLabel.setScaleX(1.5);
            magicLabel.setScaleY(1.5);
            magicLabel.setTextFill(Color.RED);
        });

        magicLabel.setOnMouseExited(event -> {
            magicLabel.setScaleX(1);
            magicLabel.setScaleY(1);
            magicLabel.setTextFill(Color.BLACK);
        });

        hBox.getChildren().addAll(label,label1,labelImg,magicLabel);

        root.getChildren().addAll(hBox);

        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
