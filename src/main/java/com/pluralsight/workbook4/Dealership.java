package com.pluralsight.workbook4;

// Handles vehicle sales
// Adding/removing vehicle
// Dealership contact information

public class Dealership {

    private String dealershipName;
    private String dealershipAddress;
    private String dealershipPhone;

    public Dealership(String dealershipName, String dealershipAddress, String dealershipPhone) {
        this.dealershipName = dealershipName;
        this.dealershipAddress = dealershipAddress;
        this.dealershipPhone = dealershipPhone;
    }

    public String getDealershipName() {
        return dealershipName;
    }

    public void setDealershipName(String dealershipName) {
        this.dealershipName = dealershipName;
    }

    public String getDealershipAddress() {
        return dealershipAddress;
    }

    public void setDealershipAddress(String dealershipAddress) {
        this.dealershipAddress = dealershipAddress;
    }

    public String getDealershipPhone() {
        return dealershipPhone;
    }

    public void setDealershipPhone(String dealershipPhone) {
        this.dealershipPhone = dealershipPhone;
    }

    @Override
    public String toString() {
        return " Name='" + dealershipName + '\'' +
               ", Address='" + dealershipAddress + '\'' +
               ", Phone='" + dealershipPhone + '\'';
    }
}