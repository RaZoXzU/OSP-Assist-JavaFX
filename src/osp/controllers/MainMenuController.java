package osp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private StackPane mainStack;

    private Pane loginForm;
    private Pane menuForm;
    //private Pane membersForm;
    //private Pane actionsForm;


    @FXML
    public void initialize(){
        try {
            loginForm = FXMLLoader.load(getClass().getResource("/osp/fxml/loginForm.fxml"));
            menuForm = FXMLLoader.load(getClass().getResource("/osp/fxml/menuForm.fxml"));
            //membersForm = FXMLLoader.load(getClass().getResource("/osp/fxml/loginForm.fxml"));
            //actionsForm = FXMLLoader.load(getClass().getResource("/osp/fxml/loginForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainStack.getChildren().add(menuForm);
        mainStack.getChildren().add(loginForm);
        loginForm.toFront();
    }
}
