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
public class Importation {
    private int importID;
    private int productID;
    private int productImportQuantity;
    private Date importDate;
    private int accountID;
    private int providerID;
    private String note;
    private double importAmount;
    private String staffName;
    private String productName;
    private String providerName;
    private String manageName;
    private int importStatus;
    private Date updateDate;

    public Importation() {
    }

    public Importation(int importID, int productID, 
            int productImportQuantity, Date importDate, int accountID, 
            int providerID, String note, double importAmount, 
            String staffName, String productName, String providerName, int importStatus,String manageName,Date updateDate) {
        this.importID = importID;
        this.productID = productID;
        this.productImportQuantity = productImportQuantity;
        this.importDate = importDate;
        this.accountID = accountID;
        this.providerID = providerID;
        this.note = note;
        this.importAmount = importAmount;
        this.staffName = staffName;
        this.productName = productName;
        this.providerName = providerName;
        this.importStatus = importStatus;
        this.manageName= manageName;
        this.updateDate=updateDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }
    
    

    public int getImportStatus() {
        return importStatus;
    }

    public void setImportStatus(int importStatus) {
        this.importStatus = importStatus;
    }

    
    
    public int getImportID() {
        return importID;
    }

    public void setImportID(int importID) {
        this.importID = importID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductImportQuantity() {
        return productImportQuantity;
    }

    public void setProductImportQuantity(int productImportQuantity) {
        this.productImportQuantity = productImportQuantity;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getImportAmount() {
        return importAmount;
    }

    public void setImportAmount(double importAmount) {
        this.importAmount = importAmount;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    
}
