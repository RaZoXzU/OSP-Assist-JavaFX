package osp.DB.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import osp.DB.DBUtil;
import osp.Models.MemberOld;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    //Select MemberOld by ID
    public static MemberOld searchMember(String idMember) throws SQLException, ClassNotFoundException {
        String statement = "SELECT * FROM T_MEMBERS WHERE ID=" + idMember;
        //Execute
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet resultSetMember = DBUtil.executeQuery(statement);
            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            MemberOld memberOld = getMemberFromResultSet(resultSetMember);
            return memberOld;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + idMember + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static MemberOld getMemberFromResultSet(ResultSet resultSet) throws SQLException {
        MemberOld memberOld = null;
        if (resultSet.next()) {
            memberOld = new MemberOld();
            memberOld.setId(resultSet.getInt("ID"));
            memberOld.setFirstName(resultSet.getString("Imie"));
            memberOld.setSurname(resultSet.getString("Nazwisko"));
            memberOld.setFatherName(resultSet.getString("ImieOjca"));
            memberOld.setBirthCity(resultSet.getString("MiejsceUrodzenia"));
            memberOld.setBirthday(resultSet.getString("DataUrodzenia"));
            memberOld.setPesel(resultSet.getString("PESEL"));
            memberOld.setCity(resultSet.getString("Miejscowosc"));
            memberOld.setHouseNumber(resultSet.getString("NrDomu"));
            memberOld.setIdCard(resultSet.getString("Dowod"));
            memberOld.setPhoneNumber(resultSet.getInt("Telefon"));
            memberOld.setJoinDate(resultSet.getString("DataWstapienia"));
            memberOld.setIsJOT(resultSet.getBoolean("JOT"));
            memberOld.setIsMember(resultSet.getBoolean("Czlonek"));
            memberOld.setMemberFunction(resultSet.getInt("Funkcja"));
            memberOld.setSex(resultSet.getInt("Plec"));
        }
        return memberOld;
    }

    //select all members
    public static ObservableList<MemberOld> searchMembers() throws SQLException, ClassNotFoundException {
        String selectStatement = "SELECT * FROM T_MEMBERS";
        try {
            ResultSet resultSetMembers = DBUtil.executeQuery(selectStatement);
            ObservableList<MemberOld> membersList = getMembersList(resultSetMembers);
            return membersList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //return memberlist from result
    private static ObservableList<MemberOld> getMembersList(ResultSet resultSetMembers) throws SQLException {
        ObservableList<MemberOld> membersList = FXCollections.observableArrayList();
        while (resultSetMembers.next()) {
            MemberOld memberOld = new MemberOld();
            memberOld.setId(resultSetMembers.getInt("ID"));
            memberOld.setFirstName(resultSetMembers.getString("Imie"));
            memberOld.setSurname(resultSetMembers.getString("Nazwisko"));
            memberOld.setFatherName(resultSetMembers.getString("ImieOjca"));
            memberOld.setBirthCity(resultSetMembers.getString("MiejsceUrodzenia"));
            memberOld.setBirthday(resultSetMembers.getString("DataUrodzenia"));
            memberOld.setPesel(resultSetMembers.getString("PESEL"));
            memberOld.setCity(resultSetMembers.getString("Miejscowosc"));
            memberOld.setHouseNumber(resultSetMembers.getString("NrDomu"));
            memberOld.setIdCard(resultSetMembers.getString("Dowod"));
            memberOld.setPhoneNumber(resultSetMembers.getInt("Telefon"));
            memberOld.setJoinDate(resultSetMembers.getString("DataWstapienia"));
            memberOld.setIsJOT(Boolean.parseBoolean(resultSetMembers.getString("JOT")));
            memberOld.setIsMember(Boolean.parseBoolean(resultSetMembers.getString("Czlonek")));
            memberOld.setMemberFunction(resultSetMembers.getInt("Funkcja"));
            memberOld.setSex(resultSetMembers.getInt("Plec"));
            membersList.add(memberOld);
        }
        return membersList;
    }

    //UPDATE member city
    public static void updateMemberCity(String memberID, String city) throws SQLException, ClassNotFoundException {
        String updateStatement = "UPDATE T_MEMBERS\n" +
                " SET Miejscowosc = '" + city + "'\n" +
                " WHERE ID = " + memberID + ";";
        try {
            DBUtil.dbExecuteUpdate(updateStatement);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    //delete member
    public static void deleteMember(String memberID) throws SQLException, ClassNotFoundException {
        String updateStatement = "DELETE FROM T_MEMBERS WHERE ID =" + memberID + ";";
        try {
            DBUtil.dbExecuteUpdate(updateStatement);
        } catch (SQLException e) {
            System.out.print("Error occurred while Delete Operation: " + e);
            throw e;
        }
    }

    //insert memberOld
    public static void insertMember(MemberOld memberOld) throws ClassNotFoundException {
        String insertStatement = "INSERT INTO T_MEMBERS VALUES (NULL,\n" +
                "'" + memberOld.getFirstName() + "', '" + memberOld.getSurname() + "', '" + memberOld.getFatherName() + "', \n" +
                "'" + memberOld.getBirthCity() + "', '" + memberOld.getBirthday() + "', '" + memberOld.getPesel() + "', \n" +
                "'" + memberOld.getCity() + "', '" + memberOld.getHouseNumber() + "', '" + memberOld.getIdCard() + "', \n" +
                "'" + memberOld.getPhoneNumber() + "', '" + memberOld.getJoinDate() + "', '" + memberOld.getIsJOT() + "', \n" +
                "'" + memberOld.getIsMember() + "', '" + memberOld.getMemberFunction() + "', '" + memberOld.getSex() + "');";
        System.out.println(insertStatement);
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