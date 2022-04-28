package DAO;

import DAO.DBContext;
import DAO.OrderDAO;
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
            = "SELECT i.import_id, i.product_id,  i.import_status, \n"
            + "i.product_import_quantity, i.created_at, i.staff_id, i.manager_id,i.updated_at,\n"
            + "i.provider_id, i.note, i.import_amount,\n"
            + "(SELECT p.provider_name FROM Provider p WHERE p.provider_id = i.provider_id) \n"
            + "AS provider_name,\n"
            + "(SELECT p.product_name FROM Product p WHERE p.product_id = i.product_id) \n"
            + "AS product_name,\n"
            + "(SELECT a.username FROM Account a INNER JOIN Profile p \n"
            + "ON a.profile_id = p.profile_id WHERE a.account_id = i.staff_id) \n"
            + "as staff_name,\n"
            + "(SELECT a.username FROM Account a INNER JOIN Profile p \n"
            + "ON a.profile_id = p.profile_id WHERE a.account_id = i.manager_id) \n"
            + "as manager_name\n"
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
                importation.setCreatedAt(rs.getDate("created_at"));
                importation.setManagerID(rs.getInt("manager_id"));
                importation.setProviderID(rs.getInt("provider_id"));
                importation.setNote(rs.getString("note"));
                importation.setImportAmount(rs.getDouble("import_amount"));
                importation.setStaffName(rs.getString("staff_name"));
                importation.setProductName(rs.getString("product_name"));
                importation.setProviderName(rs.getString("provider_name"));
                importation.setImportStatus(rs.getInt("import_status"));
                importation.setManagerName(rs.getString("manager_name"));
                importation.setUpdatedAt(rs.getDate("updated_at"));
                listImport.add(importation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listImport;
    }

    //Add new import
    public int createNewImport(Importation importation) {
        String sql
                = "INSERT INTO Importation (product_id, product_import_quantity, "
                + "created_at, manager_id, provider_id, note, "
                + "import_amount, import_status)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, 0)";
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
            ps.setInt(4, importation.getManagerID());
            ps.setInt(5, importation.getProviderID());
            ps.setString(6, importation.getNote());
            ps.setDouble(7, importation.getImportAmount());
            
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImportationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Importation getImportationById(int id) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL
                + "WHERE i.import_id= " + id;

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
                importation.setCreatedAt(rs.getDate("created_at"));
                importation.setManagerID(rs.getInt("staff_id"));
                importation.setProviderID(rs.getInt("provider_id"));
                importation.setNote(rs.getString("note"));
                importation.setImportAmount(rs.getDouble("import_amount"));
                importation.setStaffName(rs.getString("staff_name"));
                importation.setProductName(rs.getString("product_name"));
                importation.setProviderName(rs.getString("provider_name"));
                importation.setImportStatus(rs.getInt("import_status"));
                importation.setManagerName(rs.getString("manager_name"));

                return importation;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    //get all importation for staff
    public ArrayList<Importation> getAllImportationForStaff(int id) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql
                = BASE_SQL
                + "WHERE i.staff_id = " + id + "\n"
                + "OR i.import_status=0";
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
                importation.setCreatedAt(rs.getDate("created_at"));
                importation.setManagerID(rs.getInt("staff_id"));
                importation.setProviderID(rs.getInt("provider_id"));
                importation.setNote(rs.getString("note"));
                importation.setImportAmount(rs.getDouble("import_amount"));
                importation.setStaffName(rs.getString("staff_name"));
                importation.setProductName(rs.getString("product_name"));
                importation.setProviderName(rs.getString("provider_name"));
                importation.setImportStatus(rs.getInt("import_status"));
                importation.setManagerName(rs.getString("manager_name"));
                importation.setUpdatedAt(rs.getDate("updated_at"));
                listImport.add(importation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listImport;
    }

    public int creatNewImportFromCus(Importation importation) {
        String sql
                = "INSERT INTO Importation "
                + "(product_id, "
                + "product_import_quantity, "
                + "created_at, "
                + "staff_id, "
                + "note, "
                + "import_amount, "
                + "import_status)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, 1)";
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
            ps.setInt(4, importation.getStaffID());
            ps.setString(5, importation.getNote());
            ps.setDouble(6, importation.getImportAmount());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImportationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateImport(Importation importation) {
        String sql
                = "BEGIN TRANSACTION\n"
                + "UPDATE Importation\n"
                + "SET import_status = " + importation.getImportStatus() + ",\n"
                + "	staff_id = " + importation.getStaffID() + ",\n"
                + "	product_import_quantity = " + importation.getProductImportQuantity() + ",\n"
                + "	import_amount = " + importation.getImportAmount() + ",\n"
                + "     updated_at = '" + getCurrentSQLDate() + "'\n"
                + "WHERE import_id = " + importation.getImportID() + "\n"
                + "COMMIT;";
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImportationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
