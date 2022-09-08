package com.shankarkakumani.pinelabssdk.model.enquiryResponse;

import com.google.gson.annotations.SerializedName;

public class EnquiryResponse {

	@SerializedName("order_data")
	private OrderData orderData;

	@SerializedName("payment_info_data")
	private PaymentInfoData paymentInfoData;

	@SerializedName("merchant_data")
	private MerchantData merchantData;

	public void setOrderData(OrderData orderData){
		this.orderData = orderData;
	}

	public OrderData getOrderData(){
		return orderData;
	}

	public void setPaymentInfoData(PaymentInfoData paymentInfoData){
		this.paymentInfoData = paymentInfoData;
	}

	public PaymentInfoData getPaymentInfoData(){
		return paymentInfoData;
	}

	public void setMerchantData(MerchantData merchantData){
		this.merchantData = merchantData;
	}

	public MerchantData getMerchantData(){
		return merchantData;
	}
}