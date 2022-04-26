/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Provider;
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
 * @author Dat Nguyen
 */
public class ProviderDAO {
    
     private static final String BASE_SQL="Select p.provider_id, p.provider_name, p.provider_phone, \n"
             + "p.provider_address, p.provider_email, p.is_active, p.provider_created_at, p.provider_updated_at \n"
             + "From Provider p \n";
     
     public ArrayList<Provider> getAllProvider() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL;
        ArrayList<Provider> listProvider = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Provider p = new Provider();
                p.setProviderID(rs.getInt("provider_id"));               
                p.setProviderName(rs.getString("provider_name"));
                p.setProviderPhone(rs.getString("provider_phone"));
                p.setProviderAddress(rs.getString("provider_address"));
                p.setProviderEmail(rs.getString("provider_email"));
                p.setIsActive(rs.getBoolean("is_active"));
                p.setCreatedAt(rs.getDate("provider_created_at"));
                p.setUpdatedAt(rs.getDate("provider_updated_at"));
                
                listProvider.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listProvider;
    }
     
      public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }
     
     
     public int updateProvider(Provider provider) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "UPDATE provider  \n" +
"                SET provider.provider_name =  ?   , provider.provider_phone = ?, \n" +
"                provider.provider_address = ? , provider.provider_email = ? , provider.provider_updated_at=?, provider.is_active=?" +
"                 WHERE provider.provider_id = ? ";
               
        try{
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, provider.getProviderName());
            ps.setString(2, provider.getProviderPhone());
            ps.setString(3, provider.getProviderAddress());
            ps.setString(4, provider.getProviderEmail());
            
            ps.setDate(5, getCurrentSQLDate());
            ps.setInt(6, (provider.isIsActive() ? 1 : 0));
            ps.setInt(7, provider.getProviderID());
             result = ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }//finally {
//            db.closeConnection(con, ps, rs);
        //}
        return result;

    }
     
     
      public int addNewProviderToDB(Provider provider) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql
                = "INSERT INTO provider ( provider_name, \n"
                + "provider_phone, provider_address, provider_email,provider_created_at, \n"
                + " is_active)\n"
                + "VALUES(?, ?, ?, ?, ?, ?)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, provider.getProviderName());
            ps.setString(2, provider.getProviderPhone());
            ps.setString(3, provider.getProviderAddress());
            ps.setString(4, provider.getProviderEmail());
            ps.setDate(5, getCurrentSQLDate());
            ps.setBoolean(6, provider.isIsActive());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProviderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
