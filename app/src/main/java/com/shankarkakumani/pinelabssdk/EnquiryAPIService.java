
package com.shankarkakumani.pinelabssdk;

import com.shankarkakumani.pinelabssdk.model.enquiryResponse.EnquiryResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EnquiryAPIService {
    @GET("/api/v1/inquiry/order/{order}/payment/{payment}")
    Call<EnquiryResponse> enquiryAPI(@Path("order") String order, @Path("payment") String payment);
}
