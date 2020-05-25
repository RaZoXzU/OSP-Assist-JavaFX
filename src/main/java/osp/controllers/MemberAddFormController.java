package osp.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import osp.DB.DAO.FunctionDAO;
import osp.DB.DAO.MemberDAO;
import osp.Models.Function;
import osp.Models.MemberOld;

import java.sql.SQLException;

public class MemberAddFormController {

    @FXML
    Label lblTitle;
    @FXML
    Label lblInfo;
    @FXML
    TextField tfName;
    @FXML
    TextField tfSurname;
    @FXML
    TextField tfDadName;
    @FXML
    TextField tfCity;
    @FXML
    TextField tfHouseNumber;
    @FXML
    TextField tfPESEL;
    @FXML
    TextField tfBirthCity;
    @FXML
    TextField tfDocumentNumber;
    @FXML
    TextField tfPhone;
    @FXML
    DatePicker dpBirthDate;
    @FXML
    DatePicker dpJoinDate;
    @FXML
    ComboBox cbFunction;
    @FXML
    ComboBox cbSex;
    @FXML
    CheckBox chckbJOT;
    @FXML
    CheckBox chckbMember;
    @FXML
    Button bttnSaveMember;

    public void onSaveMemberClicked() throws ClassNotFoundException {

        MemberOld memberOld = new MemberOld();
        if (tfName.getText() != "") memberOld.setFirstName(tfName.getText());
        if (tfSurname.getText() != "") memberOld.setSurname(tfSurname.getText());
        if (tfDadName.getText() != "") memberOld.setFatherName(tfDadName.getText());
        if (tfBirthCity.getText() != "") memberOld.setBirthCity(tfBirthCity.getText());
        if (!dpBirthDate.getValue().equals(null)) memberOld.setBirthday(dpBirthDate.getValue().toString());
        if (tfPESEL.getText() != "") memberOld.setPesel(tfPESEL.getText());
        if (tfCity.getText() != "") memberOld.setCity(tfCity.getText());
        if (tfHouseNumber.getText() != "") memberOld.setHouseNumber(tfHouseNumber.getText());
        if (tfDocumentNumber.getText() != "") memberOld.setIdCard(tfDocumentNumber.getText());
        if (tfPhone.getText() != "") memberOld.setPhoneNumber(Integer.parseInt(tfPhone.getText()));
        if (!dpJoinDate.getValue().equals(null)) memberOld.setJoinDate(dpJoinDate.getValue().toString());
        memberOld.setIsJOT(chckbJOT.isSelected());
        memberOld.setIsMember(chckbMember.isSelected());
        Function func = (Function) cbFunction.getSelectionModel().getSelectedItem();
        memberOld.setMemberFunction(func.getId());
        memberOld.setSex(cbSex.getSelectionModel().getSelectedIndex()+1);
        MemberDAO.insertMember(memberOld);
        bttnSaveMember.setDisable(true);
    }

    private void checkFieldsIsNotEmpty() {
        if (!(tfName.getLength() > 2 && tfSurname.getLength() > 2 && tfPhone.getLength() > 2)) {
            bttnSaveMember.setDisable(true);
            lblInfo.setText("Pola Imię, Nazwisko, Telefon muszą zostać wypełnione!!!");
        } else {
            bttnSaveMember.setDisable(false);
            lblInfo.setText("");
        }
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        loadDataToComboBox();
        chckbMember.setSelected(true);
        tfName.textProperty().addListener(observable -> checkFieldsIsNotEmpty());
        tfSurname.textProperty().addListener(observable -> checkFieldsIsNotEmpty());
        tfPhone.textProperty().addListener(observable -> checkFieldsIsNotEmpty());
    }

    private void loadDataToComboBox() throws SQLException, ClassNotFoundException {
        final ObservableList<Function> functionObservableList = FunctionDAO.getFunctionList();
        cbFunction.setItems(functionObservableList);
        cbFunction.getSelectionModel().select(0);
        cbSex.getItems().addAll(new String("Mężczyzna"), new String("Kobieta"));
        cbSex.getSelectionModel().select(0);
    }
}
