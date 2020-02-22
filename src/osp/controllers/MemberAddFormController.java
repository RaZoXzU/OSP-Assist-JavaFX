package osp.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class MemberAddFormController {

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
    ComboBox cbRank;
    @FXML
    ComboBox cbSex;
    @FXML
    CheckBox chckbJOT;
    @FXML
    CheckBox chckbMember;

    public void onSaveMemberClicked(){
        System.out.println("Imie: "+tfName.getText());
        System.out.println("Nazwisko: "+tfSurname.getText());
        System.out.println("Imię ojca: "+tfDadName.getText());
        System.out.println("Miejscowość: "+tfCity.getText());
        System.out.println("Numer domu: "+tfHouseNumber.getText());
        System.out.println("PESEL: "+tfPESEL.getText());
        System.out.println("Data urodzenia: "+dpBirthDate.getValue());
        System.out.println("Miejsce urodzenia: "+tfBirthCity.getText());
        System.out.println("Dokument: "+tfDocumentNumber.getText());
        System.out.println("Telefon: "+tfPhone.getText());
        System.out.println("Data wstąpienia: "+dpJoinDate.getValue());
        System.out.println("Funkcja: "+cbFunction.toString());
        System.out.println("Stopień: "+cbRank.toString());
        System.out.println("Płeć: "+cbSex.toString());
        System.out.println("JOT: "+chckbJOT.getText());
        System.out.println("Członek: "+chckbMember.getText());
        
    }

}
