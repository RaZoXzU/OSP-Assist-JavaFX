package osp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MembersFormController {

    MainFormController mainFormController;

    @FXML
    public void initialize(){
    }

    @FXML
    public void onOptionsClicked() {
    }

    @FXML
    public void onAddMemberClicked() {
    }

    @FXML
    public void onBackClicked() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/osp/fxml/menuForm.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuFormController menuFormController = loader.getController();
        menuFormController.setMainFormController(mainFormController);
        mainFormController.setScreen(pane);
    }

    public void setMainFormController(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
    }
}
