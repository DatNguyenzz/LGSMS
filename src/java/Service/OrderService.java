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
    
    public ArrayList<Orders> getAllOrders(){
        return orderDao.getAllOrders();
    }
    
    public ArrayList<Orders> getOrdersByStatus(int status){
        return orderDao.getOrderByOrderStatus(status);
    }
    
     public ArrayList<OrderDetail> getOrderDetailByOrderID(int id){
        return orderDao.getOrderDetailByOrderId(id);
    }
     
     
}
