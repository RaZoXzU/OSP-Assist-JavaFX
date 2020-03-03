package osp.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class LoginFormController {

    @FXML
    public void onCloseClicked() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void onLoginClicked() {
    }
}