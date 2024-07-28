package org.timowa.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private char newSym = 'x';

    private char gameField[][] = new char[3][3];

    private boolean isGame = true;

    @FXML
    void btnClick(ActionEvent event) {
        Button btn = (Button) event.getSource();

        if (!isGame || !btn.getText().isEmpty()) return;

        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);

        gameField[rowIndex][columnIndex] = newSym;

        btn.setText(String.valueOf(newSym));

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "У нас есть победитель! \" " + btn.getText() +" \"", ButtonType.OK);

//        -------------------------------------------------------LOGIC-----------------------------------------------------------------------------
        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == gameField[i][1] && gameField[i][0] == gameField[i][2] && (gameField[i][0] == 'x' || gameField[i][0] == 'o')) {
                isGame = false;
                alert.showAndWait();
                break;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameField[0][i] == gameField[1][i] && gameField[0][i] == gameField[2][i] && (gameField[0][i] == 'x' || gameField[0][i] == 'o')) {
                isGame = false;
                alert.showAndWait();
                break;
            }
        }

        if (gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2] && (gameField[0][0] == 'x' || gameField[0][0] == 'o')) {
            alert.showAndWait();
            isGame = false;
        }
        if (gameField[0][2] == gameField[1][1] && gameField[0][2] == gameField[2][0] && (gameField[0][2] == 'x' || gameField[0][2] == 'o')) {
            alert.showAndWait();
            isGame = false;
        }
//        -----------------------------------------------------------------------------------------------------------------------------------------


        newSym = newSym == 'x' ? 'o' : 'x';
    }

    @FXML
    void initialize() {

    }

}
