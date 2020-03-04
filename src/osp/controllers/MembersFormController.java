package osp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import osp.Models.Member;

import java.io.IOException;

public class MembersFormController {

    MainFormController mainFormController;
    @FXML
    TableView<Member> tableViewMembers;
    @FXML
    TableColumn<Member, String> nameColumn;
    @FXML
    TableColumn<Member, String> cityColumn;
    @FXML
    TableColumn<Member, String> surnameColumn;
    @FXML
    TableColumn<Member, Integer> functionColumn;
    @FXML
    TableColumn<Member, Member> actionColumn;
    @FXML
    TableColumn<Member, Integer> phoneColumn;
    @FXML
    TableColumn<Member, Integer> memberColumn;
    @FXML
    TableColumn<Member, String> joinDateColumn;
    @FXML
    TableColumn<Member, Integer> jotColumn;

    @FXML
    public void initialize() {
    }

    //test
    Boolean opcje = true;

    @FXML
    public void onOptionsClicked() {

        joinDateColumn.setVisible(opcje);
        jotColumn.setVisible(opcje);
        phoneColumn.setVisible(opcje);
        memberColumn.setVisible(opcje);

        opcje = !opcje;
    }

    @FXML
    public void onAddMemberClicked() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("firstName"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("city"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("surname"));
        functionColumn.setCellValueFactory(new PropertyValueFactory<Member, Integer>("memberFunction"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Member, Integer>("phoneNumber"));
        joinDateColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("joinDate"));
        memberColumn.setCellValueFactory(new PropertyValueFactory<Member, Integer>("isMember"));
        jotColumn.setCellValueFactory(new PropertyValueFactory<Member, Integer>("isJOT"));

        final ObservableList<Member> data = FXCollections.observableArrayList(
                new Member("Łukasz", "Starzewski", "Warszawa", 123456789, "2020-20-20", 1, 1, 1),
                new Member("Adrian", "Rosłoński", "Gdańsk", 567234489, "2020-20-20", 1, 1, 1),
                new Member("Robert", "Brzęczyszczykiewicz", "Jelenia Góra", 123456789, "2020-20-20", 1, 1, 1),
                new Member("Jan", "Kowalski", "Babice", 345678345, "2020-20-20", 1, 1, 1)
        );
        tableViewMembers.getItems().addAll(data);
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
