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
    private static final String BASE_SQL= "Select  p.email, p.created_at, p.updated_at, a.account_id, a.username, a.role_id,  a.is_active, r.role_name "
	            + "from ((account a inner join profile p on a.profile_id = p.profile_id) inner join role r on a.role_id = r.role_id) ";
     
     public ArrayList <Account> getAllAccount(){
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
            while(rs.next()){
                Account a = new Account();
                a.setAccountID(rs.getInt("account_id"));
                a.setUsername(rs.getString("username"));
                a.setEmail(rs.getString("email"));
                
                Role role= new Role();
                String role_name= rs.getString("role_name");
                role.setRoleName(role_name);                
                a.setRole(role);
                
                a.setIsActive(rs.getBoolean("is_active"));
                a.setCreatedAt(rs.getDate("created_at"));
                a.setUpdatedAt(rs.getDate("updated_at"));
                
                listAccount.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }//finally{
//            try {
//                db.closeConnection(con, ps, rs);
//            } catch (SQLException ex) {
//                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
        //}
        return listAccount;
    }

    public Account getAccountByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }

    public int updateAccount(Account account) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "UPDATE account  \n"
                + "SET  account.username = ?  , account.role_id = ? \n"
                + " WHERE account.account_id = ?\n"
                + "\n"
                + "update profile \n"
                + "set  profile.email = ?,profile.updated_at = ?\n"
                + "FROM profile  INNER JOIN account  on account.profile_id=profile.profile_id\n"
                + " WHERE account.account_id = ?";
        try{
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            Role role = new Role();
            ps.setString(1, account.getUsername());
            ps.setInt(2, account.getRole().getRoleID());
            ps.setInt(3, account.getAccountID());
            ps.setString(4, account.getEmail());
            ps.setDate(5, getCurrentSQLDate());
            ps.setInt(6, account.getAccountID());
             result = ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }//finally {
//            db.closeConnection(con, ps, rs);
        //}
        return result;

    }
}
