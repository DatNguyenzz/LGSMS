/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ProviderDAO;
import Model.Provider;
import java.util.ArrayList;

/**
 *
 * @author Dat Nguyen
 */
public class ProviderService {
    ProviderDAO providerDao= new ProviderDAO();
    
    public ArrayList<Provider> getAllProvider(){
        return providerDao.getAllProvider();
    }
    
     public int getPoviderUpdate(Provider provider){
       
            return providerDao.updateProvider(provider);
       
    }
     
     public boolean addNewProviderToDB(Provider provider){
        int result = providerDao.addNewProviderToDB(provider);
        return result != 0;
    }
}
