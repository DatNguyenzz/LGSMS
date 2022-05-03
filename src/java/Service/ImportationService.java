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

    public Importation getImportationById(int id) {
        return importDAO.getImportationById(id);
    }

    public ArrayList<Importation> getAllImportationForStaff(int id) {
        return importDAO.getAllImportationForStaff(id);
    }

    public ArrayList<Importation> getAllImportationByStaff(int id) {
        return importDAO.getAllImportationForStaff(id);
    }

    public boolean importFromCustomer(int productID, int productImportQuantity,
            String importNote, int staffID) {
        //Update product empty quantity
        ProductDAO productDAO = new ProductDAO();
        Product productImport = productDAO.getProductByID(productID);
        productImport.setProductEmpty(productImport.getProductEmpty() + productImportQuantity);
        int resultUpdateProduct = productDAO.updateProductQuantity(productImport);

        //Add new importation to list
        Importation importation = new Importation();
        importation.setProductID(productID);
        importation.setProductImportQuantity(productImportQuantity);
        importation.setStaffID(staffID);
        importation.setNote(importNote);
        importation.setImportAmount(0);
        int resultInsertImport = importDAO.creatNewImportFromCus(importation);
        return (resultInsertImport != 0 && resultUpdateProduct != 0);
    }

    public boolean importFromProvider(int productID, int providerID,
            int productImportQuantity, double productImportPrice, String importNote, int accountID) {
        ProductDAO productDAO = new ProductDAO();
        Product productImport = productDAO.getProductByID(productID);
        //Update product empty quantity
        if (productImport.getProductEmpty() < productImportQuantity) {
            productImport.setProductEmpty(0);
        } else {
            productImport.setProductEmpty(productImport.getProductEmpty() - productImportQuantity);
        }
        //Update product instock quantity
        productImport.setProductInstock(productImport.getProductInstock() + productImportQuantity);
        //Update product provider
        productImport.setProviderID(providerID);
        //Update product import price
        productImport.setProductImportPrice(productImportPrice);
        //Update product to database
        int resultUpdateProduct = productDAO.updateProduct(productImport);

        //Add new importation to list
        Importation importation = new Importation();
        importation.setProductID(productID);
        importation.setProductImportQuantity(productImportQuantity);
        importation.setManagerID(accountID);
        importation.setProviderID(providerID);
        importation.setNote(importNote);
        importation.setImportAmount(productImportPrice * productImportQuantity);
        int resultInsertImport = importDAO.createNewImport(importation);

        return (resultInsertImport != 0 && resultUpdateProduct != 0);
    }

    public boolean createNewImport(int productID, int providerID,
            int productImportQuantity, double productImportPrice, String importNote,
            int accountID) {
        Importation importation = new Importation();
        importation.setProductID(productID);
        importation.setProductImportQuantity(productImportQuantity);
        importation.setManagerID(accountID);
        importation.setProviderID(providerID);
        importation.setNote(importNote);
        importation.setImportAmount(productImportPrice * productImportQuantity);
        return importDAO.createNewImport(importation) != 0;
    }

    public boolean confirmNewImport(int importID, int productImportPrice, int productImportQuantity, int importStatus, int accountID) {
        //Get import and update info if import is edited
        Importation importation = getImportationById(importID);
        if (importation.getProductImportQuantity() != productImportQuantity
                || importation.getImportAmount() != productImportPrice * productImportQuantity) {
            //Import is edited
            importation.setProductImportQuantity(productImportQuantity);
            importation.setImportAmount(productImportPrice * productImportQuantity);
            importation.setNote(((importation.getNote() != null) ? importation.getNote() : "")
                    + "\nHàng nhập có chỉnh sửa\n");
        }
        importation.setStaffID(accountID);
        importation.setImportStatus(importStatus);

        if (importStatus == 1) {
            //Confirm new import
            ProductDAO productDAO = new ProductDAO();
            Product productImport = productDAO.getProductByID(importation.getProductID());
            //Update product empty quantity
            if (productImport.getProductEmpty() < productImportQuantity) {
                productImport.setProductEmpty(0);
            } else {
                productImport.setProductEmpty(productImport.getProductEmpty() - productImportQuantity);
            }
            //Update product instock quantity
            productImport.setProductInstock(productImport.getProductInstock() + productImportQuantity);
            //Update product provider
            productImport.setProviderID(importation.getProviderID());
            //Update product import price
            productImport.setProductImportPrice(productImportPrice);
            //Update product to database
            int resultUpdateProduct = productDAO.updateProduct(productImport);
            int resultUpdateImport = importDAO.updateImport(importation);

            return (resultUpdateImport != 0 && resultUpdateProduct != 0);
        } else {
            //Cancel new import
            return (importDAO.updateImport(importation) != 0);
        }
    }

}
