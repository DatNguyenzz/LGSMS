/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.AccountDAO;
import Model.Account;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    //Get list all account
    public ArrayList<Account> getAllAccount() {
        return accountDao.getAllAccount();
    }

    //Get account by ID
    public Account getAccountByID(int id) {
        return accountDao.getAccountByID(id);
    }

    //Update acc new information
    public int getAccountUpdate(Account account) {
        return accountDao.updateAccount(account);
    }
    
    //Login : Get account by username and password
    public Account login(String username, String password){
        password = encryptPassword(password);
        Account acc = accountDao.getAccountByUsernameAndPassword(username, password);
        return acc;
    }

    //Ecrypt password 
    public static String encryptPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {

            return password;
        }
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}
