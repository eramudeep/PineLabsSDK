package com.shankarkakumani.pinelabssdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentInfoData {

    @SerializedName("amount")
    @Expose
    private int amount;
    @SerializedName("currency_code")
    @Expose
    private String currencyCode;
    @SerializedName("order_desc")
    @Expose
    private String orderDesc;

    /**
     * No args constructor for use in serialization
     */
    public PaymentInfoData() {
    }

    /**
     * @param amount
     * @param currencyCode
     * @param orderDesc
     */
    public PaymentInfoData(int amount, String currencyCode, String orderDesc) {
        super();
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.orderDesc = orderDesc;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

}
