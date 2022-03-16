package LGSMS.Model;

import java.sql.Date;

public class OrderDetail {
	private int orderID;
	private String orderCode;
	private int customerID;
	private int productID;
	private int productQuantity;
	private double price;
	private int orderStatus;
	private Date orderDate;
	private String orderNote1;
	private String orderNote2;
	private int businessStaffID;
	public OrderDetail() {
		super();
	}
	public OrderDetail(int orderID, String orderCode, int customerID, int productID, int productQuantity, double price,
			int orderStatus, Date orderDate, String orderNote1, String orderNote2, int businessStaffID) {
		super();
		this.orderID = orderID;
		this.orderCode = orderCode;
		this.customerID = customerID;
		this.productID = productID;
		this.productQuantity = productQuantity;
		this.price = price;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderNote1 = orderNote1;
		this.orderNote2 = orderNote2;
		this.businessStaffID = businessStaffID;
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
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public int getBusinessStaffID() {
		return businessStaffID;
	}
	public void setBusinessStaffID(int businessStaffID) {
		this.businessStaffID = businessStaffID;
	}
	
}
