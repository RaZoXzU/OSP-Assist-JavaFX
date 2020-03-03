package osp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import osp.Models.Member;

import java.io.IOException;

public class MembersFormController {

    MainFormController mainFormController;
    @FXML
    TableView tableViewMembers;
    @FXML
    TableColumn nameColumn;
    @FXML
    TableColumn cityColumn;
    @FXML
    TableColumn surnameColumn;
    @FXML
    TableColumn functionColumn;
    @FXML
    TableColumn actionColumn;
    @FXML
    TableColumn phoneColumn;
    @FXML
    TableColumn memberColumn;
    @FXML
    TableColumn joinDateColumn;
    @FXML
    TableColumn jotColumn;

    @FXML
    public void initialize() {
    }

    @FXML
    public void onOptionsClicked() {
        joinDateColumn.setVisible(true);
        jotColumn.setVisible(true);
        phoneColumn.setVisible(true);
        memberColumn.setVisible(true);
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
