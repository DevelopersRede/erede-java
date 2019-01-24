package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Capture {

  @SerializedName("amount")
  private int amount;

  @SerializedName("dateTime")
  private String dateTime;

  @SerializedName("nsu")
  private String nsu;

  public int getAmount() {
    return amount;
  }

  public Capture setAmount(int amount) {
    this.amount = amount;
    return this;
  }

  public String getDateTime() {
    return dateTime;
  }

  public Capture setDateTime(String dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  public String getNsu() {
    return nsu;
  }

  public Capture setNsu(String nsu) {
    this.nsu = nsu;
    return this;
  }
}
