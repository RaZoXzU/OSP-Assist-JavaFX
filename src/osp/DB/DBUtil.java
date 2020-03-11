package osp.DB;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBUtil {
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:OSP_DB.db";
    private static Connection connection;

    public static void createConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
            throw e;
        }

        System.out.println("JDBC Driver Registered!");

        //Establish the Connection using Connection String
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection Failed " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void closeConnection() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static ResultSet executeQuery(String query) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;

        try {
            createConnection();
            System.out.println("Select: " + query + "\n");
            //create statement
            statement = connection.createStatement();
            //execute select
            resultSet = statement.executeQuery(query);

            //CachedRowSet Implementation
            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
            //We are using CachedRowSet
            cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem at executeQuery : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            closeConnection();
        }
        //Return CachedRowSet
        return cachedRowSet;
    }


    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String query) throws SQLException, ClassNotFoundException {
        //Declare statement as null
        Statement statement = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            createConnection();
            //Create Statement
            statement = connection.createStatement();
            //Run executeUpdate operation with given sql statement
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdateQuery : " + e);
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            closeConnection();
        }
    }
}
