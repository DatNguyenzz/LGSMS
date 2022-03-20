/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Dat Nguyen
 */
public class ReceiptVoucher {
    private int receiptID;
    private int orderID;
    private Date receiptCreatedAt;
    private int bussinessStaffID;
    private double totalMoney;
    private double deposit;
    private String note;

    public ReceiptVoucher() {
    }

    public ReceiptVoucher(int receiptID, int orderID, Date receiptCreatedAt, int bussinessStaffID, double totalMoney, double deposit, String note) {
        this.receiptID = receiptID;
        this.orderID = orderID;
        this.receiptCreatedAt = receiptCreatedAt;
        this.bussinessStaffID = bussinessStaffID;
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

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getReceiptCreatedAt() {
        return receiptCreatedAt;
    }

    public void setReceiptCreatedAt(Date receiptCreatedAt) {
        this.receiptCreatedAt = receiptCreatedAt;
    }

    public int getBussinessStaffID() {
        return bussinessStaffID;
    }

    public void setBussinessStaffID(int bussinessStaffID) {
        this.bussinessStaffID = bussinessStaffID;
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
