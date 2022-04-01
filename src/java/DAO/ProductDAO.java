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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat Nguyen
 */
public class ProductDAO {

    private static final String BASE_SQL
            = "SELECT p.product_id, p.image_id, p.product_name, \n"
            + "p.product_price, p.product_import_price, p.product_instock, \n"
            + "p.product_inuse, p.product_description, p.product_created_at, \n"
            + "p.product_updated_at, p.is_active\n"
            + "FROM Product p\n";

    public java.sql.Date getCurrentSQLDate() {
        Date utilDate = new Date();
        return new java.sql.Date(utilDate.getTime());
    }
    
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
                p.setImageID(rs.getInt("image_id"));
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
    
     //Get list all product from database í active
    public ArrayList<Product> getProductIactive() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL+"where p.is_active =1";
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("product_id"));
                p.setImageID(rs.getInt("image_id"));
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
     //search product by name
     public ArrayList<Product> searchProduct(String search) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL+"where p.is_active =1 and p.product_name LIKE '%"+search+"%'";
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("product_id"));
                p.setImageID(rs.getInt("image_id"));
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
    
    //filter product
     public ArrayList<Product> getProductIactiveWithFilter(int filter) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL+"where p.is_active =1";
        
        if(filter==0){
            sql+="";
            //lấy tất cả sản phẩm
        }else if(filter==1){
            sql+="ORDER BY p.product_price ASC";
            // lấy sản phẩm theo giá tăng
        }else if(filter==2){
            sql+="ORDER BY p.product_price DESC";
            //lấy sản phẩm theo giá giảm
        }else if(filter==3){
            sql+="ORDER BY p.product_name ASC";
            //lấy sản phẩm tuwf A-Z
        }else if(filter==4){
           sql+="ORDER BY p.product_name DESC";
            //lấy sản phẩm từ Z-A
        }
        
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("product_id"));
                p.setImageID(rs.getInt("image_id"));
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
                = "INSERT INTO product (image_id, product_name, \n"
                + "product_price, product_instock, product_inuse, \n"
                + "product_description, product_created_at, is_active)\n"
                + "VALUES('" + product.getImageID() + "', "
                + "N'" + product.getProductName() + "', "
                + product.getProductPrice() + ", "
                + product.getProductInstock() + ", "
                + product.getProductInuse() + ", "
                + "N'" + product.getProductDescription() + "', "
                + "'" + getCurrentSQLDate() + "', "
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

    //Get product by ID from database
    public Product getProductByID(int productID) {
        String sql = BASE_SQL
                + "WHERE p.product_id = " + productID;
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("product_id"));
                p.setImageID(rs.getInt("image_id"));
                p.setProductName(rs.getString("product_name"));
                p.setProductPrice(rs.getDouble("product_price"));
                p.setProductImportPrice(rs.getDouble("product_import_price"));
                p.setProductInstock(rs.getInt("product_instock"));
                p.setProductInuse(rs.getInt("product_inuse"));
                p.setProductDescription(rs.getString("product_description"));
                p.setProductCreatedAt(rs.getDate("product_created_at"));
                p.setProductUpdatedAt(rs.getDate("product_updated_at"));
                p.setIsActive(rs.getBoolean("is_active"));
                return p;
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
        return null;
    }

    public int updateProduct(Product product) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "UPDATE Product\n"
                + "SET product_name = N'" + product.getProductName() + "',\n"
                + "provider_id = " + product.getProviderID() + ",\n"
                + "product_price = " + product.getProductPrice() + ",\n"
                + "is_active = " + (product.isIsActive()?1:0) + ",\n"
                + "product_description = N'"+ product.getProductDescription() + "',\n"
                + "product_updated_at = '"+ getCurrentSQLDate() + "'\n"
                + "WHERE product_id = " + product.getProductID();
        try{
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                db.closeConnection(con, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
