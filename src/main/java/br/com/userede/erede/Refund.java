package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Refund {

    @SerializedName("amount")
    private Integer amount;

    @SerializedName("refundDateTime")
    private String refundDateTime;

    @SerializedName("refundId")
    private String refundId;

    @SerializedName("status")
    private String status;

    public Integer getAmount() {
        return amount;
    }

    public Refund setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getRefundDateTime() {
        return refundDateTime;
    }

    public Refund setRefundDateTime(String refundDateTime) {
        this.refundDateTime = refundDateTime;
        return this;
    }

    public String getRefundId() {
        return refundId;
    }

    public Refund setRefundId(String refundId) {
        this.refundId = refundId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Refund setStatus(String status) {
        this.status = status;
        return this;
    }
}
