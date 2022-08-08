package by.salov.lesson_4_button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//Создаем корневой узел
        Pane root = new Pane();

        HBox hBox = new HBox(50);

        
        Button buttonOne = new Button();
        buttonOne.setText("Click me");
//        Отключаем кольцо фокусировки
        buttonOne.setFocusTraversable(false);

        Button buttonTwo = new Button();
        buttonTwo.setFocusTraversable(false);

//        Загружаем картинку
        Image image = new Image (getClass().getResourceAsStream("/button1.png"));
//        Отображаем картинку
        ImageView img = new ImageView(image);
        img.setFitHeight(40);
        img.setFitWidth(40);

//        Добавляем тень для кнопок
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.GREEN);
//        Устанавливаем радиус кнопки
        shadow.setRadius(40);

// Установим на кнопку стиль CSS, цвет кнопки
        buttonOne.setStyle("-fx-base:#b6e7c9");
        buttonTwo.setStyle("-fx-base:#b6e7c9");


//        Обработчик события для появления тени
        buttonOne.setOnAction(event -> buttonOne.setEffect(shadow));
        buttonTwo.setOnAction(event -> buttonTwo.setEffect(shadow));

        buttonTwo.setGraphic(img);

//Добавляем кнопки на горизонтальную панель
        hBox.getChildren().addAll(buttonOne,buttonTwo);
//Добавляем панель в корневой узел
        root.getChildren().addAll(hBox);

        Scene scene = new Scene(root,200,100, Color.BEIGE);
//        Добавляем сцену в окно
        primaryStage.setScene(scene);
        primaryStage.setTitle("lesson_4_button");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
