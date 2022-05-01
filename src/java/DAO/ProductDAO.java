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
            + "p.product_empty, p.product_description, p.product_created_at, \n"
            + "p.product_updated_at, p.is_active, p.provider_id, pv.provider_name, \n"
            + "i.image_path, i.image_name \n"
            + "FROM Product p \n"
            + "INNER JOIN Provider pv ON p.provider_id = pv.provider_id \n"
            + "INNER JOIN Image i ON p.image_id = i.image_id \n";

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
                p.setImagePath(rs.getString("image_path"));
                p.setProductName(rs.getString("product_name"));
                p.setProductPrice(rs.getDouble("product_price"));
                p.setProductImportPrice(rs.getDouble("product_import_price"));
                p.setProductInstock(rs.getInt("product_instock"));
                p.setProductEmpty(rs.getInt("product_empty"));
                p.setProductDescription(rs.getString("product_description"));
                p.setProductCreatedAt(rs.getDate("product_created_at"));
                p.setProductUpdatedAt(rs.getDate("product_updated_at"));
                p.setIsActive(rs.getBoolean("is_active"));
                p.setProviderID(rs.getInt("provider_id"));
                p.setProviderName(rs.getString("provider_name"));
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
    public ArrayList<Product> getProductIsActive() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = BASE_SQL + " where p.is_active =1";
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("product_id"));
                p.setImagePath(rs.getString("image_path"));
                p.setProductName(rs.getString("product_name"));
                p.setProductPrice(rs.getDouble("product_price"));
                p.setProductImportPrice(rs.getDouble("product_import_price"));
                p.setProductInstock(rs.getInt("product_instock"));
                p.setProductEmpty(rs.getInt("product_empty"));
                p.setProductDescription(rs.getString("product_description"));
                p.setProductCreatedAt(rs.getDate("product_created_at"));
                p.setProductUpdatedAt(rs.getDate("product_updated_at"));
                p.setIsActive(rs.getBoolean("is_active"));
                p.setProviderID(rs.getInt("provider_id"));
                p.setProviderName(rs.getString("provider_name"));
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
        String sql = BASE_SQL
                + "WHERE p.is_active = 1 \n"
                + "AND p.product_name LIKE N'%" + search + "%'";
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("product_id"));
                p.setImagePath(rs.getString("image_path"));
                p.setProductName(rs.getString("product_name"));
                p.setProductPrice(rs.getDouble("product_price"));
                p.setProductImportPrice(rs.getDouble("product_import_price"));
                p.setProductInstock(rs.getInt("product_instock"));
                p.setProductEmpty(rs.getInt("product_empty"));
                p.setProductDescription(rs.getString("product_description"));
                p.setProductCreatedAt(rs.getDate("product_created_at"));
                p.setProductUpdatedAt(rs.getDate("product_updated_at"));
                p.setIsActive(rs.getBoolean("is_active"));
                p.setProviderID(rs.getInt("provider_id"));
                p.setProviderName(rs.getString("provider_name"));
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
        String sql = "";

        switch (filter) {
            case 0://lấy tất cả sản phẩm
                sql += BASE_SQL + "where p.is_active =1";
                
                break;
            case 1:// lấy sản phẩm theo giá tăng
                sql += BASE_SQL + "where p.is_active =1" + "ORDER BY p.product_price ASC";
                
                break;
            case 2://lấy sản phẩm theo giá giảm
                sql += BASE_SQL + "where p.is_active =1" + "ORDER BY p.product_price DESC";
                
                break;
            case 3://lấy sản phẩm tuwf A-Z
                sql += BASE_SQL + "where p.is_active =1" + "ORDER BY p.product_name ASC";
                
                break;
            case 4://lấy sản phẩm từ Z-A
                sql += BASE_SQL + "where p.is_active =1" + "ORDER BY p.product_name DESC";
                
                break;
            case 5://lấy sản phẩm bán chạy
                sql     = "SELECT p.product_id, p.image_id, p.product_name, \n"
                        + "p.product_price, p.product_import_price, p.product_instock, \n"
                        + "p.product_empty, p.product_description, p.product_created_at, \n"
                        + "p.product_updated_at, p.is_active, p.provider_id, pv.provider_name, \n"
                        + "i.image_path, i.image_name,\n"
                        + "(	SELECT SUM(od.product_quantity) \n"
                        + "	FROM Order_Detail od INNER JOIN Orders o\n"
                        + "	ON od.order_id = o.order_id\n"
                        + "	WHERE od.product_id = p.product_id\n"
                        + "	AND o.order_status = 3) AS sold\n"
                        + "FROM Product p\n"
                        + "INNER JOIN Image i ON p.image_id = i.image_id\n"
                        + "INNER JOIN Provider pv ON p.provider_id = pv.provider_id \n"
                        + "WHERE p.is_active = 1\n"
                        + "ORDER BY sold DESC";
                break;

            default:
                break;
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
                p.setImagePath(rs.getString("image_path"));
                p.setProductName(rs.getString("product_name"));
                p.setProductPrice(rs.getDouble("product_price"));
                p.setProductImportPrice(rs.getDouble("product_import_price"));
                p.setProductInstock(rs.getInt("product_instock"));
                p.setProductEmpty(rs.getInt("product_empty"));
                p.setProductDescription(rs.getString("product_description"));
                p.setProductCreatedAt(rs.getDate("product_created_at"));
                p.setProductUpdatedAt(rs.getDate("product_updated_at"));
                p.setIsActive(rs.getBoolean("is_active"));
                p.setProviderID(rs.getInt("provider_id"));
                p.setProviderName(rs.getString("provider_name"));
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
                + "product_price, product_instock, product_empty, \n"
                + "product_description, product_created_at, is_active, \n"
                + "provider_id)\n"
                + "VALUES('" + product.getImagePath() + "', "
                + "N'" + product.getProductName() + "', "
                + product.getProductPrice() + ", "
                + product.getProductInstock() + ", "
                + product.getProductEmpty() + ", "
                + "N'" + product.getProductDescription() + "', "
                + "'" + getCurrentSQLDate() + "', "
                + (product.isIsActive() ? 1 : 0) + ", "
                + product.getProviderID()
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
                p.setImagePath(rs.getString("image_path"));
                p.setProductName(rs.getString("product_name"));
                p.setProductPrice(rs.getDouble("product_price"));
                p.setProductImportPrice(rs.getDouble("product_import_price"));
                p.setProductInstock(rs.getInt("product_instock"));
                p.setProductEmpty(rs.getInt("product_empty"));
                p.setProductDescription(rs.getString("product_description"));
                p.setProductCreatedAt(rs.getDate("product_created_at"));
                p.setProductUpdatedAt(rs.getDate("product_updated_at"));
                p.setIsActive(rs.getBoolean("is_active"));
                p.setProviderID(rs.getInt("provider_id"));
                p.setProviderName(rs.getString("provider_name"));
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

    //get product by providerID
    public ArrayList<Product> getProductByProviderID(int providerID) {
        String sql = BASE_SQL
                + "WHERE p.is_active =1 AND p.provider_id = " + providerID;
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("product_id"));
                p.setImagePath(rs.getString("image_path"));
                p.setProductName(rs.getString("product_name"));
                p.setProductPrice(rs.getDouble("product_price"));
                p.setProductImportPrice(rs.getDouble("product_import_price"));
                p.setProductInstock(rs.getInt("product_instock"));
                p.setProductEmpty(rs.getInt("product_empty"));
                p.setProductDescription(rs.getString("product_description"));
                p.setProductCreatedAt(rs.getDate("product_created_at"));
                p.setProductUpdatedAt(rs.getDate("product_updated_at"));
                p.setIsActive(rs.getBoolean("is_active"));
                p.setProviderID(rs.getInt("provider_id"));
                p.setProviderName(rs.getString("provider_name"));
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

    public int updateProduct(Product product) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "UPDATE Product\n"
                + "SET "
                //                + "image_id = " + product.getImagePath() + ",\n"
                + "product_name = N'" + product.getProductName() + "',\n"
                + "provider_id = " + product.getProviderID() + ",\n"
                + "product_price = " + product.getProductPrice() + ",\n"
                + "product_import_price = " + product.getProductImportPrice() + ",\n"
                + "product_instock = " + product.getProductInstock() + ",\n"
                + "product_empty = " + product.getProductEmpty() + ",\n"
                + "is_active = " + (product.isIsActive() ? 1 : 0) + ",\n"
                + "product_description = N'" + product.getProductDescription() + "',\n"
                + "product_updated_at = '" + getCurrentSQLDate() + "'\n"
                + "WHERE product_id = " + product.getProductID();
        try {
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

    public int updateProductQuantity(Product product) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql 
                = "UPDATE Product\n"
                + "SET  product_instock = " + product.getProductInstock() + ",\n"
                + "     product_empty = " + product.getProductEmpty() + "\n"
                + "WHERE product_id = " + product.getProductID();
        try {
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
