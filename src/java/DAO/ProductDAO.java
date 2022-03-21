/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Product;
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
public class ProductDAO {

    private static final String BASE_SQL
            = "SELECT p.product_id, p.product_image, p.product_name, \n"
            + "p.product_price, p.product_import_price, p.product_instock, \n"
            + "p.product_inuse, p.product_description, p.product_created_at, \n"
            + "p.product_updated_at, p.is_active\n"
            + "FROM Product p\n";

    //Get list all product from database
    public ArrayList<Product> getAllProduct() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL;
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("product_id"));
                p.setProductImage(rs.getString("product_image"));
                p.setProductName(rs.getString("product_name"));
                p.setProductPrice(rs.getDouble("product_price"));
                p.setProductImportPrice(rs.getDouble("product_import_price"));
                p.setProductInstock(rs.getInt("product_instock"));
                p.setProductInuse(rs.getInt("product_inuse"));
                p.setProductDescription(rs.getString("product_description"));
                p.setProductCreatedAt(rs.getDate("product_created_at"));
                p.setProductUpdatedAt(rs.getDate("product_updated_at"));
                p.setIsActive(rs.getBoolean("is_active"));
                listProduct.add(p);
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
        return listProduct;
    }

    //Add new product to database
    public int addNewProductToDB(Product product) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql
                = "INSERT INTO product (product_image, product_name, \n"
                + "product_price, product_instock, product_inuse, \n"
                + "product_description, product_created_at, is_active)\n"
                + "VALUES('" + product.getProductImage() + "', "
                + "N'" + product.getProductName() + "', "
                + product.getProductPrice() + ", "
                + product.getProductInstock() + ", "
                + product.getProductInuse() + ", "
                + "N'" + product.getProductDescription() + "', "
                + "'" + product.getProductCreatedAt() + "', "
                + (product.isIsActive() ? 1 : 0)
                + ")";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
