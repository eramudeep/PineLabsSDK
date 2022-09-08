
package com.shankarkakumani.pinelabssdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdditionalInfoData {

    @SerializedName("rfu1")
    @Expose
    private String rfu1;

    /**
     * No args constructor for use in serialization
     */
    public AdditionalInfoData() {
    }

    /**
     * @param rfu1
     */
    public AdditionalInfoData(String rfu1) {
        super();
        this.rfu1 = rfu1;
    }

    public String getRfu1() {
        return rfu1;
    }

    public void setRfu1(String rfu1) {
        this.rfu1 = rfu1;
    }

}
