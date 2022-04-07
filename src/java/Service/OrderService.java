/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.OrderDAO;
import Model.OrderDetail;
import Model.Orders;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class OrderService {

    OrderDAO orderDao = new OrderDAO();

    public ArrayList<Orders> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public Orders getOrderByID(int id) {
        return orderDao.getOrderById(id);
    }

    public ArrayList<Orders> getOrderByOrderStatus(int status) {
        return orderDao.getOrderByOrderStatus(status);
    }

    public ArrayList<OrderDetail> getOrderDetailByOrderID(int id) {
        return orderDao.getOrderDetailByOrderId(id);
    }

    //Get all accepted order by staff id
    public ArrayList<Orders> getAllAcceptedOrderByStaff(int staffID) {
        return orderDao.getAllAcceptedOrderByStaff(staffID);
    }

    public boolean updateOrderStatus(int orderId, int orderStatus, int accountID) {
        boolean result = false;
        switch (orderStatus) {
            case 1: //Accept new order
                //Update status and staff for order
                int updateDbResult = orderDao.staffUpdateOrderStatus(orderId, accountID, orderStatus);
                //Create mew receipt voucher for staff
                boolean createNewReceiptVoucher = new ReceiptVoucherService().creatNewReceiptVoucher(orderId, accountID);
                return (updateDbResult != 0 && createNewReceiptVoucher);
            case 2: //Order being delivered

                break;
            case 3: //Order completed

                break;
            case 4: //Cancel order
                return (orderDao.staffUpdateOrderStatus(orderId, accountID, orderStatus) != 0);
        }
        return result;
    }

    public ArrayList<Orders> getOrderByStatusAndStaff(int status, int staffID) {
        return orderDao.getOrderByStatusAndStaff(status, staffID);
    }

    public ArrayList<OrderDetail> getListOrderDetailByOrderID(int orderID) {
        return orderDao.getOrderDetailByOrderId(orderID);
    }

    public boolean updateOrder(int orderID, String note2, int orderStatus) {
        Orders order = getOrderByID(orderID);
        order.setOrderNote2(note2);
        order.setOrderStatus(orderStatus);
        return (orderDao.updateOrderStatus(order) != 0);
    }

}
