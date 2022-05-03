/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Provider;
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
public class ProviderServiceTest {
    
    private ProviderService providerService;
    
    public ProviderServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.providerService = new ProviderService();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetAllProvider() {
        ArrayList<Provider> providers = this.providerService.getAllProvider();
        assertTrue(providers.size() > 0);
    }
    
    @Test
    public void testGetPoviderUpdate() {
        //ArrayList<Provider> providers = this.providerService.get();
        assertTrue(true);
    }
    
    @Test
    public void testAddNewProviderToDB() {
        assertTrue(true);
    }
    
}
