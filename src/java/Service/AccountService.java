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
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
    public Account login(String username, String password) {
        password = encryptPassword(password);
        Account acc = accountDao.getAccountByUsernameAndPassword(username, password);
        return acc;
    }

    //Get list all role
    public ArrayList<Role> getAllRole() {
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
    public Date parseStringToDate(String dateIn) {
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
            String email, int roleId, Boolean isActive) {
        Account acc = getAccountByID(accountId);
        acc.setFullname(fullname);
        acc.setPhone(phone);
        acc.setAddress(address);
        acc.setDOB(parseStringToDate(dob));
        acc.setGender(gender);
        acc.setEmail(email);
        acc.getRole().setRoleID(roleId);
        acc.setIsActive(isActive);
        int result = accountDao.updateAccount(acc);
        return (result != 0);
    }
    
    
    //Update account information
    public boolean updateAccountInProfile(int accountId, String fullname, String phone,
            String address, String dob, Boolean gender,
            String email, int roleId) {
        Account acc = getAccountByID(accountId);
        acc.setFullname(fullname);
        acc.setPhone(phone);
        acc.setAddress(address);
        acc.setDOB(parseStringToDate(dob));
        acc.setGender(gender);
        acc.setEmail(email);
        acc.getRole().setRoleID(roleId);
        
        int result = accountDao.updateAccount(acc);
        return (result != 0);
    }

    //Add new account to database
    public boolean addAccount(String fullname, String phone, String address,
            String dob, Boolean gender,
            String email, int roleId) {
        Account acc = new Account();
        acc = accountDao.getAccountByEmail(email);
        if (acc == null) {
            acc = new Account();
            acc.setFullname(fullname);
            acc.setPhone(phone);
            acc.setAddress(address);
            acc.setDOB(parseStringToDate(dob));
            acc.setGender(gender);
            acc.setUsername(genName(fullname));
            acc.setPassword(encryptPassword(DEFAULT_PASSWORD));
            acc.setEmail(email);
            Role role = new Role();
            role.setRoleID(roleId);
            acc.setRole(role);
            int result = accountDao.addNewAccount(acc);
            return (result != 0);
        } else {
            return false;
        }
    }

    //Register
    public boolean register(String username,
            String email, String password, int roleId) {
        Account acc = new Account();

        acc.setUsername(username);
        acc.setPassword(encryptPassword(password));
        acc.setEmail(email);
        Role role = new Role();
        role.setRoleID(roleId);
        acc.setRole(role);
        int result = accountDao.register(acc);
        return (result != 0);
    }

    //Generate name with FPT format
    public String genName(String in) {
        in = removeAccent(in);
        String[] split = in.split(" ");
        String name = split[split.length - 1].toLowerCase();
        for (int i = 1; i < split.length - 1; i++) {
            name += split[i].subSequence(0, 1).toString().toLowerCase();
        }
        for (int i = 0;; i++) {
            String nameCode = name + i;
            if (accountDao.getAccountByUsername(nameCode) == null) {
                name = nameCode;
                break;
            }
        }
        return name;
    }

    //Remove vietnamese accent
    public String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public String randomPassword() {
        String characters = "AWERTYUIOPSDFGHJKLZXCVBNM1234567890";

        String randomPass = "";
        int legth = 8;
        Random rand = new Random();

        char[] text = new char[legth];
        for (int i = 0; i < legth; i++) {
            text[i] = characters.charAt(rand.nextInt(characters.length()));
        }

        for (int i = 0; i < text.length; i++) {
            randomPass += text[i];
        }
        return randomPass;
    }

    public Account getAccountByEmail(String email) {
        return accountDao.getAccountByEmail(email);
    }

    public boolean isEmailExist(String email) {
        return accountDao.isEmailExist(email);
    }
    
    public boolean isUserNameExist(String userName) {
        return accountDao.isUserNameExist(userName);
    }

    // doi mk cu thanh mat khau random
    public int updatePass(String email, String password) {
        return accountDao.updatePass(email, encryptPassword(password));
    }

    // change password
    public int changePass(int id, String oldpassword, String newPassword) {
        if (encryptPassword(oldpassword).equals(getAccountByID(id).getPassword())) {
            return accountDao.updateAccountPassword(id, encryptPassword(newPassword));
        } else {
            return 0;
        }

    }

    public void send(String to, String sub,
            String msg, final String user, final String pass) {
        //create an instance of Properties Class   
        Properties props = new Properties();

        /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host. 
           As shown here in the code. 
           Change accordingly, if your email id is not a gmail id
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
         */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {

            /* Create an instance of MimeMessage, 
 	      it accept MIME types and headers 
             */
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setContent(msg, "text/html");

            /* Transport class is used to deliver the message to the recipients */
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
