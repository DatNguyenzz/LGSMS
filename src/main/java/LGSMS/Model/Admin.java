package LGSMS.Model;

import java.sql.Date;

public class Admin extends Account {
	private int adminID;

	public Admin() {
		super();
	}

	public Admin(int adminID) {
		super();
		this.adminID = adminID;
	}

	public Admin(int account_id, String username, String password, Role role, boolean is_active, int adminID) {
		super(account_id, username, password, role, is_active);
		this.adminID = adminID;
	}

	public Admin(int profile_id, String image, String fullName, String phone, Date dob, boolean gender, String address,
			String email, Date created_at, Date updated_at, int account_id, String username, String password,
			Role role, boolean is_active, int adminID) {
		super(profile_id, image, fullName, phone, dob, gender, address, email, created_at, updated_at, account_id,
				username, password, role, is_active);
		this.adminID = adminID;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

}
