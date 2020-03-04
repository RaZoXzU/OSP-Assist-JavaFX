package osp.Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Member {
    private SimpleIntegerProperty id, pesel, phoneNumber, isJOT, isMember, memberFunction, sex;
    private SimpleStringProperty firstName, surname, fatherName, birthCity, birthday,
            city, idCard, joinDate, houseNumber;

    public Member() {
    }

    //for test only
    public Member(String firstName, String surname, String city, Integer phoneNumber,
                  String joinDate, Integer isJOT, Integer isMember, Integer memberFunction) {
        this.firstName = new SimpleStringProperty(firstName);
        this.surname = new SimpleStringProperty(surname);
        this.city = new SimpleStringProperty(city);
        this.phoneNumber = new SimpleIntegerProperty(phoneNumber);
        this.joinDate = new SimpleStringProperty(joinDate);
        this.isJOT = new SimpleIntegerProperty(isJOT);
        this.isMember = new SimpleIntegerProperty(isMember);
        this.memberFunction = new SimpleIntegerProperty(memberFunction);
    }

    public Member(Integer id, String firstName, String surname, String fatherName,
                  String birthCity, String birthday, Integer pesel,
                  String city, String houseNumber, String idCard, Integer phoneNumber,
                  String joinDate, Integer isJOT, Integer isMember, Integer memberFunction, Integer sex) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.surname = new SimpleStringProperty(surname);
        this.fatherName = new SimpleStringProperty(fatherName);
        this.birthCity = new SimpleStringProperty(birthCity);
        this.birthday = new SimpleStringProperty(birthday);
        this.pesel = new SimpleIntegerProperty(pesel);
        this.city = new SimpleStringProperty(city);
        this.houseNumber = new SimpleStringProperty(houseNumber);
        this.idCard = new SimpleStringProperty(idCard);
        this.phoneNumber = new SimpleIntegerProperty(phoneNumber);
        this.joinDate = new SimpleStringProperty(joinDate);
        this.isJOT = new SimpleIntegerProperty(isJOT);
        this.isMember = new SimpleIntegerProperty(isMember);
        this.memberFunction = new SimpleIntegerProperty(memberFunction);
        this.sex = new SimpleIntegerProperty(sex);
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) { this.id.set(id); }

    public Integer getPesel() {
        return pesel.get();
    }

    public void setPesel(Integer pesel) { this.pesel.set(pesel); }

    public Integer getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public Integer getIsJOT() {
        return isJOT.get();
    }

    public void setIsJOT(Integer isJOT) {
        this.isJOT.set(isJOT);
    }

    public Integer getIsMember() {
        return isMember.get();
    }

    public void setIsMember(Integer isMember) {
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
