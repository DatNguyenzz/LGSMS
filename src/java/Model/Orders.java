/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dat Nguyen
 */
public class Orders {
    private int orderID;
    private String orderCode;
    private int customerID;
    private int orderStatus;
    private Date orderDate;
    private String customerName;
    private String orderNote1;
    private String orderNote2;
    private int bussinessStaffID;
    private double totalPrice;
    private List<OrderDetail> orderDetail;
    
    public Orders() {
        orderDetail= new ArrayList<>();
    }

    public Orders(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    
    public Orders(int orderID, String orderCode, int customerID, int orderStatus, Date orderDate, String customerName, String orderNote1, String orderNote2, int bussinessStaffID, double totalPrice) {
        this.orderID = orderID;
        this.orderCode = orderCode;
        this.customerID = customerID;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.orderNote1 = orderNote1;
        this.orderNote2 = orderNote2;
        this.bussinessStaffID = bussinessStaffID;
         this.totalPrice = totalPrice;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNote1() {
        return orderNote1;
    }

    public void setOrderNote1(String orderNote1) {
        this.orderNote1 = orderNote1;
    }

    public String getOrderNote2() {
        return orderNote2;
    }

    public void setOrderNote2(String orderNote2) {
        this.orderNote2 = orderNote2;
    }

    public int getBussinessStaffID() {
        return bussinessStaffID;
    }

    public void setBussinessStaffID(int bussinessStaffID) {
        this.bussinessStaffID = bussinessStaffID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
    
}
