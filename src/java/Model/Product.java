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
public class Product {
    private int productID;
    private String productImage;
    private String productName;
    private double productPrice;
    private double productImportPrice;
    private int productInstock;
    private int productInuse;
    private String productDescription;
    private Date productCreatedAt;
    private Date productUpdatedAt;
    private boolean isActive;

    public Product() {
    }

    public Product(int productID, String productImage, String productName, double productPrice, double productImportPrice, int productInstock, int productInuse, String productDescription, Date productCreatedAt, Date productUpdatedAt, boolean isActive) {
        this.productID = productID;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImportPrice = productImportPrice;
        this.productInstock = productInstock;
        this.productInuse = productInuse;
        this.productDescription = productDescription;
        this.productCreatedAt = productCreatedAt;
        this.productUpdatedAt = productUpdatedAt;
        this.isActive = isActive;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductImportPrice() {
        return productImportPrice;
    }

    public void setProductImportPrice(double productImportPrice) {
        this.productImportPrice = productImportPrice;
    }

    public int getProductInstock() {
        return productInstock;
    }

    public void setProductInstock(int productInstock) {
        this.productInstock = productInstock;
    }

    public int getProductInuse() {
        return productInuse;
    }

    public void setProductInuse(int productInuse) {
        this.productInuse = productInuse;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Date getProductCreatedAt() {
        return productCreatedAt;
    }

    public void setProductCreatedAt(Date productCreatedAt) {
        this.productCreatedAt = productCreatedAt;
    }

    public Date getProductUpdatedAt() {
        return productUpdatedAt;
    }

    public void setProductUpdatedAt(Date productUpdatedAt) {
        this.productUpdatedAt = productUpdatedAt;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
