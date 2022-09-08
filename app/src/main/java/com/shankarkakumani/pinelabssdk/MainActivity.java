package com.shankarkakumani.pinelabssdk;

import static com.pine.plural_sdk.Constants.PluralPGConfig.createRequestForPinePG;
import static com.pine.plural_sdk.utli.Checksum.getXVerifyHeader;

import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.pine.plural_sdk.ApiLayer.APIClient;
import com.pine.plural_sdk.ApiLayer.PinePGService;
import com.pine.plural_sdk.Callbacks.Interface.IPinePGResponseCallback;
import com.pine.plural_sdk.Callbacks.PinePGPaymentManager;
import com.pine.plural_sdk.Constants.Environment;
import com.pine.plural_sdk.modals.CreateOrderRequest;
import com.pine.plural_sdk.modals.CreateOrderResponse;
import com.shankarkakumani.pinelabssdk.model.BillingAddressData;
import com.shankarkakumani.pinelabssdk.model.CustomerData;
import com.shankarkakumani.pinelabssdk.model.MerchantData;
import com.shankarkakumani.pinelabssdk.model.OrderModel;
import com.shankarkakumani.pinelabssdk.model.PaymentInfoData;
import com.shankarkakumani.pinelabssdk.model.ProductDetail;
import com.shankarkakumani.pinelabssdk.model.ProductInfoData;
import com.shankarkakumani.pinelabssdk.model.ShippingAddressData;
import com.shankarkakumani.pinelabssdk.model.enquiryResponse.EnquiryResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    static String strBase64 = "";
    static String XVerifyHeader;
    PinePGPaymentManager objPinePGPaymentManager = null;

    String PLURAL_MERCHANT_SECURE_SECRETKEY = "2207751CCF0C41519E4082F9FFC68DDE";
    String PLURAL_MERCHANT_ID = "12022";
    String PLURAL_MERCHANT_ACCESS_CODE = "708b0b81-50ea-4821-924b-61fcf1252c7a";
    String PLURAL_MERCHANT_RETURN_URL = "http://192.168.101.205:9073/chargingrespnew.aspx";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objPinePGPaymentManager = new PinePGPaymentManager();
        Environment env = Environment.UAT;
        createRequestForPinePG(env);

        OrderModel pojo = getOrderModel();
        String createOrderPojoAsResponse = new Gson().toJson(pojo);

        byte[] encodeValue = Base64.encode(createOrderPojoAsResponse.getBytes(), Base64.DEFAULT);
        strBase64 = new String(encodeValue);
        strBase64 = strBase64.replace("\n", "");


        try {
            XVerifyHeader = getXVerifyHeader(PLURAL_MERCHANT_SECURE_SECRETKEY, createOrderPojoAsResponse, strBase64);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CreateOrderRequest createOrderRequest = new CreateOrderRequest(strBase64);
        PinePGService apiInterface = APIClient.getClient().create(PinePGService.class);
        byte[] data = (PLURAL_MERCHANT_ID + ":" + PLURAL_MERCHANT_ACCESS_CODE).getBytes(StandardCharsets.UTF_8);
        String encodedString = Base64.encodeToString(data, Base64.NO_WRAP);
//        String encodedString = java.util.Base64.getEncoder().encodeToString(data);
        Call<CreateOrderResponse> call = apiInterface.callCreateOrderApi("Basic " + encodedString, "application/json", XVerifyHeader, createOrderRequest);
        Log.d("TAG_RESPONSE", "response of payment call: " + call);

        call.enqueue(new retrofit2.Callback<CreateOrderResponse>() {
            @Override
            public void onResponse(@NonNull Call<CreateOrderResponse> call, @NonNull retrofit2.Response<CreateOrderResponse> response) {
                if(response.isSuccessful() && response.code() == 200) {
                    assert response.body() != null;
                    initializePayment(response.body().token);
                }
                Log.d("TAG_RESPONSE", "response of payment : " + response);
            }

            @Override
            public void onFailure(@NonNull Call<CreateOrderResponse> call, @NonNull Throwable t) {
                Log.d("TAG_RESPONSE", "response of payment : " + t);
            }
        });


    }

    private void initializePayment(String orderToken) {

        JSONObject options = getJsonOptions(orderToken);
        objPinePGPaymentManager.startPayment(this, options, new IPinePGResponseCallback() {
            @Override
            public void onErrorOccured(int code, String message) {
                Log.d("TAG_RESPONSE", "onErrorOccured : " + message);
            }

            @Override
            public void onTransactionResponse(JSONObject jsonObject) {
                Log.d("TAG_RESPONSE", "onTransactionResponse : " + jsonObject);
                Toast.makeText(getApplicationContext(), String.valueOf(jsonObject), Toast.LENGTH_LONG).show();
                try {
                    String paymentId = jsonObject.getString("payment_id");
                    String orderId = jsonObject.getString("plural_order_id");
                    inquiryAPI(orderId, paymentId);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelTxn(int code, String message) {
                Log.d("TAG_RESPONSE", "onCancelTxn : " + message);
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void inquiryAPI(String orderId, String paymentId) {
        EnquiryAPIService apiInterface = APIClient.getClient().create(EnquiryAPIService.class);
        Call<EnquiryResponse> call = apiInterface.enquiryAPI(orderId, paymentId);
        call.enqueue(new Callback<EnquiryResponse>() {
            @Override
            public void onResponse(@NonNull Call<EnquiryResponse> call, @NonNull Response<EnquiryResponse> response) {
                Log.d("TAG_RESPONSE", "onTransactionResponse : " + response);
                if(response.isSuccessful() && response.code() == 200) {
                    assert response.body() != null;
//                    initializePayment(response.body().toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<EnquiryResponse> call, @NonNull Throwable t) {
                Log.d("TAG_RESPONSE", "response of payment : " + t);
            }
        });

    }

    private JSONObject getJsonOptions(String orderToken) {
        JSONObject options = new JSONObject();
        try {
            options.put("emailId", "xyz@pinelabs.com");
            options.put("countryCode", "91");
            options.put("mobileNumber", "1234567890");
            options.put("showSavedCardsFeature", false);
            options.put("orderToken", orderToken);
            options.put("channelId", "APP");
            options.put("theme", "default");
            options.put("paymentMode", "ALL");
            return options;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JSONObject createOrderParam() {
        try {
            return new JSONObject("{\n" +
                    "  \"merchant_data\": {\n" +
                    "    \"merchant_id\": 12022,\n" +
                    "    \"order_id\": \"2626L31LB412P9BS\"\n" +
                    "  },\n" +
                    "  \"order_data\": {\n" +
                    "    \"order_status\": \"CHARGED\",\n" +
                    "    \"plural_order_id\": 105771,\n" +
                    "    \"amount\": 1000,\n" +
                    "    \"order_desc\": \"One shirt\",\n" +
                    "    \"refund_amount\": \"0\"\n" +
                    "  },\n" +
                    "  \"payment_info_data\": {\n" +
                    "    \"acquirer_name\": \"RazorPay\",\n" +
                    "    \"auth_code\": \"NA\",\n" +
                    "    \"captured_amount_in_paisa\": \"1000\",\n" +
                    "    \"card_holder_name\": \"NA\",\n" +
                    "    \"masked_card_number\": \"NA\",\n" +
                    "    \"merchant_return_url\": \"http://192.168.101.205:9073/chargingrespnew.aspx\",\n" +
                    "    \"mobile_no\": \"NA\",\n" +
                    "    \"payment_completion_date_time\": \"2021-09-15T10:43:55.673Z\",\n" +
                    "    \"payment_id\": \"431723\",\n" +
                    "    \"payment_status\": \"CAPTURED\",\n" +
                    "    \"payment_response_code\": 1,\n" +
                    "    \"payment_response_message\": \"NA\",\n" +
                    "    \"product_code\": \"NA\",\n" +
                    "    \"rrn\": \"NA\",\n" +
                    "    \"refund_amount_in_paisa\": \"0\",\n" +
                    "    \"salted_card_hash\": \"NA\",\n" +
                    "    \"udf_field_1\": \"NA\",\n" +
                    "    \"udf_field_2\": \"NA\",\n" +
                    "    \"udf_field_3\": \"NA\",\n" +
                    "    \"udf_field_4\": \"NA\",\n" +
                    "    \"payment_mode\": \"NETBANKING\",\n" +
                    "    \"issuer_name\": \"NONE\",\n" +
                    "    \"gateway_payment_id\": \"pay_HxcaJfiAUV5bOL\"\n" +
                    "  }\n" +
                    "}");
        } catch (JSONException e) {
            return null;
        }
    }

    private OrderModel getOrderModel() {
        OrderModel orderPojo = new OrderModel();
        orderPojo.setMerchantData(getMerchantData());
        orderPojo.setPaymentInfoData(getPaymentInfoData());
        orderPojo.setCustomerData(getCustomerData());
        orderPojo.setProductInfoData(getProductInfo());
        orderPojo.setBillingAddressData(getBillingAddressInfo());
        orderPojo.setShippingAddressData(getShippingAddress());
        return orderPojo;
    }

    private ShippingAddressData getShippingAddress() {
        ShippingAddressData data = new ShippingAddressData();
        data.setFirstName("Mani");
        data.setLastName("Shankar");
        data.setPinCode("523116");
        data.setCity("Kandukur");
        data.setState("Andhra Pradesh");
        data.setCountry("India");
        data.setAddress1("2-22, Main Road, VV Palem");
        data.setAddress2("Prakasam District");
        data.setAddress3("Andhra Pradesh - 523116");
        return data;
    }

    private BillingAddressData getBillingAddressInfo() {
        BillingAddressData data = new BillingAddressData();
        data.setFirstName("Mani");
        data.setLastName("Shankar");
        data.setPinCode("523116");
        data.setCity("Kandukur");
        data.setState("Andhra Pradesh");
        data.setCountry("India");
        data.setAddress1("2-22, Main Road, VV Palem");
        data.setAddress2("Prakasam District");
        data.setAddress3("Andhra Pradesh - 523116");
        return data;
    }

    private ProductInfoData getProductInfo() {
        ProductInfoData infoData = new ProductInfoData();
        List<ProductDetail> list = new ArrayList<ProductDetail>();
        list.add(getProductListItem());
        infoData.setProductDetails(list);
        return infoData;
    }

    private ProductDetail getProductListItem() {
        ProductDetail data = new ProductDetail();
        data.setProductCode("121");
        data.setProductAmount(100);
        return data;
    }

    private CustomerData getCustomerData() {
        CustomerData customerData = new CustomerData();
        customerData.setEmailId("shankar@binaryveda.com");
//        customerData.setCountryCode("+91");
        customerData.setMobileNumber("8184964359");
        return customerData;
    }

    private PaymentInfoData getPaymentInfoData() {
        PaymentInfoData paymentInfoData = new PaymentInfoData();
        paymentInfoData.setAmount(100);
        paymentInfoData.setCurrencyCode("INR");
        paymentInfoData.setOrderDesc("still figuring this out..");
        return paymentInfoData;
    }

    private MerchantData getMerchantData() {
        MerchantData merchantData = new MerchantData();
        merchantData.setMerchantAccessCode(PLURAL_MERCHANT_ACCESS_CODE);
        merchantData.setMerchantId(PLURAL_MERCHANT_ID);
        merchantData.setMerchantAccessCode(PLURAL_MERCHANT_ACCESS_CODE);
        merchantData.setMerchantOrderId(UUID.randomUUID().toString());
        merchantData.setMerchantReturnUrl(PLURAL_MERCHANT_RETURN_URL);
        return merchantData;
    }


}