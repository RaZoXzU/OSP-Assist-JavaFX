package osp.DB.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import osp.DB.DBUtil;
import osp.Models.Function;
import osp.Models.Member;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FunctionDAO {

    private static Function getFunctionFromResult(ResultSet resultSet) throws SQLException {
        Function function = null;
        if (resultSet.next()) {
            function = new Function();
            function.setId(resultSet.getInt("ID"));
            function.setName(resultSet.getString("NAME"));
        }
        return function;
    }

    private static ObservableList<Function> getFunctionListFromResult(ResultSet resultSet) throws SQLException {
        ObservableList<Function> functionList = FXCollections.observableArrayList();
        while (resultSet.next()){
            Function function = new Function();
            function.setId(resultSet.getInt("ID"));
            function.setName(resultSet.getString("NAME"));
            functionList.add(function);
        }
        return functionList;
    }

    public static ObservableList<Function> getFunctionList() throws ClassNotFoundException, SQLException {
        String statement = "SELECT * FROM T_FUNCTION_NAMES";
        try {
            ResultSet resultSet = DBUtil.executeQuery(statement);
            ObservableList<Function> functionsList = getFunctionListFromResult(resultSet);
            return functionsList;
        } catch (SQLException e) {
            System.out.println("SQL select failed: "+e);
            throw e;
        }
    }
}
