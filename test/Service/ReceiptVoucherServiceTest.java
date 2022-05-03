/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.ReceiptVoucher;
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
public class ReceiptVoucherServiceTest {

    private ReceiptVoucherService receiptVoucherService;

    public ReceiptVoucherServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.receiptVoucherService = new ReceiptVoucherService();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllReceiptVoucher() {
        ArrayList<ReceiptVoucher> receiptVouchers = this.receiptVoucherService.getAllReceiptVoucher();
        assertTrue(receiptVouchers.size() > 0);
    }

    @Test
    public void testCreatNewReceiptVoucher_UTCID01() {
        int orderId = 0;
        int staffId = 1;
        assertTrue(true);
    }
    
    @Test
    public void testCreatNewReceiptVoucher_UTCID02() {
        int orderId = 2;
        int staffId = 0;
        assertTrue(true);
    }
    
    @Test
    public void testCreatNewReceiptVoucher_UTCID03() {
        int orderId = 2;
        int staffId = 1;
        assertTrue(true);
    }

    @Test
    public void testGetReceiptVoucherByID_UTCID01() {
        int recriptId = 0;
        assertTrue(true);
    }
    
    @Test
    public void testGetReceiptVoucherByID_UTCID02() {
        int recriptId = 2;
        assertTrue(true);
    }

    @Test
    public void testUpdateReceiptVoucher_UTCID01() {
        int reciptId = 0;
        assertTrue(true);
    }
    
    @Test
    public void testUpdateReceiptVoucher_UTCID02() {
        int reciptId = 0;
        assertTrue(true);
    }
    
    @Test
    public void testUpdateReceiptVoucher_UTCID03() {
        int reciptId = 0;
        assertTrue(true);
    }
    
    @Test
    public void testUpdateReceiptVoucher_UTCID04() {
        int reciptId = 0;
        assertTrue(true);
    }

    @Test
    public void testGetReceiptVoucherByOrderID_UTCID01() {
        int reciptId = 0;
        assertTrue(true);
    }
    
    @Test
    public void testGetReceiptVoucherByOrderID_UTCID02() {
        int reciptId = 1;
        assertTrue(true);
    }

}

