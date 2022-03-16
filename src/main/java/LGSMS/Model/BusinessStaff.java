package LGSMS.Model;

import java.sql.Date;

public class BusinessStaff extends Account {
	private int businessStaffID;

	public BusinessStaff() {
		super();
	}

	public BusinessStaff(int businessStaffID) {
		super();
		this.businessStaffID = businessStaffID;
	}

	public BusinessStaff(int account_id, String username, String password, int role_id, boolean is_active,
			int businessStaffID) {
		super(account_id, username, password, role_id, is_active);
		this.businessStaffID = businessStaffID;
	}

	public BusinessStaff(int profile_id, String image, String fullName, String phone, Date dob, boolean gender,
			String address, String email, Date created_at, Date updated_at, int account_id, String username,
			String password, int role_id, boolean is_active, int businessStaffID) {
		super(profile_id, image, fullName, phone, dob, gender, address, email, created_at, updated_at, account_id,
				username, password, role_id, is_active);
		this.businessStaffID = businessStaffID;
	}

	public int getBusinessStaffID() {
		return businessStaffID;
	}

	public void setBusinessStaffID(int businessStaffID) {
		this.businessStaffID = businessStaffID;
	}

}
