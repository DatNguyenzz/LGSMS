package DAO;

import Model.Importation;
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
            + "FROM Importation i\n";

    public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }
    
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
    
    //Add new import
    public int addImport(Importation importation) {
        String sql 
                = "INSERT INTO Importation (product_id, product_import_quantity, "
                + "import_date, account_id, provider_id, note, "
                + "import_amount)\n" 
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, importation.getProductID());
            ps.setInt(2, importation.getProductImportQuantity());
            ps.setDate(3, getCurrentSQLDate());
            ps.setInt(4, importation.getAccountID());
            ps.setInt(5, importation.getProviderID());
            ps.setString(6, importation.getNote());
            ps.setDouble(7, importation.getImportAmount());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImportationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}