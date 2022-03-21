/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ProductDAO;
import Model.Product;
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
    
    //add new product to database
    public boolean addNewProductToDB(Product product){
        int result = productDAO.addNewProductToDB(product);
        return result != 0;
    }
}
