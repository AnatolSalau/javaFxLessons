package by.salov.jfoenixstart;

import com.jfoenix.controls.JFXTreeTableView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/by/salov/jfoenixstart.fxml"));
        primaryStage.setTitle("JFoenix start");
        primaryStage.setScene(new Scene(root,500,300));
        primaryStage.show();
        List<Node> allNodesInParent = getAllNodesInParent(root);
        System.out.println(allNodesInParent);
        JFXTreeTableView jfxTreeTableView = (JFXTreeTableView) allNodesInParent.get(0);
        List<Node> allNodesInTreeTableView = getAllNodesInParent(jfxTreeTableView);
        for (int i = 0; i < allNodesInTreeTableView.size(); i++) {
            System.out.println("Item number : " + i);
            System.out.println(allNodesInTreeTableView.get(i));
            System.out.println();
        }

    }

    public static void main(String[] args) {

        launch(args);
    }
    public static List<Node> getAllNodesInParent(Parent parent) {
        List<Node> ret = new ArrayList<>();
        for (Node child : parent.getChildrenUnmodifiable()) {
            ret.add(child);
            if (child instanceof Parent) {
                ret.addAll(getAllNodesInParent((Parent) child));
            }
        }
        return ret;
    }
}