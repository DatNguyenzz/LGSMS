package DAO;

import Model.ReceiptVoucher;
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
public class ReceiptVoucherDAO {

    private static final String BASE_SQL
            = "SELECT r.receipt_id, r.order_id, r.create_at, \n"
            + "r.business_staff_id, r.total_money, r.deposit, \n"
            + "r.note, r.voucher_status,\n"
            + "(SELECT p.full_name\n"
            + "FROM Orders o\n"
            + "INNER JOIN Account a ON o.customer_id = a.account_id\n"
            + "INNER JOIN Profile p ON a.profile_id = p.profile_id\n"
            + "WHERE o.order_id = r.order_id) AS customer_name,\n"
            + "(SELECT p.full_name\n"
            + "FROM Account a INNER JOIN Profile p ON a.profile_id = p.profile_id\n"
            + "WHERE a.account_id = r.business_staff_id) AS staff_name\n"
            + "FROM Receipt_Voucher r \n";

    public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }

    //Get all receipt voucher from database
    public ArrayList<ReceiptVoucher> getAllReceiptVoucher() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL;
        ArrayList<ReceiptVoucher> listReceiptVoucher = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReceiptVoucher receiptVoucher = new ReceiptVoucher();
                receiptVoucher.setReceiptID(rs.getInt("receipt_id"));
                receiptVoucher.setOrderID(rs.getInt("order_id"));
                receiptVoucher.setReceiptCreatedAt(rs.getDate("create_at"));
                receiptVoucher.setBussinessStaffID(rs.getInt("business_staff_id"));
                receiptVoucher.setTotalMoney(rs.getDouble("total_money"));
                receiptVoucher.setDeposit(rs.getDouble("deposit"));
                receiptVoucher.setNote(rs.getString("note"));
                receiptVoucher.setStatus(rs.getInt("voucher_status"));
                receiptVoucher.setCustomerName(rs.getString("customer_name"));
                receiptVoucher.setStaffName(rs.getString("staff_name"));
                listReceiptVoucher.add(receiptVoucher);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReceiptVoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listReceiptVoucher;
    }

    public int addNewReceiptVoucher(ReceiptVoucher receiptVoucher) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "INSERT INTO Receipt_Voucher(order_id, create_at, "
                + "business_staff_id, total_money, deposit, voucher_status)\n"
                + "VALUES (?,?,?,?,?,0)";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, receiptVoucher.getOrderID());
            ps.setDate(2, getCurrentSQLDate());
            ps.setInt(3, receiptVoucher.getBussinessStaffID());
            ps.setDouble(4, receiptVoucher.getTotalMoney());
            ps.setDouble(5, receiptVoucher.getDeposit());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReceiptVoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public ReceiptVoucher getReceiptVoucherByID(int receiptID) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE r.receipt_id = " + receiptID;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                ReceiptVoucher receiptVoucher = new ReceiptVoucher();
                receiptVoucher.setReceiptID(rs.getInt("receipt_id"));
                receiptVoucher.setOrderID(rs.getInt("order_id"));
                receiptVoucher.setReceiptCreatedAt(rs.getDate("create_at"));
                receiptVoucher.setBussinessStaffID(rs.getInt("business_staff_id"));
                receiptVoucher.setTotalMoney(rs.getDouble("total_money"));
                receiptVoucher.setDeposit(rs.getDouble("deposit"));
                receiptVoucher.setNote(rs.getString("note"));
                receiptVoucher.setStatus(rs.getInt("voucher_status"));
                receiptVoucher.setCustomerName(rs.getString("customer_name"));
                receiptVoucher.setStaffName(rs.getString("staff_name"));
                return receiptVoucher;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReceiptVoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public int updateReceiptVoucher(ReceiptVoucher receiptVoucher) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "UPDATE Receipt_Voucher\n"
                + "SET deposit = " + receiptVoucher.getDeposit() + ",\n"
                + "voucher_status = " + receiptVoucher.getStatus() + ",\n"
                + "note = N'" + receiptVoucher.getNote() + "',\n"
                + "total_money = " + receiptVoucher.getTotalMoney() + "\n"
                + "WHERE receipt_id = " + receiptVoucher.getReceiptID();
        try{
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReceiptVoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public ReceiptVoucher getReceiptVoucherByOrderID(int orderID) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE r.order_id = " + orderID;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                ReceiptVoucher receiptVoucher = new ReceiptVoucher();
                receiptVoucher.setReceiptID(rs.getInt("receipt_id"));
                receiptVoucher.setOrderID(rs.getInt("order_id"));
                receiptVoucher.setReceiptCreatedAt(rs.getDate("create_at"));
                receiptVoucher.setBussinessStaffID(rs.getInt("business_staff_id"));
                receiptVoucher.setTotalMoney(rs.getDouble("total_money"));
                receiptVoucher.setDeposit(rs.getDouble("deposit"));
                receiptVoucher.setNote(rs.getString("note"));
                receiptVoucher.setStatus(rs.getInt("voucher_status"));
                receiptVoucher.setCustomerName(rs.getString("customer_name"));
                receiptVoucher.setStaffName(rs.getString("staff_name"));
                return receiptVoucher;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReceiptVoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
