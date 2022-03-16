package LGSMS.Model;

import java.sql.Date;

public class Customer extends Account{
	private int customerID;

	public Customer() {
		super();
	}

	public Customer(int customerID) {
		super();
		this.customerID = customerID;
	}

	public Customer(int account_id, String username, String password, int role_id, boolean is_active, int customerID) {
		super(account_id, username, password, role_id, is_active);
		this.customerID = customerID;
	}

	public Customer(int profile_id, String image, String fullName, String phone, Date dob, boolean gender,
			String address, String email, Date created_at, Date updated_at, int account_id, String username,
			String password, int role_id, boolean is_active, int customerID) {
		super(profile_id, image, fullName, phone, dob, gender, address, email, created_at, updated_at, account_id,
				username, password, role_id, is_active);
		this.customerID = customerID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
}
