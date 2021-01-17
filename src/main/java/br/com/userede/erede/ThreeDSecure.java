package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class ThreeDSecure {

    public static final String CONTINUE_ON_FAILURE = "continue";
    public static final String DECLINE_ON_FAILURE = "decline";

    @SerializedName("cavv")
    private String cavv;

    @SerializedName("eci")
    private String eci;

    @SerializedName("embedded")
    private Boolean embedded = true;

    @SerializedName("onFailure")
    private String onFailure;

    @SerializedName("url")
    private String url;

    @SerializedName("userAgent")
    private String userAgent = eRede.USER_AGENT;

    @SerializedName("xid")
    private String xid;

    public String getCavv() {
        return cavv;
    }

    public ThreeDSecure setCavv(String cavv) {
        this.cavv = cavv;
        return this;
    }

    public String getEci() {
        return eci;
    }

    public ThreeDSecure setEci(String eci) {
        this.eci = eci;
        return this;
    }

    public Boolean getEmbedded() {
        return embedded;
    }

    public ThreeDSecure setEmbedded(Boolean embedded) {
        this.embedded = embedded;
        return this;
    }

    public String getOnFailure() {
        return onFailure;
    }

    public ThreeDSecure setOnFailure(String onFailure) {
        this.onFailure = onFailure;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ThreeDSecure setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public ThreeDSecure setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public String getXid() {
        return xid;
    }

    public ThreeDSecure setXid(String xid) {
        this.xid = xid;
        return this;
    }
}
