package by.salov.jfoenixstart;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeTableColumn column1 = new TreeTableColumn<>("Фамилия");
        //column1.setStyle();
        TreeTableColumn column2 = new TreeTableColumn<>("Имя");
        TreeTableColumn column3 = new TreeTableColumn<>("Отчество");
        tableview.getColumns().addAll(column1,column2,column3);
        buttonOne.setText("Добавить пациента");
    }
}
