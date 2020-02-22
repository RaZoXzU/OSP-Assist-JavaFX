package osp.controllers.items;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MemberRowItemController {

    @FXML
    private Label lblName;
    @FXML
    private Label lblSurname;
    @FXML
    private Label lblCity;
    @FXML
    private Label lblFunction;

    public void setLblName(Label lblName) {
        this.lblName = lblName;
    }

    public void setLblSurname(Label lblSurname) {
        this.lblSurname = lblSurname;
    }

    public void setLblCity(Label lblCity) {
        this.lblCity = lblCity;
    }

    public void setLblFunction(Label lblFunction) {
        this.lblFunction = lblFunction;
    }

    public void setLblRank(Label lblRank) {
        this.lblRank = lblRank;
    }

    @FXML
    private Label lblRank;

    @FXML
    private void onEditClicked(){
        lblName.setText("Roman");
        lblSurname.setText("Kowalski");
        lblCity.setText("Warszawa");
        lblFunction.setText("Członek zwyczajny");
        lblRank.setText("Strażak");
    }

}
