package osp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

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
    public void initialize(){
        List<String> rankList = new ArrayList<>();
        rankList.add("Strażak");
        rankList.add("Starszy strażak");
        rankList.add("Dowódca roty");
        rankList.add("Pomocnik dowódcy sekcji");
        rankList.add("Dowódca sekcji");
        rankList.add("Pomocnik dowódcy plutonu");
        rankList.add("Dowódca plutonu");

        List<String> functionList = new ArrayList<>();
        functionList.add("Członek zarządu");
        functionList.add("Zastępca naczelnika");
        functionList.add("Naczelnik");
        functionList.add("Wiceprezes");
        functionList.add("Prezes");
        functionList.add("Członek komisji rewizyjnej");
        functionList.add("Przewodniczący komisji rewizyjnej");

        cbSex.getItems().addAll(new String("Mężczyzna"), new String("Kobieta"));
        cbFunction.getItems().addAll(functionList);
        cbRank.getItems().addAll(rankList);

    }

}
