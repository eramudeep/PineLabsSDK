package com.shankarkakumani.pinelabssdk.model.enquiryResponse;

import com.google.gson.annotations.SerializedName;

public class MerchantData{

	@SerializedName("merchant_id")
	private int merchantId;

	@SerializedName("order_id")
	private String orderId;

	public void setMerchantId(int merchantId){
		this.merchantId = merchantId;
	}

	public int getMerchantId(){
		return merchantId;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public String getOrderId(){
		return orderId;
	}
}