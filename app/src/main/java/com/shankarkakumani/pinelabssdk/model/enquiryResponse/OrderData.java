package com.shankarkakumani.pinelabssdk.model.enquiryResponse;

import com.google.gson.annotations.SerializedName;

public class OrderData{

	@SerializedName("plural_order_id")
	private int pluralOrderId;

	@SerializedName("order_status")
	private String orderStatus;

	@SerializedName("amount")
	private int amount;

	@SerializedName("refund_amount")
	private String refundAmount;

	@SerializedName("order_desc")
	private String orderDesc;

	public void setPluralOrderId(int pluralOrderId){
		this.pluralOrderId = pluralOrderId;
	}

	public int getPluralOrderId(){
		return pluralOrderId;
	}

	public void setOrderStatus(String orderStatus){
		this.orderStatus = orderStatus;
	}

	public String getOrderStatus(){
		return orderStatus;
	}

	public void setAmount(int amount){
		this.amount = amount;
	}

	public int getAmount(){
		return amount;
	}

	public void setRefundAmount(String refundAmount){
		this.refundAmount = refundAmount;
	}

	public String getRefundAmount(){
		return refundAmount;
	}

	public void setOrderDesc(String orderDesc){
		this.orderDesc = orderDesc;
	}

	public String getOrderDesc(){
		return orderDesc;
	}
}