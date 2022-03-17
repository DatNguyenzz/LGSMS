package LGSMS.Model;

import java.sql.Date;

public class Account extends Profile{
	private int accountId;
	private String username;
	private String password;
	private Role role;
	private boolean isActive;
	public Account() {
		super();
	}
	public Account(int account_id, String username, String password, Role role, boolean is_active) {
		super();
		this.accountId = account_id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.isActive = is_active;
	}
	public Account(int profile_id, String image, String fullName, String phone, Date dob, boolean gender,
			String address, String email, Date created_at, Date updated_at, int account_id, String username,
			String password, Role role, boolean is_active) {
		super(profile_id, image, fullName, phone, dob, gender, address, email, created_at, updated_at);
		this.accountId = account_id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.isActive = is_active;
	}
	public int getAccount_id() {
		return accountId;
	}
	public void setAccount_id(int account_id) {
		this.accountId = account_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public boolean isIs_active() {
		return isActive;
	}
	public void setIs_active(boolean is_active) {
		this.isActive = is_active;
	}
	
}
