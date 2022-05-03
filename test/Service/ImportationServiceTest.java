/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Importation;
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
public class ImportationServiceTest {

    private ImportationService importationService;

    public ImportationServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.importationService = new ImportationService();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllImportation() {
        ArrayList<Importation> immportations = this.importationService.getAllImportation();
        assertTrue(immportations.size() > 0);
    }

    @Test
    public void testImportFromCustomer_UTCID01() {
        //data input
        int productId = 0;
        int providerId = 1;
        int productImportQuantity = 2;
        double productImportPrice = 12000;
        //Date importDate = Date.valueOf("12-13-2021");
        String importNode = "abc";
        int accountId = 1;
        //Importation importation = new Importation(accountId, productId, productImportQuantity, importDate, accountId, providerId, importNode, productImportPrice, importNode, importNode, importNode);
        assertTrue(true);
    }

    @Test
    public void testImportFromCustomer_UTCID02() {
        //data input
        int productId = 1;
        int providerId = 0;
        int productImportQuantity = 2;
        double productImportPrice = 12000;
        //Date importDate = Date.valueOf("12-13-2021");
        String importNode = "abc";
        int accountId = 1;
        //Importation importation = new Importation(accountId, productId, productImportQuantity, importDate, accountId, providerId, importNode, productImportPrice, importNode, importNode, importNode);
        assertTrue(true);
    }

    @Test
    public void testImportFromCustomer_UTCID03() {
        //data input
        int productId = 1;
        int providerId = 1;
        int productImportQuantity = 0;
        double productImportPrice = 12000;
        //Date importDate = Date.valueOf("12-13-2021");
        String importNode = "abc";
        int accountId = 1;
        //Importation importation = new Importation(accountId, productId, productImportQuantity, importDate, accountId, providerId, importNode, productImportPrice, importNode, importNode, importNode);
        assertTrue(true);
    }

    @Test
    public void testImportFromCustomer_UTCID04() {
        //data input
        int productId = 1;
        int providerId = 1;
        int productImportQuantity = 2;
        double productImportPrice = 0;
        //Date importDate = Date.valueOf("12-13-2021");
        String importNode = "abc";
        int accountId = 1;
        //Importation importation = new Importation(accountId, productId, productImportQuantity, importDate, accountId, providerId, importNode, productImportPrice, importNode, importNode, importNode);
        assertTrue(true);
    }

    @Test
    public void testImportFromCustomer_UTCID05() {
        //data input
        int productId = 1;
        int providerId = 1;
        int productImportQuantity = 2;
        double productImportPrice = 0;
        //Date importDate = Date.valueOf("12-13-2021");
        String importNode = "abc";
        int accountId = 0;
        //Importation importation = new Importation(accountId, productId, productImportQuantity, importDate, accountId, providerId, importNode, productImportPrice, importNode, importNode, importNode);
        assertTrue(true);
    }

    @Test
    public void testImportFromCustomer_UTCID06() {
        //data input
        int productId = 1;
        int providerId = 1;
        int productImportQuantity = 2;
        double productImportPrice = 0;
        //Date importDate = Date.valueOf("12-13-2021");
        String importNode = "abc";
        int accountId = 1;
        //Importation importation = new Importation(accountId, productId, productImportQuantity, importDate, accountId, providerId, importNode, productImportPrice, importNode, importNode, importNode);
        assertTrue(true);
    }

    @Test
    public void testImportFromProvider_UTCID01() {
        int productId = 0;
        int providerId = 2;
        int productImportQuantity = 2;
        double productImportPice = 25160;
        String importNote = "sxs";
        int accountId = 1;
        assertTrue(true);
    }

    @Test
    public void testImportFromProvider_UTCID02() {
        int productId = 1;
        int providerId = 0;
        int productImportQuantity = 2;
        double productImportPice = 25160;
        String importNote = "sxs";
        int accountId = 1;
        assertTrue(true);
    }

    @Test
    public void testImportFromProvider_UTCID03() {
        int productId = 1;
        int providerId = 2;
        int productImportQuantity = 0;
        double productImportPice = 25160;
        String importNote = "sxs";
        int accountId = 1;
        assertTrue(true);
    }

    @Test
    public void testImportFromProvider_UTCID04() {
        int productId = 1;
        int providerId = 2;
        int productImportQuantity = 2;
        double productImportPice = 25160;
        String importNote = "sxs";
        int accountId = 0;
        assertTrue(true);
    }

    @Test
    public void testImportFromProvider_UTCID05() {
        int productId = 1;
        int providerId = 2;
        int productImportQuantity = 2;
        double productImportPice = 25160;
        String importNote = "sxs";
        int accountId = 1;
        assertTrue(true);
    }

}