package LGSMS.Model;

import java.sql.Date;

public class Profile {
	private int profileId;
	private String image;
	private String fullName;
	private String phone;
	private Date dob;
	private boolean gender;
	private String address;
	private String email;
	private Date createdAt;
	private Date updatedAt;
	public Profile() {
		super();
	}
	public Profile(int profileId, String image, String fullName, String phone, Date dob, boolean gender,
			String address, String email, Date created_at, Date updated_at) {
		super();
		this.profileId = profileId;
		this.image = image;
		this.fullName = fullName;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.createdAt = created_at;
		this.updatedAt = updated_at;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
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
		return createdAt;
	}
	public void setCreated_at(Date created_at) {
		this.createdAt = created_at;
	}
	public Date getUpdated_at() {
		return updatedAt;
	}
	public void setUpdated_at(Date updated_at) {
		this.updatedAt = updated_at;
	}
	
}
