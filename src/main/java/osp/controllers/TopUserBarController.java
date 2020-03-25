package osp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TopUserBarController {

    @FXML
    Label lblName;

    @FXML
    Label lblFunction;

    @FXML
    Label lblDate;

    public void initialize(){
        setLblDate();
        setLblFunction();
        setLblName();
    }

    public void setLblName() {
        this.lblName.setText("Łukasz");
    }

    public void setLblFunction() {
        this.lblFunction.setText("Przew. Komisji Rewizyjnej");
    }

    public void setLblDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE dd.MM.yyyy");
        this.lblDate.setText(date.format(dtf));
    }
}
