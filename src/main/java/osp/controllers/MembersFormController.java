package osp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import osp.DB.DAO.MemberDAO;
import osp.Models.MemberOld;

import java.io.IOException;
import java.sql.SQLException;

public class MembersFormController {

    MainFormController mainFormController;
    @FXML
    private TableView<MemberOld> tableViewMembers;
    @FXML
    private TableColumn<MemberOld, String> nameColumn;
    @FXML
    private TableColumn<MemberOld, String> cityColumn;
    @FXML
    private TableColumn<MemberOld, String> surnameColumn;
    @FXML
    private TableColumn<MemberOld, Integer> functionColumn;
    @FXML
    private TableColumn<MemberOld, Void> actionColumn;
    @FXML
    private TableColumn<MemberOld, Integer> phoneColumn;
    @FXML
    private TableColumn<MemberOld, Boolean> memberColumn;
    @FXML
    private TableColumn<MemberOld, String> joinDateColumn;
    @FXML
    private TableColumn<MemberOld, Boolean> jotColumn;
    private Boolean options;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        options = false;
        nameColumn.setCellValueFactory(new PropertyValueFactory<MemberOld, String>("firstName"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<MemberOld, String>("city"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<MemberOld, String>("surname"));
        functionColumn.setCellValueFactory(new PropertyValueFactory<MemberOld, Integer>("memberFunction"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<MemberOld, Integer>("phoneNumber"));
        joinDateColumn.setCellValueFactory(new PropertyValueFactory<MemberOld, String>("joinDate"));
        memberColumn.setCellValueFactory(new PropertyValueFactory<MemberOld, Boolean>("isMember"));
        jotColumn.setCellValueFactory(new PropertyValueFactory<MemberOld, Boolean>("isJOT"));

        fillTableViewMembers();
        //sort table
        tableViewMembers.getSortOrder().setAll(surnameColumn, nameColumn);
    }

    private void fillTableViewMembers() throws SQLException, ClassNotFoundException {
        try {
            ObservableList<MemberOld> membersData = MemberDAO.searchMembers();
            populateMembers(membersData);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
        addEditMemberButtonTable();
    }

    private void populateMembers(ObservableList<MemberOld> memberOld) {
        ObservableList<MemberOld> membersTblView = FXCollections.observableArrayList();
        membersTblView.setAll(memberOld);
        tableViewMembers.setItems(membersTblView);
    }

    @FXML
    public void onOptionsClicked() {
        options = !options;
        joinDateColumn.setVisible(options);
        jotColumn.setVisible(options);
        phoneColumn.setVisible(options);
        memberColumn.setVisible(options);
    }

    @FXML
    private void onAddMemberClicked() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/memberAddForm.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menuForm.fxml"));
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

    private void addEditMemberButtonTable() {
        Callback<TableColumn<MemberOld, Void>, TableCell<MemberOld, Void>> cellFactory = new Callback<TableColumn<MemberOld, Void>, TableCell<MemberOld, Void>>() {
            @Override
            public TableCell<MemberOld, Void> call(TableColumn<MemberOld, Void> memberVoidTableColumn) {
                TableCell<MemberOld, Void> cell = new TableCell<MemberOld, Void>() {
                    private Button button = new Button("Edytuj");
                    {
                        button.setOnAction((ActionEvent event) -> {
                            MemberOld memberOld = getTableView().getItems().get(getIndex());
                            System.out.println("Imie: " + memberOld.getFirstName());
                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
                return cell;
            }
        };
        actionColumn.setCellFactory(cellFactory);
    }
}
