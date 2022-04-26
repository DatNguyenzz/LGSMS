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
    private Date createdAt;
    private int managerID;
    private int staffID;
    private int providerID;
    private String note;
    private double importAmount;
    private String staffName;
    private String productName;
    private String providerName;
    private String managerName;
    private int importStatus;
    private Date updatedAt;

    public Importation() {
    }

    public Importation(int importID, int productID, 
            int productImportQuantity, Date importDate, int accountID, 
            int providerID, String note, double importAmount, 
            String staffName, String productName, String providerName,
            int importStatus,String manageName,Date updateDate) {
        this.importID = importID;
        this.productID = productID;
        this.productImportQuantity = productImportQuantity;
        this.createdAt = importDate;
        this.managerID = accountID;
        this.providerID = providerID;
        this.note = note;
        this.importAmount = importAmount;
        this.staffName = staffName;
        this.productName = productName;
        this.providerName = providerName;
        this.importStatus = importStatus;
        this.managerName= manageName;
        this.updatedAt=updateDate;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
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
