package LGSMS.Model;

import java.sql.Date;

public class ReceiptVoucher {
	private int receiptID;
	private String orderCode;
	private Date createdAt;
	private int businessStaffID;
	private double totalMoney;
	private double deposit;
	private String note;
	
	public ReceiptVoucher() {
		super();
	}
	public ReceiptVoucher(int receiptID, String orderCode, Date createdAt, int businessStaffID, double totalMoney,
			double deposit, String note) {
		super();
		this.receiptID = receiptID;
		this.orderCode = orderCode;
		this.createdAt = createdAt;
		this.businessStaffID = businessStaffID;
		this.totalMoney = totalMoney;
		this.deposit = deposit;
		this.note = note;
	}
	public int getReceiptID() {
		return receiptID;
	}
	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public int getBusinessStaffID() {
		return businessStaffID;
	}
	public void setBusinessStaffID(int businessStaffID) {
		this.businessStaffID = businessStaffID;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

}
