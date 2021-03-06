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

    private static final String BASE_SQL
            = "SELECT o.order_id, o.order_code, o.customer_id, \n"
            + "o.order_status, o.created_at, o.customer_name, \n"
            + "o.order_note_1, o.order_note_2, o.business_staff_id,\n"
            + "o.updated_at, o.phone, o.address,\n"
            //            + "od.order_detail_id, od.product_id, od.product_quantity, od.price, p.product_id, p.product_name,p.product_price,\n"
            + "(SELECT SUM(Price) FROM Order_Detail od\n"
            + "WHERE od.order_id = o.order_id) AS total_money\n"
            + "FROM Orders o\n" //            
            //            + "INNER JOIN Order_Detail od ON o.order_id = od.order_id\n"
            //            + "INNER JOIN Product p ON od.product_id = p.product_id \n"
            ;

    public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }

    public ArrayList<Orders> getAllOrders() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL;

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
                order.setCreatedAt(rs.getDate("created_at"));
                order.setUpdatedAt(rs.getDate("updated_at"));
                order.setCustomerName(rs.getString("customer_name"));
                order.setCustomerID(rs.getInt("customer_id"));
                order.setOrderStatus(rs.getInt("order_status"));
                order.setBussinessStaffID(rs.getInt("business_staff_id"));
                order.setOrderNote1(rs.getString("order_note_1"));
                order.setOrderNote2(rs.getString("order_note_2"));
                order.setTotalPrice(rs.getDouble("total_money"));
                order.setCustomerPhone(rs.getString("phone"));
                order.setCustomerAddress(rs.getString("address"));
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

    public ArrayList<Orders> getOrderByOrderStatus(int status) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql
                = "SELECT o.order_id, o.order_code, o.customer_id, \n"
                + "o.order_status, o.created_at, o.updated_at, o.customer_name, \n"
                + "o.order_note_1, o.order_note_2, o.business_staff_id,\n"
                + "o.phone, o.address, \n"
                + "(SELECT SUM(Price) FROM Order_Detail od\n"
                + "WHERE od.order_id = o.order_id) as total_money\n"
                + "FROM Orders o\n"
                + "WHERE o.order_status =" + status;
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
                order.setCreatedAt(rs.getDate("created_at"));
                order.setUpdatedAt(rs.getDate("updated_at"));
                order.setCustomerName(rs.getString("customer_name"));
                order.setCustomerID(rs.getInt("customer_id"));
                order.setOrderStatus(rs.getInt("order_status"));
                order.setBussinessStaffID(rs.getInt("business_staff_id"));
                order.setOrderNote1(rs.getString("order_note_1"));
                order.setOrderNote2(rs.getString("order_note_2"));
                order.setTotalPrice(rs.getDouble("total_money"));
                order.setCustomerPhone(rs.getString("phone"));
                order.setCustomerAddress(rs.getString("address"));
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

    public ArrayList<OrderDetail> getListOrderDetailByOrderId(int id) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql
                = "SELECT od.order_detail_id, od.order_id, od.price, od.product_id, od.product_quantity,\n"
                + "(	SELECT p.product_name \n"
                + "	FROM Product p \n"
                + "	WHERE p.product_id = od.product_id) AS product_name,\n"
                + "(	SELECT i.image_path\n"
                + "	FROM Product p \n"
                + "	INNER JOIN Image i ON p.image_id = i.image_id\n"
                + "	WHERE p.product_id = od.product_id) AS image_path\n"
                + "FROM Order_Detail od\n"
                + "WHERE od.order_id = " + id;
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
                orderDetail.setProductName(rs.getString("product_name"));
                orderDetail.setProductQuantity(rs.getInt("product_quantity"));
                orderDetail.setPrice(rs.getDouble("price"));
                orderDetail.setProductImagePath(rs.getString("image_path"));
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
                + "WHERE o.order_id= " + id;

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderID(rs.getInt("order_id"));
                order.setOrderCode(rs.getString("order_code"));
                order.setCreatedAt(rs.getDate("created_at"));
                order.setUpdatedAt(rs.getDate("updated_at"));
                order.setCustomerName(rs.getString("customer_name"));
                order.setCustomerID(rs.getInt("customer_id"));
                order.setOrderStatus(rs.getInt("order_status"));
                order.setBussinessStaffID(rs.getInt("business_staff_id"));
                order.setOrderNote1(rs.getString("order_note_1"));
                order.setOrderNote2(rs.getString("order_note_2"));
                
                order.setTotalPrice(rs.getDouble("total_money"));
                order.setCustomerPhone(rs.getString("phone"));
                order.setCustomerAddress(rs.getString("address"));

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

    public int staffUpdateOrderStatus(int orderID, int staffID, int status) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "UPDATE Orders\n"
                + "SET business_staff_id = " + staffID + ",\n"
                + "order_status = " + status + "\n,"
                + "updated_at = '" + getCurrentSQLDate() + "'\n"
                + "WHERE order_id = " + orderID;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public int updateOrderStatus(Orders order) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "UPDATE orders  \n"
                + "SET  orders.order_status = ? ,"
                + "orders.order_note_2= ? ,"
                + "orders.updated_at = ? \n"
                + "WHERE orders.order_id = ? \n";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, order.getOrderStatus());
            ps.setString(2, order.getOrderNote2());
            ps.setDate(3, getCurrentSQLDate());
            ps.setInt(4, order.getOrderID());
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

    public ArrayList<Orders> getAllAcceptedOrderByStaff(int staffID) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE o.order_status > 0 \n"
                + "AND o.order_status < 4\n"
                + "AND o.business_staff_id = " + staffID;
        ArrayList<Orders> listOrder = new ArrayList();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderID(rs.getInt("order_id"));
                order.setOrderCode(rs.getString("order_code"));
                order.setCreatedAt(rs.getDate("created_at"));
                order.setUpdatedAt(rs.getDate("updated_at"));
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

    public ArrayList<Orders> getOrderByStatusAndStaff(int status, int staffID) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL
                + "WHERE o.order_status = " + status + "\n"
                + "AND o.business_staff_id = " + staffID;
        ArrayList<Orders> listOrder = new ArrayList();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderID(rs.getInt("order_id"));
                order.setOrderCode(rs.getString("order_code"));
                order.setCreatedAt(rs.getDate("created_at"));
                order.setUpdatedAt(rs.getDate("updated_at"));
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

    //Get list all order create by customer id
    public ArrayList<Orders> getListOrderByCusID(int id) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql
                = BASE_SQL
                + "WHERE o.customer_id =" + id;
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
                order.setCreatedAt(rs.getDate("created_at"));
                order.setCustomerName(rs.getString("customer_name"));
                order.setCustomerID(rs.getInt("customer_id"));
                order.setOrderStatus(rs.getInt("order_status"));
                order.setBussinessStaffID(rs.getInt("business_staff_id"));
                order.setOrderNote1(rs.getString("order_note_1"));
                order.setOrderNote2(rs.getString("order_note_2"));
                order.setTotalPrice(rs.getDouble("total_money"));

                ArrayList<OrderDetail> listOrderDetail = getListOrderDetailByOrderId(rs.getInt("order_id"));
                order.setOrderDetail(listOrderDetail);
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

    //Customer create new order
    public int createNewOrder(Orders order) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql
                = "BEGIN TRANSACTION;\n"
                + "\n"
                + "INSERT INTO Orders (order_code, customer_id, customer_name, \n"
                + "phone, address, created_at, order_status, order_note_1)\n"
                + "VALUES ('" + order.getOrderCode() + "',\n"
                + order.getCustomerID() + ",\n"
                + "N'" + order.getCustomerName() + "',\n"
                + "'" + order.getCustomerPhone() + "',\n"
                + "N'" + order.getCustomerAddress() + "',\n"
                + "'" + getCurrentSQLDate() + "',\n"
                + "0,N'" + order.getOrderNote1() + "');\n"
                + "\n";
        ArrayList<OrderDetail> listOrderDetails = (ArrayList<OrderDetail>) order.getOrderDetail();
        for (OrderDetail od : listOrderDetails) {
            sql += "INSERT INTO Order_Detail (order_id, product_id, product_quantity, price)\n"
                    + "VALUES (\n"
                    + "(SELECT order_id FROM Orders WHERE order_code = '" + order.getOrderCode() + "'),\n"
                    + od.getProductID() + ", " + od.getProductQuantity() + ", "
                    + od.getPrice() + ");\n"
                    + "\n";
        }
        sql += "COMMIT;";
        int result = 0;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public Orders getOrderByOrderCode(String code) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = BASE_SQL
                + "WHERE o.order_code= '" + code + "'";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderID(rs.getInt("order_id"));
                order.setOrderCode(rs.getString("order_code"));
                order.setCreatedAt(rs.getDate("created_at"));
                order.setUpdatedAt(rs.getDate("updated_at"));
                order.setCustomerName(rs.getString("customer_name"));
                order.setCustomerID(rs.getInt("customer_id"));
                order.setOrderStatus(rs.getInt("order_status"));
                order.setBussinessStaffID(rs.getInt("business_staff_id"));
                order.setOrderNote1(rs.getString("order_note_1"));
                order.setOrderNote2(rs.getString("order_note_2"));

                order.setTotalPrice(rs.getDouble("total_money"));
                order.setCustomerPhone(rs.getString("phone"));
                order.setCustomerAddress(rs.getString("address"));

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

    public String getStaffCodeByOrderID(int orderId) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT a.username\n"
                + "FROM Orders o, Account a\n"
                + "WHERE o.business_staff_id = a.account_id\n"
                + "AND o.order_id = 1 ";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("username");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
