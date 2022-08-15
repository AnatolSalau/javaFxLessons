package by.salov.jfoenixstart;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
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
    }
}
