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

    public Importation() {
    }

    public Importation(int importID, int productID, int productImportQuantity, Date importDate, int accountID, int providerID, String note, double importAmount) {
        this.importID = importID;
        this.productID = productID;
        this.productImportQuantity = productImportQuantity;
        this.importDate = importDate;
        this.accountID = accountID;
        this.providerID = providerID;
        this.note = note;
        this.importAmount = importAmount;
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
}