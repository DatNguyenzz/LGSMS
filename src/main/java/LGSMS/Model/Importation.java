package LGSMS.Model;

import java.sql.Date;

public class Importation {
	private int importationID;
	private int productID;
	private int productImportQuantity;
	private Date importDate;
	private int accountID;
	private int providerID;
	private String note;
	private double spendingMoney;
	public Importation() {
		super();
	}
	public Importation(int importationID, int productID, int productImportQuantity, Date importDate, int accountID,
			int providerID, String note, double spendingMoney) {
		super();
		this.importationID = importationID;
		this.productID = productID;
		this.productImportQuantity = productImportQuantity;
		this.importDate = importDate;
		this.accountID = accountID;
		this.providerID = providerID;
		this.note = note;
		this.spendingMoney = spendingMoney;
	}
	public int getImportationID() {
		return importationID;
	}
	public void setImportationID(int importationID) {
		this.importationID = importationID;
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
	public double getSpendingMoney() {
		return spendingMoney;
	}
	public void setSpendingMoney(double spendingMoney) {
		this.spendingMoney = spendingMoney;
	}

}
