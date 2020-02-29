package osp.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuFormController {

    private MainFormController mainFormController;

    @FXML
    public void onCloseClicked(){
        Platform.exit();
    }

    @FXML
    public void onAwardsClicked() {
    }

    @FXML
    public void onMembersClicked() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/osp/fxml/membersForm.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MembersFormController membersFormController = loader.getController();
        membersFormController.setMainFormController(mainFormController);
        mainFormController.setScreen(pane);
    }

    @FXML
    public void onActionsClicked() {
    }

    @FXML
    public void onPaymentsClicked() {
    }

    @FXML
    public void onStockClicked() {
    }

    public void setMainFormController(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
    }
}
