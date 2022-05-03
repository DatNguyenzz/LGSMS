/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ProductDAO;
import Model.Product;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Dat Nguyen
 */
public class ProductService {
    ProductDAO productDAO = new ProductDAO();
    
    //get list all product from database
    public ArrayList<Product> getAllProduct(){
        return productDAO.getAllProduct();
    }
     public ArrayList<Product> getAllProductIsActive(){
        return productDAO.getProductIsActive();
    }
     
     public ArrayList<Product> getAllProductFilter(int filter){
        return productDAO.getProductIactiveWithFilter(filter);
    }
     
     public ArrayList<Product> getSearchProduct(String seach){
        return productDAO.searchProduct(seach);
    }
    
    //add new product to database
    public boolean addNewProductToDB(String productName, int productImage, 
            int productQuantity, double productPrice, String productDescription,
            int providerID) {
        Product product = new Product();
        product.setProductName(productName);
//        product.setImagePath(productImage);
        product.setProductInstock(productQuantity);
        product.setProductEmpty(0);
        product.setProductPrice(productPrice);
        product.setProductDescription(productDescription);
        product.setIsActive(true);
        product.setProviderID(providerID);
        int result = productDAO.addNewProductToDB(product);
        return (result!=0);
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
            int image, double productPrice, boolean productStatus, 
            String productDescription) {
        Product product = getProductByID(productID);
        product.setProductName(productName);
        product.setProviderID(providerID);
//        product.setImagePath(image);
        product.setProductPrice(productPrice);
        product.setIsActive(productStatus);
        product.setProductDescription(productDescription);
        int result = productDAO.updateProduct(product);
        return (result != 0);
        
    }
    
     public boolean isProductNameIsExsit(String productName){
        return productDAO.isProductNameExist(productName);
    }
    
}
