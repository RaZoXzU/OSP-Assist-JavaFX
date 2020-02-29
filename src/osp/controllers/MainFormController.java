package osp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainFormController {

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    public void initialize(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/osp/fxml/menuForm.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuFormController menuFormController = loader.getController();
        menuFormController.setMainFormController(this);
        setScreen(pane);
    }

    public void setScreen(Pane pane) {
        mainBorderPane.setCenter(pane);
    }

}
