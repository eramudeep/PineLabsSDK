package com.shankarkakumani.pinelabssdk.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderModel {

    @SerializedName("merchant_data")
    @Expose
    private MerchantData merchantData;
    @SerializedName("payment_info_data")
    @Expose
    private PaymentInfoData paymentInfoData;
    @SerializedName("customer_data")
    @Expose
    private CustomerData customerData;
    @SerializedName("billing_address_data")
    @Expose
    private BillingAddressData billingAddressData;
    @SerializedName("shipping_address_data")
    @Expose
    private ShippingAddressData shippingAddressData;
    @SerializedName("product_info_data")
    @Expose
    private ProductInfoData productInfoData;

    /**
     * No args constructor for use in serialization
     */
    public OrderModel() {
    }

    /**
     * @param shippingAddressData
     * @param billingAddressData
     * @param productInfoData
     * @param merchantData
     * @param customerData
     * @param paymentInfoData
     */
    public OrderModel(MerchantData merchantData, PaymentInfoData paymentInfoData, CustomerData customerData, BillingAddressData billingAddressData, ShippingAddressData shippingAddressData, ProductInfoData productInfoData) {
        super();
        this.merchantData = merchantData;
        this.paymentInfoData = paymentInfoData;
        this.customerData = customerData;
        this.billingAddressData = billingAddressData;
        this.shippingAddressData = shippingAddressData;
        this.productInfoData = productInfoData;
    }

    public MerchantData getMerchantData() {
        return merchantData;
    }

    public void setMerchantData(MerchantData merchantData) {
        this.merchantData = merchantData;
    }

    public PaymentInfoData getPaymentInfoData() {
        return paymentInfoData;
    }

    public void setPaymentInfoData(PaymentInfoData paymentInfoData) {
        this.paymentInfoData = paymentInfoData;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }

    public BillingAddressData getBillingAddressData() {
        return billingAddressData;
    }

    public void setBillingAddressData(BillingAddressData billingAddressData) {
        this.billingAddressData = billingAddressData;
    }

    public ShippingAddressData getShippingAddressData() {
        return shippingAddressData;
    }

    public void setShippingAddressData(ShippingAddressData shippingAddressData) {
        this.shippingAddressData = shippingAddressData;
    }

    public ProductInfoData getProductInfoData() {
        return productInfoData;
    }

    public void setProductInfoData(ProductInfoData productInfoData) {
        this.productInfoData = productInfoData;
    }
    
}








