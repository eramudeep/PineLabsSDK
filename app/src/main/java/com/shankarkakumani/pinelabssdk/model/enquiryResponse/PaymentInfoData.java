package com.shankarkakumani.pinelabssdk.model.enquiryResponse;

import com.google.gson.annotations.SerializedName;

public class PaymentInfoData{

	@SerializedName("merchant_return_url")
	private String merchantReturnUrl;

	@SerializedName("refund_amount_in_paisa")
	private String refundAmountInPaisa;

	@SerializedName("gateway_payment_id")
	private String gatewayPaymentId;

	@SerializedName("payment_response_message")
	private String paymentResponseMessage;

	@SerializedName("payment_mode")
	private String paymentMode;

	@SerializedName("card_holder_name")
	private String cardHolderName;

	@SerializedName("captured_amount_in_paisa")
	private String capturedAmountInPaisa;

	@SerializedName("payment_status")
	private String paymentStatus;

	@SerializedName("mobile_no")
	private String mobileNo;

	@SerializedName("masked_card_number")
	private String maskedCardNumber;

	@SerializedName("payment_response_code")
	private int paymentResponseCode;

	@SerializedName("product_code")
	private String productCode;

	@SerializedName("auth_code")
	private String authCode;

	@SerializedName("rrn")
	private String rrn;

	@SerializedName("issuer_name")
	private String issuerName;

	@SerializedName("udf_field_1")
	private String udfField1;

	@SerializedName("acquirer_name")
	private String acquirerName;

	@SerializedName("udf_field_2")
	private String udfField2;

	@SerializedName("udf_field_3")
	private String udfField3;

	@SerializedName("udf_field_4")
	private String udfField4;

	@SerializedName("salted_card_hash")
	private String saltedCardHash;

	@SerializedName("payment_id")
	private String paymentId;

	@SerializedName("payment_completion_date_time")
	private String paymentCompletionDateTime;

	public void setMerchantReturnUrl(String merchantReturnUrl){
		this.merchantReturnUrl = merchantReturnUrl;
	}

	public String getMerchantReturnUrl(){
		return merchantReturnUrl;
	}

	public void setRefundAmountInPaisa(String refundAmountInPaisa){
		this.refundAmountInPaisa = refundAmountInPaisa;
	}

	public String getRefundAmountInPaisa(){
		return refundAmountInPaisa;
	}

	public void setGatewayPaymentId(String gatewayPaymentId){
		this.gatewayPaymentId = gatewayPaymentId;
	}

	public String getGatewayPaymentId(){
		return gatewayPaymentId;
	}

	public void setPaymentResponseMessage(String paymentResponseMessage){
		this.paymentResponseMessage = paymentResponseMessage;
	}

	public String getPaymentResponseMessage(){
		return paymentResponseMessage;
	}

	public void setPaymentMode(String paymentMode){
		this.paymentMode = paymentMode;
	}

	public String getPaymentMode(){
		return paymentMode;
	}

	public void setCardHolderName(String cardHolderName){
		this.cardHolderName = cardHolderName;
	}

	public String getCardHolderName(){
		return cardHolderName;
	}

	public void setCapturedAmountInPaisa(String capturedAmountInPaisa){
		this.capturedAmountInPaisa = capturedAmountInPaisa;
	}

	public String getCapturedAmountInPaisa(){
		return capturedAmountInPaisa;
	}

	public void setPaymentStatus(String paymentStatus){
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentStatus(){
		return paymentStatus;
	}

	public void setMobileNo(String mobileNo){
		this.mobileNo = mobileNo;
	}

	public String getMobileNo(){
		return mobileNo;
	}

	public void setMaskedCardNumber(String maskedCardNumber){
		this.maskedCardNumber = maskedCardNumber;
	}

	public String getMaskedCardNumber(){
		return maskedCardNumber;
	}

	public void setPaymentResponseCode(int paymentResponseCode){
		this.paymentResponseCode = paymentResponseCode;
	}

	public int getPaymentResponseCode(){
		return paymentResponseCode;
	}

	public void setProductCode(String productCode){
		this.productCode = productCode;
	}

	public String getProductCode(){
		return productCode;
	}

	public void setAuthCode(String authCode){
		this.authCode = authCode;
	}

	public String getAuthCode(){
		return authCode;
	}

	public void setRrn(String rrn){
		this.rrn = rrn;
	}

	public String getRrn(){
		return rrn;
	}

	public void setIssuerName(String issuerName){
		this.issuerName = issuerName;
	}

	public String getIssuerName(){
		return issuerName;
	}

	public void setUdfField1(String udfField1){
		this.udfField1 = udfField1;
	}

	public String getUdfField1(){
		return udfField1;
	}

	public void setAcquirerName(String acquirerName){
		this.acquirerName = acquirerName;
	}

	public String getAcquirerName(){
		return acquirerName;
	}

	public void setUdfField2(String udfField2){
		this.udfField2 = udfField2;
	}

	public String getUdfField2(){
		return udfField2;
	}

	public void setUdfField3(String udfField3){
		this.udfField3 = udfField3;
	}

	public String getUdfField3(){
		return udfField3;
	}

	public void setUdfField4(String udfField4){
		this.udfField4 = udfField4;
	}

	public String getUdfField4(){
		return udfField4;
	}

	public void setSaltedCardHash(String saltedCardHash){
		this.saltedCardHash = saltedCardHash;
	}

	public String getSaltedCardHash(){
		return saltedCardHash;
	}

	public void setPaymentId(String paymentId){
		this.paymentId = paymentId;
	}

	public String getPaymentId(){
		return paymentId;
	}

	public void setPaymentCompletionDateTime(String paymentCompletionDateTime){
		this.paymentCompletionDateTime = paymentCompletionDateTime;
	}

	public String getPaymentCompletionDateTime(){
		return paymentCompletionDateTime;
	}
}