package com.shankarkakumani.pinelabssdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductInfoData {

    @SerializedName("product_details")
    @Expose
    private List<ProductDetail> productDetails = null;

    /**
     * No args constructor for use in serialization
     */
    public ProductInfoData() {
    }

    /**
     * @param productDetails
     */
    public ProductInfoData(List<ProductDetail> productDetails) {
        super();
        this.productDetails = productDetails;
    }

    public List<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

}
