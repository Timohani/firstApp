package org.timowa.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void btnClick(ActionEvent event) {
        char newSym = 'x';
        ((Button) event.getSource()).setText(String.valueOf(newSym));
    }

    @FXML
    void initialize() {

    }

}
