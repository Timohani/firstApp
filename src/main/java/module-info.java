module org.timowa.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.timowa.game to javafx.fxml;
    exports org.timowa.game;
}