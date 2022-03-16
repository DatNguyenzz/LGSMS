package LGSMS.Model;

public class Provider {
	private int providerID;
	private String providerName;
	private String address;
	private String phone;
	private String email;
	private boolean isActive;
	public Provider() {
		super();
	}
	public Provider(int providerID, String providerName, String address, String phone, String email, boolean isActive) {
		super();
		this.providerID = providerID;
		this.providerName = providerName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.isActive = isActive;
	}
	public int getProviderID() {
		return providerID;
	}
	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
