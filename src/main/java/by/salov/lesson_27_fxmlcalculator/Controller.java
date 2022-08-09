package by.salov.lesson_27_fxmlcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Text output;
    private long num1 = 0;
    private long num2 = 0;
    private boolean start = true;
    private String operatorValue = "";
    private Model model = new Model();

    @FXML
    private void num(ActionEvent actionEvent) {
        if(start) {
            output.setText("");
            start = false;
        }
        //Get button where was action event
        Button button = (Button) actionEvent.getSource();
        String text = button.getText();
        //Adding text to existing
        output.setText(output.getText()+text);
    }
    @FXML
    private void operator(ActionEvent actionEvent) {
        //Get button where was action event
        Button button = (Button) actionEvent.getSource();
        String text = button.getText();
        if (!"=".equals(text)) {
            if (!operatorValue.isEmpty()){
                return;
            }
            operatorValue = text;
            num1 = Long.parseLong(output.getText());
            output.setText("");
        }
        else {
            if (operatorValue.isEmpty()) {
                return;
            }
            output.setText(String.valueOf(model.calculation(
                    num1,Long.parseLong(output.getText()),operatorValue
            )));
            operatorValue = "";
            start = true;
        }
    }
}
