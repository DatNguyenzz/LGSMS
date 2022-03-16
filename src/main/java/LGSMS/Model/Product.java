package LGSMS.Model;

import java.sql.Date;

public class Product {
	private int productID;
	private String productImage;
	private String productName;
	private double productPrice;
	private int productInStock;
	private int productInUse;
	private String productDescription;
	private Date productCreatedAt;
	private Date productUpdatedAt;
	private boolean isActive;
	public Product() {
		super();
	}
	public Product(int productID, String productImage, String productName, double productPrice, int productInStock,
			int productInUse, String productDescription, Date productCreatedAt, Date productUpdatedAt,
			boolean isActive) {
		super();
		this.productID = productID;
		this.productImage = productImage;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productInStock = productInStock;
		this.productInUse = productInUse;
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
	public int getProductInStock() {
		return productInStock;
	}
	public void setProductInStock(int productInStock) {
		this.productInStock = productInStock;
	}
	public int getProductInUse() {
		return productInUse;
	}
	public void setProductInUse(int productInUse) {
		this.productInUse = productInUse;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
