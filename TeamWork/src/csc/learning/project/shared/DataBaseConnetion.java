package csc.learning.project.shared;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by cchandragiri on 4/12/2017.
 */
public class DataBaseConnetion {

    Connection connection = null;
    Statement statement = null;
    String UserName = "postgres";
    String Password ="1234";


    public void createStatement() {
        System.out.println("Creating statement...");
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Unable to create Statement");
        }
    }


    public void createConnection(String UserName, String Password) {
        System.out.println("Working on Connecting to DB");
        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;
        }
        System.out.println("PostgreSQL JDBC Driver Registered!");
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", this.UserName,this.Password);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        createStatement();
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Execured SQL Query");
        }
        return rs;
    }

    public Collection resultSetToArrayList(String sql_query) throws SQLException {
        ResultSet rs = executeQuery(sql_query);
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        HashMap row = new HashMap(columns);
        ArrayList list = new ArrayList(50);
        try {
            while (rs.next()) {
                for (int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(row);
            }
        } catch (SQLException e) {

        }
        closeResutlSet(rs);
        closeConnection();
        return row.values();
    }

    private void closeResutlSet(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException s) {
            System.out.println("Closed Result Set");
        }
    }

    private void closeConnection() {
        try {
            if (statement != null)
                connection.close();
        } catch (SQLException e) {
            System.out.println("Problem while conneting to Connetion");
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }


    public void update_table(String table_name, String coulmn_to_update, int value_to_update, String coulmn_to_validate, int value_to_validate)
    {
        String query = "update "+table_name + " set "+ coulmn_to_update +" = " +value_to_update + " where " + coulmn_to_validate + " = " + value_to_validate;
        System.out.println("Query Prepared " + query);
        try {
            executeQuery(query);
        }catch (Exception se){
            System.out.println("Unable to update table as mentioned");
        }

    }










}
