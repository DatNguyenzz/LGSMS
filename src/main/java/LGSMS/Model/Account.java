package LGSMS.Model;

import java.sql.Date;

public class Account extends Profile{
	private int account_id;
	private String username;
	private String password;
	private int role_id;
	private boolean is_active;
	public Account() {
		super();
	}
	public Account(int account_id, String username, String password, int role_id, boolean is_active) {
		super();
		this.account_id = account_id;
		this.username = username;
		this.password = password;
		this.role_id = role_id;
		this.is_active = is_active;
	}
	public Account(int profile_id, String image, String fullName, String phone, Date dob, boolean gender,
			String address, String email, Date created_at, Date updated_at, int account_id, String username,
			String password, int role_id, boolean is_active) {
		super(profile_id, image, fullName, phone, dob, gender, address, email, created_at, updated_at);
		this.account_id = account_id;
		this.username = username;
		this.password = password;
		this.role_id = role_id;
		this.is_active = is_active;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
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
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
}
