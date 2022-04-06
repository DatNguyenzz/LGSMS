package Model;

import java.sql.Date;
import java.text.DecimalFormat;
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
    private Date createdAt;
    private Date updatedAt;
    private String customerName;
    private String orderNote1;
    private String orderNote2;
    private int bussinessStaffID;
    private double totalPrice;
    private String customerPhone;
    private String customerAddress;
    private List<OrderDetail> orderDetail;

    public Orders() {
    }

    public Orders(int orderID, String orderCode, int customerID, 
            int orderStatus, Date createdAt,Date updatedAt, String customerName, 
            String orderNote1, String orderNote2, int bussinessStaffID,
            double totalPrice, String customerPhone, String customerAddress) {
        this.orderID = orderID;
        this.orderCode = orderCode;
        this.customerID = customerID;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.customerName = customerName;
        this.orderNote1 = orderNote1;
        this.orderNote2 = orderNote2;
        this.bussinessStaffID = bussinessStaffID;
        this.totalPrice = totalPrice;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    
    public String formatMoneyToVND(double in){
        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        return formatter.format(in) + " VND";
    }
}