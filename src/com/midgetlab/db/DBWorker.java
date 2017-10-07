package com.midgetlab.db;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBWorker {

    private Connection connection;

    private InitialContext ic;
    private DataSource ds;

    public Connection getConnection() throws SQLException, NamingException {
        ic = new InitialContext();
        ds = (DataSource) ic.lookup("java:comp/env/jdbc/midgetlab");
        return ds.getConnection();
    }
}
