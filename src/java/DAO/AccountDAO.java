/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Account;
import Model.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class AccountDAO {

    private static final String BASE_SQL
            = "SELECT p.profile_id, p.image, p.full_name, p.phone, \n"
            + "p.dob, p.gender, p.address, p.email, p.created_at, \n"
            + "p.updated_at, a.account_id, a.username, a.password, \n"
            + "a.role_id,  a.is_active, r.role_name\n"
            + "FROM Account a\n"
            + "INNER JOIN Profile p ON a.profile_id = p.profile_id\n"
            + "INNER JOIN Role r on a.role_id = r.role_id";

    public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }

    public ArrayList<Account> getAllAccount() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL;
        ArrayList<Account> listAccount = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setAccountID(rs.getInt("account_id"));
                acc.setUsername(rs.getString("username"));
                Role role = new Role();
                role.setRoleID(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
                acc.setRole(role);
                acc.setProfileID(rs.getInt("profile_id"));
                acc.setImage(rs.getString("image"));
                acc.setFullname(rs.getString("full_name"));
                acc.setPhone(rs.getString("phone"));
                acc.setDOB(rs.getDate("dob"));
                acc.setGender(rs.getBoolean("gender"));
                acc.setAddress(rs.getString("address"));
                acc.setEmail(rs.getString("email"));
                acc.setCreatedAt(rs.getDate("created_at"));
                acc.setUpdatedAt(rs.getDate("updated_at"));
                acc.setIsActive(rs.getBoolean("is_active"));
                listAccount.add(acc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listAccount;
    }

    public Account getAccountByID(int id) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE a.acount_id = " + id;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setAccountID(rs.getInt("account_id"));
                acc.setUsername(rs.getString("username"));
                Role role = new Role();
                role.setRoleID(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
                acc.setRole(role);
                acc.setProfileID(rs.getInt("profile_id"));
                acc.setImage(rs.getString("image"));
                acc.setFullname(rs.getString("full_name"));
                acc.setPhone(rs.getString("phone"));
                acc.setDOB(rs.getDate("dob"));
                acc.setGender(rs.getBoolean("gender"));
                acc.setAddress(rs.getString("address"));
                acc.setEmail(rs.getString("email"));
                acc.setCreatedAt(rs.getDate("created_at"));
                acc.setUpdatedAt(rs.getDate("updated_at"));
                acc.setIsActive(rs.getBoolean("is_active"));
                return acc;
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public int updateAccount(Account account) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "UPDATE Account  \n"
                + "SET  Account.username = ?  , Account.role_id = ? \n"
                + " WHERE Account.account_id = ?\n"
                + "\n"
                + "UPDATE Profile \n"
                + "set  Profile.email = ?,profile.updated_at = ?\n"
                + "FROM Profile  INNER JOIN Account  on Account.profile_id = Profile.profile_id\n"
                + " WHERE Account.account_id = ?";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setInt(2, account.getRole().getRoleID());
            ps.setInt(3, account.getAccountID());
            ps.setString(4, account.getEmail());
            ps.setDate(5, getCurrentSQLDate());
            ps.setInt(6, account.getAccountID());
            result = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;

    }

    public Account getAccountByUsernameAndPassword(String username, String password) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE a.username = '" + username + "'\n"
                + "AND a.password = '" + password + "'";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                Account acc = new Account();
                acc.setAccountID(rs.getInt("account_id"));
                acc.setUsername(rs.getString("username"));
                Role role = new Role();
                role.setRoleID(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
                acc.setRole(role);
                acc.setProfileID(rs.getInt("profile_id"));
                acc.setImage(rs.getString("image"));
                acc.setFullname(rs.getString("full_name"));
                acc.setPhone(rs.getString("phone"));
                acc.setDOB(rs.getDate("dob"));
                acc.setGender(rs.getBoolean("gender"));
                acc.setAddress(rs.getString("address"));
                acc.setEmail(rs.getString("email"));
                acc.setCreatedAt(rs.getDate("created_at"));
                acc.setUpdatedAt(rs.getDate("updated_at"));
                acc.setIsActive(rs.getBoolean("is_active"));
                return acc;
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
