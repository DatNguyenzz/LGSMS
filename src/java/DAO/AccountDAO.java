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
            = "SELECT p.profile_id, p.image_id, p.full_name, p.phone, \n"
            + "p.dob, p.gender, p.address, p.email, p.created_at, \n"
            + "p.updated_at, a.account_id, a.username, a.password, \n"
            + "a.role_id,  a.is_active, r.role_name, \n"
            + "i.image_path, i.image_name\n"
            + "FROM Account a\n"
            + "INNER JOIN Profile p ON a.profile_id = p.profile_id\n"
            + "INNER JOIN Role r on a.role_id = r.role_id\n"
            + "INNER JOIN Image i ON i.image_id = p.image_id\n";

    public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }

    //Get list all account
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
                acc.setImagePath(rs.getString("image_path"));
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

    //Get account by id
    public Account getAccountByID(int id) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE a.account_id = " + id;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setAccountID(rs.getInt("account_id"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                Role role = new Role();
                role.setRoleID(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
                acc.setRole(role);
                acc.setProfileID(rs.getInt("profile_id"));
                acc.setImagePath(rs.getString("image_path"));
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

    //Update account information
    public int updateAccount(Account account) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "BEGIN TRANSACTION;\n"
                + "UPDATE Account\n"
                + "SET username = '" + account.getUsername() + "',\n"
                + "role_id = " + account.getRole().getRoleID() + "\n"
                + "WHERE account_id = " + account.getAccountID() + ";\n"
                + "\n"
                + "UPDATE Profile\n"
                + "SET full_name = N'" + account.getFullname() + "',\n"
                + "phone = '" + account.getPhone() + "',\n"
                + "dob = '" + account.getDOB() + "',\n"
                + "gender = " + (account.isGender() ? 1 : 0) + ",\n"
                + "address = N'" + account.getAddress() + "',\n"
                + "email = '" + account.getEmail() + "',\n"
                + "updated_at = '" + getCurrentSQLDate() + "'\n"
                + "FROM Profile p, Account a\n"
                + "WHERE p.profile_id = a.profile_id\n"
                + "AND a.account_id = " + account.getAccountID() + ";\n"
                + "COMMIT;";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
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

    //Add new account
    public int addNewAccount(Account acc) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "INSERT INTO Profile (full_name, phone, dob, \n"
                + "gender, address, email, created_at)\n"
                + "VALUES(N'" + acc.getFullname() + "', \n"
                + "'" + acc.getPhone() + "', \n"
                + "'" + acc.getDOB() + "', \n"
                + "'" + (acc.isGender() ? 1 : 0) + "',\n"
                + "N'" + acc.getAddress() + "', \n"
                + "'" + acc.getEmail() + "', \n"
                + "'" + getCurrentSQLDate() + "');\n"
                + "INSERT INTO Account(username, password, role_id, profile_id, is_active)\n"
                + "VALUES('" + acc.getUsername() + "', "
                + "'" + acc.getPassword() + "', " + acc.getRole().getRoleID() + ", \n"
                + "(\n"
                + "	SELECT p.profile_id FROM Profile p\n"
                + "	WHERE p.full_name = N'" + acc.getFullname() + "'\n"
                + "	AND p.phone = '" + acc.getPhone() + "'\n"
                + "	AND p.dob = '" + acc.getDOB() + "'\n"
                + "	AND p.address = N'" + acc.getAddress() + "'\n"
                + "	AND p.email = '" + acc.getEmail() + "'\n"
                + "	AND p.created_at = '" + getCurrentSQLDate() + "'\n"
                + "), 1)";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
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
    
    //Register
    public int register(Account acc) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "INSERT INTO Profile ( \n"
                + " email,image_id, created_at)\n"
                + "VALUES( \n"
                + "'" + acc.getEmail() + "', \n"
                + 1 + ", \n"
                + "'" + getCurrentSQLDate() + "');\n"
                + "INSERT INTO Account(username, password, role_id, profile_id, is_active)\n"
                + "VALUES('" + acc.getUsername() + "', "
                + "'" + acc.getPassword() + "', " + acc.getRole().getRoleID() + ", \n"
                + "(\n"
                + "	SELECT p.profile_id FROM Profile p\n"
                + "	WHERE \n"
                + "	 p.email = '" + acc.getEmail() + "'\n"
                + "), 1)";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
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

    //Login 
    public Account getAccountByUsernameAndPassword(String username, String password) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE a.username = '" + username + "'\n"
                + "AND a.password = '" + password + "'\n"
                + "AND a.is_active = 1";
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
                acc.setImagePath(rs.getString("image_path"));
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

    //Get list all role
    public ArrayList<Role> getAllRole() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Role";
        ArrayList<Role> listRole = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setRoleID(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
                listRole.add(role);
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
        return listRole;
    }

    //Get account by username
    public Account getAccountByUsername(String username) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE a.username = '" + username + "'";
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
                acc.setImagePath(rs.getString("image_path"));
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
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account getAccountByEmail(String email) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE p.email = '" + email + "'";
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
                acc.setImagePath(rs.getString("image_path"));
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
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //forgotPassword
    public int updatePass(String email, String password) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "UPDATE Account\n"
                + "SET password = '" + password + "'\n"
                + "FROM Account a\n"
                + "INNER JOIN Profile p ON a.profile_id = p.profile_id\n"
                + "WHERE \n"
                + " p.email ='" + email + "'";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
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

    // kiểm tra email có tồn tại ko
    public boolean isEmailExist(String email) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE p.email = '" + email + "'\n"
                + "AND a.is_active = 1";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                return false;
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
        return true;
    }
    
     // kiểm tra username có tồn tại ko
    public boolean isUserNameExist(String userName) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE a.username = '" + userName + "'\n"
                + "AND a.is_active = 1";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                return false;
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
        return true;
    }

    //Update account information
    public int updateAccountPassword(int id, String password) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "UPDATE Account\n"
                + "SET password = '" + password + "'\n"
                + "WHERE account_id = " + id;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
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
}
