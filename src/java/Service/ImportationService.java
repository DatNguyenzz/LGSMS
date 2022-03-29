/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ImportationDAO;
import Model.Importation;
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
    
}
