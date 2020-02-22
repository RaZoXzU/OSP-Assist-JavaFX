package osp.controllers;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import osp.Main;

import java.io.IOException;

public class LoginFormController {

    public void onCloseClicked(){
        Platform.exit();
    }
    public void onLoginClicked(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/osp/fxml/menuForm.fxml"));
        Pane pane;
        try{
            pane = loader.load();
            Main.primaryStage.setScene(new Scene(pane));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}