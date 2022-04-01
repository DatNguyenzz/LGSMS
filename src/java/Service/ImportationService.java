package Service;

import DAO.ImportationDAO;
import DAO.ProductDAO;
import Model.Importation;
import Model.Product;
import java.util.ArrayList;

/**
 *
 * @author Dat Nguyen
 */
public class ImportationService {
    ImportationDAO importDAO = new ImportationDAO();
    
    
    public ArrayList<Importation> getAllImportation() {
        return importDAO.getAllImportation();
    }

    public boolean importFromCustomer(int productID, int providerID, 
            int productImportQuantity, double importAmount, String importNote, int accountID) {
        //Update product empty quantity
        ProductDAO productDAO = new ProductDAO();
        Product productImport = productDAO.getProductByID(productID);
        productImport.setProductEmpty(productImport.getProductEmpty() + productImportQuantity);
        int resultUpdateProduct = productDAO.updateProduct(productImport);
        
        //Add new importation to list
        Importation importation = new Importation();
        importation.setProductID(productID);
        importation.setProductImportQuantity(productImportQuantity);
        importation.setAccountID(accountID);
        importation.setProviderID(providerID);
        importation.setNote(importNote);
        importation.setImportAmount(importAmount);
        int resultInsertImport = importDAO.addImport(importation);
        
        return (resultInsertImport != 0 && resultUpdateProduct != 0);
    }

    public boolean importFromProvider(int productID, int providerID, 
            int productImportQuantity, double importAmount, String importNote, int accountID) {
        ProductDAO productDAO = new ProductDAO();
        Product productImport = productDAO.getProductByID(productID);
        //Update product empty quantity
        if(productImport.getProductEmpty() < productImportQuantity){
            productImport.setProductEmpty(0);
        }else{
            productImport.setProductEmpty(productImport.getProductEmpty() - productImportQuantity);
        }
        //Update product instock quantity
        productImport.setProductInstock(productImport.getProductInstock() + productImportQuantity);
        productImport.setProviderID(providerID);
        productImport.setProductImportPrice(importAmount / productImportQuantity);
        int resultUpdateProduct = productDAO.updateProduct(productImport);
        
        //Add new importation to list
        Importation importation = new Importation();
        importation.setProductID(productID);
        importation.setProductImportQuantity(productImportQuantity);
        importation.setAccountID(accountID);
        importation.setProviderID(providerID);
        importation.setNote(importNote);
        importation.setImportAmount(importAmount);
        int resultInsertImport = importDAO.addImport(importation);
        
        return (resultInsertImport != 0 && resultUpdateProduct != 0);
    }
    
}