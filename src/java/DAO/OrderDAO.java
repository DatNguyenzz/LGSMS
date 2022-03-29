/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.OrderDetail;
import Model.Orders;
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
public class OrderDAO {


    private static final String BASE_SQL = "select o.order_id, o.order_code, o.customer_id, o.order_status, \n"
            + "            o.order_date, o.customer_name, o.order_note_1, o.order_note_2, o.business_staff_id,\n"
            + "             od.order_detail_id, od.product_id, od.product_quantity, od.price, p.product_id, p.product_name,p.product_price,\n"
            + "             (SELECT SUM(Price) FROM Order_Detail od\n"
            + "             WHERE od.order_id = o.order_id) as total_money\n"
            + "             From Orders o\n"
            + "             INNER JOIN Order_Detail od on o.order_id = od.order_id\n"
            + "		    inner join Product p on od.product_id = p.product_id ";


    public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }

     public ArrayList<Orders> getAllOrders() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT o.order_id, o.order_code, o.customer_id, \n"
                + "o.order_status, o.order_date, o.customer_name, \n"
                + "o.order_note_1, o.order_note_2, o.business_staff_id,\n"
                + "(SELECT SUM(Price) FROM Order_Detail od\n"
                + "WHERE od.order_id = o.order_id) as total_money\n"
                + "FROM Orders o\n";
              
        ArrayList<Orders> listOrder = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderID(rs.getInt("order_id"));
                order.setOrderCode(rs.getString("order_code"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setCustomerName(rs.getString("customer_name"));
                order.setCustomerID(rs.getInt("customer_id"));
                order.setOrderStatus(rs.getInt("order_status"));
                order.setBussinessStaffID(rs.getInt("business_staff_id"));
                order.setOrderNote1(rs.getString("order_note_1"));
                order.setOrderNote2(rs.getString("order_note_2"));
                order.setTotalPrice(rs.getDouble("total_money"));
                listOrder.add(order);
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
        return listOrder;
    }
    
    public ArrayList<Orders> getOrderByOrderStatus(int id) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT o.order_id, o.order_code, o.customer_id, \n"
                + "o.order_status, o.order_date, o.customer_name, \n"
                + "o.order_note_1, o.order_note_2, o.business_staff_id,\n"
                + "(SELECT SUM(Price) FROM Order_Detail od\n"
                + "WHERE od.order_id = o.order_id) as total_money\n"
                + "FROM Orders o\n"
                + "WHERE o.order_status =" + id;
        ArrayList<Orders> listOrder = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderID(rs.getInt("order_id"));
                order.setOrderCode(rs.getString("order_code"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setCustomerName(rs.getString("customer_name"));
                order.setCustomerID(rs.getInt("customer_id"));
                order.setOrderStatus(rs.getInt("order_status"));
                order.setBussinessStaffID(rs.getInt("business_staff_id"));
                order.setOrderNote1(rs.getString("order_note_1"));
                order.setOrderNote2(rs.getString("order_note_2"));
                order.setTotalPrice(rs.getDouble("total_money"));
                listOrder.add(order);
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
        return listOrder;
    }


 public ArrayList<OrderDetail> getOrderDetailByOrderId(int id) {

        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL + "Where o.order_id= " + id;
        ArrayList<OrderDetail> listOrderDetail = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderID(rs.getInt("order_id"));

                orderDetail.setOrderDetailID(rs.getInt("order_detail_id"));
                orderDetail.setProductID(rs.getInt("product_id"));
                orderDetail.setProductQuantity(rs.getInt("product_quantity"));

                orderDetail.setPrice(rs.getDouble("price"));
                listOrderDetail.add(orderDetail);
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
        return listOrderDetail;
    }

    public Orders getOrderById(int id) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL
                + "Where o.order_id= " + id;


        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();


            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderID(rs.getInt("order_id"));
                order.setOrderCode(rs.getString("order_code"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setCustomerName(rs.getString("customer_name"));
                order.setCustomerID(rs.getInt("customer_id"));
                order.setOrderStatus(rs.getInt("order_status"));
                order.setBussinessStaffID(rs.getInt("business_staff_id"));
                order.setOrderNote1(rs.getString("order_note_1"));
                order.setOrderNote2(rs.getString("order_note_2"));

                order.setTotalPrice(rs.getDouble("total_money"));

//                order.setOrderDetail(getOrderDetailByOrderId(rs.getInt("order_id")));
                return order;


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


    public int updateOrderStatus(Orders order) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "UPDATE orders  \n"
                + "SET  orders.order_status = ? \n"
                + " WHERE orders.order_id = ?\n";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ;
            ps.setInt(1, order.getOrderStatus());

            ps.setInt(2, order.getOrderID());
            result = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
}
        }
        return result;

    }


}
