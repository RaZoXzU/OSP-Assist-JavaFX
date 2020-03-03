package osp.Models;

public class Member {
    private Integer id, pesel, phoneNumber, isJOT, isMember, memberFunction, sex;
    private String name, surname, fatherName, birthCity, birthday,
            city, idCard, joinDate, houseNumber;

    public Member(){}
    public Member(Integer id, String name, String surname, String fatherName,
                  String birthCity, String birthday, Integer pesel,
                  String city, String houseNumber, String idCard, Integer phoneNumber,
                  String joinDate, Integer isJOT, Integer isMember, Integer memberFunction, Integer sex){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.birthCity = birthCity;
        this.birthday = birthday;
        this.pesel=pesel;
        this.city = city;
        this.houseNumber = houseNumber;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.joinDate = joinDate;
        this.isJOT=isJOT;
        this.isMember=isMember;
        this.memberFunction = memberFunction;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        this.pesel = pesel;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getIsJOT() {
        return isJOT;
    }

    public void setIsJOT(Integer isJOT) {
        this.isJOT = isJOT;
    }

    public Integer getIsMember() {
        return isMember;
    }

    public void setIsMember(Integer isMember) {
        this.isMember = isMember;
    }

    public Integer getMemberFunction() {
        return memberFunction;
    }

    public void setMemberFunction(Integer memberFunction) {
        this.memberFunction = memberFunction;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
