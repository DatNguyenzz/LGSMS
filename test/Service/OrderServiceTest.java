/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Orders;
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
public class OrderServiceTest {

    private OrderService orderService;

    public OrderServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.orderService = new OrderService();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllOrders() {
        ArrayList<Orders> orders = this.orderService.getAllOrders();
        assertTrue(orders.size() > 0);
    }

    @Test
    public void testGetOrderByID_UTCID01() {
        int id = 0;
        assertTrue(true);
    }

    @Test
    public void testGetOrderByID_UTCID02() {
        int id = 1;
        assertTrue(true);
    }

    @Test
    public void testGetOrderByOrderStatus_UTCID01() {
        int status = 0;
        assertTrue(true);
    }

    @Test
    public void testGetOrderByOrderStatus_UTCID02() {
        int status = 2;
        assertTrue(true);
    }

    @Test
    public void testGetOrderDetailByOrderID_UTCID01() {
        int id = 0;
        assertTrue(true);
    }

    @Test
    public void testGetOrderDetailByOrderID_UTCID02() {
        int id = 1;
        assertTrue(true);
    }

    @Test
    public void testGetAllAcceptedOrderByStaff_UTCID01() {
        int staffId = 0;
        assertTrue(true);
    }

    @Test
    public void testGetAllAcceptedOrderByStaff_UTCID02() {
        int staffId = 2;
        assertTrue(true);
    }

    @Test
    public void testUpdateOrderStatus_UTCID01() {
        int orderId = 0;
        int orderStatus = 1;
        int accountId = 1;
        assertTrue(true);
    }

    @Test
    public void testUpdateOrderStatus_UTCID02() {
        int orderId = 1;
        int orderStatus = 0;
        int accountId = 1;
        assertTrue(true);
    }

    @Test
    public void testUpdateOrderStatus_UTCID03() {
        int orderId = 1;
        int orderStatus = 2;
        int accountId = 0;
        assertTrue(true);
    }

    @Test
    public void testUpdateOrderStatus_UTCID04() {
        int orderId = 1;
        int orderStatus = 2;
        int accountId = 1;
        assertTrue(true);
    }

    @Test
    public void testGetOrderByStatusAndStaff_UTCID01() {
        int orderId = 0;
        int staffId = 1;
        assertTrue(true);
    }

    @Test
    public void testGetOrderByStatusAndStaff_UTCID02() {
        int orderId = 2;
        int staffId = 0;
        assertTrue(true);
    }

    @Test
    public void testGetOrderByStatusAndStaff_UTCID03() {
        int orderId = 2;
        int staffId = 1;
        assertTrue(true);
    }

    @Test
    public void testGetListOrderDetailByOrderID_UTCID01() {
        int orderId = 0;
        assertTrue(true);
    }

    @Test
    public void testGetListOrderDetailByOrderID_UTCID02() {
        int orderId = 2;
        assertTrue(true);
    }

    @Test
    public void testGetListOrderDetailByOrderID_UTCID03() {
        int orderId = 3;
        assertTrue(true);
    }

    @Test
    public void testUpdateOrder_UTCID01() {
        int orderId = 0;
        String note2 = "string";
        int orderStatus = 1;
        assertTrue(true);
    }

    @Test
    public void testUpdateOrder_UTCID02() {
        int orderId = 1;
        String note2 = "";
        int orderStatus = 1;
        assertTrue(true);
    }

    @Test
    public void testUpdateOrder_UTCID03() {
        int orderId = 1;
        String note2 = "Srting";
        int orderStatus = 0;
        assertTrue(true);
    }

    @Test
    public void testUpdateOrder_UTCID04() {
        int orderId = 1;
        String note2 = "Srting";
        int orderStatus = 1;
        assertTrue(true);
    }

}
