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

    private static final String BASE_SQL_Revenues = "Select Month(r.create_at) as 'monthR', DATEPART(quarter, r.create_at) as 'quarterR',   \n"
            + "  sum(r.total_money) as revenues\n"
            + "  from Receipt_Voucher r\n"
            + " where r.voucher_status=1 "
          ;

    private static final String BASE_SQL_Cost = " Select Month(i.created_at) as 'monthI', DATEPART(quarter, i.created_at) as 'quarterI', \n"
            + " sum(i.import_amount) as cost\n"
            + "  from Importation i\n"
            + " where i.import_status =1";
           

    public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }
    // lay doanh so theo thang
    public Report getRevenuesByMonth(int month) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL_Revenues
                + "AND Month(r.create_at)= " + month
                + " group by Month(r.create_at),DATEPART(quarter, r.create_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setMonth(rs.getInt("monthR"));
               
                rp.setQuarter(rs.getInt("quarterR"));
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
    //lay doanh so theo quy
    public Report getRevenuesByQuarter(int quarter) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL_Revenues
                + "AND DATEPART(quarter, r.create_at)= " + quarter
                + "group by Month(r.create_at),DATEPART(quarter, r.create_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setMonth(rs.getInt("monthR"));
               
                rp.setQuarter(rs.getInt("quarterR"));
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
    
    
     // lay chi phi theo thang
    public Report getCostByMonth(int month) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL_Cost
                + "AND Month(i.created_at)= " + month
                + " group by Month(i.created_at),DATEPART(quarter, i.created_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setMonth(rs.getInt("monthI"));
               
                rp.setQuarter(rs.getInt("quarterI"));
                rp.setCost(rs.getDouble("cost"));

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
    //lay chi phi theo quy
    public Report getCostByQuarter(int quarter) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL_Cost
                + "AND DATEPART(quarter, i.created_at)= " + quarter
                + "group by Month(r.i.created_at),DATEPART(quarter, i.created_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setMonth(rs.getInt("monthI"));
                rp.setCost(rs.getDouble("cost"));
                rp.setQuarter(rs.getInt("quarterI"));
                
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
    // lay doanh so theo thang hien tai
    public Report getRevenuesByMonthNow() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL_Revenues
                + " AND Month(r.create_at)= Month('"+getCurrentSQLDate()+"')"
                + "  group by Month(r.create_at),DATEPART(quarter, r.create_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                Report rp = new Report();

                rp.setMonth(rs.getInt("monthR"));
             
                rp.setQuarter(rs.getInt("quarterR"));
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

    // lay doanh so theo quy hien tai
    public Report getRevenuesByQuarterNow() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL_Revenues
                + "AND DATEPART(quarter, r.create_at)=DATEPART(quarter, "+getCurrentSQLDate()+")"
                + "group by Month(r.create_at),DATEPART(quarter, r.create_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setMonth(rs.getInt("monthR"));
              
                rp.setQuarter(rs.getInt("quarterR"));
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
    
    
    
     // lay doanh so theo quy truoc hien tai
    public Report getRevenuesByQuarterBefore() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL_Revenues
                + "AND DATEPART(quarter, r.create_at)=DATEPART(quarter, "+getCurrentSQLDate()+")-1"
                + "group by Month(r.create_at),DATEPART(quarter, r.create_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setMonth(rs.getInt("monthR"));
              
                rp.setQuarter(rs.getInt("quarterR"));
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
    
    
    // lay chi phi theo thang hien tai
    public Report getCostByMonthNow() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL_Cost
                + " AND Month(i.created_at)= Month("+getCurrentSQLDate()+")\n"
                + "  group by Month(i.created_at),DATEPART(quarter, i.created_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setMonth(rs.getInt("monthI"));
                rp.setCost(rs.getDouble("cost"));
                rp.setQuarter(rs.getInt("quarterI"));
              

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

    // lay chi phi theo quy hien tai
    public Report getCostByQuarterNow() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL_Cost
                + "AND DATEPART(quarter, i.created_at)=DATEPART(quarter,"+getCurrentSQLDate()+")"
                + "group by Month(i.created_at),DATEPART(quarter, i.created_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setMonth(rs.getInt("monthI"));
                rp.setCost(rs.getDouble("cost"));
                rp.setQuarter(rs.getInt("quarterI"));
             

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
    
    // lay chi phi theo quy truoc hien tai
    public Report getCostByQuarterBefore() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL_Cost
                + "AND DATEPART(quarter, i.created_at)=DATEPART(quarter,"+getCurrentSQLDate()+")-1"
                + "group by Month(i.created_at),DATEPART(quarter, i.created_at)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Report rp = new Report();

                rp.setMonth(rs.getInt("monthI"));
                rp.setCost(rs.getDouble("cost"));
                rp.setQuarter(rs.getInt("quarterI"));
             

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
