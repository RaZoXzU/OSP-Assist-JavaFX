package osp.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import osp.DB.DAO.FunctionDAO;
import osp.DB.DAO.MemberDAO;
import osp.Models.Function;
import osp.Models.Member;

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

        Member member = new Member();
        if (tfName.getText() != "") member.setFirstName(tfName.getText());
        if (tfSurname.getText() != "") member.setSurname(tfSurname.getText());
        if (tfDadName.getText() != "") member.setFatherName(tfDadName.getText());
        if (tfBirthCity.getText() != "") member.setBirthCity(tfBirthCity.getText());
        if (!dpBirthDate.getValue().equals(null)) member.setBirthday(dpBirthDate.getValue().toString());
        if (tfPESEL.getText() != "") member.setPesel(tfPESEL.getText());
        if (tfCity.getText() != "") member.setCity(tfCity.getText());
        if (tfHouseNumber.getText() != "") member.setHouseNumber(tfHouseNumber.getText());
        if (tfDocumentNumber.getText() != "") member.setIdCard(tfDocumentNumber.getText());
        if (tfPhone.getText() != "") member.setPhoneNumber(Integer.parseInt(tfPhone.getText()));
        if (!dpJoinDate.getValue().equals(null)) member.setJoinDate(dpJoinDate.getValue().toString());
        member.setIsJOT(chckbJOT.isSelected());
        member.setIsMember(chckbMember.isSelected());
        Function func = (Function) cbFunction.getSelectionModel().getSelectedItem();
        member.setMemberFunction(func.getId());
        member.setSex(cbSex.getSelectionModel().getSelectedIndex()+1);
        MemberDAO.insertMember(member);
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
