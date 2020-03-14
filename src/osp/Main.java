package osp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import osp.Models.Member;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/mainForm.fxml"));
        primaryStage.setTitle("OSP Assist");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        Member member = new Member();
        String insertStatement = "INSERT INTO T_MEMBERS VALUES (NULL,\n"+
                "'"+member.getFirstName()+"', '"+member.getSurname()+"', '"+member.getFatherName()+"', " +
                "'"+member.getBirthCity()+"', '"+member.getBirthday()+"', '"+member.getPesel()+"', "+
                "'"+member.getCity()+"', '"+member.getHouseNumber()+"', '"+member.getIdCard()+"', "+
                "'"+member.getPhoneNumber()+"', '"+member.getJoinDate()+"', '"+member.getIsJOT()+"', "+
                "'"+member.getIsMember()+"', '"+member.getMemberFunction()+"', '"+member.getSex()+"'";
        System.out.println(insertStatement);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
