package osp.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class LoginFormController {

    @FXML
    public void onCloseClicked(){
        Platform.exit();
    }

    @FXML
    public void onLoginClicked(){

    }
}