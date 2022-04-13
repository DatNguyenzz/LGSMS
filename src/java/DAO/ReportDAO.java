/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Report;
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
public class ReportDAO {

    private static final String BASE_SQL = "Select Month(r.create_at) as 'month', DATEPART(quarter, r.create_at) as 'quarter', sum(r.total_money)   as revenues, sum(p.product_import_price*od.product_quantity) as cost\n"
            + "  from Receipt_Voucher r\n"
            + "  inner join Orders o on r.order_id = o.order_id\n"
            + "  inner join Order_Detail od on o.order_id = od.order_id\n"
            + "  inner join Product p on od.product_id = p.product_id";

    public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }

    public Report getReportByMonth(int month) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL
                + "WHERE Month(r.create_at)= " + month
                + "group by Month(r.create_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setCost(rs.getInt("month"));
                rp.setCost(rs.getDouble("cost"));
                rp.setQuarter(rs.getInt("quarter"));
                rp.setRevenue(rs.getDouble("revenues"));

//                order.setOrderDetail(getOrderDetailByOrderId(rs.getInt("order_id")));
                return rp;

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

    public Report getReportByQuarter(int quarter) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL
                + "WHERE DATEPART(quarter, r.create_at)= " + quarter
                + "group by Month(r.create_at),DATEPART(quarter, r.create_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setCost(rs.getInt("month"));
                rp.setCost(rs.getDouble("cost"));
                rp.setQuarter(rs.getInt("quarter"));
                rp.setRevenue(rs.getDouble("revenues"));

//                order.setOrderDetail(getOrderDetailByOrderId(rs.getInt("order_id")));
                return rp;

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

//     public ArrayList<Report>  getListReportByMonth(int month) {
//        DBContext db = null;
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String sql = BASE_SQL
//                + "WHERE Month(r.create_at)= " + month
//                + "group by Month(r.create_at)";
//
//        try {
//            db = new DBContext();
//            con = db.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Report rp = new Report();
//                
//                rp.setCost(rs.getInt("month"));
//                rp.setCost(rs.getDouble("cost"));
//                rp.setQuarter(rs.getInt("quarter"));
//                rp.setRevenue(rs.getDouble("revenues"));
//                
//
////                order.setOrderDetail(getOrderDetailByOrderId(rs.getInt("order_id")));
//                return rp;
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                db.closeConnection(con, ps, rs);
//            } catch (SQLException ex) {
//                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return null;
//    }
    // lay report theo thang hien tai
    public Report getReportByMonthNow() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL
                + " where Month(r.create_at)= Month(GETDATE())\n"
                + "  group by Month(r.create_at),DATEPART(quarter, r.create_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setCost(rs.getInt("month"));
                rp.setCost(rs.getDouble("cost"));
                rp.setQuarter(rs.getInt("quarter"));
                rp.setRevenue(rs.getDouble("revenues"));

//                order.setOrderDetail(getOrderDetailByOrderId(rs.getInt("order_id")));
                return rp;

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

    // lay report theo quy hien tai
    public Report getReportByQuarterNow() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL
                + "DATEPART(quarter, r.create_at)=DATEPART(quarter, GETDATE())"
                + "group by Month(r.create_at),DATEPART(quarter, r.create_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setCost(rs.getInt("month"));
                rp.setCost(rs.getDouble("cost"));
                rp.setQuarter(rs.getInt("quarter"));
                rp.setRevenue(rs.getDouble("revenues"));

//                order.setOrderDetail(getOrderDetailByOrderId(rs.getInt("order_id")));
                return rp;

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

}
