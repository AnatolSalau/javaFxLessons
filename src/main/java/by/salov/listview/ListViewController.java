package by.salov.listview;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ListViewController implements Initializable {

    @FXML
    private JFXListView<JFXButton> listview;

    @FXML
    JFXButton topbutton;
    @FXML
    JFXButton botbutton;
    @FXML
    JFXButton addbutton;

    @FXML
    private JFXPopup popup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listview.setPrefWidth(250);
        listview.setPrefHeight(350);
        topbutton.setText("Load");
        botbutton.setText("Unload");
        addbutton.setText("Add");
        for (int i = 0; i < 4; i++) {
            try {
                JFXButton button = new JFXButton("Item" + i);
                listview.getItems().add(button);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }

    @FXML
    private void load(ActionEvent event) {
        if(!listview.isExpanded()) {
            listview.setExpanded(true);
            listview.setVerticalGap(10.0);
            listview.setStyle("-fx-cell-vertical-margin: 10");
            listview.depthProperty().set(3);
            listview.getItems().get(0).setLayoutY(listview.getItems().get(0).getLayoutY() + 50);
/*            listview.getItems().remove(0, 1);
            listview.getItems().add( new JFXButton("New"));*/

        } else {
            listview.setExpanded(false);
            listview.setVerticalGap(0.0);
            listview.setStyle("-fx-cell-vertical-margin: 0");
            listview.depthProperty().set(0);
        }
    }

    @FXML
    private void addnew(ActionEvent event) {

    }

    @FXML
    private void unload(ActionEvent event) {

    }
}