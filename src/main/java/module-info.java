module by.salov.javafxlessons {
    requires javafx.controls;
    requires javafx.fxml;


    opens by.salov.helloapp to javafx.fxml;
    exports by.salov.helloapp;
}