package com.midgetlab.test;

import com.midgetlab.db.DBWorker;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static DBWorker dbWorker = new DBWorker();
    private static String user = "admin";
    private static String password = "admin";

    public static void main(String[] args) throws NamingException {

        String query = "select * from users where username='" + user + "'" + "and password='" + password + "'" ;

        try {
            Statement statement = dbWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String username = "username: " + resultSet.getString(2) + " Password: " + resultSet.getString(3);
                System.out.println(username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
