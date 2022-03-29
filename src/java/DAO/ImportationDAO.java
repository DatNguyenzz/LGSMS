/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Importation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat Nguyen
 */
public class ImportationDAO {

    private static final String BASE_SQL
            = "SELECT i.import_id, i.product_id, i.product_id, \n"
            + "i.product_import_quantity, i.import_date, i.account_id, \n"
            + "i.provider_id, i.note, i.import_amount,\n"
            + "(SELECT p.provider_name FROM Provider p WHERE p.provider_id = i.provider_id) "
            + "AS provider_name,\n"
            + "(SELECT p.product_name FROM Product p WHERE p.product_id = i.product_id) "
            + "AS product_name,\n"
            + "(SELECT p.full_name FROM Account a INNER JOIN Profile p "
            + "ON a.profile_id = p.profile_id WHERE a.account_id = i.account_id) "
            + "as staff_name\n"
            + "FROM Importation i";

    //get all importation
    public ArrayList<Importation> getAllImportation() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL;
        ArrayList<Importation> listImport = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Importation importation = new Importation();
                importation.setImportID(rs.getInt("import_id"));
                importation.setProductID(rs.getInt("product_id"));
                importation.setProductImportQuantity(rs.getInt("product_import_quantity"));
                importation.setImportDate(rs.getDate("import_date"));
                importation.setAccountID(rs.getInt("account_id"));
                importation.setProviderID(rs.getInt("provider_id"));
                importation.setNote(rs.getString("note"));
                importation.setImportAmount(rs.getDouble("import_amount"));
                importation.setStaffName(rs.getString("staff_name"));
                importation.setProductName(rs.getString("product_name"));
                importation.setProviderName(rs.getString("provider_name"));
                listImport.add(importation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listImport;
    }

}
