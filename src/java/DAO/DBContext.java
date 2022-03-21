/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat Nguyen
 */
public class DBContext {
    public Connection getConnection(){
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userID, password);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    private final String serverName = "localhost";
    private final String dbName = "LGSMS";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "sa";

    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
