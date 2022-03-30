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
        return productDAO.getProductIactive();
    }
    
    //add new product to database
    public boolean addNewProductToDB(String productName, int productImage, int productQuantity, double productPrice, String productDescription) {
        Product product = new Product();
        product.setProductName(productName);
        product.setImageID(productImage);
        product.setProductInstock(productQuantity);
        product.setProductInuse(0);
        product.setProductPrice(productPrice);
        product.setProductDescription(productDescription);
        product.setIsActive(true);
        int result = productDAO.addNewProductToDB(product);
        return (result!=0);
    }

    //get product by ID
    public Product getProductByID(int productID) {
        return productDAO.getProductByID(productID);
    }

    //Update product information
    public boolean updateProduct(int productID, String productName, int providerID, 
            int image, double productPrice, boolean productStatus, 
            String productDescription) {
        Product product = getProductByID(productID);
        product.setProductName(productName);
        product.setProviderID(providerID);
        product.setImageID(image);
        product.setProductPrice(productPrice);
        product.setIsActive(productStatus);
        product.setProductDescription(productDescription);
        int result = productDAO.updateProduct(product);
        return (result != 0);
        
    }
    
}
