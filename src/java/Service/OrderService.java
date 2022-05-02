/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.OrderDAO;
import DAO.ProductDAO;
import Model.OrderDetail;
import Model.Orders;
import Model.Product;
import Model.ShoppingCart;
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
        return orderDao.getListOrderDetailByOrderId(id);
    }

    //Get all accepted order by staff id
    public ArrayList<Orders> getAllAcceptedOrderByStaff(int staffID) {
        return orderDao.getAllAcceptedOrderByStaff(staffID);
    }

    public boolean updateOrderStatus(int orderId, int orderStatus, int accountID, String note2) {
        boolean result = false;
        Orders order = getOrderByID(orderId);
        if (order.getOrderStatus() == 0) {
            //Update staff accept new order
            order.setBussinessStaffID(accountID);
            if (orderStatus != 4) {
                //Update product quantity if staff accept new order
                ArrayList<OrderDetail> listOrderDetail = getListOrderDetailByOrderID(orderId);
                ProductDAO productDAO = new ProductDAO();
                for (OrderDetail od : listOrderDetail) {
                    Product p = productDAO.getProductByID(od.getProductID());
                    if (p.getProductInstock() < od.getProductQuantity()) {
                        //Dont have enough product instock to sell for customer
                        return false;
                    }
                    p.setProductInstock(p.getProductInstock() - od.getProductQuantity());
                    int resultUpdateProduct = productDAO.updateProductQuantity(p);
                    if (resultUpdateProduct == 0) {
                        System.out.println("Update product fail");
                        return false;
                    }
                }
            }
        }
        switch (orderStatus) {
            case 1: //Accept new order
                //Update status and staff for order
                int updateDbResult = orderDao.staffUpdateOrderStatus(orderId, accountID, orderStatus);
                //Create new receipt voucher for staff
                boolean createNewReceiptVoucher = new ReceiptVoucherService().creatNewReceiptVoucher(orderId, accountID);

                return (updateDbResult != 0 && createNewReceiptVoucher);
            case 2: {//Order being delivered
                order.setOrderNote2(note2);
                order.setOrderStatus(orderStatus);
                return (orderDao.updateOrderStatus(order) != 0);
            }
            case 3: {//Order completed
                order.setOrderNote2(note2);
                order.setOrderStatus(orderStatus);
                return (orderDao.updateOrderStatus(order) != 0);
            }
            case 4: {//Cancel order
                if (order.getOrderStatus() != 0) {
                    //Cancel confirmed order
                    ArrayList<OrderDetail> listOrderDetail = getListOrderDetailByOrderID(orderId);
                    ProductDAO productDAO = new ProductDAO();
                    for (OrderDetail od : listOrderDetail) {
                        Product p = productDAO.getProductByID(od.getProductID());
                        p.setProductInstock(p.getProductInstock() + od.getProductQuantity());
                        int resultUpdateProduct = productDAO.updateProductQuantity(p);
                        if (resultUpdateProduct == 0) {
                            System.out.println("Update product fail");
                            return false;
                        }
                    }
                }
                //Reject new order
                order.setOrderNote2(note2);
                order.setOrderStatus(orderStatus);
                return (orderDao.updateOrderStatus(order) != 0);
            }
        }
        return result;
    }

    public ArrayList<Orders> getOrderByStatusAndStaff(int status, int staffID) {
        return orderDao.getOrderByStatusAndStaff(status, staffID);
    }

    public ArrayList<OrderDetail> getListOrderDetailByOrderID(int orderID) {
        return orderDao.getListOrderDetailByOrderId(orderID);
    }

    public boolean updateOrder(int orderID, String note2, int orderStatus) {
        Orders order = getOrderByID(orderID);
        order.setOrderNote2(note2);
        order.setOrderStatus(orderStatus);
        return (orderDao.updateOrderStatus(order) != 0);
    }

    //Customer create new order
    public boolean createNewOrder(int accountID, String fullname, String phone, String address, String note) {
        ShoppingCartService cartService = new ShoppingCartService();
        ArrayList<ShoppingCart> listCartByCusID = cartService.getCartByCusID(accountID);
        Orders order = new Orders();
        order.setCustomerID(accountID);
        order.setCustomerName(fullname);
        order.setCustomerPhone(phone);
        order.setCustomerAddress(address);
        order.setOrderNote1(note);
        order.setOrderCode(genOrderCode());
        order.setOrderStatus(0);
        ArrayList<OrderDetail> listOrderDetail = new ArrayList<>();
        for (ShoppingCart cart : listCartByCusID) {
            OrderDetail od = new OrderDetail();
            od.setOrderID(accountID);
            od.setProductID(cart.getProductID());
            od.setProductQuantity(cart.getProductQuantity());
            od.setPrice(cart.getProduct().getProductPrice() * cart.getProductQuantity());
            od.setProductName(cart.getProduct().getProductName());
            listOrderDetail.add(od);
        }
        order.setOrderDetail(listOrderDetail);
        if (orderDao.createNewOrder(order) != 0) {
            //Clear cart if create order success
            boolean flag = new ShoppingCartService().clearCartForCusByID(accountID);
            return flag;
        } else {
            return false;
        }
    }

    //GENERATE ORDERCODE
    public String genOrderCode() {
        String[] stringDate = orderDao.getCurrentSQLDate().toString().split("-");
        String code = "DH" + stringDate[2] + stringDate[1] + stringDate[0];
        for (int i = 1;; i++) {
            Orders o = getOrderByOrderCode(code + i);
            if (o == null) {
                return code + i;
            }
        }
    }

    //Get order by order code
    public Orders getOrderByOrderCode(String code) {
        return orderDao.getOrderByOrderCode(code);
    }

    public ArrayList<Orders> getListOrdersByCusId(int id) {
        return orderDao.getListOrderByCusID(id);
    }

    //Get name of staff who confirm the order
    public String getStaffNameByOrderID(int orderId) {
        return orderDao.getStaffCodeByOrderID(orderId);
    }
}
