package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class ThreeDSecure {
    public static final String MPI_REDE = "mpi_rede";
    public static final String MPI_THIRD_PARTY = "mpi_third_party";

    public static final String CONTINUE_ON_FAILURE = "continue";
    public static final String DECLINE_ON_FAILURE = "decline";
    public String returnCode;
    public String returnMessage;

    @SerializedName("ThreeDIndicator")
    public int threeDIndicator = 2;
    @SerializedName("DirectoryServerTransactionId")
    public String directoryServerTransactionId;
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
    @SerializedName("Device")
    private Device device;

    public ThreeDSecure() {
    }

    public ThreeDSecure(Device device) {
        this.device = device;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public ThreeDSecure setReturnCode(String returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public ThreeDSecure setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
        return this;
    }

    public int getThreeDIndicator() {
        return threeDIndicator;
    }

    public ThreeDSecure setThreeDIndicator(int threeDIndicator) {
        this.threeDIndicator = threeDIndicator;
        return this;
    }

    public String getDirectoryServerTransactionId() {
        return directoryServerTransactionId;
    }

    public ThreeDSecure setDirectoryServerTransactionId(String directoryServerTransactionId) {
        this.directoryServerTransactionId = directoryServerTransactionId;
        return this;
    }

    public Device getDevice() {
        return device;
    }

    public ThreeDSecure setDevice(Device device) {
        this.device = device;
        return this;
    }

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
