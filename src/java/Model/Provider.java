/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dat Nguyen
 */
public class Provider {
    private int providerID;
    private String providerName;
    private String providerPhone;
    private String providerAddress;
    private String providerEmail;
    private boolean isActive;

    public Provider() {
    }

    public Provider(int providerID, String providerName, String providerPhone, String providerAddress, String providerEmail, boolean isActive) {
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerPhone = providerPhone;
        this.providerAddress = providerAddress;
        this.providerEmail = providerEmail;
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

    public String getProviderPhone() {
        return providerPhone;
    }

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getProviderEmail() {
        return providerEmail;
    }

    public void setProviderEmail(String providerEmail) {
        this.providerEmail = providerEmail;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
