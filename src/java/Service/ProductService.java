/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ProductDAO;
import Model.Product;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author Dat Nguyen
 */
public class ProductService {

    ProductDAO productDAO = new ProductDAO();

    //get list all product from database
    public ArrayList<Product> getAllProduct() {
        return productDAO.getAllProduct();
    }

    public ArrayList<Product> getAllProductIsActive() {
        return productDAO.getProductIsActive();
    }

    public ArrayList<Product> getAllProductFilter(int filter) {
        return productDAO.getProductIactiveWithFilter(filter);
    }

    public ArrayList<Product> getSearchProduct(String seach) {
        return productDAO.searchProduct(seach);
    }

    //add new product to database
    public boolean addNewProductToDB(String productName, int productQuantity,
            double productPrice, String productDescription, int providerID,
            String storePath, FileItem item) {
        Product product = new Product();
        product.setProductName(productName);
        product.setImagePath(storeProductImage(storePath, item, productName));
        product.setProductInstock(productQuantity);
        product.setProductEmpty(0);
        product.setProductPrice(productPrice);
        product.setProductDescription(productDescription);
        product.setIsActive(true);
        product.setProviderID(providerID);
        int result = productDAO.addNewProductToDB(product);
        return (result != 0);
    }

    //get product by ID
    public Product getProductByID(int productID) {
        return productDAO.getProductByID(productID);
    }

    //get product by provider ID
    public ArrayList<Product> getProductByProviderID(int providerID) {
        return productDAO.getProductByProviderID(providerID);
    }

    //Update product information
    public boolean updateProduct(int productID, String productName, int providerID,
            double productPrice, boolean productStatus, String productDescription,
            String storePath, FileItem item) {
        Product product = getProductByID(productID);
        product.setProductName(productName);
        product.setProviderID(providerID);
        product.setImagePath(storeProductImage(storePath, item, productName));
        product.setProductPrice(productPrice);
        product.setIsActive(productStatus);
        product.setProductDescription(productDescription);
        int result = productDAO.updateProduct(product);
        return (result != 0);

    }

    public boolean isProductNameIsExsit(String productName) {
        return productDAO.isProductNameExist(productName);
    }

    public String storeProductImage(String storePath, FileItem item, String productName) {
        try {
            File uploadFile = new File(storePath + File.separator
                    + "product_image_" + productName //
                    + item.getContentType().replaceFirst("image/", "."));
            if (uploadFile.exists()) {
                uploadFile.delete();
            }
            item.write(uploadFile);
            String imagePath = "Assets/images/product/"
                    + "product_image_" + productName
                    + item.getContentType().replaceFirst("image/", ".");
            return imagePath;
        } catch (Exception ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
