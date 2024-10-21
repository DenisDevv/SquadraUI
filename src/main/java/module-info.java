module live.denisdev.squadraui {
    requires javafx.controls;
    requires javafx.fxml;


    opens live.denisdev.squadraui to javafx.fxml;
    exports live.denisdev.squadraui;
}