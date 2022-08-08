module by.salov.javafxlessons {
    requires javafx.controls;
    requires javafx.fxml;


    opens by.salov.javafxlessons to javafx.fxml;
    exports by.salov.javafxlessons;
}