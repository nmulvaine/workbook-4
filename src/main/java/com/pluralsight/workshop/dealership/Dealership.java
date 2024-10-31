package com.pluralsight.workshop.dealership;

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
// None of the setters and getters get called
    // Might be issue with dealership name parsing and printing
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
        return " D & B Used Cars '" + dealershipName + '\'' +
               ", 111 Old Benbrook Rd '" + dealershipAddress + '\'' +
               ", 817-555-5555 " + dealershipPhone + '\'';
    }
}