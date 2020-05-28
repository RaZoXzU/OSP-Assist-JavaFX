package osp.Models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Actions")
public class Action {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String regNumber;
    private LocalDateTime dateStart;
    private LocalDateTime dateStop;
    private Integer type;
    private String title;
    private String address;
    private String caption;
    @ManyToMany
    private List<Member> firefighters;

    public Action() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateStop() {
        return dateStop;
    }

    public void setDateStop(LocalDateTime dateStop) {
        this.dateStop = dateStop;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<Member> getFirefighters() {
        return firefighters;
    }

    public void setFirefighters(List<Member> firefighters) {
        this.firefighters = firefighters;
    }

    @Override
    public String toString(){
        return("ID: "+id+
                "\nNumer: "+regNumber+
                "\nNazwa: "+title+
                "\nTyp: "+type+
                "\nAdres: "+address+
                "\nUwagi: " +caption+
                "\nStart: "+dateStart+
                "\nStop: "+dateStop+
                "\nKod: "+regNumber);
    }
}
