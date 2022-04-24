/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Product;
import Model.ShoppingCart;
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
public class ShoppingCartDAO {

    private static final String BASE_SQL = "";

    public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }

    // show all product in cart for the customerID
    public ArrayList<ShoppingCart> getCartByIdCustomer(int id) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql
                = "SELECT c.cart_id, c.product_id, c.product_quantity, c.customer_id, \n"
                + "p.product_name, p.product_price  \n"
                + "FROM Shopping_Cart c\n"
                + "INNER JOIN Product p on c.product_id= p.product_id\n"
                + "WHERE c.customer_id=" + id;
        ArrayList<ShoppingCart> listCart = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ShoppingCart cart = new ShoppingCart();
                cart.setCartID(rs.getInt("cart_id"));
                cart.setProductID(rs.getInt("product_id"));
                cart.setProductQuantity(rs.getInt("product_quantity"));
                cart.setCustomerID(rs.getInt("customer_id"));

                Product product = new Product();
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getDouble("product_price"));

                cart.setProduct(product);
                listCart.add(cart);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listCart;
    }

    public ShoppingCart getProductByCartID(int id) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT c.cart_id, c.product_id, c.product_quantity, c.customer_id, \n"
                + "p.product_name, p.product_price  \n"
                + "FROM Shopping_Cart c\n"
                + "INNER JOIN Product p on c.product_id= p.product_id\n"
                + "WHERE c.cart_id=" + id;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                ShoppingCart cart = new ShoppingCart();
                cart.setCartID(rs.getInt("cart_id"));
                cart.setProductID(rs.getInt("product_id"));
                cart.setProductQuantity(rs.getInt("product_quantity"));
                cart.setCustomerID(rs.getInt("customer_id"));

                Product product = new Product();
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getDouble("product_price"));

                cart.setProduct(product);
                return cart;
            }
        } catch (SQLException e) {
            Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public ShoppingCart getProductByCusIdAndProID(int productID, int cusID) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT c.cart_id, c.product_id, c.product_quantity, c.customer_id, \n"
                + "p.product_name, p.product_price  \n"
                + "FROM Shopping_Cart c\n"
                + "INNER JOIN Product p ON c.product_id= p.product_id\n"
                + "WHERE c.customer_id=" + cusID + "and c.product_id= " + productID;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                ShoppingCart cart = new ShoppingCart();
                cart.setCartID(rs.getInt("cart_id"));
                cart.setProductID(rs.getInt("product_id"));
                cart.setProductQuantity(rs.getInt("product_quantity"));
                cart.setCustomerID(rs.getInt("customer_id"));

                Product product = new Product();
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getDouble("product_price"));

                cart.setProduct(product);
                return cart;
            }
        } catch (SQLException e) {
            Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    //check product co trong cart ko
    public boolean isProductExist(int productID, int cusID) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT c.cart_id, c.product_id, c.product_quantity, c.customer_id \n"
                + "FROM Shopping_Cart c\n"
                + "WHERE c.customer_id=" + cusID + "AND c.product_id= " + productID;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return false;
            }
        } catch (SQLException e) {
            Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    // add product to customer cart
    public int addNewProductToCart(int productID, int customerID) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "INSERT INTO Shopping_Cart (product_id, product_quantity, customer_id) \n"
                + "VALUES(N'" + productID + "', \n"
                + "'" + 1 + "', \n"
                + "'" + customerID + "'); \n";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public int updateProductQuantity(int productID, int customerID, int quantity) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "BEGIN TRANSACTION;\n"
                + "UPDATE Shopping_Cart\n"
                + "SET product_quantity = " + quantity + " \n"
                + "WHERE product_id = " + productID + " AND customer_id = " + customerID + ";\n"
                + "\n"
                + "COMMIT;";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    
    public int updateProductQuantityByCartID(int id, int quantity) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "BEGIN TRANSACTION;\n"
                + "UPDATE Shopping_Cart\n"
                + "SET product_quantity = " + quantity + " \n"
                + "WHERE cart_id = " + id + "\n"
             
                + "COMMIT;";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public double getTotalCartPrice(ArrayList<ShoppingCart> cartList) {
        double sum = 0;
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "SELECT c.product_quantity, \n"
                + " p.product_price  \n"
                + "FROM Shopping_Cart c\n"
                + "INNER JOIN Product p ON c.product_id= p.product_id\n"
                + "Where c.cart_id=?";
        try {

            if (cartList.size() > 0) {
                for (ShoppingCart item : cartList) {
                    db = new DBContext();
                    con = db.getConnection();
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, item.getCartID());
                    rs=ps.executeQuery();
                    while(rs.next()){
                        sum+=rs.getDouble("product_price")*item.getProductQuantity();
                    }
                }
            }

           
        } catch (Exception e) {
            Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sum;
    }
    
    
    public int deleteCartByID(int cartID) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "BEGIN TRANSACTION;\n"
                + "DELETE Shopping_Cart\n"              
                + "WHERE cart_id = " + cartID + "\n"
                + "COMMIT;";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
     
    public int deleteCartByCustomerID(int cusID) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql
                = "BEGIN TRANSACTION;\n"
                + "DELETE Shopping_Cart\n"              
                + "WHERE customer_id = " + cusID + "\n"
                + "COMMIT;";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ShoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
     
}
