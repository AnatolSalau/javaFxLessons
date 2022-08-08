package by.salov.lesson_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

//Наследуемся от класса Application
public class Main extends Application {
//Реализуем метод start - метод в котором пишем приложение
    @Override
    public void start(Stage primaryStage) throws Exception {
//        primaryStage - контейнер самого высокого уровня, окно
        primaryStage.setTitle("My window");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);

//создание коренвого узла
        Pane root = new Pane();

//        Создадим кнопку
        Button btn = new Button();
        btn.setText("Click me");

//        задаем позицию кнопки
        btn.setTranslateX(140);
        btn.setTranslateY(140);

//      задаем размер кнопки
        btn.setPrefSize(70,20);

//        Создадим прямоугольник и закрасим его
        Rectangle rect = new Rectangle(50,50);

// создаем обработчик событий
        CmdDebug cmdDebug = new CmdDebug();
        btn.setOnAction(event ->{
            cmdDebug.cmdPrint("Hello");
            rect.setFill(Color.RED);
                });

//создаем сцену и указываем корневой узел - элемент где будут распологаться все поля, кнопки, итд
        Scene scene = new Scene(root);

//добавим кнопку и прямоуголник на панель
        root.getChildren().addAll(btn,rect);

//задаем сцену  для нашего окна
        primaryStage.setScene(scene);

//        отобразим наше окно
        primaryStage.show();
    }
    //Реализуем метод main - запускаем наше приложение
    public static void main(String[] args) {
        launch(args);
    }
}
