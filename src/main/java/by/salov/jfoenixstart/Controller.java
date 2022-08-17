package by.salov.jfoenixstart;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label label;

    @FXML
    private JFXButton buttonOne;

    @FXML
    private JFXTreeTableView tableview;

    @FXML
    private  void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me");
        label.setText("Hello world");
    }
    ObservableList<User> data;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeTableColumn column1 = new TreeTableColumn<>("Фамилия");
        TreeTableColumn column2 = new TreeTableColumn<>("Имя");
        TreeTableColumn column3 = new TreeTableColumn<>("Отчество1");
        TreeTableColumn column4 = new TreeTableColumn<>("Отчество2");
        TreeTableColumn column5 = new TreeTableColumn<>("Отчество3");
        TreeTableColumn column6 = new TreeTableColumn<>("Отчество4");
        TreeTableColumn column7 = new TreeTableColumn<>("Отчество5");
        TreeTableColumn column8 = new TreeTableColumn<>("Отчество6");
        TreeTableColumn column9 = new TreeTableColumn<>("Отчество7");
        TreeTableColumn column10 = new TreeTableColumn<>("Отчество8");
        TreeTableColumn column11 = new TreeTableColumn<>("Отчество9");

        tableview.getColumns().addAll(column1,column2,column3,column4,column5,column6,column7,column8,column9,column10,column11);
        buttonOne.setText("                  Добавить пациента");
        label.setText("");

        data = FXCollections.observableArrayList(
                new User("name1", "name2",
                        "name3","name4",
                        "name5","name6",
                        "name7","name8",
                        "name9"),
                new User("name1", "name2",
                        "name3","name4",
                        "name5","name6",
                        "name7","name8",
                        "name9"),
                new User("name1", "name2",
                        "name3","name4",
                        "name5","name6",
                        "name7","name8",
                        "name9"),
                new User("name1", "name2",
                        "name3","name4",
                        "name5","name6",
                        "name7","name8",
                        "name9"),
                new User("name1", "name2",
                        "name3","name4",
                        "name5","name6",
                        "name7","name8",
                        "name9"),
                new User("name1", "name2",
                        "name3","name4",
                        "name5","name6",
                        "name7","name8",
                        "name9"),
                new User("name1", "name2",
                        "name3","name4",
                        "name5","name6",
                        "name7","name8",
                        "name9"),
                new User("name1", "name2",
                        "name3","name4",
                        "name5","name6",
                        "name7","name8",
                        "name9"),
                new User("name1", "name2",
                        "name3","name4",
                        "name5","name6",
                        "name7","name8",
                        "name9")
        );

        column1.setCellValueFactory(
                new TreeItemPropertyValueFactory<User,String>("name1")
        );
        column2.setCellValueFactory(
                new TreeItemPropertyValueFactory<User,String>("name2")
        );
        column3.setCellValueFactory(
                new TreeItemPropertyValueFactory<User,String>("name3")
        );
        TreeItem<User> root = new RecursiveTreeItem<>(data, RecursiveTreeObject::getChildren);

        tableview.setRoot(root);

        tableview.setShowRoot(false);

    }
}
