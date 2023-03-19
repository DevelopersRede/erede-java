package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Brand {

    @SerializedName("name")
    private String name;

    @SerializedName("returnCode")
    private String returnCode;

    @SerializedName("returnMessage")
    private String returnMessage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}