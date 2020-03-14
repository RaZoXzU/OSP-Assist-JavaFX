package osp.DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import osp.Models.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    //Select Member
    public static Member searchMember(String idMember) throws SQLException, ClassNotFoundException {
        String statement = "SELECT * FROM T_MEMBERS WHERE ID=" + idMember;
        //Execute
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet resultSetMember = DBUtil.executeQuery(statement);
            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Member member = getMemberFromResultSet(resultSetMember);
            return member;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + idMember + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Member getMemberFromResultSet(ResultSet resultSet) throws SQLException {
        Member member = null;
        if (resultSet.next()) {
            member = new Member();
            member.setId(resultSet.getInt("ID"));
            member.setFirstName(resultSet.getString("Imie"));
            member.setSurname(resultSet.getString("Nazwisko"));
            member.setFatherName(resultSet.getString("ImieOjca"));
            member.setBirthCity(resultSet.getString("MiejsceUrodzenia"));
            member.setBirthday(resultSet.getString("DataUrodzenia"));
            member.setPesel(resultSet.getString("PESEL"));
            member.setCity(resultSet.getString("Miejscowosc"));
            member.setHouseNumber(resultSet.getString("NrDomu"));
            member.setIdCard(resultSet.getString("Dowod"));
            member.setPhoneNumber(resultSet.getInt("Telefon"));
            member.setJoinDate(resultSet.getString("DataWstapienia"));
            member.setIsJOT(resultSet.getInt("JOT"));
            member.setIsMember(resultSet.getInt("Czlonek"));
            member.setMemberFunction(resultSet.getInt("Funkcja"));
            member.setSex(resultSet.getInt("Plec"));
        }
        return member;
    }

    //*******************************
    //SELECT Members
    //*******************************

    public static ObservableList<Member> searchMembers() throws SQLException, ClassNotFoundException {
        String selectStatement = "SELECT * FROM T_MEMBERS";
        try {
            ResultSet resultSetMembers = DBUtil.executeQuery(selectStatement);
            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Member> membersList = getMembersList(resultSetMembers);
            return membersList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from employees operation
    private static ObservableList<Member> getMembersList(ResultSet resultSetMembers) throws SQLException {
        ObservableList<Member> membersList = FXCollections.observableArrayList();
        while (resultSetMembers.next()) {
            Member member = new Member();
            member.setId(resultSetMembers.getInt("ID"));
            member.setFirstName(resultSetMembers.getString("Imie"));
            member.setSurname(resultSetMembers.getString("Nazwisko"));
            member.setFatherName(resultSetMembers.getString("ImieOjca"));
            member.setBirthCity(resultSetMembers.getString("MiejsceUrodzenia"));
            member.setBirthday(resultSetMembers.getString("DataUrodzenia"));
            member.setPesel(resultSetMembers.getString("PESEL"));
            member.setCity(resultSetMembers.getString("Miejscowosc"));
            member.setHouseNumber(resultSetMembers.getString("NrDomu"));
            member.setIdCard(resultSetMembers.getString("Dowod"));
            member.setPhoneNumber(resultSetMembers.getInt("Telefon"));
            member.setJoinDate(resultSetMembers.getString("DataWstapienia"));
            member.setIsJOT(resultSetMembers.getInt("JOT"));
            member.setIsMember(resultSetMembers.getInt("Czlonek"));
            member.setMemberFunction(resultSetMembers.getInt("Funkcja"));
            member.setSex(resultSetMembers.getInt("Plec"));

            membersList.add(member);
        }
        return membersList;
    }

    //UPDATE member city

    public static void updateMemberCity(String memberID, String city) throws SQLException, ClassNotFoundException {
        String updateStatement ="UPDATE T_MEMBERS\n" +
                " SET Miejscowosc = '" + city + "'\n" +
                " WHERE ID = " + memberID + ";";
        try{
            DBUtil.dbExecuteUpdate(updateStatement);
        }catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    //delete member
    public static void deleteMember(String memberID) throws SQLException, ClassNotFoundException {
        String updateStatement ="DELETE FROM T_MEMBERS WHERE ID =" + memberID + ";";
        try{
            DBUtil.dbExecuteUpdate(updateStatement);
        }catch (SQLException e) {
            System.out.print("Error occurred while Delete Operation: " + e);
            throw e;
        }
    }

    public static void insertMember(Member member) throws ClassNotFoundException {
        String insertStatement = "INSERT INTO T_MEMBERS VALUES (NULL,\n" +
                "'" + member.getFirstName() + "', '" + member.getSurname() + "', '" + member.getFatherName() + "', " +
                "'" + member.getBirthCity() + "', '" + member.getBirthday() + "', '" + member.getPesel() + "', " +
                "'" + member.getCity() + "', '" + member.getHouseNumber() + "', '" + member.getIdCard() + "', " +
                "'" + member.getPhoneNumber() + "', '" + member.getJoinDate() + "', '" + member.getIsJOT() + "', " +
                "'" + member.getIsMember() + "', '" + member.getMemberFunction() + "', '" + member.getSex() + "'";
        try {
            DBUtil.dbExecuteUpdate(insertStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
}