/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Dat Nguyen
 */
public class Account extends Profile{
    private int accountID;
    private String username;
    private String password;
    private boolean isActive;
    private Role role;

    public Account() {
    }

    public Account(int accountID, String username, String password, boolean isActive, Role role) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
    }

    public Account(int accountID, String username, String password, boolean isActive, Role role, int profileID, String Image, String fullname, String phone, Date DOB, boolean gender, String address, String email, Date createdAt, Date updatedAt) {
        super(profileID, Image, fullname, phone, DOB, gender, address, email, createdAt, updatedAt);
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
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

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
}
