package osp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import osp.DB.MemberDAO;
import osp.Models.Member;

import java.io.IOException;
import java.sql.SQLException;

public class MembersFormController {

    MainFormController mainFormController;
    @FXML
    private TableView<Member> tableViewMembers;
    @FXML
    private TableColumn<Member, String> nameColumn;
    @FXML
    private TableColumn<Member, String> cityColumn;
    @FXML
    private TableColumn<Member, String> surnameColumn;
    @FXML
    private TableColumn<Member, Integer> functionColumn;
    @FXML
    private TableColumn<Member, Member> actionColumn;
    @FXML
    private TableColumn<Member, Integer> phoneColumn;
    @FXML
    private TableColumn<Member, Integer> memberColumn;
    @FXML
    private TableColumn<Member, String> joinDateColumn;
    @FXML
    private TableColumn<Member, Integer> jotColumn;
    private Boolean options;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        options = false;
        nameColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("firstName"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("city"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("surname"));
        functionColumn.setCellValueFactory(new PropertyValueFactory<Member, Integer>("memberFunction"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Member, Integer>("phoneNumber"));
        joinDateColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("joinDate"));
        memberColumn.setCellValueFactory(new PropertyValueFactory<Member, Integer>("isMember"));
        jotColumn.setCellValueFactory(new PropertyValueFactory<Member, Integer>("isJOT"));

        fillTableViewMembers();
    }

    private void fillTableViewMembers() throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Member> membersData = MemberDAO.searchMembers();
            populateMembers(membersData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }

    private void populateMembers(ObservableList<Member> member){
        ObservableList<Member> membersTblView = FXCollections.observableArrayList();
        membersTblView.setAll(member);
        tableViewMembers.setItems(membersTblView);
    }

    @FXML
    public void onOptionsClicked() {
        joinDateColumn.setVisible(options);
        jotColumn.setVisible(options);
        phoneColumn.setVisible(options);
        memberColumn.setVisible(options);
        options = !options;
    }

    @FXML
    private void onAddMemberClicked() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/memberAddForm.fxml"));
        Scene scene;
        try {
            scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onBackClicked() {
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
