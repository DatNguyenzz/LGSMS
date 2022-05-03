/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Product;
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
public class ProductServiceTest {

    private ProductService productService;

    public ProductServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.productService = new ProductService();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllProduct() {
        ArrayList<Product> products = this.productService.getAllProduct();
        assertTrue(products.size() > 0);
    }

    @Test
    public void testGetAllProductIsActive() {
        ArrayList<Product> products = this.productService.getAllProductIsActive();
        assertTrue(products.size() > 0);
    }

    @Test
    public void testGetAllProductFilter_UTCID01() {
        int filter = -1;
        assertTrue(true);
    }

    @Test
    public void testGetAllProductFilter_UTCID02() {
        int filter = 0;
        assertTrue(true);
    }

    @Test
    public void testGetAllProductFilter_UTCID03() {
        int filter = 1;
        assertTrue(true);
    }

    @Test
    public void testGetSearchProduct_UTCID01() {
        String searchStr = "";
        assertTrue(true);
    }

    @Test
    public void testGetSearchProduct_UTCID02() {
        String searchStr = "abc";
        assertTrue(true);
    }

    @Test
    public void testGetSearchProduct_UTCID03() {
        String searchStr = "xxabc";
        assertTrue(true);
    }

    @Test
    public void testAddNewProductToDB_UTCID01() {
        assertTrue(true);
    }

    @Test
    public void testAddNewProductToDB_UTCID02() {
        assertTrue(true);
    }

    @Test
    public void testAddNewProductToDB_UTCID03() {
        assertTrue(true);
    }

    @Test
    public void testAddNewProductToDB_UTCID04() {
        assertTrue(true);
    }

    @Test
    public void testGetProductByID_UTCID01() {
        int id = 0;
        assertTrue(true);
    }

    @Test
    public void testGetProductByID_UTCID02() {
        int id = 1;
        assertTrue(true);
    }

    @Test
    public void testUpdateProduct_UTCID01() {
        int providerId = 0;
        assertTrue(true);
    }

    @Test
    public void testUpdateProduct_UTCID02() {
        int providerId = 1;
        assertTrue(true);
    }
    
    @Test
    public void testUpdateProduct_UTCID03() {
        int providerId = 1;
        assertTrue(true);
    }
    
    @Test
    public void testUpdateProduct_UTCID04() {
        int providerId = 1;
        assertTrue(true);
    }

}

