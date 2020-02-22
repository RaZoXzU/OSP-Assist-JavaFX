package osp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import osp.controllers.items.MemberRowItemController;

import java.io.IOException;

public class MembersFormController {

    @FXML
    private VBox listMembers = null;

    public void addMembers(){
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {
                nodes[i] = FXMLLoader.load(getClass().getResource("/osp/fxml/items/memberRowItem.fxml"));
                listMembers.getChildren().add(nodes[i]);
                System.out.println();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onBackClicked(){
        listMembers.getChildren().clear();
    }
}
