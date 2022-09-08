package com.shankarkakumani.pinelabssdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MerchantData {

    @SerializedName("merchant_id")
    @Expose
    private String merchantId;
    @SerializedName("merchant_access_code")
    @Expose
    private String merchantAccessCode;
    @SerializedName("merchant_return_url")
    @Expose
    private String merchantReturnUrl;
    @SerializedName("merchant_order_id")
    @Expose
    private String merchantOrderId;

    /**
     * No args constructor for use in serialization
     */
    public  MerchantData() {
    }

    /**
     * @param merchantReturnUrl
     * @param merchantId
     * @param merchantAccessCode
     * @param merchantOrderId
     */
    public MerchantData(String merchantId, String merchantAccessCode, String merchantReturnUrl, String merchantOrderId) {
        super();
        this.merchantId = merchantId;
        this.merchantAccessCode = merchantAccessCode;
        this.merchantReturnUrl = merchantReturnUrl;
        this.merchantOrderId = merchantOrderId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantAccessCode() {
        return merchantAccessCode;
    }

    public void setMerchantAccessCode(String merchantAccessCode) {
        this.merchantAccessCode = merchantAccessCode;
    }

    public String getMerchantReturnUrl() {
        return merchantReturnUrl;
    }

    public void setMerchantReturnUrl(String merchantReturnUrl) {
        this.merchantReturnUrl = merchantReturnUrl;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

}
