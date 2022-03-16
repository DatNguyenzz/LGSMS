package LGSMS.Model;

import java.sql.Date;

public class Profile {
	private int profile_id;
	private String image;
	private String fullName;
	private String phone;
	private Date dob;
	private boolean gender;
	private String address;
	private String email;
	private Date created_at;
	private Date updated_at;
	public Profile() {
		super();
	}
	public Profile(int profile_id, String image, String fullName, String phone, Date dob, boolean gender,
			String address, String email, Date created_at, Date updated_at) {
		super();
		this.profile_id = profile_id;
		this.image = image;
		this.fullName = fullName;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
}
