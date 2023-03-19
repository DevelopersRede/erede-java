package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class SubMerchant {
    @SerializedName("mcc")
    private String mcc;

    @SerializedName("city")
    private String city;

    @SerializedName("country")
    private String country;

    public SubMerchant(String mcc, String city, String country) {
        this.mcc = mcc;
        this.city = city;
        this.country = country;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
