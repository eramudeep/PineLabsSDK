package com.shankarkakumani.pinelabssdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductDetail {

    @SerializedName("product_code")
    @Expose
    private String productCode;
    @SerializedName("product_amount")
    @Expose
    private int productAmount;

    /**
     * No args constructor for use in serialization
     */
    public ProductDetail() {
    }

    /**
     * @param productAmount
     * @param productCode
     */
    public ProductDetail(String productCode, int productAmount) {
        super();
        this.productCode = productCode;
        this.productAmount = productAmount;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

}
