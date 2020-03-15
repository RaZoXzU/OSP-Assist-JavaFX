package osp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import osp.DB.MemberDAO;
import osp.Models.Function;
import osp.Models.Member;

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
        member.setMemberFunction(cbFunction.getSelectionModel().getSelectedIndex());
        member.setSex(cbSex.getSelectionModel().getSelectedIndex());
        MemberDAO.insertMember(member);
    }

    private void checkFieldsIsNotEmpty() {
        bttnSaveMember.setDisable(!(tfName.getLength() > 2 && tfSurname.getLength() > 2 && tfPhone.getLength() > 2));
    }

    public void initialize() {
        loadDataToComboBox();
        chckbMember.setSelected(true);
        //checkFieldsIsNotEmpty();
        bttnSaveMember.setDisable(false);
    }

    private void loadDataToComboBox() {
        final ObservableList<Function> functionObservableList = FXCollections.observableArrayList(
                new Function(0, "Strażak"),
                new Function(1, "Starszy Strażak"),
                new Function(2, "Dowódca roty"),
                new Function(3, "Pomocnik dowódcy sekcji"),
                new Function(4, "Dowódca sekcji"),
                new Function(5, "Pomocnik dowódcy plutonu"),
                new Function(6, "Dowódca plutonu"),
                new Function(7, "Członek komisji rewizyjnej"),
                new Function(8, "Przewodniczący komisji rewizyjnej"),
                new Function(9, "Członek zarządu"),
                new Function(10, "Zastępca naczelnika"),
                new Function(11, "Naczelnik"),
                new Function(12, "Wiceprezes"),
                new Function(13, "Prezes")
        );
        cbFunction.setItems(functionObservableList);
        cbFunction.getSelectionModel().select(0);

        cbSex.getItems().addAll(new String("Mężczyzna"), new String("Kobieta"));
        cbSex.getSelectionModel().select(0);
    }
}
