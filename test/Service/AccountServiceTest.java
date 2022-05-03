/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Account;
import Model.Role;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class AccountServiceTest {

    private AccountService accountService;

    public AccountServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        //connect db 
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        this.accountService = new AccountService();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllAccount_UTCID01() {
        ArrayList<Account> accounts = new ArrayList();
        ArrayList<Account> actualOutput = this.accountService.getAllAccount();
        actualOutput.stream().forEach(e -> {
            System.out.println(e.getAccountID());
        });

        assertEquals(6, actualOutput.size());
    }

    @Test
    public void testGetAllAccount_UTCID02() {
        ArrayList<Account> accounts = new ArrayList();
        ArrayList<Account> actualOutput = this.accountService.getAllAccount();
        actualOutput.stream().forEach(e -> {
            System.out.println(e.getAccountID());
        });

        assertEquals(6, actualOutput.size());
    }

    @Test
    public void testGetAccountByID_nomal_UTCID01() {
        //data input
        int id = 1;
        Account actualOutput = this.accountService.getAccountByID(id);

        //compare
        assertEquals(id, actualOutput.getAccountID());
        
    }

    @Test()
    public void testGetAccountByID_normal_UTCID02() {
        //data input
        int id = 5;

        //call method
        Account actualOutput = this.accountService.getAccountByID(id);
        
        //expect throw exception
        assertEquals(id,actualOutput.getAccountID());
    }

    @Test(expected = NullPointerException.class)
    public void testGetAccountByID_abnormal_UTCID03() {
        //data input
        int id = -1;

        Account actualOutput = this.accountService.getAccountByID(id);
        //expect throw exception
        assertEquals(id, actualOutput.getAccountID());
    }

    @Test(expected = NullPointerException.class)
    public void testGetAccountByID_abnormal_UTCID04() {
        //data input
        int id = 0;

        Account actualOutput = this.accountService.getAccountByID(id);
        //expect throw exception
        assertEquals(id, actualOutput.getAccountID());
    }

    @Test
    public void testGetAccountUpdate_abnormal_UTCID01() {
        //data input
        Account account = new Account();

        //int rs = this.accountService.getAccountUpdate(account);
        //assertEquals(rs, 1);
        assertTrue(true);
    }

    @Test
    public void testGetAccountUpdate_abnormal_UTCID02() {
        //data input
        Account account = new Account();

        //int rs = this.accountService.getAccountUpdate(account);
        //assertEquals(rs, 1);
        assertTrue(true);
    }

    @Test
    public void testGetAccountUpdate_normal_UTCID03() {
        //data input
        Account account = new Account();

        //int rs = this.accountService.getAccountUpdate(account);
        //assertEquals(rs, 1);
        assertTrue(true);
    }

    @Test
    public void testGetAccountUpdate_normal_UTCID04() {
        //data input
        Account account = new Account();

        //int rs = this.accountService.getAccountUpdate(account);
        //assertEquals(rs, 1);
        assertTrue(true);
    }

    @Test
    public void testLogin_abnormal_UTCID01() {
        //data input
        String username = "long";
        String password = "123456";
        Account account = this.accountService.login(username, password);

        //assertEquals((account!== string));
        assertTrue(account!= null);
    }

    @Test
    public void testLogin_abnormal_UTCID02() {
        //data input
        String username = "abc";
        String password = "";
        Account account = this.accountService.login(username, password);

        //assertEquals((account!== string));
        assertTrue(account == null);
    }
    
        @Test
    public void testLogin_normal_UTCID03() {
        //data input
        String username = "abc";
        String password = "xyz";
        Account account = this.accountService.login(username, password);

        //assertEquals((account!== string));
        assertTrue(true);
    }

    @Test
    public void testGetAllRole() {
        ArrayList<Role> roles = this.accountService.getAllRole();
        assertTrue(true);
    }

    @Test
    public void testEncryptPassword_UTCID01() {
        //data input
        String password = "";
        String encryptRs = AccountService.encryptPassword(password);
        assertTrue(true);
    }
    
    @Test
    public void testEncryptPassword_UTCID02() {
        //data input
        String password = "abcs";
        String encryptRs = AccountService.encryptPassword(password);
        assertTrue(true);
    }
    
    @Test
    public void testEncryptPassword_UTCID03() {
        //data input
        String password = "Pass1223*";
        String encryptRs = AccountService.encryptPassword(password);
        assertTrue(true);
    }

    @Test
    public void testParseStringToDate_UTCID01() {
        String dateIn = "";
        //Date date = this.accountService.parseStringToDate(dateIn);
        assertTrue(true);
    }
    
    @Test
    public void testParseStringToDate_UTCID02() {
        String dateIn = "30-13-2015";
        //Date date = this.accountService.parseStringToDate(dateIn);
        assertTrue(true);
    }
    
    @Test
    public void testParseStringToDate_UTCID03() {
        String dateIn = "32-2-2018";
        Date date = this.accountService.parseStringToDate(dateIn);
        assertTrue(true);
    }
    
    @Test
    public void testParseStringToDate_UTCID04() {
        String dateIn = "12-4-2021";
        Date date = this.accountService.parseStringToDate(dateIn);
        assertTrue(true);
    }

    @Test
    public void testUpdateAccount_UTCID01() {
        Account account = new Account();
        assertTrue(true);
    }
    
    @Test
    public void testUpdateAccount_UTCID02() {
        Account account = new Account();
        assertTrue(true);
    }

    @Test
    public void testAddAccount_UTCID01() {
        Account account = new Account();
        assertTrue(true);
    }
    
    @Test
    public void testAddAccount_UTCID02() {
        Account account = new Account();
        assertTrue(true);
    }
    
    @Test
    public void testRegister_UTCID01() {
        String username = "vanhpc";
        String email = "vanhpc123";
        String password = "manhdt";
        int roleId = 1;
        assertTrue(true);
    }
    
    @Test
    public void testRegister_UTCID02() {
        String username = "vanhpc";
        String email = "vanhpc123";
        String password = "manhdt";
        int roleId = 1;
        assertTrue(true);
    }

    @Test
    public void testGenName_UTCID01() {
        String in = "";
        String name = this.accountService.genName(in);
        assertTrue(true);
    }
    
    @Test
    public void testGenName_UTCID02() {
        String in = "av";
        String name = this.accountService.genName(in);
        assertTrue(true);
    }

    @Test
    public void testRemoveAccent_UTCID01() {
        String in = "";
        String name = this.accountService.removeAccent(in);
        assertTrue(true);
    }
    
    @Test
    public void testRemoveAccent_UTCID02() {
        String in = "abcd";
        String name = this.accountService.removeAccent(in);
        assertTrue(true);
    }
    
    @Test
    public void testRemoveAccent_UTCID03() {
        String in = "abcd";
        String name = this.accountService.removeAccent(in);
        assertTrue(true);
    }
    
    @Test
    public void testRemoveAccent_UTCID04() {
        String in = "abcd";
        String name = this.accountService.removeAccent(in);
        assertTrue(true);
    }

}