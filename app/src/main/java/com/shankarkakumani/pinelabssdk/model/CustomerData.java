package com.shankarkakumani.pinelabssdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerData {

    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("email_id")
    @Expose
    private String emailId;

    /**
     * No args constructor for use in serialization
     */
    public CustomerData() {
    }

    /**
     * @param countryCode
     * @param mobileNumber
     * @param emailId
     */
    public CustomerData(String countryCode, String mobileNumber, String emailId) {
        super();
        this.countryCode = countryCode;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}
