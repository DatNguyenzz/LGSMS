package LGSMS.Model;

public class ShoppingCart {
	private int cartID;
	private int productID;
	private int productQuantity;
	private int customerID;
	public ShoppingCart() {
		super();
	}
	public ShoppingCart(int cartID, int productID, int productQuantity, int customerID) {
		super();
		this.cartID = cartID;
		this.productID = productID;
		this.productQuantity = productQuantity;
		this.customerID = customerID;
	}
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
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
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
}
