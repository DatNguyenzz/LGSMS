/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.AccountDAO;
import Model.Account;
import Model.Role;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class AccountService {
    private static final String DEFAULT_PASSWORD = "123456";

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
    
    //Get list all role
    public ArrayList<Role> getAllRole(){
        return accountDao.getAllRole();
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
    
    //Parse string to sql date
    public Date parseStringToDate(String dateIn){
        try {
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateIn);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //Update account information
    public boolean updateAccount(int accountId, String fullname, String phone, 
            String address, String dob, Boolean gender, 
            String username, String email, int roleId) {
        Account acc = getAccountByID(accountId);
        acc.setFullname(fullname);
        acc.setPhone(phone);
        acc.setAddress(address);
        acc.setDOB(parseStringToDate(dob));
        acc.setGender(gender);
        acc.setUsername(username);
        acc.setEmail(email);
        acc.getRole().setRoleID(roleId);
        int result = accountDao.updateAccount(acc);
        return (result != 0);
    }
    
    //Add new account to database
    public boolean addAccount(String fullname, String phone, String address, 
            String dob, Boolean gender, String username, 
            String email, int roleId) {
        Account acc = new Account();
        acc.setFullname(fullname);
        acc.setPhone(phone);
        acc.setDOB(parseStringToDate(dob));
        acc.setGender(gender);
        acc.setUsername(username);
        acc.setPassword(encryptPassword(DEFAULT_PASSWORD));
        acc.setEmail(email);
        Role role = new Role();
        role.setRoleID(roleId);
        acc.setRole(role);
        int result = accountDao.addNewAccount(acc); 
        return (result != 0);
        
    }
}
