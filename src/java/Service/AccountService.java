/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.AccountDAO;
import Model.Account;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class AccountService {
    AccountDAO accountDao = new AccountDAO();
    public ArrayList<Account> getAllAccount(){
        return accountDao.getAllAccount();
    }
    
    public Account getAccountByID(int id){
        return accountDao.getAccountByID(id);
    }
    
    public int getAccountUpdate(Account account){
       
            return accountDao.updateAccount(account);
       
    }
}
