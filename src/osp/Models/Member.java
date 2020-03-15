package osp.Models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Member {
    private SimpleIntegerProperty id, phoneNumber, memberFunction, sex;
    private SimpleStringProperty firstName, surname, fatherName, birthCity, birthday,
            city, idCard, joinDate, houseNumber, pesel;
    private SimpleBooleanProperty isJOT, isMember;

    public Member() {
        this.id = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.surname = new SimpleStringProperty();
        this.fatherName = new SimpleStringProperty();
        this.birthCity = new SimpleStringProperty();
        this.birthday = new SimpleStringProperty();
        this.pesel = new SimpleStringProperty();
        this.city = new SimpleStringProperty();
        this.houseNumber = new SimpleStringProperty();
        this.idCard = new SimpleStringProperty();
        this.phoneNumber = new SimpleIntegerProperty();
        this.joinDate = new SimpleStringProperty();
        this.isJOT = new SimpleBooleanProperty();
        this.isMember = new SimpleBooleanProperty();
        this.memberFunction = new SimpleIntegerProperty();
        this.sex = new SimpleIntegerProperty();
    }

    //for test only
    public Member(String firstName, String surname, String city, Integer phoneNumber,
                  String joinDate, Boolean isJOT, Boolean isMember, Integer memberFunction) {
        this.firstName = new SimpleStringProperty(firstName);
        this.surname = new SimpleStringProperty(surname);
        this.city = new SimpleStringProperty(city);
        this.phoneNumber = new SimpleIntegerProperty(phoneNumber);
        this.joinDate = new SimpleStringProperty(joinDate);
        this.isJOT = new SimpleBooleanProperty(isJOT);
        this.isMember = new SimpleBooleanProperty(isMember);
        this.memberFunction = new SimpleIntegerProperty(memberFunction);
    }

    public Member(Integer id, String firstName, String surname, String fatherName,
                  String birthCity, String birthday, String pesel,
                  String city, String houseNumber, String idCard, Integer phoneNumber,
                  String joinDate, Boolean isJOT, Boolean isMember, Integer memberFunction, Integer sex) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.surname = new SimpleStringProperty(surname);
        this.fatherName = new SimpleStringProperty(fatherName);
        this.birthCity = new SimpleStringProperty(birthCity);
        this.birthday = new SimpleStringProperty(birthday);
        this.pesel = new SimpleStringProperty(pesel);
        this.city = new SimpleStringProperty(city);
        this.houseNumber = new SimpleStringProperty(houseNumber);
        this.idCard = new SimpleStringProperty(idCard);
        this.phoneNumber = new SimpleIntegerProperty(phoneNumber);
        this.joinDate = new SimpleStringProperty(joinDate);
        this.isJOT = new SimpleBooleanProperty(isJOT);
        this.isMember = new SimpleBooleanProperty(isMember);
        this.memberFunction = new SimpleIntegerProperty(memberFunction);
        this.sex = new SimpleIntegerProperty(sex);
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) { this.id.set(id); }

    public String getPesel() {
        return pesel.get();
    }

    public void setPesel(String pesel) { this.pesel.set(pesel); }

    public Integer getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public Boolean getIsJOT() {
        return isJOT.get();
    }

    public void setIsJOT(Boolean isJOT) {
        this.isJOT.set(isJOT);
    }

    public Boolean getIsMember() {
        return isMember.get();
    }

    public void setIsMember(Boolean isMember) {
        this.isMember.set(isMember);
    }

    public Integer getMemberFunction() {
        return memberFunction.get();
    }

    public void setMemberFunction(Integer memberFunction) {
        this.memberFunction.set(memberFunction);
    }

    public Integer getSex() {
        return sex.get();
    }

    public void setSex(Integer sex) {
        this.sex.set(sex);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) { this.firstName.set(firstName); }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getFatherName() {
        return fatherName.get();
    }

    public void setFatherName(String fatherName) {
        this.fatherName.set(fatherName);
    }

    public String getBirthCity() {
        return birthCity.get();
    }

    public void setBirthCity(String birthCity) {
        this.birthCity.set(birthCity);
    }

    public String getBirthday() {
        return birthday.get();
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) { this.city.set(city);}

    public String getIdCard() {
        return idCard.get();
    }

    public void setIdCard(String idCard) {
        this.idCard.set(idCard);
    }

    public String getJoinDate() {
        return joinDate.get();
    }

    public void setJoinDate(String joinDate) { this.joinDate.set(joinDate); }

    public String getHouseNumber() {
        return houseNumber.get();
    }

    public void setHouseNumber(String houseNumber) { this.houseNumber.set(houseNumber); }
}
