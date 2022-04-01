package Model;

import java.sql.Date;

/**
 *
 * @author Dat Nguyen
 */
public class Product {
    private int productID;
    private int imageID;
    private String productName;
    private double productPrice;
    private double productImportPrice;
    private int productInstock;
    private int productEmpty;
    private String productDescription;
    private Date productCreatedAt;
    private Date productUpdatedAt;
    private boolean isActive;
    private int providerID;

    public Product() {
    }

    public Product(int productID, int productImage, String productName, 
            double productPrice, double productImportPrice, int productInstock, 
            int productInuse, String productDescription, Date productCreatedAt, 
            Date productUpdatedAt, boolean isActive, int providerID) {
        this.productID = productID;
        this.imageID = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImportPrice = productImportPrice;
        this.productInstock = productInstock;
        this.productEmpty = productInuse;
        this.productDescription = productDescription;
        this.productCreatedAt = productCreatedAt;
        this.productUpdatedAt = productUpdatedAt;
        this.isActive = isActive;
        this.providerID = providerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
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

    public int getProductEmpty() {
        return productEmpty;
    }

    public void setProductEmpty(int productEmpty) {
        this.productEmpty = productEmpty;
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

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }
    
    
}