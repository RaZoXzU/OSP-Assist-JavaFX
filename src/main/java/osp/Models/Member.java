package osp.Models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Members")
public class Member {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String birthCity;
    private LocalDateTime birthday;
    @Column(unique = true)
    private String pesel;
    private String adress;
    private String idCardNumber;
    private Integer phoneNumber;
    private LocalDateTime joinDate;
    private Boolean isJOT;
    private Boolean isMember;
    private Boolean isMan;

    @OneToMany(mappedBy = "idMember")
    private List<MembersFunctions>membersFunctions;

    public Member(){ }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public Boolean getJOT() {
        return isJOT;
    }

    public void setJOT(Boolean JOT) {
        isJOT = JOT;
    }

    public Boolean getMember() {
        return isMember;
    }

    public void setMember(Boolean member) {
        isMember = member;
    }

    public Boolean getMan() {
        return isMan;
    }

    public void setMan(Boolean man) {
        isMan = man;
    }

    @Override
    public String toString(){
        return ("ID: "+id+
                "\nImie: "+firstName+
                "\nNazwisko: "+lastName+
                "\nImieOjca: "+fatherName+
                "\nMiejsceUrodzenia: "+ birthCity+
                "\nDataUrodzenia: "+birthday+
                "\nPESEL: "+pesel+
                "\nAdres: "+adress+
                "\nNumer dowodu: "+idCardNumber+
                "\nTelefon: "+phoneNumber+
                "\nDataWstapienia: "+joinDate+
                "\nJOT: "+isJOT+
                "\nCzlonek: "+isMember+
                "\nPlec: "+isMan);
    }
}